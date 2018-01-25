package book.string;

import java.io.UnsupportedEncodingException;

/**
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         ChangeCharset
 * 创建时间： 2018年1月24日下午9:42:54
 * 修改人：     Jefy
 * 类描述：    字符串编码的转换
 * 
 * 字节数组 + 字符编码集 = 编码
 * 字符串  + 字符编码集 = 解码
 */
public class ChangeCharset {
	/**
	 * 7位ASCII字符，也叫做ISO646-US、Unicode字符集的基本拉丁块
	 */
	public static final String US_ASCII = "US-ASCII";
	
	public static final String ISO_8859_1 = "ISO-8859-1";
	
	public static final String UTF_8 = "UTF-8";
	
	public static final String UTF_16BE = "UTF-16BE";
	
	public static final String UTF_16LE = "UTF-16LE";
	
	public static final String UTF_16 = "UTF-16";
	/*中文超大字符集*/
	public static final String GBK = "GBK";
	
	//将字符编码转换成US-ASCII
	public String toASCII(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str,US_ASCII);
	}
	//将字符编码转成ISO_8859_1
	public String toISO_8859_1(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, ISO_8859_1);
	}
	//将字符编码转成UTF-8
	public String toUTF_8(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str,UTF_8);
	}
	//将字符编码转成UTF_16BE
	public String toUTF_16BE(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, UTF_16BE);
	}
	//将字符编码转成UTF_16LE
	public String toUTF_16LE(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, UTF_16LE);
	}
	//将字符编码转成UTF_16
	public String toUTF_16(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, UTF_16);
	}
	//将字符编码转成GBK
	public String toGBK(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, GBK);
	}
	/**
	 * 字符串编码转换的实现方法1
	 * @param str 待转换编码的字符串
	 * @param newCharset 目标编码 
	 * @return 返回转换编码后的字符串
	 */
	private String changeCharset(String str, String newCharset)throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		if(str != null) {
			//用默认字符编码解码字符串。与系统相关，中文Windows默认为GB2312
			byte[] bs = str.getBytes();//解码从而获得字节数组byte[] bs
			return new String(bs,newCharset);//用新的字符编码集  再编码 生成可视的字符串
		}
		return null;
	}
	public String changeCharset(String str,String oldCharset,String newCharset) throws UnsupportedEncodingException{
		if(str != null) {
			//用旧的字符编码去  解码  字符串，解码可能会出现异常
			byte[] bs = str.getBytes(oldCharset);
			return new String(bs,newCharset);
		}
		return null;
	}
	public static void main(String[] args) throws UnsupportedEncodingException {
		ChangeCharset test = new ChangeCharset();
		
		String str = "This is a 中文的 String!";
		System.out.println("str:" + str);
		String gbk = test.toGBK(str);
		System.out.println("转成GBK码：" + gbk); 
		
		System.out.println();
		String ascii = test.toASCII(str);
		System.out.println("转成ASCII码：" + ascii);
		
		System.out.println();
		String iso_8859_12 = test.toISO_8859_1(str);
		System.out.println("转成ISO-8859-1码：" + iso_8859_12);
		gbk = test.changeCharset(iso_8859_12, ISO_8859_1,GBK);
		System.out.println("再把ISO-8859-1码转成GBK码：" + gbk);
		
		System.out.println();
		String utf_8 = test.toUTF_8(str);
		System.out.println("转成UTF-8码：" + utf_8);
		
		System.out.println();
		String utf_16be2 = test.toUTF_16BE(str);
		System.out.println("转成UTF-16BE码：" + utf_16be2);
		
		System.out.println();
		String utf_16le2 = test.toUTF_16LE(str);
		System.out.println("转成UTF-16LE码：" + utf_16le2);
		String changeCharset = test.changeCharset(utf_16le2, UTF_16LE, GBK);
		System.out.println("再把UTF-16LE码转成GBK码：" + changeCharset);
		System.out.println();
		String utf_162 = test.toUTF_16(str);
		System.out.println("转成UTF-16码：" + utf_162);
	}
}
