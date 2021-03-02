package com.ragnardragus.scalinghealthprogress.util;

public class RandomUtil {

	public static int getIntegerRandByRange(int min, int max) {
		max = Math.abs(max);
		min = Math.abs(min);
		if(min > max)  min = 0;
		return (int) ((Math.random() * (max - min)) + min);
	}
}
