package book.io;

import java.io.File;

/**
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         FileDivisionUniter
 * ����ʱ�䣺 2018��1��17������2:22:52
 * �޸��ˣ�     Jefy
 * ��������     �ļ��ķָ���ϲ���
 * �ļ��ָ�ϲ����������ļ��ָ�����ɸ�С�ļ���
 * �����С�ļ��ϲ���һ�����ļ�
 */
public class FileDivisionUniter {
	public static final String SUFFIX = ".pp";//�ָ����ļ�����׺
	
	public static String[] divide(String fileName,long size) throws Exception {
		File inFile = new File(fileName);
		if(!inFile.exists() || (!inFile.isFile())) {
			throw new Exception("ָ���ļ�������");
		}
		//>>>δ�����......
		return null;
	}
	
}
