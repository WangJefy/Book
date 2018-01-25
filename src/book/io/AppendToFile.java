package book.io;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ���ļ�β��׷������
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         AppendToFile
 * ����ʱ�䣺 2018��1��17������1:18:19
 * �޸��ˣ�     Jefy
 * ��������
 */
public class AppendToFile {
	/**
	 * A����׷���ļ���ʹ��RandomAccessFile
	 * @param fileName �ļ���
	 * @param content ׷�ӵ�����
	 * @throws IOException 
	 */
	public static void appendMethodA(String fileName,String content) throws IOException {
		try {
			RandomAccessFile randomFile = new RandomAccessFile(fileName,"rw");
			long fileLength = randomFile.length();//�ļ����ȣ��ֽ���
			randomFile.seek(fileLength);
			randomFile.writeBytes(content);
			randomFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
	/**
	 * B����׷���ļ���ʹ��FileWriter
	 * @param fileName �ļ���
	 * @param content ׷������
	 */
	public static void appendMethodB(String fileName,String content) {
		try {
			FileWriter writer = new FileWriter(fileName,true);
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * �ͻ���������
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String fileName = "C:\\Users\\Jefy\\Desktop\\demo\\test.txt";
		String content = "new append!";
		//��A����׷���ļ�
		AppendToFile.appendMethodA(fileName, content);
		AppendToFile.appendMethodA(fileName, "append end. \n");
		ReadFromFile.readFileByLines(fileName);//��ʾ�ļ�����
		
		//��B����׷���ļ�
		AppendToFile.appendMethodB(fileName, content);
		AppendToFile.appendMethodB(fileName, "append end. \n");
		ReadFromFile.readFileByLines(fileName);//��ȡ�ļ�����
		
	}
}
