package book.string;

/**
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         UsingStringBuffer
 * ����ʱ�䣺 2018��1��24������3:27:42
 * �޸��ˣ�     Jefy
 * ��������     ʹ��StringBuffer
 * String�ǲ����࣬��String�޸��ַ������õ�����һ���µ��ַ����������Ƶ�����޸��ַ�������������ܶ�String���󣬿�����ܴ�
 * ��ˣ�java�ṩ��StringBuffer�࣬�ø����޸��ַ���������String��Ч�ʸߵöࡣ
 * 
 * A thread-safe, mutable sequence of characters.һ���̰߳�ȫ���ɱ���ַ�����
 * 
 * 1.indexOf()��lastIndexOf()ʵ���������ڲ����Ӵ�
 * 2.substringʵ���������ڽ�ȡ�Ӵ�
 * 3.charAtʵ���������ڻ�ȡĳλ���ϵ��ַ�
 * 4.appendʵ���������ַ���β������ַ������ַ���
 * 5.insertʵ���������ַ����м�����ַ������ַ���
 * 6.delete������deleteCharAt����ɾ���ַ����е��Ӵ������ַ�
 * 7.replace���������滻�Դ�
 * 8.reverse�������ַ�������
 */
public class UsingStringBuffer {
	/**
	 * ����ƥ���ַ���
	 */
	public static void testFindStr(StringBuffer sb) {
		System.out.println("\"is\"�״γ��ֵ�λ�ã�" + sb.indexOf("is")); 
		System.out.println("\"is\"�����ֵ�λ�ã�" + sb.lastIndexOf("is"));
	}
	/**
	 * ��ȡ�ַ���
	 */
	public static void testSubStr(StringBuffer sb) {
		System.out.println("���ַ�����" + sb.substring(3));
		System.out.println("���ַ�����" + sb.substring(2, 5));
		System.out.println("���ַ�����" + sb.substring(1, 7));
		System.out.println("ԭ�ַ�����" + sb);
	}
	/**
	 * ��ȡ�ַ�����ĳ��λ���ϵ��ַ�
	 * @param sb
	 */
	public static void testCharAt(StringBuffer sb) {
		System.out.println("��5��λ���ϵ��ַ���" + sb.charAt(5)); 
	}
	public static void testAppend(StringBuffer sb) {
		sb.append("good");
		sb.append(true);//�����ǽ�������trueת�� 't' 'r' 'u' 'e' ���StringBuffer��
		sb.append(new java.util.Date());
		sb.append(2.9f);
		char[] chars = {'3','d'};
		sb.append(chars);
		System.out.println(sb);
	}
	/**
	 * ɾ���ַ����е�����
	 * @param sb
	 */
	public static void testDelete(StringBuffer sb) {
		System.out.println("ɾ����һ���ַ���" + sb.deleteCharAt(0));
	}
	public static void testReverseStr(StringBuffer sb) {
		System.out.println("��ת����ַ���:" + sb.reverse());
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
