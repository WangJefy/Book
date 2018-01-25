package book.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* �������ڱ����ڣ���������Ͳ�������ʧ�����������ǿ���ͨ������Խ�����ͼ���
 * ͨ������Խ�����ͼ��
 * ���磺��һ��String���ͼ��ϣ���ô����������������һ��Integer���͵�ֵ��
 */
public class Demo {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		ArrayList<String> strList = new ArrayList<>();
		strList.add("aaa");
		strList.add("bbb");
		
		//��ȡArrayList��Class���󣬷������add�������������
		Class<?> listClass = strList.getClass();
		//��ȡadd()����
		Method m = listClass.getMethod("add", Object.class);
		//����add()����
		m.invoke(strList, 100);
		
		//��������
		for (Object obj : strList) {
			System.out.println(obj);
		}
	}
}
