package book.oo;
/**
 * ������Ϊ��չʾ ��������ָ�������������
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         MyDemo01
 * ����ʱ�䣺 2018��1��22������8:21:52
 * �޸��ˣ�     Jefy
 * ��������
 */
public class MyDemo01 {
	static class Fu{
		int age = 49;
		String name = "Fu";
		void study() {
			System.out.println("This is Fu study()");
		}
		void good() {
			System.out.println("This is Fu good()");
		}
	}
	static class Zi extends Fu{
		int age = 12;
		
		@Override
		void study() {
			System.out.println("This is Zi study()");
		}
		
		void bad() {
			System.out.println("This is Zi bad()");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("******************��������ָ���������********************");
		Fu f = new Zi(); //��������ָ���������
		System.out.println("�ж�fָ����ǲ���Zi��ʵ������" + (f instanceof Zi)); 
		int age = f.age;
		System.out.println(age);
		f.study();
//		f.bad();����ֱ����쳣��The method bad() is undefined for the type MyDemo01.Fu������Ϊbad()�����������ʵ�����������봴�����������ܵ���
		f.good();
		
		Zi z = (Zi) f; //ǿ������ת��
		z.bad();
		
		System.out.println();
		System.out.println("******************�ӿ�����ָ��ʵ�������********************");
		Jk jk = new Boy();
		jk.play();
		System.out.println(jk.toString());
		System.out.println(jk instanceof Boy);
		
		Boy b = (Boy) jk;
		b.run();;
	}
	
	
	public interface Jk{
		public void play();
	}
	static class Boy implements Jk{

		@Override
		public void play() {
			// TODO Auto-generated method stub
			System.out.println("This is Boy play()");
		}
		public void run() {
			System.out.println("This is Boy run()");
		}
	}
}
