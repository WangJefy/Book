package book.string;

import java.util.Scanner;

/**
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         UsingString
 * ����ʱ�䣺 2018��1��24������12:04:41
 * �޸��ˣ�     Jefy
 * ��������    ʹ���ַ�����String 
 */
public class UsingString {
	/**
	 * �������ַ���
	 * @param str 
	 */
	public static void testFindStr(String str) {
		System.out.println("str.indexOf(\"is\") = " + str.indexOf("is") ); 
		System.out.println("str.indexOf(\"is\", 4) = " + str.indexOf("is",4));
		System.out.println("str.lastIndexOf(\"is\") = " + str.lastIndexOf("is"));//����"is"�����ֵ�λ��
		System.out.println("str.lastIndexOf(\"is\",1) = " + str.lastIndexOf("is",1));
	}
	/**
	 * ��ȡ�ַ���
	 * @param str
	 */
	public static void testSubStr(String str) {
		System.out.println("str.substring(2) = " + str.substring(2));
		
		System.out.println("str.substring(2,9) = " + str.substring(2, 9));
	}
	
	/**
	 * �滻�ַ���
	 * @param str
	 */
	public static void testReplaceStr(String str) {
		System.out.println("str.replace('i','I') = " + str.replace('i', 'I'));
	}
	public static void main(String[] args) {
		//String str = "This is a String object!";
		Scanner sc = new Scanner(System.in);
		System.out.println("�������ַ�����");
		String str = sc.nextLine();
		System.out.println("������ַ�����        " + str);
		testFindStr(str);
		System.out.println("ԭ��������ַ�����" + str);
		System.out.println();
		testReplaceStr(str);
		System.out.println("ԭ��������ַ�����" + str);
		sc.close();
		System.out.println("String ��һ�������࣬���ַ��������仯ʱ�����ᴴ��һ���µ��ַ�����ԭ�ַ������䡣");
	}
}
