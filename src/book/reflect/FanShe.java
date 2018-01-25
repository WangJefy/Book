package book.reflect;

/**
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         FanShe
 * ����ʱ�䣺 2018��1��21������12:25:44
 * �޸��ˣ�     Jefy
 * ��������     ��ȡClass��������ַ�ʽ
 * 		  1.Object---> getClass()
 *  	  2.�κ��ࣨ����������������,�ӿڣ�����һ����̬����class
 *        3.ͨ��Class��ľ�̬������forName(String className)  (Ƶ��ʹ��)
 */
public class FanShe {
	public static void main(String[] args) {
		//��һ�ַ�ʽ��ȡClass����
		Student stu1 = new Student();
		Class<?> stuClass = stu1.getClass();//��ȡClass����
		System.out.println(stuClass.getName());
		
		//�ڶ��ַ�ʽ��ȡClass����
		Class<?> stuClass2 = Student.class;
		System.out.println(stuClass == stuClass2);//
		
		//�����ַ�ʽ��ȡClass����
		try {
			Class<?> stuClass3 = Class.forName("book.reflect.Student");
			System.out.println(stuClass3 == stuClass2);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * �������ڼ䣬һ����ֻ����һ��Class����!!!
	 * ���ַ�ʽ���õ����֣���һ�ֶ������˻�Ҫ�����ʲô��
	 *              �ڶ�����Ҫ������İ�������̫ǿ�����������ױ������
	 *              �����֣�һ���ַ������Դ���Ҳ��д�������ļ��еȶ��ַ���.��Ϊ����
	 */
}
