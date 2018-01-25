package book.reflect;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/*
 * ���÷���������ļ�������ʹ��Ӧ�ó������ʱ����Դ����������κ��޸�
 * ����ֻ�轫���෢�͸��ͻ��ˣ����޸������ļ�����
 */
public class DemoReflectOnProperties {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		try {
			//ͨ�������ȡClass����
			Class<?> stuClass = Class.forName(getValue("className"));
			
			//��ȡshow()����
			Method m = stuClass.getMethod(getValue("methodName"));
			
			//����show()����
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
	 * �������������ϵͳʱ����ҪStudent�࣬����Ҫ��дһ��Student2����ʱ����ʱֻ��Ҫ����pro.txt���ļ����ݾͿ����ˡ������һ�㲻�øĶ�
	 */
	public static String getValue(String key) throws IOException {
		Properties pro = new Properties();
		FileReader in = new FileReader("pro.txt");//��ȡ������
		pro.load(in);//�������ݼ��ص������ļ�������
		in.close();
		return pro.getProperty(key);
	}
}
