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
 * ���л����Ѷ���־û����ļ�
 * �����л�����������ļ��лָ����ڴ�
 * ʲô�������Ҫ���л���
 * a��������ѵ��ڴ��еĶ���״̬���浽һ���ļ��л������ݿ���ʱ��
 * b�����������׽����������ϴ��Ͷ����ʱ��
 * c��������ͨ��RMI��������ʱ��
 */
public class SerializeObject {
	//һ���ڲ��࣬���ڱ����л��ͷ����л���һ��Ҫʵ��Serializable���ܱ����л��ͷ����л�
	static class MyClass implements Serializable{

		/**
		 * ���ɵ����к�
		 */
		private static final long serialVersionUID = -8026472407613524608L;
		private int a,b;
		private transient int c; //��ʱ�������ᱻ���л����ļ�
		private static int d;    //��̬�����������л����ļ�
		
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
	 * ���л������ļ�
	 * @param fileName �ļ���
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void serialize(String fileName) throws FileNotFoundException, IOException {
		//����һ�������������������������ļ�
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
		
		out.writeObject("Today:");  //1.���л�һ���ַ��������ļ�
		out.writeObject(new Date());//2.���л���ǰ���ڶ����ļ�
		
		MyClass myl = new MyClass(5,6,7,8);
		out.writeObject(myl);       //3.���л�һ��MyClass����
		out.close();
	}
	/**
	 * ���ļ������л�������
	 * @param fileName �ļ���
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static void deserialize(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
		//����һ�����������������ļ���ȡ����
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
		//ע�������ʱ���밴�����л�����ʱ��˳�������������
		
		//1.��ȡ�ַ�������
		String today = (String)(in.readObject());
		System.out.println(today);
		
		//2.��ȡ���ڶ���
		Date date = (Date)(in.readObject());
		System.out.println(date.toString());
		
		//3.��ȡMyClass���󣬲���������add����
		MyClass myl = (MyClass)(in.readObject());
		System.out.println(myl.toString());
		in.close();
		/*
		 * ���ָ������ʱ�򣬶����е��������Զ��ػָ�
		 * �����ϣ��ĳ�������л�������������ǰ�����transient�ؼ���
		 * ��������Ĵ��룺transient int noSer = 0;
		 * ���Ƶģ�������е�ĳ����Ϊ��̬�������ᱻ���л�
		 */
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		String fileName = "C:\\Users\\Jefy\\Desktop\\demo\\ob.ser";
		//SerializeObject.serialize(fileName);
		SerializeObject.deserialize(fileName);//�����л������ļ������л�������
	}
}
