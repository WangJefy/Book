package book.string;

/**
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         UsingStringBuffer
 * 创建时间： 2018年1月24日下午3:27:42
 * 修改人：     Jefy
 * 类描述：     使用StringBuffer
 * String是不变类，用String修改字符串，得到的是一个新的字符串对象，如果频繁地修改字符串，将会产生很多String对象，开销会很大
 * 因此，java提供了StringBuffer类，用该类修改字符串，比用String类效率高得多。
 * 
 * A thread-safe, mutable sequence of characters.一个线程安全，可变的字符序列
 * 
 * 1.indexOf()和lastIndexOf()实例方法用于查找子串
 * 2.substring实例方法用于截取子串
 * 3.charAt实例方法用于获取某位置上的字符
 * 4.append实例方法往字符串尾部添加字符或者字符串
 * 5.insert实例方法往字符串中间插入字符或者字符串
 * 6.delete方法和deleteCharAt方法删除字符串中的子串或者字符
 * 7.replace方法用于替换自创
 * 8.reverse方法将字符串倒序
 */
public class UsingStringBuffer {
	/**
	 * 查找匹配字符串
	 */
	public static void testFindStr(StringBuffer sb) {
		System.out.println("\"is\"首次出现的位置：" + sb.indexOf("is")); 
		System.out.println("\"is\"最后出现的位置：" + sb.lastIndexOf("is"));
	}
	/**
	 * 截取字符串
	 */
	public static void testSubStr(StringBuffer sb) {
		System.out.println("子字符串：" + sb.substring(3));
		System.out.println("子字符串：" + sb.substring(2, 5));
		System.out.println("子字符串：" + sb.substring(1, 7));
		System.out.println("原字符串：" + sb);
	}
	/**
	 * 获取字符串中某个位置上的字符
	 * @param sb
	 */
	public static void testCharAt(StringBuffer sb) {
		System.out.println("第5个位置上的字符：" + sb.charAt(5)); 
	}
	public static void testAppend(StringBuffer sb) {
		sb.append("good");
		sb.append(true);//本质是将布尔型true转成 't' 'r' 'u' 'e' 存进StringBuffer中
		sb.append(new java.util.Date());
		sb.append(2.9f);
		char[] chars = {'3','d'};
		sb.append(chars);
		System.out.println(sb);
	}
	/**
	 * 删除字符串中的数据
	 * @param sb
	 */
	public static void testDelete(StringBuffer sb) {
		System.out.println("删除第一个字符后：" + sb.deleteCharAt(0));
	}
	public static void testReverseStr(StringBuffer sb) {
		System.out.println("倒转后的字符串:" + sb.reverse());
	}
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("This is a StringBuffer!");
		UsingStringBuffer.testFindStr(sb);
		UsingStringBuffer.testSubStr(sb);
		UsingStringBuffer.testAppend(sb);
		UsingStringBuffer.testDelete(sb);
		UsingStringBuffer.testReverseStr(sb);
		System.out.println(sb);
		System.out.println(sb.charAt(3));
	}
}
