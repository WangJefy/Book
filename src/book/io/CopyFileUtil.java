package book.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * �����ļ���Ŀ¼
 *
 */
public class CopyFileUtil {
	/**
	 * ���Ƶ����ļ������Ŀ���ļ����ڣ��򲻸���
	 * @param srcFileName �����Ƶ��ļ���
	 * @param destFileName Ŀ���ļ���
	 * @return ���Ƴɹ��򷵻�true,���򷵻�false
	 * @throws IOException 
	 */
	public static boolean copyFile(String srcFileName,String destFileName) throws IOException {
		return CopyFileUtil.copyFile(srcFileName, destFileName,false);
	}
	/**
	 * ���Ƶ����ļ�
	 * @param srcFileName �����Ƶ��ļ���
	 * @param destFileName Ŀ���ļ���
	 * @param overlay ���Ŀ���ļ����ڣ��Ƿ񸲸�
	 * @return
	 * @throws IOException 
	 */
	public static boolean copyFile(String srcFileName, String destFileName, boolean overlay) throws IOException {
		// TODO Auto-generated method stub
		//�ж�Դ�ļ��Ƿ����
		File srcFile = new File(srcFileName);
		if(!srcFile.exists()) {
			System.out.println("�����ļ�ʧ�ܣ�" + srcFileName + "������");
			return false;
		}else if(!srcFile.isFile()) {
			System.out.println("�����ļ�ʧ�ܣ�" + srcFileName + "����һ���ļ���");
			return false;
		}
		
		//�ж�Ŀ���ļ��Ƿ����
		File destFile = new File(destFileName);
		if(destFile.exists()) {
			//���Ŀ���ļ����ڣ����Ҹ���ʱ������
			if(overlay) {
				//ɾ���Ѵ��ڵ�Ŀ���ļ�������Ŀ���ļ���Ŀ¼���ǵ����ļ�
				System.out.println("Ŀ���ļ��Ѵ��ڣ�׼��ɾ������");
				if(!DeleteFileUtil.delete(destFileName)) {
					System.out.println("�����ļ�ʧ�ܣ�ɾ��Ŀ���ļ�" + destFileName + "ʧ�ܣ�");
					return false;
				}
			}else {
				System.out.println("�����ļ�ʧ�ܣ�Ŀ���ļ�" + destFileName + "�Ѵ��ڣ�");
				return false;
			}
		}else {
			if(!destFile.getParentFile().exists()) {
				//���Ŀ���ļ����ڵ�Ŀ¼�����ڣ��򴴽�Ŀ¼
				System.out.println("Ŀ���ļ����ڵ�Ŀ¼�����ڣ�׼����������");
				if(!destFile.getParentFile().mkdirs()) {
					System.out.println("�����ļ�ʧ�ܣ�����Ŀ���ļ����ڵ�Ŀ¼ʧ�ܣ�");
				}
			}
		}
		//׼�������ļ�
		int byteread = 0;//��ȡ���ֽ���
		InputStream in = null; //������
		OutputStream out = null; //�����
		
		try {
			//FileInputStream:�ļ����������ļ�ϵͳ�е��ļ���ȡ�����ֽ�
			in = new FileInputStream(srcFile);//��Դ�ļ�
			
			out = new FileOutputStream(destFile);//�����ӵ�Ŀ���ļ��������
			byte[] buffer = new byte[1024];
			//һ�ζ�ȡ1024���ֽڣ��� byteread Ϊ-1ʱ��ʾ�ļ��Ѿ�����
			while((byteread = in.read(buffer)) != -1) {
				out.write(buffer, 0, byteread);//����ȡ���ֽ�д�������
			}
			System.out.println("���Ƶ����ļ�" + srcFileName + "��" + destFileName + "�ɹ���");
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("�����ļ�ʧ�ܣ�" + e.getMessage());
			return false;
		}finally {
			//�ر������������ ע���ȹر���������ڹر�������
			if(out != null) {
				out.close();
			}
			if(in != null) {
				in.close();
			}
		}
	}
	/**
	 * ��������Ŀ¼������
	 * @param srcDirName �����Ƶ�Ŀ¼��
	 * @param destDirName Ŀ��Ŀ¼��
	 * @return ������Ƴɹ�����true,���򷵻�false
	 * @throws IOException 
	 */
	public static boolean copyDirectory(String srcDirName,String destDirName) throws IOException {
		return CopyFileUtil.copyDirectory(srcDirName, destDirName,false);
	}
	/**
	 * ��������Ŀ¼�����ݣ����Ŀ��Ŀ¼���ڣ��򲻸���
	 * @param srcDirName �����Ƶ�Ŀ¼��
	 * @param destDirName Ŀ��Ŀ¼��
	 * @param overlay ���Ŀ��Ŀ¼���ڣ��Ƿ񸲸�
	 * @return ������Ƴɹ�����true,���򷵻�false
	 * @throws IOException 
	 */
	public static boolean copyDirectory(String srcDirName, String destDirName, boolean overlay) throws IOException {
		// TODO Auto-generated method stub
		//�ж�Ŀ¼�Ƿ����
		File srcDir = new File(srcDirName);//��װ
		if(!srcDir.exists()) {
			System.out.println("����Ŀ¼ʧ�ܣ�ԴĿ¼" + srcDirName + "�����ڣ�");
			return false;
		}else if(!srcDir.isDirectory()) {
			System.out.println("����Ŀ¼ʧ�ܣ�" + srcDirName + "����һ��Ŀ¼��");
			return false;
		}
		
		//���Ŀ���ļ����������ļ��ָ�����β���Զ�����ļ��ָ��
		if(!destDirName.endsWith(File.separator)) {
			destDirName = destDirName + File.separator;
		}
		
		File destDir = new File(destDirName);
		//���Ŀ���ļ��д���
		if(destDir.exists()) {
			if(overlay) {
				//��������ɾ���Ѵ��ڵ�Ŀ��Ŀ¼
				System.out.println("Ŀ��Ŀ¼�Ѵ��ڣ�׼��ɾ������");
				if(!DeleteFileUtil.delete(destDirName)) {
					System.out.println("����Ŀ¼ʧ�ܣ�ɾ��Ŀ��Ŀ¼" + destDirName + "ʧЧ��");
				}
			}else {
				System.out.println("����Ŀ¼ʧ�ܣ�Ŀ��Ŀ¼" + destDirName + "�Ѵ��ڣ�");
				return false;
			}
		}else {
			//����Ŀ��Ŀ¼
			System.out.println("Ŀ��Ŀ¼�����ڣ�׼����������");
			if(!destDir.mkdirs()) {
				System.out.println("����Ŀ¼ʧ�ܣ�����Ŀ��Ŀ¼ʧ�ܣ�");
				return false;
			}
		}
		boolean flag = true;
		//�г�Դ�ļ����������ļ���������Ŀ¼�����ļ���
		File[] files = srcDir.listFiles();
		for (int i = 0; i < files.length; i++) {
			//����ǵ����ļ�������и���
			if(files[i].isFile()) {
				flag = CopyFileUtil.copyFile(files[i].getAbsolutePath(), destDirName + files[i].getName());
				if(!flag) {
					break;
				}
			}
			//�������Ŀ¼����������Ŀ¼
			if(files[i].isDirectory()) {
				flag = CopyFileUtil.copyDirectory(files[i].getAbsolutePath(), destDirName + files[i].getName());
				if(!flag) {
					break;
				}
			}
		}
		if(!flag) {
			System.out.println("����Ŀ¼" + srcDirName + "��" + destDirName + "ʧ�ܣ�");
			return false;
		}
		System.out.println("����Ŀ¼" + srcDirName + "��" + destDirName + "�ɹ���");
		return true;
	}
	/**
	 * ���������������
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//���Ƶ����ļ������Ŀ���ļ����ڣ��򸲸�
		String srcPath = "F:\\temp\\tempfile0.txt";
		String destPath = "F:\\temp_bak\\tempfile0_bak.txt";
		CopyFileUtil.copyFile(srcPath, destPath, true);
		//���Ŀ����ڣ��򲻸���
		CopyFileUtil.copyFile(srcPath, destPath);
		System.out.println();
		//�����ļ��У����Ŀ����ڣ��򸲸�
		String srcDir = "F:\\temp";
		String destDir = "F:\\Copy\\temp";
		CopyFileUtil.copyDirectory(srcDir, destDir, true);
	}
}
