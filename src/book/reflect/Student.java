package book.reflect;

public class Student {
	public String name;
	protected int age;
	char sex;
	private String phoneNum;
	
	public static int a = 88;
	
	public static void StaticMethod() {
		System.out.println("Student的静态方法");
	}
	
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", sex=" + sex  
                + ", phoneNum=" + phoneNum + "]";  
	}
	
	public Student(String str) {
		System.out.println("Student的构造方法:s = "  + str);
		
	}
	public Student() {
		System.out.println("Student的无参构造。。。。");
	}
	public Student(char name) {
		System.out.println("姓名：" + name);
	}
	public Student(String name,int age) {
		System.out.println("姓名：" + name + "年龄：" + age);
	}
	protected Student(boolean n) {
		System.out.println("受保护的构造方法  n = " + n);
	}
	
	@SuppressWarnings("unused")
	private Student(int age) {
		System.out.println("私有的构造方法   age = " + age);
		this.age = age;
	}
	
	/***********成员方法*************/
	public void show1(String s) {
		System.out.println("调用了public含参成员函数show1(String s): s = " + s);
	}
	protected void show2() {
		System.out.println("调用了protected show2()函数");
	}
	void show3() {
		System.out.println("调用了show3()");
	}
	
	@SuppressWarnings("unused")
	private String show4(int age) {
		System.out.println("调用了private String show4(int age): age = " + age);
		return "abcd";
	}
	public static void main(String[] args) {
		System.out.println("Student的main函数执行了...");
	}
	public void show() {
		System.out.println("Through peizhiwenjian This is Student show()");
	}
}
