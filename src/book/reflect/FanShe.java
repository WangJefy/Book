package book.reflect;

/**
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         FanShe
 * 创建时间： 2018年1月21日下午12:25:44
 * 修改人：     Jefy
 * 类描述：     获取Class对象的三种方式
 * 		  1.Object---> getClass()
 *  	  2.任何类（包括基本数据类型,接口）都有一个静态属性class
 *        3.通过Class类的静态方法：forName(String className)  (频繁使用)
 */
public class FanShe {
	public static void main(String[] args) {
		//第一种方式获取Class对象
		Student stu1 = new Student();
		Class<?> stuClass = stu1.getClass();//获取Class对象
		System.out.println(stuClass.getName());
		
		//第二种方式获取Class对象
		Class<?> stuClass2 = Student.class;
		System.out.println(stuClass == stuClass2);//
		
		//第三种方式获取Class对象
		try {
			Class<?> stuClass3 = Class.forName("book.reflect.Student");
			System.out.println(stuClass3 == stuClass2);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 在运行期间，一个类只能有一个Class对象!!!
	 * 三种方式常用第三种，第一种对象都有了还要反射干什么。
	 *              第二种需要导入类的包，依赖太强，不导包就抛编译错误。
	 *              第三种，一个字符串可以传入也可写在配置文件中等多种方法.最为常用
	 */
}
