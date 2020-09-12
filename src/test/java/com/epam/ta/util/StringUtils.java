package com.epam.ta.util;

import java.util.Random;

public class StringUtils
{
	private static final String ALFANUMERICAL_ALL_CAPS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static Random random = new Random();
	private static int USER_NAME_EMAIL_FIXED_LENGTH = 7;


	public static String getRandomString(int stringLength)
	{
		StringBuilder stringBuilder = new StringBuilder(stringLength);
		for (int i = 0; i < stringLength; i++)
		{
			stringBuilder.append(ALFANUMERICAL_ALL_CAPS.charAt(random.nextInt(ALFANUMERICAL_ALL_CAPS.length())));
		}
		return stringBuilder.toString();
	}

	public static String generateRandomStringWithSetLength(int setLength){
		return "Hello !".concat(getRandomString(setLength));
	}

	public static String generateRandomEmailWithSetLength(){
		return getRandomString(USER_NAME_EMAIL_FIXED_LENGTH).concat("@bigmir.net");
	}

}
