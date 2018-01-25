package book.oo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test01 {
	
	public static void main(String args[]) {
		String str1 = "12345678901234568901234567890";
		String str2 = ")faew位发顺丰";
		String str3 = "once";
//		String pattern = "^((?!(【|】| )).){0,30}$";
//		String pattern = "^((?!e).)*$";
//		String pattern = "^((?!(【|】| )).){0,30}$";
		String pattern = "[0-9]+";

		Pattern r = Pattern.compile(pattern);
		Matcher m1 = r.matcher(str1);
		Matcher m2 = r.matcher(str2);
		Matcher m3 = r.matcher(str3);
		System.out.println("str1 满足条件吗？" + m1.matches());
		System.out.println("str2 满足条件吗？" + m2.matches());
		System.out.println("str3 满足条件吗？" + m3.matches());
	}

}
