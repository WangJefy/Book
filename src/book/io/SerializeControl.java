package book.io;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * 
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         SerializeControl
 * 创建时间： 2018年1月17日下午5:15:56
 * 修改人：     Jefy
 * 类描述：     本应用程序通过实现Externalizable接口控制对象的序列化和反序列化
 */
public class SerializeControl {
	static class MyClassControl implements Externalizable{
		int serialClassInt;
		int a = 3,b = 4;
		public MyClassControl() {
			System.out.println("MyClass constructor");
			this.serialClassInt = 9;
		}
		
		public void show() {
			System.out.println("serialClassInt:" + serialClassInt);
		}
		@Override
		//当序列化对象的时候，该方法自动被调用
		public void writeExternal(ObjectOutput out) throws IOException {
			// TODO Auto-generated method stub
			System.out.println("run writeException!");
			//可以在序列化时写非自身的变量
			Date d = new Date();
			out.writeObject(d);
			//只序列化serialClassInt变量，a,b两个变量并不会被序列化
			out.writeInt(this.serialClassInt);
		}

		@Override
		//当反序列化对象的时候，该方法自动被调用
		public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
			// TODO Auto-generated method stub
			System.out.println("run readExternal");
			Date d = (Date) in.readObject();
			System.out.println(d);
			this.serialClassInt = in.readInt();
		}
	}
	/**
	 * 反序列化对象
	 * @param fileName
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void serializable(String fileName) throws FileNotFoundException, IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
		MyClassControl myl = new MyClassControl();
		out.writeObject(myl);
		out.close();
	}
	/**
	 * 序列化对象
	 * @param fileName
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static void deserializable(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
		MyClassControl my2 = (MyClassControl)in.readObject();
		my2.show();
		in.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		String fileName = "C:\\Users\\Jefy\\Desktop\\demo\\ob1.txt";
		SerializeControl.serializable(fileName);
		SerializeControl.deserializable(fileName);
	}
}
