package book.string;
/**
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         BasicToString
 * 创建时间： 2018年1月24日下午12:49:50
 * 修改人：     Jefy
 * 类描述：     基本数据类型与字符串的转换
 * 一、基本类型转换成字符串
 *   1.使用String的静态方法valueOf(basic_type)
 *   2.将基本类型封装成包装类，再调用对象的toString()方法
 *   3.用一个空字符串加上基本类型，就是基本类型对应的字符串
 * 二、字符串转成基本类型
 *   1.调用包装类的parseXXX静态方法
 *   2.用字符串构造基本类型的封装对象，在调用封装对象的xxxValue()方法
 */
public class BasicToString {
	/**
	 * 整数转成字符串
	 * @param n
	 * @return
	 */
	public String int2Str(int n) {
		//return String.valueOf(n);
		//return new Integer(n).toString();
		return "" + n;
	}
	/**字符串转成整数
	 * @param str
	 * @return
	 */
	public int str2int(String str) {
		return Integer.parseInt(str);
		//return new Integer(str).intValue();
	}
	public static void main(String[] args) {
		BasicToString bs = new BasicToString();
		int n = 124;
		String str = bs.int2Str(n);
		System.out.println("整型转成字符串： " + str);
		
		int i = bs.str2int(str);
		System.out.println("字符串str转成整型: " + i);
	}
}
