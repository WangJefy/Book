package book.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/*
 * 2.��ȡ��Ա��������ֵ
 * 	1)����
 * 		1)Field[] getFileds();��ȡ����public��Ա����
 * 		2)Field[] getDeclaredFields();��ȡ���г�Ա����
 *  2)��ȡ����
 *     	1)public Field getField(String fieldName):��ȡĳ��public��Ա����
 *     	2)public Field getDeclaredField(String fieldName)��ȡĳ����Ա����
 *     
 *     	����ĳ��Ա������ֵ��
 *     Field ---> public void set(Object obj,Object value);����objΪ��Ա�������ڵĶ���valueΪ�ֶ�ֵ
 */
public class Fields {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		try {
			//��ȡClass����book.reflect.Student
			Class<?> stuClass = Class.forName("book.reflect.Student");
			
			//��ȡ�ֶ�
			System.out.println("***********��ȡ����public��Ա����************");
			Field[] fieldArray = stuClass.getFields();
			for (Field f : fieldArray) {
				System.out.println(f);
			}
			
			System.out.println("*************��ȡ���г�Ա����****************");
			fieldArray = stuClass.getDeclaredFields();
			for (Field field : fieldArray) {
				System.out.println(field);
			}
			
			System.out.println("************��ȡ����public��Ա��������ֵ**********");
			Field f = stuClass.getField("name");
			System.out.println(f);
			//��ȡһ������
			Object obj = stuClass.getConstructor().newInstance();//������һ��Student����--->Student stu = new Student();
			//Ϊ�ֶ�����ֵ
			f.set(obj, "���»�");//ΪStudent�����е�name���Ը�ֵ��stu.name = "���»�"
			//��֤
			Student stu = (Student) obj;
			System.out.println("��֤������" + stu.name);
			
			System.out.println("************��ȡ˽�г�Ա��������ֵ****************");
			f = stuClass.getDeclaredField("phoneNum");
			System.out.println(f);
			f.setAccessible(true);//�������䣬���˽���޶�
			f.set(obj, "13939389099");
			System.out.println("��֤�绰��" + stu);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
