package book.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * �Ӽ��̽������ݲ�������ļ�
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         CatStdinToFile
 * ����ʱ�䣺 2018��1��17������2:30:41
 * �޸��ˣ�     Jefy
 * ��������     �ӱ�׼�������ж�ȡ���ݣ����洢���ļ���
 */
public class CatStdinToFile {
	/**
	 * �ӱ�׼�������ж�ȡ����
	 * @param fileName �ļ���
	 * @return �ļ�д�ɹ����򷵻�true;���򷵻�false;
	 */
	public static boolean catStdinToFile(String fileName) {
		File file = new File(fileName);
		//�����ݰ����ı������ �ļ�
		PrintWriter writer = null;
		BufferedReader in = null;
		try {
			writer = new PrintWriter(new FileWriter(file));
			System.out.println("�������ļ����ݣ�����quit����");
			//��BufferedReader��װ��׼������
			in = new BufferedReader(new InputStreamReader(System.in));
			String inputLine = null;
			while(((inputLine = in.readLine()) != null) && (!inputLine.equals("quit"))) {
				writer.println(inputLine);
			}
			
			//�������new PrintWriter(new FileWriter(file),true)����Զ�flush
			writer.flush();
			writer.close();
			return true;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String fileName = "C:\\Users\\Jefy\\Desktop\\demo\\test1.txt";
		CatStdinToFile.catStdinToFile(fileName);
		
		System.out.println();
		System.out.println("����ļ�������");
		ReadFromFile.readFileByLines(fileName);
	}
}
