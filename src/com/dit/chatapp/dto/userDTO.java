/*
 DTO - data transfer object
 Swing(Screen) se data collect krte hai(jaise userid, password, state, age, pincode, etc)
 Phir ye data ko DTO mei fill krte hai aur ye DTO fil ho jane ke baad DAO ko pass kr dete hai
 DAO sare data ko DTO se nikalega aur database mei fill kr dega
 and, then database operations are performed on these data
 */
package com.dit.chatapp.dto;

public class userDTO {
	private String userid;
	private char[] password;
	public userDTO(String userid, char[] password) {
		this.userid = userid;
		this.password = password;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] password) {
		this.password = password;
	}
}
