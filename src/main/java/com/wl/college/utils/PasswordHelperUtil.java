package com.wl.college.utils;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 创建用户密码加密工具类
 * Created by XJH on 2017/8/21.
 */
public class PasswordHelperUtil {

    /**
     * 该正则必须符合以下条例：
     * 1、不能是纯数字
     * 2、不能是纯字母
     * 3、不能是纯特殊符号
     * 4、必须是字母或数字或指定特殊符号        !@#$%^&*
     * 5、必须是字母开头
     * 6、长度必须是8-16位（包括8，包括16）
     */
    public static String MATCHER = "^[A-Za-z](?![a-zA-Z]+$)[0-9A-Za-z!@#$%^&*]{7,15}$";

    /**
     * 返回一个随机的salt
     *
     * @return
     */
    public static String getSalt() {
        RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
        return randomNumberGenerator.nextBytes().toHex();
    }

    /**
     * 传入salt、明文密码  ==》  返回明文密码根据salt加密过后的密文
     *
     * @param salt
     * @param password
     * @return
     */
    public static String getEncryptPassword(String salt, String password) {
        String algorithmName = "md5";
        Integer hashIterations = 2;
        return new SimpleHash(
                algorithmName,
                password,
                ByteSource.Util.bytes(salt),
                hashIterations).toHex();
    }
}
