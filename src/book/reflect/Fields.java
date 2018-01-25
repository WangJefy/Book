package book.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/*
 * 2.获取成员变量并赋值
 * 	1)批量
 * 		1)Field[] getFileds();获取所有public成员变量
 * 		2)Field[] getDeclaredFields();获取所有成员变量
 *  2)获取单个
 *     	1)public Field getField(String fieldName):获取某个public成员变量
 *     	2)public Field getDeclaredField(String fieldName)获取某个成员变量
 *     
 *     	设置某成员变量的值：
 *     Field ---> public void set(Object obj,Object value);其中obj为成员变量所在的对象，value为字段值
 */
public class Fields {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		try {
			//获取Class对象book.reflect.Student
			Class<?> stuClass = Class.forName("book.reflect.Student");
			
			//获取字段
			System.out.println("***********获取所有public成员变量************");
			Field[] fieldArray = stuClass.getFields();
			for (Field f : fieldArray) {
				System.out.println(f);
			}
			
			System.out.println("*************获取所有成员变量****************");
			fieldArray = stuClass.getDeclaredFields();
			for (Field field : fieldArray) {
				System.out.println(field);
			}
			
			System.out.println("************获取单个public成员变量并赋值**********");
			Field f = stuClass.getField("name");
			System.out.println(f);
			//获取一个对象
			Object obj = stuClass.getConstructor().newInstance();//创建了一个Student对象--->Student stu = new Student();
			//为字段设置值
			f.set(obj, "刘德华");//为Student对象中的name属性赋值。stu.name = "刘德华"
			//验证
			Student stu = (Student) obj;
			System.out.println("验证姓名：" + stu.name);
			
			System.out.println("************获取私有成员变量并赋值****************");
			f = stuClass.getDeclaredField("phoneNum");
			System.out.println(f);
			f.setAccessible(true);//暴力反射，解除私有限定
			f.set(obj, "13939389099");
			System.out.println("验证电话：" + stu);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
