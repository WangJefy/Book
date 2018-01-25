package book.reflect;

/**
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         InstanceOf
 * 创建时间： 2018年1月20日下午10:47:24
 * 修改人：     Jefy
 * 类描述：     instanceOf操作符
 * (1) 类的对象与类做instanceof操作，返回true
 * (2) 子类对象与父类做instanceof操作，返回true
 * (3) 其他情况返回false
 */
public class InstanceOf {
	
	static class ClassA {
		
	}
	static class ClassB extends ClassA{
		
	}
	public static void main(String[] args) {
		ClassA a = new ClassA();
		ClassB b = new ClassB();
		//检测对象a,b是否为ClassA类型
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
