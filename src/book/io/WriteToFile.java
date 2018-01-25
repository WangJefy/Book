package book.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * д�ļ�
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         WriteToFile
 * ����ʱ�䣺 2018��1��17������10:53:15
 * �޸��ˣ�     Jefy
 * �������� ��java����д�ļ������ֽ�д�����ַ�д�Ͱ���д
 */
public class WriteToFile {
	/**
	 * ���ֽ�Ϊ��λд�ļ����ʺ�д�������ļ�����ͼƬ��
	 * @param fileName �ļ���
	 * @throws IOException 
	 */
	public static void writeFileByBytes(String fileName) throws IOException {
		File file = new File(fileName);
		OutputStream out = null;
		
		try {
			//���ļ������
			out = new FileOutputStream(file);
			String content = "�ļ�����:This is a read file";
			byte[] bytes = content.getBytes();//��ȡ������е��ֽ�
			
			//д�ļ�
			out.write(bytes);
			System.out.println("д�ļ�" + file.getAbsolutePath() + "�ɹ�");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("д�ļ�" + file.getAbsolutePath() + "ʧ��");
		}finally {
			if(out != null) {
				out.close();
			}
		}
		return;
	}
	/**
	 * ���ַ�Ϊ��λд�ļ�
	 * @param fileName �ļ���
	 * @throws IOException 
	 */
	public static void writeFileByChars(String fileName) throws IOException {
		File file = new File(fileName);
		Writer writer = null;
		try {
			//���ļ�����������ļ��������װ��writer����
			writer = new OutputStreamWriter(new FileOutputStream(file));
			String content = "�ļ����ݣ�\n1,The First line;\n2,The second line.";
			writer.write(content);
			System.out.println("д�ļ�" + file.getAbsolutePath() + "�ɹ�");
		} catch (FileNotFoundException e) {
			System.out.println("д�ļ�" + file.getAbsolutePath() + "ʧ��");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(writer != null) {
				writer.close();//�ر������
			}
		}
		return;
	}
	/**
	 * ����Ϊ��λд�ļ�
	 * @param fileName �ļ���
	 */
	public static void writeFileByLines(String fileName) {
		File file = new File(fileName);
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileOutputStream(file));
			writer.println("�ļ�����"); //д�ַ���
//			д����ֻ�������
			writer.print(true);
			writer.print(155);
			writer.println();//����
			writer.flush();//д���ļ�
			System.out.println("д�ļ���" + file.getAbsolutePath() + "�ɹ�");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("д�ļ��� " + file.getAbsolutePath() + "ʧ��");
		}finally {
			if(writer != null) {
				writer.close();
			}
		}
		return;
	}
	/**
	 * �������ͻ���
	 * @param args ��������
	 * @throws IOException 
	 */ 
	public static void main(String[] args) throws IOException {
		String fileName = "C:\\Users\\Jefy\\Desktop\\demo\\test.txt";
		writeFileByBytes(fileName);
		File file = new File(fileName);
		System.out.println(file.length());
	}
}
