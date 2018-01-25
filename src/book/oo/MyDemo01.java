package book.oo;
/**
 * 此类是为了展示 父类引用指向子类对象的情况
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         MyDemo01
 * 创建时间： 2018年1月22日上午8:21:52
 * 修改人：     Jefy
 * 类描述：
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
		System.out.println("******************父类引用指向子类对象********************");
		Fu f = new Zi(); //父类引用指向子类对象
		System.out.println("判断f指向的是不是Zi类实例对象：" + (f instanceof Zi)); 
		int age = f.age;
		System.out.println(age);
		f.study();
//		f.bad();会出现编译异常：The method bad() is undefined for the type MyDemo01.Fu。还因为bad()方法是子类的实例方法，必须创建子类对象才能调用
		f.good();
		
		Zi z = (Zi) f; //强制向下转型
		z.bad();
		
		System.out.println();
		System.out.println("******************接口引用指向实现类对象********************");
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
