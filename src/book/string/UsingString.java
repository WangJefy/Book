package book.string;

import java.util.Scanner;

/**
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         UsingString
 * 创建时间： 2018年1月24日下午12:04:41
 * 修改人：     Jefy
 * 类描述：    使用字符串类String 
 */
public class UsingString {
	/**
	 * 查找子字符串
	 * @param str 
	 */
	public static void testFindStr(String str) {
		System.out.println("str.indexOf(\"is\") = " + str.indexOf("is") ); 
		System.out.println("str.indexOf(\"is\", 4) = " + str.indexOf("is",4));
		System.out.println("str.lastIndexOf(\"is\") = " + str.lastIndexOf("is"));//查找"is"最后出现的位置
		System.out.println("str.lastIndexOf(\"is\",1) = " + str.lastIndexOf("is",1));
	}
	/**
	 * 截取字符串
	 * @param str
	 */
	public static void testSubStr(String str) {
		System.out.println("str.substring(2) = " + str.substring(2));
		
		System.out.println("str.substring(2,9) = " + str.substring(2, 9));
	}
	
	/**
	 * 替换字符串
	 * @param str
	 */
	public static void testReplaceStr(String str) {
		System.out.println("str.replace('i','I') = " + str.replace('i', 'I'));
	}
	public static void main(String[] args) {
		//String str = "This is a String object!";
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入字符串：");
		String str = sc.nextLine();
		System.out.println("输入的字符串：        " + str);
		testFindStr(str);
		System.out.println("原来输入的字符串：" + str);
		System.out.println();
		testReplaceStr(str);
		System.out.println("原来输入的字符串：" + str);
		sc.close();
		System.out.println("String 是一个不变类，当字符串发生变化时，它会创造一个新的字符串，原字符串不变。");
	}
}
