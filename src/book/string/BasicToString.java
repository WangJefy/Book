package book.string;
/**
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         BasicToString
 * ����ʱ�䣺 2018��1��24������12:49:50
 * �޸��ˣ�     Jefy
 * ��������     ���������������ַ�����ת��
 * һ����������ת�����ַ���
 *   1.ʹ��String�ľ�̬����valueOf(basic_type)
 *   2.���������ͷ�װ�ɰ�װ�࣬�ٵ��ö����toString()����
 *   3.��һ�����ַ������ϻ������ͣ����ǻ������Ͷ�Ӧ���ַ���
 * �����ַ���ת�ɻ�������
 *   1.���ð�װ���parseXXX��̬����
 *   2.���ַ�������������͵ķ�װ�����ڵ��÷�װ�����xxxValue()����
 */
public class BasicToString {
	/**
	 * ����ת���ַ���
	 * @param n
	 * @return
	 */
	public String int2Str(int n) {
		//return String.valueOf(n);
		//return new Integer(n).toString();
		return "" + n;
	}
	/**�ַ���ת������
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
		System.out.println("����ת���ַ����� " + str);
		
		int i = bs.str2int(str);
		System.out.println("�ַ���strת������: " + i);
	}
}
