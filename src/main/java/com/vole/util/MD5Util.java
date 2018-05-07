package com.vole.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 编写者： Wu
 * Time： 2018/5/7.22:26
 * 内容：MD5 加密工具
 */

public class MD5Util {

    public static String md5(String str, String salt) {
        return new Md5Hash(str, salt).toString();
    }

    public static void main(String[] args) {
        String password = "123";
        System.out.println("Md5加密：" + MD5Util.md5(password, "vole"));
    }

}
