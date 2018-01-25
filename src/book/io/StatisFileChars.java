package book.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

/**
 * ͳ���ļ����ַ���
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         StatisFileChars
 * ����ʱ�䣺 2018��1��17������3:09:19
 * �޸��ˣ�     Jefy
 * ��������     ʹ��StreamTokenizer��ͳ���ļ��е��ַ���
 */
public class StatisFileChars {
	/**
	 * ʹ��StreamTokenizer��ͳ���ļ��е��ַ���
	 * @param fileName �ļ���
	 * @return �����ַ���
	 * @throws IOException 
	 */
	public static long statis(String fileName) throws IOException {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(fileName);
			//�������������ַ����ı��������
			StreamTokenizer st = new StreamTokenizer(new BufferedReader(fileReader));
			
			//ordinaryChar����ָ���ַ������ڴ˱������������"��ͨ"�ַ�
			//����ָ�������š�˫���ź�ע�ͷ�������ͨ�ַ�
			st.ordinaryChar('\'');
			st.ordinaryChar('\"');
			st.ordinaryChar('/');
			
//			String s;
//			int numberSum = 0;
//			int wordSum = 0;
//			int symbolSum = 0;
//			int total = 0;
			
			//nextToken������ȡ��һ��Token
			//TT_EOLָʾ�Ѷ�����ĩβ�ĳ���
			while(st.nextToken() != StreamTokenizer.TT_EOF) {
				//>>>δ�����......
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
