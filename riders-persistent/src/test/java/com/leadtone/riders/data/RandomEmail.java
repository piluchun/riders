package com.leadtone.riders.data;

import java.util.Random;

public class RandomEmail {

	private static Random random = new Random();

	/**
	 * 返回随机ID.
	 */
	public static long randomId() {
		return random.nextLong();
	}

	/**
	 * 返回随机名称, prefix字符串+5位随机数字.
	 */
	public static String randomEmail(String prefix,String domain) {
		return prefix + random.nextInt(10000) + "@"+domain;
	}
}
