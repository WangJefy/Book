package book.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import book.basic.HelloWorld;

/**
 * ��jar���ж���Դ�ļ����������ļ���
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         ResourceReader
 * ����ʱ�䣺 2018��1��17������5:51:27
 * �޸��ˣ�     Jefy
 * ��������
 */
public class ResourceReader {
	/**
	 * ��һ�ַ�����jar���е���Դ��Ϣ�����ȶ�ȡ��Դ��URL���ڶ�ȡURL��Ӧ���ļ���Ϣ��
	 * @param class1 ��
	 * @param fileName �ļ���
	 * @throws IOException 
	 */
	public static void readFromJarA(Class<?> class1,String fileName) throws IOException {
		//ʹ��getResource�õ�һ��URL��������λ��Դ
		URL fileURL = class1.getResource(fileName);
		System.out.println("��Դ��URL:" + fileURL);
		//��fileURL��Ӧ���ļ���
		InputStream inputstream = fileURL.openStream();
		BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
		String str;
		while((str = bufferedreader.readLine()) != null) {
			System.out.println(str);
		}
		inputstream.close();
	}
	/**
	 * �ڶ��ַ�����jar���е���Դ��Ϣ
	 * @param class1 ��
	 * @param fileName �ļ���
 	 */
	public static void readFromJarB(Class<?> class1,String fileName) {
		//getResourceAsStreamȡ�ø���Դ�����������ã���֤������Դ���ȷ��λ�ó�ȡ����
		InputStream inputStream = class1.getResourceAsStream(fileName);
		if(inputStream != null) {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String str;
			 
			//���ж�ȡ���е�����
			try {
				while((str = bufferedReader.readLine()) != null) {
					System.out.println(str);
				}
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Class<?> class1 = HelloWorld.class;
		//����ļ����·��ǰû��"/",���ʾ����ڸ�class�ļ���λ��
		String fileName = "config0.conf";
		try {
			ResourceReader.readFromJarA(class1, fileName);
			System.out.println();
			
			fileName = "Resource/config1.conf";
			ResourceReader.readFromJarB(class1, fileName);
			System.out.println();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
