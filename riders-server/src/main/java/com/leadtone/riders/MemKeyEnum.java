/**
 * 
 */
package com.leadtone.riders;

/**
 * @author lvqi
 * 
 */

public enum MemKeyEnum {
	MOBILE(0), 
	EMAIL(1), SERVER(2),CONFIG(3),CLIENT(4) , EXCONFIG(5) , POP3SERVER(6) , POP3ACCOUNT(7);

	private static MemKeyEnum[] allEnums = { 
	    MOBILE, 
	    EMAIL, SERVER ,CONFIG , CLIENT,EXCONFIG,POP3SERVER,POP3ACCOUNT};

	private MemKeyEnum(int value) {
	}

	public static MemKeyEnum[] getAllEnums() {
		return allEnums;
	}

	public int value() {
		return ordinal();
	}

	public static MemKeyEnum getEnum(int value) {
		switch (value) {
		case 0:
			return MOBILE;
		case 1:
			return EMAIL;
		case 2:
			return SERVER;
		case 3:
            return CONFIG;
		case 4:
            return CLIENT;
		case 5:
            return EXCONFIG;
		case 6:
            return POP3SERVER;
		case 7:
            return POP3ACCOUNT;
		default:
			return null;
		}
	}

	public static MemKeyEnum getEnum(String value) {
		return MemKeyEnum.valueOf(value);
	}

	/**
	 * Checks whether the enum's value is greater than the input enum's value.
	 */
	public boolean above(MemKeyEnum input) {
		return compareTo(input) > 0;
	}

	/**
	 * Checks whether the enum's value is less than the input enum's value.
	 */
	public boolean below(MemKeyEnum input) {
		return compareTo(input) < 0;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(MemKeyEnum.MOBILE.ordinal());
		System.out.println(MemKeyEnum.getEnum("EMAIL"));
	}

}
