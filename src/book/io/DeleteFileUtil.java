package book.io;

import java.io.File;

/**
 * ɾ���ļ���Ŀ¼
 */
public class DeleteFileUtil {
	/**
	 * ɾ���ļ��������ǵ����ļ����ļ���
	 * @param fileName  ��ɾ�����ļ�
	 * @return �ļ�ɾ���ɹ��򷵻�true,ɾ��ʧ���򷵻�false
	 */
	public static boolean delete(String fileName) {
		File file = new File(fileName);//��װ
		if(!file.exists()) {
			System.out.println("ɾ���ļ�ʧ�ܣ�" + fileName + "�ļ�������");
			return false;
		}else {
			if(file.isFile()) {
				return DeleteFileUtil.deleteFile(fileName);
			}else {
				return DeleteFileUtil.deleteDirectory(fileName);
			}
		}
	}
	/**
	 * ɾ�������ļ�
	 * @param fileName ��ɾ���ļ����ļ���
	 * @return �����ļ�ɾ���ɹ����򷵻�true�����򷴻�false
	 */
	private static boolean deleteFile(String fileName) {
		// TODO Auto-generated method stub
		File file = new File(fileName);//��װ
		//����ļ�·����Ӧ���ļ����ڣ�������һ���ļ�����ֱ��ɾ��
		if(file.exists() && file.isFile()) {
			if(file.delete()) {
				System.out.println("ɾ�������ļ�" + fileName + "�ɹ��� ");
				return true;
			}else {
				System.out.println("ɾ�������ļ�" + fileName + "ʧ��");
				return false;
			}
		}else {
			System.out.println("ɾ�������ļ�ʧ�ܣ�" + fileName + "�ļ�������");
			return false;
		}
	}
	/**
	 * ɾ��Ŀ¼(�ļ���)�Լ�Ŀ¼�µ��ļ�
	 * @param dir ��ɾ��Ŀ¼���ļ�·��
	 * @return Ŀ¼ɾ���ɹ��򷵻�true,���򷵻�false;
	 */
	private static boolean deleteDirectory(String dir) {
		// TODO Auto-generated method stub
		//���dir�����ļ��ָ�����β���Զ�����ļ��ָ���
		if(!dir.endsWith(File.separator)) {
			dir = dir + File.separator;
		}
		File dirFile = new File(dir);
		//���dir��Ӧ���ļ������ڣ����߲���һ��Ŀ¼�����˳�
		if(!dirFile.exists() || (!dirFile.isDirectory())) {
			System.out.println("ɾ��Ŀ¼ʧ�ܣ�" + dir + "Ŀ¼�����ڣ�");
			return false;
		}
		boolean flag = true;
		//ɾ���ļ����µ������ļ���������Ŀ¼��
		File[] files = dirFile.listFiles();
		for(int i = 0;i < files.length; i++) {
			//ɾ�����ļ�
			if(files[i].isFile()) {
				flag = DeleteFileUtil.deleteFile(files[i].getAbsolutePath());
				if(!flag) {
					break;
				}
			}
			//ɾ����Ŀ¼
			else if(files[i].isDirectory()) {
				flag = DeleteFileUtil.deleteDirectory(files[i].getAbsolutePath());
				if(!flag) {
					break;
				}
			}
		}
		if(!flag) {
			System.out.println("ɾ��Ŀ¼ʧ��");
			return false;
		}
		//ɾ����ǰĿ¼
		if(dirFile.delete()) {
			System.out.println("ɾ��Ŀ¼��" + dir + "�ɹ���");
			return true;
		}else {
			return false;
		}
	}
	/**
	 * ������
	 * @param args
	 */
	public static void main(String[] args) {
		//ɾ�������ļ�
		String file = "F:\\GOOD\\BOY\\GOOD\\aaa.txt";
		DeleteFileUtil.deleteFile(file);
		System.out.println();
		
		//ɾ��һ��Ŀ¼
		String dir = "F:\\GOOD\\BOY\\GOOD";
		DeleteFileUtil.deleteDirectory(dir);
		System.out.println();
		
		//ɾ���ļ�
		dir = "F:\\GOOD";
		DeleteFileUtil.delete(dir);
	}
}
