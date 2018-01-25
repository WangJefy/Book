package book.string;

/**
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         JavaIdentifier
 * 创建时间： 2018年1月24日下午3:01:25
 * 修改人：     Jefy
 * 类描述：     判断一个字符串是否能够当Java标识符，即是否为合法的标识符
 */
public class JavaIdentifier {
	/**
	 * 判断字符串是否是合法的标识符
	 * @param s
	 * @return
	 */
	public static boolean isJavaIdentifier(String s) {
		if((s == null) || ((s.length()) == 0)) {
			return false;
		}
		
		for(int i = 0;i < s.length();i++) {
			if(!Character.isJavaIdentifierPart(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println("\"my_var\" is an identifier? " + JavaIdentifier.isJavaIdentifier("my_var") );
		System.out.println("\"my_var.1\" is an identifier? " + JavaIdentifier.isJavaIdentifier("my_var.1") );
		
	}
}
