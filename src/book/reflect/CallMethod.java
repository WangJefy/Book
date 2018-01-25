package book.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         CallMethod
 * 创建时间： 2018年1月21日上午8:24:02
 * 修改人：     Jefy
 * 类描述：    动态调用类的方法：如何动态生成类的实例，调用类的方法，包括静态方法和实例方法
 *        1.调用类的Class对象的newInstance方法能够创建一个类的对象，该方法实质上调用了类的无参构造函数
 */
public class CallMethod {
	//测试类
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
		//获取TestClass的Class对象
		Class<?> testClass = Class.forName("book.reflect.CallMethod$TestClass");
		Class<?> testClass2 = Class.forName("book.reflect.CallMethod$TestClass");
		System.out.println(testClass.equals(testClass2));//同一个Class对象
		System.out.println("类名为：" + testClass.getName());
		
		/** 创建实例   **/
		//1.使用Class对象的newInstance方法创建一个实例，这种方法用默认构造方法创建对象
		TestClass objectA = (TestClass) testClass.newInstance();
		System.out.println("Class的newInstance()方法创建默认TestClass实例" + objectA.toString());
		
		
		/** 获取方法  **/
		//获取所有方法
		Method[] methods = testClass.getMethods();
		System.out.println(methods[0]);
		
		try {
			//获取某个特定的无参方法
			Method saddMethod1 = testClass.getMethod("sadd");
			Method addMethod1 = testClass.getMethod("add");
			
			//获取某个特定的有参方法
			Method saddMethod2 = testClass.getMethod("sadd", new Class[] {int.class,int.class});
			Method addMethod2 = testClass.getMethod("add", new Class[] {int.class,int.class});
			System.out.println(saddMethod2.toString());
			System.out.println(addMethod2.toString());
					
			/**调用静态方法**/
			//调用不带参数的静态方法
			
			int result = ((Integer) saddMethod1.invoke("sadd")).intValue();
			System.out.println("调用无参的静态方法sadd():"  + result);
			
			//调用有参的静态方法
			result = ((Integer) saddMethod2.invoke(null, new Object[] {new Integer(30),new Integer(70)})).intValue();
			System.out.println("调用带参数30,70的静态方法sadd:" + result);
			
			/** 调用实例方法 **/
			objectA = (TestClass) testClass.newInstance();
			//调用不带参数的实例方法
			result = ((Integer)addMethod1.invoke(objectA)).intValue();
			System.out.println("调用不带参数的实例方法add:" + result);
			
			//调用含参的实例方法
			result = ((Integer) addMethod2.invoke(objectA, new Object[] {new Integer(130),new Integer(170)})).intValue();
			System.out.println("调用含参的实例方法add: " + result);
			
			//不能访问私有方法，就说明一个问题：Class.forName()创建的TestClass.class是Class对象，不是TestClass对象
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
