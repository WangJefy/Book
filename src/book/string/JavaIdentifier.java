package book.string;

/**
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         JavaIdentifier
 * ����ʱ�䣺 2018��1��24������3:01:25
 * �޸��ˣ�     Jefy
 * ��������     �ж�һ���ַ����Ƿ��ܹ���Java��ʶ�������Ƿ�Ϊ�Ϸ��ı�ʶ��
 */
public class JavaIdentifier {
	/**
	 * �ж��ַ����Ƿ��ǺϷ��ı�ʶ��
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
