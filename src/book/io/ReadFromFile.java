package book.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;

/**
 * ���ļ�:���ļ����뵽�ڴ棨���ļ�ϵͳ���ļ���Ŀ¼�ĳ���·����װ��File�࣬������File�����Ϊ�ļ�������FileInputStream,
 * �ļ�������FileInputStream������������InputStream�������һ�����ࡣ���ֽ�������InputStream�����ڴ棬���������ַ�ʽ��
 * ���ֽڶ�ȡ�ļ����ݣ����ַ���ȡ�ļ����ݣ����ж�ȡ�ļ����ݣ������ȡ�ļ����ݣ�
 * @author Jefy
 *
 */
public class ReadFromFile {
	/**
	 * ���ֽ�Ϊ��λ���ļ��������ڶ��������ļ�����ͼƬ��������Ӱ����ļ�
	 * 
	 * @param fileName �ļ���
	 * @throws IOException 
	 */
	public static void readFileByBytes(String fileName) throws IOException {
		File file = new File(fileName);//��װ���ļ���
		InputStream in = null;
		//һ�ζ�һ���ֽ�
		try {
			System.out.println("���ֽ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���ֽڣ�");
			in = new FileInputStream(file);//���ļ�������(����������ת��)
			int tempbyte;
			/**
			 * ����ȡ������ʹ��int���ܣ�ֵ�ͱ����0-255;���û�пɶ����ݣ��򷵻�-1��
			 * ���ϵض�ȡ��ֱ���ļ�����
			 * read�������������ݿ��á���⵽��ĩβ�����׳��쳣ǰ����һֱ������
			 * �� ����һֱͣ��read()��������ȴ����ݡ�û�����ݾͲ���������ִ�У�ֱ���õ����ݡ������һֱ�ȴ���ֱ�����������ݣ��ſ�ʼ����
			 * tempbyte = in.read()ִ��˳���ǣ���ִ��in.read(),���ȶ�ȡ���ݣ�����֮�󷵻���һ�ֽ����ݵ��ֽ�ֵ��������ֵ��ֵ��tempbyte
			 */
			while((tempbyte = in.read()) != -1) {
				System.out.write(tempbyte);
			}
			in.close();//�ر��ļ�������
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		try {
			
			System.out.println("���ֽ�Ϊ��λ��ȡ�ļ���һ�ζ�����ֽ�");
			//һ�ζ�ȡ����ֽ�
			byte[] tempbytes = new byte[100]; //��Ϊ�ֽڻ��������ֽ�����
			int byteread = 0;
			in = new FileInputStream(fileName);
			ReadFromFile.showAvailableBytes(in);
			//�������ֽڵ��ֽ������У�bytereadΪһ�ζ�����ֽ���
			while((byteread = in.read(tempbytes)) != -1) {
				System.out.write(tempbytes,0,byteread);
			}
		}catch(Exception e1) {
			e1.printStackTrace();
			
		}finally {
			if(in != null) {
				in.close();
			}
		}
	}
	/**
	 * ���ֽ�Ϊ��λ��ȡ�ļ��������ڶ��ı������ֵ����͵��ļ�
	 * @param fileName �ļ���
	 */
	public static void readFileByChars(String fileName) {
		File file = new File(fileName);
		Reader reader = null;//Reader���ַ�������������
		 try {
			 System.out.println("���ַ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�ȡһ���ַ�");
			 //һ�ζ�ȡһ���ַ�
			 reader = new InputStreamReader(new FileInputStream(file));
			 int tempchar;
			 while((tempchar = reader.read()) != -1) {
				 //��windows�£�\r\n�������ַ���һ��ʱ����ʾһ������
				 //������������ַ��ֿ���ʾʱ���ỻ������
				 // ��ˣ����ε�\r���������ε�\n����������ܶ����
				 if(((char)tempchar) != '\r') {
					 System.out.print((char)tempchar);
				 }
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			 System.out.println("���ַ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�ȡ����ַ�");
			 //һ�ζ�ȡ����ַ�
			 char[] tempchars = new char[30];
			 int charread = 0;
			 reader = new InputStreamReader(new FileInputStream(fileName));
			 //�������ַ����ַ������У�charreadΪһ�ζ�ȡ�ַ���
			while((charread = reader.read(tempchars)) != -1) {
				 //ͬ�����ε�\r����ʾ
				if((charread == tempchars.length) && (tempchars[tempchars.length - 1] != '\r')) {
					System.out.println(tempchars);
				}else {
					for (int i = 0; i < charread; i++) {
						if(tempchars[i] == '\r') {
							continue;
						}else {
							System.out.print(tempchars[i]);
						}
					}
				}
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		 
	}
	/**
	 * ����Ϊ��λ��ȡ�ļ��������ڶ�ȡ�����еĸ�ʽ���ļ�
	 * @param fileName �ļ���
	 * @throws IOException 
	 */
	public static void readFileByLines(String fileName) throws IOException {
		File file = new File(fileName);
		BufferedReader reader =  null;
		
		System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�ȡһ��");
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			//һ�ζ���һ�У�ֱ������nullΪ�ļ�����
			while((tempString = reader.readLine()) != null) {
				//��ʾ�к�
				System.out.println("Line " + line + ":" + tempString);
				line++;
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(reader != null) {
				reader.close();
			}
		}
	}
	/**
	 * �����ȡ�ļ�����
	 * @param fileName �ļ���
	 * @throws IOException 
	 */
	public static void readFileByRandomAccess(String fileName) throws IOException {
		RandomAccessFile randomFile = null;
		System.out.println("�����ȡһ���ļ����ݣ�");
		//��һ����������ļ�������ֻ����ʽ
		try {
			randomFile = new RandomAccessFile(fileName,"r");
			long fileLength = randomFile.length();
			int beginIndex = (fileLength > 4) ? 4 : 0;
			//�����ļ��Ŀ�ʼλ���ƶ���beginIndexλ��
			randomFile.seek(beginIndex);
			byte[] bytes = new byte[10];
			int byteread = 0;
			//һ�ζ�ȡ10���ֽڣ�����ļ����ݲ���10���ֽڣ����ʣ�µ��ֽ�
			//��һ�ζ�ȡ���ֽ�����ֵ��byteread
			while((byteread = randomFile.read(bytes)) != -1) {
				System.out.write(bytes,0,byteread);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ��ʾ�������л�ʣ���ֽ���
	 * @param in ����������
	 */
	public static void showAvailableBytes(InputStream in) {
		// TODO Auto-generated method stub
		try {
			System.out.println("��ǰ�ֽ��������е��ֽ���Ϊ��" + in.available());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ���������������
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String fileName = "C:/temp/newTemp.txt";
		ReadFromFile.readFileByBytes(fileName);
		ReadFromFile.readFileByChars(fileName);
		ReadFromFile.readFileByLines(fileName);
		ReadFromFile.readFileByRandomAccess(fileName);
	}
}
