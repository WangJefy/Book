package book.string;

import java.io.UnsupportedEncodingException;

/**
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         ChangeCharset
 * ����ʱ�䣺 2018��1��24������9:42:54
 * �޸��ˣ�     Jefy
 * ��������    �ַ��������ת��
 * 
 * �ֽ����� + �ַ����뼯 = ����
 * �ַ���  + �ַ����뼯 = ����
 */
public class ChangeCharset {
	/**
	 * 7λASCII�ַ���Ҳ����ISO646-US��Unicode�ַ����Ļ���������
	 */
	public static final String US_ASCII = "US-ASCII";
	
	public static final String ISO_8859_1 = "ISO-8859-1";
	
	public static final String UTF_8 = "UTF-8";
	
	public static final String UTF_16BE = "UTF-16BE";
	
	public static final String UTF_16LE = "UTF-16LE";
	
	public static final String UTF_16 = "UTF-16";
	/*���ĳ����ַ���*/
	public static final String GBK = "GBK";
	
	//���ַ�����ת����US-ASCII
	public String toASCII(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str,US_ASCII);
	}
	//���ַ�����ת��ISO_8859_1
	public String toISO_8859_1(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, ISO_8859_1);
	}
	//���ַ�����ת��UTF-8
	public String toUTF_8(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str,UTF_8);
	}
	//���ַ�����ת��UTF_16BE
	public String toUTF_16BE(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, UTF_16BE);
	}
	//���ַ�����ת��UTF_16LE
	public String toUTF_16LE(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, UTF_16LE);
	}
	//���ַ�����ת��UTF_16
	public String toUTF_16(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, UTF_16);
	}
	//���ַ�����ת��GBK
	public String toGBK(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, GBK);
	}
	/**
	 * �ַ�������ת����ʵ�ַ���1
	 * @param str ��ת��������ַ���
	 * @param newCharset Ŀ����� 
	 * @return ����ת���������ַ���
	 */
	private String changeCharset(String str, String newCharset)throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		if(str != null) {
			//��Ĭ���ַ���������ַ�������ϵͳ��أ�����WindowsĬ��ΪGB2312
			byte[] bs = str.getBytes();//����Ӷ�����ֽ�����byte[] bs
			return new String(bs,newCharset);//���µ��ַ����뼯  �ٱ��� ���ɿ��ӵ��ַ���
		}
		return null;
	}
	public String changeCharset(String str,String oldCharset,String newCharset) throws UnsupportedEncodingException{
		if(str != null) {
			//�þɵ��ַ�����ȥ  ����  �ַ�����������ܻ�����쳣
			byte[] bs = str.getBytes(oldCharset);
			return new String(bs,newCharset);
		}
		return null;
	}
	public static void main(String[] args) throws UnsupportedEncodingException {
		ChangeCharset test = new ChangeCharset();
		
		String str = "This is a ���ĵ� String!";
		System.out.println("str:" + str);
		String gbk = test.toGBK(str);
		System.out.println("ת��GBK�룺" + gbk); 
		
		System.out.println();
		String ascii = test.toASCII(str);
		System.out.println("ת��ASCII�룺" + ascii);
		
		System.out.println();
		String iso_8859_12 = test.toISO_8859_1(str);
		System.out.println("ת��ISO-8859-1�룺" + iso_8859_12);
		gbk = test.changeCharset(iso_8859_12, ISO_8859_1,GBK);
		System.out.println("�ٰ�ISO-8859-1��ת��GBK�룺" + gbk);
		
		System.out.println();
		String utf_8 = test.toUTF_8(str);
		System.out.println("ת��UTF-8�룺" + utf_8);
		
		System.out.println();
		String utf_16be2 = test.toUTF_16BE(str);
		System.out.println("ת��UTF-16BE�룺" + utf_16be2);
		
		System.out.println();
		String utf_16le2 = test.toUTF_16LE(str);
		System.out.println("ת��UTF-16LE�룺" + utf_16le2);
		String changeCharset = test.changeCharset(utf_16le2, UTF_16LE, GBK);
		System.out.println("�ٰ�UTF-16LE��ת��GBK�룺" + changeCharset);
		System.out.println();
		String utf_162 = test.toUTF_16(str);
		System.out.println("ת��UTF-16�룺" + utf_162);
	}
}
