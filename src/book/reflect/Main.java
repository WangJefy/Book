package book.reflect;
/*
 * ����������main
 */
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		try {
			//��ȡClass����
			Class<?> clazz = Class.forName("book.reflect.Student");
			
			//��ȡmain����
			Method methodMain = clazz.getMethod("main", String[].class);
			
			// methodMain.invoke(null, new String[]{"a","b","c"});  
            //��һ���������������ͣ���Ϊ������static��̬�ģ�����Ϊnull���ԣ��ڶ���������String���飬����Ҫע����jdk1.4ʱ�����飬jdk1.5֮���ǿɱ����  
            //������ʱ��  new String[]{"a","b","c"} ���3�����󡣡���������Ҫ����ǿת��  
            methodMain.invoke(null, (Object)new String[]{"a","b","c"});//��ʽһ  
            // methodMain.invoke(null, new Object[]{new String[]{"a","b","c"}});//��ʽ��  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
