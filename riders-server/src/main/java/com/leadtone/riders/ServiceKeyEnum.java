/**
 * 
 */
package com.leadtone.riders;

/**
 * @author lvqi
 * 
 */

public enum ServiceKeyEnum {
	// 用户服务
	USER(0),
	// 好友服务
	FRIEND(1),
	// 活动服务
	ACTIVITY(2),
	// 回复服务
	COMMENT(3),
	// 车队服务
	TEAM(4),
	// 求救服务
	SOS(5),
	// 上报服务
	REPORT(6),
	// 意见建议服务
	SUGGESTION(7), 
	// 软件更新服务
	VERSION(8);

	private static ServiceKeyEnum[] allEnums = { USER, FRIEND, ACTIVITY,
			COMMENT, TEAM, SOS, REPORT, SUGGESTION, VERSION };

	private ServiceKeyEnum(int value) {
	}

	public static ServiceKeyEnum[] getAllEnums() {
		return allEnums;
	}

	public int value() {
		return ordinal();
	}

	public static ServiceKeyEnum getEnum(int value) {
		switch (value) {
		case 0:
			return USER;
		case 1:
			return FRIEND;
		case 2:
			return ACTIVITY;
		case 3:
			return COMMENT;
		case 4:
			return TEAM;
		case 5:
			return SOS;
		case 6:
			return REPORT;
		case 7:
			return SUGGESTION;
		case 8:
			return VERSION;
		default:
			return null;
		}
	}

	public static ServiceKeyEnum getEnum(String value) {
		return ServiceKeyEnum.valueOf(value);
	}

	/**
	 * Checks whether the enum's value is greater than the input enum's value.
	 */
	public boolean above(ServiceKeyEnum input) {
		return compareTo(input) > 0;
	}

	/**
	 * Checks whether the enum's value is less than the input enum's value.
	 */
	public boolean below(ServiceKeyEnum input) {
		return compareTo(input) < 0;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(ServiceKeyEnum.USER.ordinal());
		System.out.println(ServiceKeyEnum.getEnum("LOGIN"));
	}

}
