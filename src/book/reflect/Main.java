package book.reflect;
/*
 * 反射主函数main
 */
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		try {
			//获取Class对象
			Class<?> clazz = Class.forName("book.reflect.Student");
			
			//获取main方法
			Method methodMain = clazz.getMethod("main", String[].class);
			
			// methodMain.invoke(null, new String[]{"a","b","c"});  
            //第一个参数，对象类型，因为方法是static静态的，所以为null可以，第二个参数是String数组，这里要注意在jdk1.4时是数组，jdk1.5之后是可变参数  
            //这里拆的时候将  new String[]{"a","b","c"} 拆成3个对象。。。所以需要将它强转。  
            methodMain.invoke(null, (Object)new String[]{"a","b","c"});//方式一  
            // methodMain.invoke(null, new Object[]{new String[]{"a","b","c"}});//方式二  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
