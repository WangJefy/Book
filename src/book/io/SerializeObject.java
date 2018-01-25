package book.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * 序列化：把对象持久化到文件
 * 反序列化：将对象从文件中恢复到内存
 * 什么情况下需要序列化：
 * a）当你想把的内存中的对象状态保存到一个文件中或者数据库中时候；
 * b）当你想用套接字在网络上传送对象的时候；
 * c）当你想通过RMI传输对象的时候；
 */
public class SerializeObject {
	//一个内部类，用于被序列化和反序列化。一定要实现Serializable才能被序列化和反序列化
	static class MyClass implements Serializable{

		/**
		 * 生成的序列号
		 */
		private static final long serialVersionUID = -8026472407613524608L;
		private int a,b;
		private transient int c; //临时变量不会被序列化到文件
		private static int d;    //静态变量不会序列化到文件
		
		public MyClass() {
			
		}
		public MyClass(int a, int b, int c, int d) {
			this.a = a;
			this.b = b;
			this.c = c;
			MyClass.d = d;
		}
		public String toString() {
			return this.a + " " + this.b + " " + this.c + " " + MyClass.d; 
		}
	}
	/**
	 * 序列化对象到文件
	 * @param fileName 文件名
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void serialize(String fileName) throws FileNotFoundException, IOException {
		//创建一个对象输出流，将对象输出到文件
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
		
		out.writeObject("Today:");  //1.序列化一个字符串对象到文件
		out.writeObject(new Date());//2.序列化当前日期对象到文件
		
		MyClass myl = new MyClass(5,6,7,8);
		out.writeObject(myl);       //3.序列化一个MyClass对象
		out.close();
	}
	/**
	 * 从文件反序列化到对象
	 * @param fileName 文件名
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static void deserialize(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
		//创建一个对象输入流，从文件读取对象
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
		//注意读对象时必须按照序列化对象时的顺序读，否则会出错
		
		//1.读取字符串对象
		String today = (String)(in.readObject());
		System.out.println(today);
		
		//2.读取日期对象
		Date date = (Date)(in.readObject());
		System.out.println(date.toString());
		
		//3.读取MyClass对象，并调用它的add方法
		MyClass myl = (MyClass)(in.readObject());
		System.out.println(myl.toString());
		in.close();
		/*
		 * 当恢复对象的时候，对象中的所有域被自动地恢复
		 * 如果不希望某个域被序列化，可以在它的前面加上transient关键字
		 * 例如下面的代码：transient int noSer = 0;
		 * 类似的，如果类中的某个域为静态，它不会被序列化
		 */
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		String fileName = "C:\\Users\\Jefy\\Desktop\\demo\\ob.ser";
		//SerializeObject.serialize(fileName);
		SerializeObject.deserialize(fileName);//反序列化：从文件反序列化到对象
	}
}
