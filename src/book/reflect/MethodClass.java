package book.reflect;

import java.lang.reflect.Method;

/*
 * 获取成员方法并调用：
 * 	1.批量
 * 		public Method[] getMethods();获取所有public方法，包括了父类也包括Object类中的
 * 		public Method[] getDeclaredMethods();获取所有的成员方法，包括私有（不包括继承的）
 *  2.获取单个成员方法
 *  	public Method getMethod(String name,Class<?>... parameterTypes);
 *      public Method getDeclaredMethod(String name,Class<?>... parameterTypes)
 *      								参数说明：
 *      								name: 方法名
 *      								Class<?>... ：Class类型的对象
 *      
 *      调用方法：
 *      	Method --->public Object invoke(Object obj,Object... args);
 *      								参数说明：
 *      								obj : 要调用方法的对象
 *      								args: 调用方式时所传递的实参
 */
public class MethodClass {
	public static void main(String[] args) throws Exception{
		//1.获取Class对象
		Class<?> stuClass = Class.forName("book.reflect.Student");
		//2.获取所有的public方法
		System.out.println("************获取所有的public成员方法**************");
		Method[] methodsArray = stuClass.getMethods();
		for (Method method : methodsArray) {
			System.out.println(method);
		}
		
		System.out.println();
		System.out.println("***********获取所有的成员方法，包括私有的*************");
		Method[] declaredMethods = stuClass.getDeclaredMethods();
		for (Method method : declaredMethods) {
			System.out.println(method);
		}
		
		System.out.println();
		System.out.println("*************获取public show1方法*************");
		Method m = stuClass.getMethod("show1", String.class);
		System.out.println(m);
		//实例化一个Student对象
		Object obj = stuClass.getConstructor().newInstance();//父类引用指向子类对象的新发现
		System.out.println("obj信息:" + obj.toString());
		
		System.out.println();
		System.out.println("***************获取private show4方法**********");
		m = stuClass.getDeclaredMethod("show4", int.class);
		System.out.println(m);
		m.setAccessible(true);
		m.invoke(obj, 20);
	}
}
