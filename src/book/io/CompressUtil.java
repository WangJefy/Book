package book.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * ʹ��ZipOutputStream����ʵ���ļ�ѹ��������д�뵽ZipOutputStream������е����ݣ����ᱻZip��ʽѹ��
 *  
 * ʹ��ZipOutputStream��ZipInputStream�ȣ����InputStream��OutputStream����װ�Σ������ڴ�������ʱ�Ĵ��Σ�
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         CompressUtil
 * ����ʱ�䣺 2018��1��18������8:53:29
 * �޸��ˣ�     Jefy
 * ��������
 */
public class CompressUtil {
	/**
	 * ѹ���ļ���Ŀ¼
	 * @param baseDirName ѹ���ĸ�Ŀ¼
	 * @param fileName ��Ŀ¼�´�ѹ�����ļ���Ŀ¼��ʹ��*�ţ���ʾѹ����Ŀ¼�µ�ȫ���ļ�
	 * @param targetFileName Ŀ��ZIP�ļ�
	 * @throws IOException 
	 */
	public static void zipFile(String baseDirName,String fileName,String targetFileName) throws IOException {
		//����Ŀ¼�Ƿ����
		if(baseDirName == null) {
			System.out.println("ѹ��ʧ�ܣ���Ŀ¼�����ڣ� " + baseDirName);
			return;
		}
		File baseDir = new File(baseDirName);
		if(!baseDir.exists() || (!baseDir.isDirectory())) {
			System.out.println("ѹ��ʧ�ܣ���Ŀ¼�����ڣ�" + baseDirName);
			return;
		}
		String baseDirPath = baseDir.getAbsolutePath();
		//Ŀ���ļ�
		File targetFile = new File(targetFileName);
		//����һ��zip�������ѹ�����ݲ�д��zip�ļ�
		try {
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(targetFile));
			if(fileName.equals("*")) {
				//��baseDirĿ¼�µ������ļ�ѹ����ZIP
				CompressUtil.dirToZip(baseDirPath,baseDir,out);
			}else {
				File file = new File(baseDir,fileName);
				if(file.isFile()) {
					CompressUtil.fileToZip(baseDirPath,file,out);
				}else {
					CompressUtil.dirToZip(baseDirPath, file, out);
				}
			}
			out.close();
			System.out.println("ѹ���ļ��ɹ���Ŀ���ļ�����" + targetFileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("ѹ��ʧ�ܣ�" + e);
			e.printStackTrace();
		}
	}
	/**
	 * ��ѹ��ZIP�ļ�����ZIP�ļ�������ݽ�ѹ��targetDIRĿ¼��
	 * @param zipFileName
	 * @param targetBaseDirName
	 */
	public static void upzipFile(String zipFileName,String targetBaseDirName) {
		if(!targetBaseDirName.endsWith(File.separator)) {
			targetBaseDirName += File.separator;
		}
		try {
			//����ZIP�ļ�����ZipFile����
			ZipFile zipFile = new ZipFile(zipFileName);
			ZipEntry entry = null;
			String entryName = null;
			String targetFileName = null;
			byte[] buffer = new byte[4096];
			int bytes_read;
			//��ȡZIP�ļ������е�entry
			Enumeration<?> entrys = zipFile.entries();
			//�������е�entry
			while(entrys.hasMoreElements()) {
				entry = (ZipEntry) entrys.nextElement();
				//���entry������
				entry.getName();
				targetFileName = targetBaseDirName + entryName;
				if(entry.isDirectory()) {
					//���entry��һ��Ŀ¼���򴴽�Ŀ¼
					new File(targetFileName).mkdirs();
					continue;
				}else {
					//���entry��һ���ļ����򴴽���Ŀ¼
					new File(targetFileName).getParentFile().mkdirs();
				}
				//���򴴽��ļ�
				File targetFile = new File(targetFileName);
				System.out.println("�����ļ���" + targetFile.getAbsolutePath());
				//���ļ������
				FileOutputStream os = new FileOutputStream(targetFile);
				//��ZipFile�����д�entry�������
				InputStream is = zipFile.getInputStream(entry);
				while((bytes_read = is.read(buffer)) != -1) {
					os.write(buffer, 0, bytes_read);
				}
				//�ر���
				os.close();
				is.close();
				zipFile.close();
			}
			System.out.println("��ѹ���ļ��ɹ���");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("��ѹ���ļ�ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	/**
	 * ���ļ�ѹ����ZIP�ļ���
	 * @param baseDirPathd
	 * @param file
	 * @param out
	 * @throws IOException 
	 */
	public static void fileToZip(String baseDirPath, File file, ZipOutputStream out) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream in = null;
		ZipEntry entry = null;
		
		//�������ƻ�����
		byte[] buffer = new byte[4096];
		int bytes_read;
		if(file.isFile()) {
			try {
				in = new FileInputStream(file);//����һ���ļ�������
				//����һ��ZipEntry
				entry = new ZipEntry(getEntryName(baseDirPath,file));
				out.putNextEntry(entry);//�洢����Ϣ��ѹ���ļ�
				//�����ֽڵ�ѹ���ļ�
				while((bytes_read = in.read(buffer)) != -1) {
					out.write(buffer, 0, bytes_read);
				}
				out.closeEntry();
				in.close();
				System.out.println("�����ļ�" + file.getAbsolutePath() + "��Zip�ļ��У�");
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	/**
	 * ��Ŀ¼ѹ����ZIP�����
	 * @param baseDirPath
	 * @param dir
	 * @param out
	 * @throws IOException 
	 */
	public static void dirToZip(String baseDirPath, File dir, ZipOutputStream out) throws IOException {
		// TODO Auto-generated method stub
		if(dir.isDirectory()) {
			//�г�dirĿ¼�������ļ�
			File[] files = dir.listFiles();
			//����ǿ��ļ�
			if(files.length == 0) {
				ZipEntry entry = new ZipEntry(getEntryName(baseDirPath, dir));
				//�洢Ŀ¼��Ϣ
				out.putNextEntry(entry);
				out.closeEntry();
				return;
			}
			for (int i = 0; i < files.length; i++) {
				if(files[i].isFile()) {
					//������ļ�������fileToZip����
					CompressUtil.dirToZip(baseDirPath, files[i], out);
				}else {
					//�����Ŀ¼���ݹ����
					CompressUtil.dirToZip(baseDirPath, files[i], out);
				}
					
			}
		}
		
	}
	public static String getEntryName(String baseDirPath, File file) {
		// TODO Auto-generated method stub
		if(!baseDirPath.endsWith(File.separator)) {
			baseDirPath += File.separator;
		}
		String filePath = file.getAbsolutePath();
		//����Ŀ¼��������entry���ֺ������"/"����ʾ������Ŀ¼��洢
		if(file.isDirectory()) {
			filePath += "/";
			
		}
		int index = filePath.indexOf(baseDirPath);
		return filePath.substring(index + baseDirPath.length());
	}
	
	public static void main(String[] args) {
		//ѹ��
		String baseDirName = "C:";
		String fileName = "";
		String zipFileName = "";
		try {
			CompressUtil.zipFile(baseDirName, fileName, zipFileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//��ѹ��
		System.out.println();
		fileName = "";
		CompressUtil.upzipFile(zipFileName, fileName);
		
	}
}