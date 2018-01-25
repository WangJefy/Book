package book.reflect;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/*
 * 利用反射和配置文件，可以使：应用程序更新时，对源码无需进行任何修改
 * 我们只需将新类发送给客户端，并修改配置文件即可
 */
public class DemoReflectOnProperties {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		try {
			//通过反射获取Class对象
			Class<?> stuClass = Class.forName(getValue("className"));
			
			//获取show()方法
			Method m = stuClass.getMethod(getValue("methodName"));
			
			//调用show()方法
			m.invoke(stuClass.getConstructor().newInstance());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/*
	 * 当我们升级这个系统时，不要Student类，而需要新写一个Student2的类时，这时只需要更改pro.txt的文件内容就可以了。代码就一点不用改动
	 */
	public static String getValue(String key) throws IOException {
		Properties pro = new Properties();
		FileReader in = new FileReader("pro.txt");//获取输入流
		pro.load(in);//将流内容加载到配置文件对象中
		in.close();
		return pro.getProperty(key);
	}
}
