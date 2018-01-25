package book.string;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.sun.javafx.image.ByteToBytePixelConverter;

/**
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         Password
 * 创建时间： 2018年1月25日上午10:51:17
 * 修改人：     Jefy
 * 类描述：     密码加密与验证
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
	 * 用MD5算法对输入的密码字符串进行编码
	 * @param inputString
	 * @return
	 */
	private static String encodeByMD5(String originString) {
		// TODO Auto-generated method stub
		if(originString != null) {
			try {
				//根据指定算法，创建信息摘要对象
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] results = md.digest(originString.getBytes());
				System.out.println("字节数组的大小：" + results.length);
				//将得到的字节数组转成字符串返回
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
	 * 转换字节数组为16进制字符串
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
	//将一个字节转化为16进制形式的字符串
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
		System.out.println("对123456用MD5摘要后的字符串：" + password);
		
		String inputString = "123456";
		System.out.println("888与密码是否匹配？" + Password.authenticatePassword(password, inputString));
		byte a = 8;
		String byteArrayToHexString = Password.byteArrayToHexString(a);
		System.out.println(byteArrayToHexString);
	}
}
