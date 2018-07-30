package com.iss.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5 {
	
	
	/**
	 * @param oldStr
	 * @return  加密
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@SuppressWarnings("restriction")
	public static String encodeByMD5(String oldStr) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		String newStr="";
		MessageDigest md5=MessageDigest.getInstance("MD5");
		BASE64Encoder base64en = new BASE64Encoder();
		newStr=base64en.encode(md5.digest(oldStr.getBytes("utf-8")));
		return newStr;
	}
	
	/**
	 * @param oldPassword
	 * @param newPassword
	 * @return  判断密码是否正确
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static boolean checkPassword(String oldPassword, String newPassword) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		if(encodeByMD5(newPassword).equals(oldPassword)){
			return true;
		}
		return false;
	}

}

