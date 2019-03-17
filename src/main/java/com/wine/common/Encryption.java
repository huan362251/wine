package com.wine.common;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @Author LIUHUAN
 * @Description
 * @Date Created by  2019/3/17 18:56
 **/
public class Encryption {

    public static void main(String[] args) throws Exception {
        System.out.println("输出参数为：" + entryptionMd5("pass"));
    }


    public static String entryptionMd5(String str){
        Md5Hash md5Hash= new Md5Hash(str,null, 2);// 不设置盐值，只设置加密两次

        String hashPwd= md5Hash.toString();// 经过加密以后的密码

        return hashPwd;
    }
}
