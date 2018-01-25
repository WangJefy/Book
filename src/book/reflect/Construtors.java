package book.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
 * 1.获取构造方法：
 *   1)批量获取
 *     public Constructor[] getConstructors();所有public构造方法
 *     public Constructor[] getDeclaredConstructors();获取所有的构造方法（包括private、protected、default、public）
 *     
 *   2)获取单个的方法，并调用
 *     public Constructor getConstructor(Class... parameterTypes);获取单个public构造方法
 *     public Constructor getDeclaredConstructor(Class... parameterTypes);获取某个任意的构造方法
 *     
 * 	       调用单个构造方法：
 *     Constructor--->newInstance(Object... initargs)
 */
public class Construtors {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		try {
			//1.获取Class对象:Book.reflect.Student.class (运行时加载，即动态加载)
			Class<?> clazz = Class.forName("book.reflect.Student");
			
			//2.获取所有public构造方法
			System.out.println("**********反射获取所有public构造方法***********");
			Constructor<?>[] conArray = clazz.getConstructors();
			for (Constructor<?> c : conArray) {
				System.out.println(c);
			}
			
			System.out.println();
			System.out.println("**********反射获取所有声明的构造方法*************");
			conArray = clazz.getDeclaredConstructors();
			for (Constructor<?> c : conArray) {
				System.out.println(c);
			}
			
			System.out.println();
			System.out.println("**********反射获取public无参构造方法,并调用*******");
			Constructor<?> con = clazz.getConstructor();//每个类的无参构造只有一个+++
			System.out.println(con);
			//调用该无参构造函数
			con.newInstance();
			
			System.out.println();
			System.out.println("**********反射获取private有参构造函数，并调用*********");
			con = clazz.getDeclaredConstructor(int.class);
			System.out.println(con);
			//调用私有有参构造方法
			con.setAccessible(true);//暴力访问（忽略掉访问修饰符）.这一步对于访问私有构造函数有重要意义
			con.newInstance(18);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
