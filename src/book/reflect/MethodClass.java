package book.reflect;

import java.lang.reflect.Method;

/*
 * ��ȡ��Ա���������ã�
 * 	1.����
 * 		public Method[] getMethods();��ȡ����public�����������˸���Ҳ����Object���е�
 * 		public Method[] getDeclaredMethods();��ȡ���еĳ�Ա����������˽�У��������̳еģ�
 *  2.��ȡ������Ա����
 *  	public Method getMethod(String name,Class<?>... parameterTypes);
 *      public Method getDeclaredMethod(String name,Class<?>... parameterTypes)
 *      								����˵����
 *      								name: ������
 *      								Class<?>... ��Class���͵Ķ���
 *      
 *      ���÷�����
 *      	Method --->public Object invoke(Object obj,Object... args);
 *      								����˵����
 *      								obj : Ҫ���÷����Ķ���
 *      								args: ���÷�ʽʱ�����ݵ�ʵ��
 */
public class MethodClass {
	public static void main(String[] args) throws Exception{
		//1.��ȡClass����
		Class<?> stuClass = Class.forName("book.reflect.Student");
		//2.��ȡ���е�public����
		System.out.println("************��ȡ���е�public��Ա����**************");
		Method[] methodsArray = stuClass.getMethods();
		for (Method method : methodsArray) {
			System.out.println(method);
		}
		
		System.out.println();
		System.out.println("***********��ȡ���еĳ�Ա����������˽�е�*************");
		Method[] declaredMethods = stuClass.getDeclaredMethods();
		for (Method method : declaredMethods) {
			System.out.println(method);
		}
		
		System.out.println();
		System.out.println("*************��ȡpublic show1����*************");
		Method m = stuClass.getMethod("show1", String.class);
		System.out.println(m);
		//ʵ����һ��Student����
		Object obj = stuClass.getConstructor().newInstance();//��������ָ�����������·���
		System.out.println("obj��Ϣ:" + obj.toString());
		
		System.out.println();
		System.out.println("***************��ȡprivate show4����**********");
		m = stuClass.getDeclaredMethod("show4", int.class);
		System.out.println(m);
		m.setAccessible(true);
		m.invoke(obj, 20);
	}
}
