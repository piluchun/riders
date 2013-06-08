package com.leadtone.riders.data;

import java.util.Date;

import org.springside.modules.test.data.RandomData;

import com.leadtone.riders.entity.User;

public class UserData {

	public static User randomNewUser(String name,String domain) {
		User user = new User();
		user.setEmail(RandomEmail.randomEmail(name, domain));
		user.setAge(20);
		user.setBrand(RandomData.randomName("brand"));
		user.setBrithday(new Date(1990,2,2));
		user.setCtime(new Date());
		user.setMobile("13910766840");
		user.setNickname(RandomData.randomName("nick"));
		user.setPicture(RandomData.randomName("url"));
		user.setPwd(RandomData.randomName("123456"));
		user.setSex(1);
		user.setSignature(RandomData.randomName("signature"));
		user.setTools(RandomData.randomName("tools"));
		return user;
	}
}
