package com.leadtone.riders.ui;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class UserUI {
	
	private String email;
	
	private String pwd;
	
	private String nickname;
	
	private Integer age;
	
	private Integer sex;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")  
	private Date brithday;
	
	private byte[] pictureFile;
	
	private String signature;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getBrithday() {
		return brithday;
	}

	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}


	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public byte[] getPictureFile() {
		return pictureFile;
	}

	public void setPictureFile(byte[] pictureFile) {
		this.pictureFile = pictureFile;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	private String mobile;
	
}
