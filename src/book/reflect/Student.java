package book.reflect;

public class Student {
	public String name;
	protected int age;
	char sex;
	private String phoneNum;
	
	public static int a = 88;
	
	public static void StaticMethod() {
		System.out.println("Student�ľ�̬����");
	}
	
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", sex=" + sex  
                + ", phoneNum=" + phoneNum + "]";  
	}
	
	public Student(String str) {
		System.out.println("Student�Ĺ��췽��:s = "  + str);
		
	}
	public Student() {
		System.out.println("Student���޲ι��졣������");
	}
	public Student(char name) {
		System.out.println("������" + name);
	}
	public Student(String name,int age) {
		System.out.println("������" + name + "���䣺" + age);
	}
	protected Student(boolean n) {
		System.out.println("�ܱ����Ĺ��췽��  n = " + n);
	}
	
	@SuppressWarnings("unused")
	private Student(int age) {
		System.out.println("˽�еĹ��췽��   age = " + age);
		this.age = age;
	}
	
	/***********��Ա����*************/
	public void show1(String s) {
		System.out.println("������public���γ�Ա����show1(String s): s = " + s);
	}
	protected void show2() {
		System.out.println("������protected show2()����");
	}
	void show3() {
		System.out.println("������show3()");
	}
	
	@SuppressWarnings("unused")
	private String show4(int age) {
		System.out.println("������private String show4(int age): age = " + age);
		return "abcd";
	}
	public static void main(String[] args) {
		System.out.println("Student��main����ִ����...");
	}
	public void show() {
		System.out.println("Through peizhiwenjian This is Student show()");
	}
}
