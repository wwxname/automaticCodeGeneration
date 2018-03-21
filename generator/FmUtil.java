package com.td.spm.generator;


public class FmUtil {
	public static String TuoToZiduan(String Tuo) {
		char[] cs = new char[80];
		int j = 0;
		for (int i = 0; i < Tuo.length(); i++) {
			char c = Tuo.charAt(i);
			if (Character.isUpperCase(c)) {
				cs[j] = '_';
				j++;
				cs[j] = Character.toLowerCase(c);
			} else {
				cs[j] = c;
			}
			j++;
		}
		return String.valueOf(cs).trim();
	}
	
	public static String ClassPathToDirPath(String Tuo) {
		char[] cs = new char[50];
		int j = 0;
		for (int i = 0; i < Tuo.length(); i++) {
			char c = Tuo.charAt(i);
			if (c=='.') {
				cs[j] = '/';
			} else {
				cs[j] = c;
			}
			j++;
		}
		return String.valueOf(cs).trim();
	}
}
