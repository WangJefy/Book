package book.reflect;

/**
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         InstanceOf
 * ����ʱ�䣺 2018��1��20������10:47:24
 * �޸��ˣ�     Jefy
 * ��������     instanceOf������
 * (1) ��Ķ���������instanceof����������true
 * (2) ��������븸����instanceof����������true
 * (3) �����������false
 */
public class InstanceOf {
	
	static class ClassA {
		
	}
	static class ClassB extends ClassA{
		
	}
	public static void main(String[] args) {
		ClassA a = new ClassA();
		ClassB b = new ClassB();
		//������a,b�Ƿ�ΪClassA����
		if(a instanceof ClassA) {
			System.out.println("Object a is a ClassA Object!");
		}else {
			System.out.println("Object a is not a ClassA Object!");
		}
		if(b instanceof ClassA) {
			System.out.println("Object b is a ClassA Object!");
		}else {
			System.out.println("Object b is not a ClassA Object!");
		}
		
	}
}
