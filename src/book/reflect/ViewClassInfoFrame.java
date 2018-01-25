package book.reflect;

import java.lang.reflect.Method;

/**
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         ViewClassInfoFrame
 * ����ʱ�䣺 2018��1��21������8:10:59
 * �޸��ˣ�     Jefy
 * ��������     �鿴�����Ϣ
 */
public class ViewClassInfoFrame {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		try {
			Class<?>  a = Class.forName("book.reflect.InstanceOf");
			Method[] methods = a.getMethods();
			for (int i = 0; i < methods.length; i++) {
				System.out.println(methods[i]);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
