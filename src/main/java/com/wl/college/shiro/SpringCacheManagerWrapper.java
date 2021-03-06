package com.wl.college.shiro;

import net.sf.ehcache.Ehcache;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 包装Spring cache抽象
 */
@Component("cacheManager")
public class SpringCacheManagerWrapper implements CacheManager {

    @Autowired
    private org.springframework.cache.CacheManager springCacheManager;

    public org.springframework.cache.CacheManager getSpringCacheManager() {
        return springCacheManager;
    }

    /**
     * 设置spring cache manager
     * @param springCacheManager
     */
    public void setSpringCacheManager(org.springframework.cache.CacheManager springCacheManager) {
        this.springCacheManager = springCacheManager;
    }



    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        org.springframework.cache.Cache springCache = springCacheManager.getCache(name);
        return new SpringCacheWrapper(springCache);
    }

    static class SpringCacheWrapper implements Cache {
        private org.springframework.cache.Cache springCache;

        SpringCacheWrapper(org.springframework.cache.Cache springCache) {
            this.springCache = springCache;
        }

        public Object get(Object key) throws CacheException {
            Object value = springCache.get(key);
            if (value instanceof SimpleValueWrapper) {
                return ((SimpleValueWrapper) value).get();
            }
            return value;
        }

        public Object put(Object key, Object value) throws CacheException {
            springCache.put(key, value);
            return value;
        }

        public Object remove(Object key) throws CacheException {
            springCache.evict(key);
            return null;
        }

        public void clear() throws CacheException {
            springCache.clear();
        }

        public int size() {
            if (springCache.getNativeCache() instanceof Ehcache) {
                Ehcache ehcache = (Ehcache) springCache.getNativeCache();
                return ehcache.getSize();
            }
            throw new UnsupportedOperationException("invoke shiro cache abstract size method not supported");
        }

        public Set keys() {
            if (springCache.getNativeCache() instanceof Ehcache) {
                Ehcache ehcache = (Ehcache) springCache.getNativeCache();
                return new HashSet(ehcache.getKeys());
            }
            throw new UnsupportedOperationException("invoke shiro cache abstract keys method not supported");
        }

        public Collection values() {
            if (springCache.getNativeCache() instanceof Ehcache) {
                Ehcache ehcache = (Ehcache) springCache.getNativeCache();
                List keys = ehcache.getKeys();
                if (!CollectionUtils.isEmpty(keys)) {
                    List values = new ArrayList(keys.size());
                    for (Object key : keys) {
                        Object value = get(key);
                        if (value != null) {
                            values.add(value);
                        }
                    }
                    return Collections.unmodifiableList(values);
                } else {
                    return Collections.emptyList();
                }
            }
            throw new UnsupportedOperationException("invoke shiro cache abstract values method not supported");
        }
    }
}
