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
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         SerializeControl
 * ����ʱ�䣺 2018��1��17������5:15:56
 * �޸��ˣ�     Jefy
 * ��������     ��Ӧ�ó���ͨ��ʵ��Externalizable�ӿڿ��ƶ�������л��ͷ����л�
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
		//�����л������ʱ�򣬸÷����Զ�������
		public void writeExternal(ObjectOutput out) throws IOException {
			// TODO Auto-generated method stub
			System.out.println("run writeException!");
			//���������л�ʱд������ı���
			Date d = new Date();
			out.writeObject(d);
			//ֻ���л�serialClassInt������a,b�������������ᱻ���л�
			out.writeInt(this.serialClassInt);
		}

		@Override
		//�������л������ʱ�򣬸÷����Զ�������
		public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
			// TODO Auto-generated method stub
			System.out.println("run readExternal");
			Date d = (Date) in.readObject();
			System.out.println(d);
			this.serialClassInt = in.readInt();
		}
	}
	/**
	 * �����л�����
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
	 * ���л�����
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
