package book.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         LogWriter
 * ����ʱ�䣺 2018��1��19������1:39:07
 * �޸��ˣ�     Jefy
 * ��������     �Զ�����־�ļ���    
 *        1.ʹ��Singleton����ģʽ��ʹ������������ֻ����һ����־���ʵ��
 *        2.д��־�ļ�ʹ��java.io.PrintWriter,��Ϊ���ܶ��ı����и�ʽ��д��
 *        3.ͨ�������ļ��ķ�ʽ�������û��޸���־�ļ���·����ʹ��java.util.Properties����������ļ�
 *        4.Ϊ�˱�����߳�ͬʱд�ļ���ɵ���־���ң���д��־��Ϣʱ��ʹ��ͬ������
 */
public class LogWriter {
	public static final String LOG_CONFIGFILE_NAME = "log.properties";
	public static final String LOGFILE_TAG_NAME = "logfile";
	private final String DEFAULT_LOG_FILE_NAME = "./logtext.log";
	
	private static LogWriter logWriter;//�����Ψһʵ��
	private PrintWriter writer;//�ļ������
	private String logFileName;//��־�ļ���
	
	private LogWriter() throws LogException {
		this.init();
	}
	private LogWriter(String fileName) throws LogException {
		this.logFileName = fileName;
		this.init();
	}
	
	//��ȡLogWriter��Ψһʵ��
	public synchronized static LogWriter getLogWriter() throws LogException {
		if(logWriter == null) {
			logWriter = new LogWriter();
		}
		return logWriter;
	}
	
	public synchronized static LogWriter getLogWriter(String logFileName) throws LogException {
		if(logWriter == null) {
			logWriter = new LogWriter(logFileName);
		}
		return logWriter;
	}
	
	
	/**
	 * ����־�ļ���дһ����־��Ϣ
	 * Ϊ�˷�ֹ���߳�ͬʱ����д��־�ļ�������ļ���������ʹ��synchronized�ؼ���
	 * @param LogMsg ��־С��Ϣ
	 */
	public synchronized void log(String logMsg) {
		this.writer.println(new java.util.Date() + ":" + logMsg);
	}
	
	/**
	 * ����־�ļ���дһ���쳣��Ϣ
	 * ʹ��synchronized�ؼ���
	 * @param ex ��д����쳣
	 */
	public synchronized void log(Exception ex) {
		writer.println(new java.util.Date() + ":");
	}
	
	/**
	 * ��ʼ��LogWriter
	 */
	private void init() throws LogException{
		//����û�û���ڲ�����ָ����־�ļ�������������ļ��л�ȡ
		if(this.logFileName == null) {
			this.logFileName = this.getLogFileNameFromConfigFile();
			if(this.logFileName == null) {
				this.logFileName = DEFAULT_LOG_FILE_NAME;
			}
		}
		File logFile = new File(this.logFileName);
		
		try {
			writer = new PrintWriter(new FileWriter(logFile,true),true);
			System.out.println("��־�ļ���λ�ã�" + logFile.getAbsolutePath());
		} catch (IOException e) {
			String errmsg = "�޷�����־�ļ�" + logFile.getAbsolutePath();
			throw new LogException(errmsg);
		}
	}
	
	/**
	 * �������ļ��л�ȡ��־�ļ���
	 * @return
	 */
	private String getLogFileNameFromConfigFile() {
			try {
				Properties pro = new Properties();
				//����ĵ�ǰλ�ã��������������ļ�log.properties
				InputStream fin = getClass().getResourceAsStream(LOG_CONFIGFILE_NAME);
				if(fin != null) {
					pro.load(fin);
					fin.close();
					return pro.getProperty(LOGFILE_TAG_NAME);
				}else {
					System.err.println("�޷������������ļ���log.properties");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("�޷������������ļ���log.properties");
			}//װ�������ļ�
			return null;
	}
	public void close() {
		logWriter = null;
		if(writer == null) {
			writer.close();
		}
	}
	public static void main(String[] args) {
		LogWriter logger = null;
		try {
			String fileName = "F:\\eclipse-workspace\\IO\\log\\logger.log";
			try {
				logger = LogWriter.getLogWriter(fileName);
			} catch (LogException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logger.log("First log!");
			logger.log("�ڶ�����־��Ϣ");
			logger.log("Third log:");
			logger.log("���ĸ���־��Ϣ");
			logger.close();
			ReadFromFile.readFileByLines(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		java.util.Date a = new java.util.Date();
		System.out.println("ʱ��" + a);
		Te te = new Te();
		System.out.println(te);
		Ze ze = new Ze();
		System.out.println(ze);
	}
}
class Te{
	public String toString() {
		return "chongxie";
	}
}
class Ze{
	
}