package book.io;

import java.io.File;
import java.io.FilenameFilter;

/**
 * �г�ָ��Ŀ¼�µ��ļ�
 *
 */
public class ListFileUtil {
	
	/**����һ���ڲ��࣬ʵ����FilenameFilter�ӿڣ����ڹ����ļ�*/
	static class MyFilenameFilter implements FilenameFilter{
		private String suffix = "";//�ļ�����׺
		
		public MyFilenameFilter(String suffix) {
			this.suffix = suffix;
		}
		@Override
		public boolean accept(File dir, String name) {
			//����ļ�����suffixָ���ĺ�׺��ͬ���㷵��true,���򷵻�false
			if(new File(dir,name).isFile()) {
				return name.endsWith(suffix);
			}else {
				//������ļ��У���ֱ�ӷ���true
				return true;
			}
		}	
	}
	
	/**
	 * �г�Ŀ¼�������ļ�������Ŀ¼���ļ�·��
	 * @param dirName  �ļ��е��ļ�·��
	 */
	public static void listAllFiles(String dirName) {
		//���dir�����ļ��ָ�����β���Զ�����ļ��ָ���
		if(!dirName.endsWith(File.separator)) {
			dirName = dirName + File.separator;
		}
		File dirFile = new File(dirName);
		//���dir��Ӧ���ļ������ڣ����߲���һ���ļ��У����˳�
		if(!dirFile.exists()||(!dirFile.isDirectory())) {
			System.out.println("Listʧ�ܣ��Ҳ���Ŀ¼��" + dirName);
			return;
		}
		
		//�г� Դ�ļ��� �µ������ļ���������Ŀ¼��
		File[] files = dirFile.listFiles();
		for(int i = 0;i < files.length;i++) {
			if(files[i].isFile()) {
				System.out.println(files[i].getAbsolutePath() + " ���ļ���");
			}else if (files[i].isDirectory()) {
				System.out.println(files[i].getAbsolutePath() + "��Ŀ¼��");
				ListFileUtil.listAllFiles(files[i].getAbsolutePath());
			}
		}
	}
	
	/**
	 * �г�Ŀ¼��ͨ���ļ������������˺���ļ�
	 * @param filter   �ļ���������
	 * @param dirName  Ŀ¼��
	 */
	public static void listFilesByFilenameFilter(FilenameFilter filter,String dirName) {
		//���dir�����ļ��ָ����β,�Զ�����ļ��ָ���
		if(!dirName.endsWith(File.separator)) {
			dirName = dirName + File.separator;
		}
		File dirFile = new File(dirName);//��װ
		//���dir��Ӧ���ļ������ڣ����߲���һ���ļ��У� ���˳�
		if(!dirFile.exists()||(!dirFile.isDirectory())) {
			System.out.println("Listʧ�ܣ��Ҳ���Ŀ¼��" + dirName);
			return;
		}
		//�г�Դ�ļ�����������ͨ�����������ļ���������Ŀ¼��
		File[] files = dirFile.listFiles(filter);
		for(int i = 0;i < files.length;i++) {
			if(files[i].isFile()) {
				System.out.println(files[i].getAbsolutePath() + " ���ļ���");
			}else if(files[i].isDirectory()) {
				System.out.println(files[i].getAbsolutePath() + " ��Ŀ¼��");
				ListFileUtil.listFilesByFilenameFilter(filter, files[i].getAbsolutePath());
			}
		}
	}
	public static void main(String[] args) {
		String dir = "F:/myfile";
		System.out.println(dir + "Ŀ¼�µ����ݣ�");
		ListFileUtil.listAllFiles(dir);
		
		System.out.println();
		System.out.println("�������������˺������");
		//�½�һ���ļ���������������Ϊ".txt"
		FilenameFilter myFilenameFilter = new ListFileUtil.MyFilenameFilter(".txt");
		ListFileUtil.listFilesByFilenameFilter(myFilenameFilter, dir);
	}
}
