package com.dit.chatapp.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface Encryption {
	//takes plain password as input and returns password in encrypted form
	public static String passwordEncrypt(String plainPassword) throws NoSuchAlgorithmException {
		String encryptedPassword = null;
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(plainPassword.getBytes());
		byte[] encrypt = messageDigest.digest();
		System.out.println(encrypt);
		StringBuffer sb = new StringBuffer();
		for(byte b:encrypt) {
			sb.append(b);
		}
		encryptedPassword = sb.toString();
		System.out.println("Encrypted Password : "+encryptedPassword);
		return encryptedPassword;
	}
	/*(for testing)
	public static void main(String[] args) throws NoSuchAlgorithmException {
		passwordEncrypt("amit");
	}
	*/
}
