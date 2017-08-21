package com.wl.college.utils;

import com.wl.college.entity.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 创建用户密码加密工具类
 * Created by XJH on 2017/8/21.
 */
public class PasswordHelperUtil {

    private static String algorithmName = "md5";
    private static Integer hashIterations = 2;                 //加密次数

    public static String getAlgorithmName() {
        return algorithmName;
    }

    public static void setAlgorithmName(String algorithmName) {
        PasswordHelperUtil.algorithmName = algorithmName;
    }

    public static Integer getHashIterations() {
        return hashIterations;
    }

    public static void setHashIterations(Integer hashIterations) {
        PasswordHelperUtil.hashIterations = hashIterations;
    }

    public static void encryptPassword(User user) {
        RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(
                algorithmName,
                user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),
                hashIterations).toHex();
        user.setPassword(newPassword);
    }
}
