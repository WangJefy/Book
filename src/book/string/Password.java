package book.string;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.sun.javafx.image.ByteToBytePixelConverter;

/**
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         Password
 * ����ʱ�䣺 2018��1��25������10:51:17
 * �޸��ˣ�     Jefy
 * ��������     �����������֤
 */
public class Password {
	private final static String [] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
	
	public static String createPassword(String inputString) {
		return encodeByMD5(inputString);
	}
	
	public static boolean authenticatePassword(String password, String inputString) {
		if(password.equals(encodeByMD5(inputString))) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * ��MD5�㷨������������ַ������б���
	 * @param inputString
	 * @return
	 */
	private static String encodeByMD5(String originString) {
		// TODO Auto-generated method stub
		if(originString != null) {
			try {
				//����ָ���㷨��������ϢժҪ����
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] results = md.digest(originString.getBytes());
				System.out.println("�ֽ�����Ĵ�С��" + results.length);
				//���õ����ֽ�����ת���ַ�������
				String resultString = byteArrayToHexString(results);
				return resultString.toUpperCase();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * ת���ֽ�����Ϊ16�����ַ���
	 * @param results
	 * @return
	 */
	private static String byteArrayToHexString(byte[] b) {
		// TODO Auto-generated method stub
		StringBuffer resultSb = new StringBuffer();
		for(int i = 0;i < b.length; i++) {
			resultSb.append(byteArrayToHexString(b[i]));
		}
		return resultSb.toString();
	}
	//��һ���ֽ�ת��Ϊ16������ʽ���ַ���
	public static String byteArrayToHexString(byte b) {
		// TODO Auto-generated method stub
		int n = b;
		if(n < 0) {
			n = 256 + n;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
	
	public static void main(String[] args) {
		String password = Password.createPassword("123456");
		System.out.println("��123456��MD5ժҪ����ַ�����" + password);
		
		String inputString = "123456";
		System.out.println("888�������Ƿ�ƥ�䣿" + Password.authenticatePassword(password, inputString));
		byte a = 8;
		String byteArrayToHexString = Password.byteArrayToHexString(a);
		System.out.println(byteArrayToHexString);
	}
}
