/**
 * 
 */
package com.leadtone.riders;

/**
 * @author lvqi
 * 
 */

public enum BizKeyEnum {
	LOGIN(0), 
	REGISTER_USER(1), GET_USER_PROFILE(2),GET_TEAM_INFO(3),GET_FRIENDS(4) , GET_ACTIVITY(5) , GET_ACTIVITY_LIST(6) , UPDATE_USER_PROFILE(7);

	private static BizKeyEnum[] allEnums = { 
		LOGIN, 
		REGISTER_USER, GET_USER_PROFILE,GET_TEAM_INFO,GET_FRIENDS , GET_ACTIVITY , GET_ACTIVITY_LIST , UPDATE_USER_PROFILE};

	private BizKeyEnum(int value) {
	}

	public static BizKeyEnum[] getAllEnums() {
		return allEnums;
	}

	public int value() {
		return ordinal();
	}

	public static BizKeyEnum getEnum(int value) {
		switch (value) {
		case 0:
			return LOGIN;
		case 1:
			return REGISTER_USER;
		case 2:
			return GET_USER_PROFILE;
		case 3:
            return GET_TEAM_INFO;
		case 4:
            return GET_FRIENDS;
		case 5:
            return GET_ACTIVITY;
		case 6:
            return GET_ACTIVITY_LIST;
		case 7:
            return UPDATE_USER_PROFILE;
		default:
			return null;
		}
	}

	public static BizKeyEnum getEnum(String value) {
		return BizKeyEnum.valueOf(value);
	}

	/**
	 * Checks whether the enum's value is greater than the input enum's value.
	 */
	public boolean above(BizKeyEnum input) {
		return compareTo(input) > 0;
	}

	/**
	 * Checks whether the enum's value is less than the input enum's value.
	 */
	public boolean below(BizKeyEnum input) {
		return compareTo(input) < 0;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(BizKeyEnum.LOGIN.ordinal());
		System.out.println(BizKeyEnum.getEnum("LOGIN"));
	}

}
