package book.io;

import java.io.File;
import java.util.Date;

/**
 * ��ȡ�ļ��Ļ�����Ϣ
 */
public class GetFileInfos {
	public static void main(String[] args) {
		//���ļ�·���½�һ���ļ�����·�������Ǿ���·��Ҳ���������·��
		//����Ĳ����������ļ��ĳ���·��
		File file = new File("F:/myfile/readme.txt");//������·��������װ��File����
		System.out.println("����ļ���׼��·����" + file.getPath());
		
		//��ȡ�ļ���
		System.out.println("�ļ�����\t" + file.getName());
		//��ȡ�ļ��ľ���·��
		System.out.println("�ļ�����·����\t" + file.getAbsolutePath());
		//��ȡ����·�����ĸ�������·��
		System.out.println("�ļ���������·���� \t" + file.getParent());
		//�ж��ļ��Ƿ����
		System.out.println("�ļ��Ƿ���ڣ�\t" + file.exists());//��������豸��û�и��ļ����򷵻�false
		System.out.println("�ļ��Ƿ�ɶ�:\t" + file.canRead());
		System.out.println("�ļ��Ƿ��д��\t" + file.canWrite());
		System.out.println("�ļ��Ƿ��������ļ���\t" + file.isHidden());
		System.out.println("�ļ��Ƿ�����ͨ�ļ���\t" + file.isFile());
		System.out.println("�ļ��Ƿ���Ŀ¼�� \t" + file.isDirectory());
		System.out.println("�ļ�·���Ƿ��Ǿ���·����\t" + file.isAbsolute());
		System.out.println("�ļ�·����URI: \t" + file.toURI());
		System.out.println("�ļ�������޸�ʱ�䣺\t" + new Date(file.lastModified()));
		System.out.println("�ļ���С��\t" + file.length());
		System.out.println("�ļ�����׺�Ƿ�Ϊָ������txt��\t" + file.getName().endsWith("txt"));
		System.out.println("�ļ��ķָ�����\t" + File.separator);
		boolean b = file.toURI().toString().endsWith("myfile");
		System.out.println("�ж��ļ��Ƿ����ļ��ָ�����β��" + b);
		File file2 = new File("F:/GOOD/BOY/GOOD/GIRL");
		boolean c = file2.mkdirs();//�������������赫�����ڵĸ�Ŀ¼
		System.out.println(c);
		System.out.println(file2.getAbsolutePath());
		System.out.println("�Ƿ�ΪĿ¼�� " + file2.isDirectory());
		System.out.println("�ļ���С��" + file.length() + " ���ֽ�");
		
		String str = "a";
		System.out.println(str.getBytes().length);
		
	}
}
