package book.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         CallMethod
 * ����ʱ�䣺 2018��1��21������8:24:02
 * �޸��ˣ�     Jefy
 * ��������    ��̬������ķ�������ζ�̬�������ʵ����������ķ�����������̬������ʵ������
 *        1.�������Class�����newInstance�����ܹ�����һ����Ķ��󣬸÷���ʵ���ϵ���������޲ι��캯��
 */
public class CallMethod {
	//������
	static class TestClass{
		static int sa = 100;
		static int sb = 50;
		
		int a;
		int b;
		
		public TestClass() {
			this.a = 5;
			this.b = 10;
		}
		
		public TestClass(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		public static int sadd() {
			return sa + sb;
		}
		public static int sadd(int a, int b) {
			return a + b;
		}
		
		public int add() {
			return this.a + this.b;
		}
		public int add(int a, int b) {
			return a + b;
		}
		
		public String toString() {
			return "a =" + this.a + "; b = " + this.b;
		}
		
		@SuppressWarnings("unused")
		private int sub() {
			return this.a + this.b;
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//��ȡTestClass��Class����
		Class<?> testClass = Class.forName("book.reflect.CallMethod$TestClass");
		Class<?> testClass2 = Class.forName("book.reflect.CallMethod$TestClass");
		System.out.println(testClass.equals(testClass2));//ͬһ��Class����
		System.out.println("����Ϊ��" + testClass.getName());
		
		/** ����ʵ��   **/
		//1.ʹ��Class�����newInstance��������һ��ʵ�������ַ�����Ĭ�Ϲ��췽����������
		TestClass objectA = (TestClass) testClass.newInstance();
		System.out.println("Class��newInstance()��������Ĭ��TestClassʵ��" + objectA.toString());
		
		
		/** ��ȡ����  **/
		//��ȡ���з���
		Method[] methods = testClass.getMethods();
		System.out.println(methods[0]);
		
		try {
			//��ȡĳ���ض����޲η���
			Method saddMethod1 = testClass.getMethod("sadd");
			Method addMethod1 = testClass.getMethod("add");
			
			//��ȡĳ���ض����вη���
			Method saddMethod2 = testClass.getMethod("sadd", new Class[] {int.class,int.class});
			Method addMethod2 = testClass.getMethod("add", new Class[] {int.class,int.class});
			System.out.println(saddMethod2.toString());
			System.out.println(addMethod2.toString());
					
			/**���þ�̬����**/
			//���ò��������ľ�̬����
			
			int result = ((Integer) saddMethod1.invoke("sadd")).intValue();
			System.out.println("�����޲εľ�̬����sadd():"  + result);
			
			//�����вεľ�̬����
			result = ((Integer) saddMethod2.invoke(null, new Object[] {new Integer(30),new Integer(70)})).intValue();
			System.out.println("���ô�����30,70�ľ�̬����sadd:" + result);
			
			/** ����ʵ������ **/
			objectA = (TestClass) testClass.newInstance();
			//���ò���������ʵ������
			result = ((Integer)addMethod1.invoke(objectA)).intValue();
			System.out.println("���ò���������ʵ������add:" + result);
			
			//���ú��ε�ʵ������
			result = ((Integer) addMethod2.invoke(objectA, new Object[] {new Integer(130),new Integer(170)})).intValue();
			System.out.println("���ú��ε�ʵ������add: " + result);
			
			//���ܷ���˽�з�������˵��һ�����⣺Class.forName()������TestClass.class��Class���󣬲���TestClass����
			/**
			 * Method sub = testClass.getMethod("sub",null);
			 * System.out.println(sub.invoke(objectA,null);
			 */
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
