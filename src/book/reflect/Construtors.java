package book.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
 * 1.��ȡ���췽����
 *   1)������ȡ
 *     public Constructor[] getConstructors();����public���췽��
 *     public Constructor[] getDeclaredConstructors();��ȡ���еĹ��췽��������private��protected��default��public��
 *     
 *   2)��ȡ�����ķ�����������
 *     public Constructor getConstructor(Class... parameterTypes);��ȡ����public���췽��
 *     public Constructor getDeclaredConstructor(Class... parameterTypes);��ȡĳ������Ĺ��췽��
 *     
 * 	       ���õ������췽����
 *     Constructor--->newInstance(Object... initargs)
 */
public class Construtors {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		try {
			//1.��ȡClass����:Book.reflect.Student.class (����ʱ���أ�����̬����)
			Class<?> clazz = Class.forName("book.reflect.Student");
			
			//2.��ȡ����public���췽��
			System.out.println("**********�����ȡ����public���췽��***********");
			Constructor<?>[] conArray = clazz.getConstructors();
			for (Constructor<?> c : conArray) {
				System.out.println(c);
			}
			
			System.out.println();
			System.out.println("**********�����ȡ���������Ĺ��췽��*************");
			conArray = clazz.getDeclaredConstructors();
			for (Constructor<?> c : conArray) {
				System.out.println(c);
			}
			
			System.out.println();
			System.out.println("**********�����ȡpublic�޲ι��췽��,������*******");
			Constructor<?> con = clazz.getConstructor();//ÿ������޲ι���ֻ��һ��+++
			System.out.println(con);
			//���ø��޲ι��캯��
			con.newInstance();
			
			System.out.println();
			System.out.println("**********�����ȡprivate�вι��캯����������*********");
			con = clazz.getDeclaredConstructor(int.class);
			System.out.println(con);
			//����˽���вι��췽��
			con.setAccessible(true);//�������ʣ����Ե��������η���.��һ�����ڷ���˽�й��캯������Ҫ����
			con.newInstance(18);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
