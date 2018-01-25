package book.io;

import java.io.File;
import java.io.IOException;

/**
 * �����ļ���Ŀ¼
 */
public class CreateFileUtil {
	/**
	 * ���������ļ�
	 * @param destFileName Ŀ���ļ���
	 * @return �����ɹ�������true,����ʧ�ܣ�����false
	 */
	public static boolean createFile(String destFileName) {
		File file = new File(destFileName);//��Ŀ���ļ���װ��File����
		if(file.exists()) {
			System.out.println("���������ļ�" + destFileName + "ʧ�ܣ�Ŀ���ļ��Ѵ��ڣ�");
			return false;
		}
		if(destFileName.endsWith(File.separator)) {
			System.out.println("���������ļ�" + destFileName + "ʧ�ܣ�Ŀ���ļ�����ΪĿ¼��");
			return false;
		}
		//�ж�Ŀ���ļ����ڵ�Ŀ¼�Ƿ����
		if(!file.getParentFile().exists()) {
			//���Ŀ���ļ����ڵ�Ŀ¼�����ڣ��򴴽���Ŀ¼
			System.out.println("Ŀ���ļ�����Ŀ¼�����ڣ�׼����������");
			if(!file.getParentFile().mkdirs()) {
				System.out.println("����Ŀ���ļ����ڵ�Ŀ¼ʧ�ܣ�");
				return false;
			}
		}
		//����Ŀ���ļ�
		try {
			if(file.createNewFile()) {
				System.out.println("���������ļ�" + destFileName + " �ɹ���");
				return true;
			}else {
				System.out.println("���������ļ�" + destFileName + "ʧ�ܣ�");
				return false;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���������ļ�" + destFileName + "ʧ�ܣ� " + e.getMessage());
		}
		return false;
	}
	
	/**
	 * ����Ŀ¼
	 * @param destDirName Ŀ��Ŀ¼��
	 * @return Ŀ¼�����ɹ�����true,����ʧ�ܷ���false
	 */
	public static boolean createDir(String destDirName) {
		File dir = new File(destDirName);//��Ŀ¼����Ŀ��·����װ�ɶ���
		if(dir.exists()) {
			System.out.println("����Ŀ¼" + destDirName + "ʧ�ܣ�Ŀ��Ŀ¼�Ѵ��ڣ�");
			return false;
		}
		if(!destDirName.endsWith(File.separator)) {
			destDirName = destDirName + File.separator;
		}
		if(dir.mkdirs()) {
			System.out.println("����Ŀ¼" + destDirName + "�ɹ���" );
			return true;
		}else {
			System.out.println("����Ŀ¼" + destDirName + "ʧ�ܣ�" );
			return false;
		}
	}
	/**
	 * ������ʱ�ļ�
	 * @param prefix ��ʱ�ļ�����ǰհ
	 * @param suffix ��ʱ�ļ��ĺ�׺
	 * @param dirName ��ʱ�ļ����ڵ�Ŀ¼���������null�������û����ĵ�Ŀ¼�´�����ʱ�ļ�
	 * @return ��ʱ�ļ������ɹ�����true,���򷵻�false
	 */
	public static String createTempFile(String prefix,String suffix,String dirName) {
		File tempFile = null;
		if(dirName == null) {
			
			try {
				//��Ĭ���ļ����´�����ʱ�ļ�
				tempFile = File.createTempFile(prefix, suffix);
				//������ʱ�ļ���·��
				return tempFile.getCanonicalPath();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("������ʱ�ļ�ʧ�ܣ����ܴ�����ʱ�ļ����ڵ�Ŀ¼��");
				return null;
			}
		}else {
			File dir = new File(dirName);
			//�����ʱ�ļ�����Ŀ¼�����ڣ����ȴ���
			if(!dir.exists()) {
				if(CreateFileUtil.createDir(dirName)) {
					System.out.println("������ʱ�ļ�ʧ�ܣ����ܴ�����ʱ�ļ����ڵ�Ŀ¼��");
					return null;
				}
			}
			try {
				//��ָ��Ŀ¼�´�����ʱ�ļ�
				tempFile = File.createTempFile(prefix, suffix,dir);
				return tempFile.getCanonicalPath();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("������ʱ�ļ�ʧ�ܣ�" + e.getMessage());
				return null;
			}
		}
	}
	/**
	 * ������
	 * @param args �����в������ַ�������
	 * @throws IOException ����IO�쳣
	 */
	public static void main(String[] args) throws IOException {
		//����Ŀ¼
		String dirName = "F:/MuLu/";
		CreateFileUtil.createDir(dirName);
		//�����ļ�
		String fileName = dirName + "aa.txt";
		CreateFileUtil.createFile(fileName);
		//������ʱ�ļ�
		String prefix = "temp";
		String suffix = ".txt";
		for(int i = 0; i < 10;i++) {
			System.out.println("��������ʱ�ļ���" + CreateFileUtil.createTempFile(prefix, suffix, dirName));
		}
	}
}
