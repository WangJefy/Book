package book.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         LogWriter
 * 创建时间： 2018年1月19日下午1:39:07
 * 修改人：     Jefy
 * 类描述：     自定义日志文件类    
 *        1.使用Singleton单例模式，使得整个程序中只存在一个日志类的实例
 *        2.写日志文件使用java.io.PrintWriter,因为它能对文本进行格式化写入
 *        3.通过配置文件的方式，允许用户修改日志文件的路径。使用java.util.Properties类解析配置文件
 *        4.为了避免多线程同时写文件造成的日志紊乱，在写日志消息时，使用同步机制
 */
public class LogWriter {
	public static final String LOG_CONFIGFILE_NAME = "log.properties";
	public static final String LOGFILE_TAG_NAME = "logfile";
	private final String DEFAULT_LOG_FILE_NAME = "./logtext.log";
	
	private static LogWriter logWriter;//该类的唯一实例
	private PrintWriter writer;//文件输出流
	private String logFileName;//日志文件名
	
	private LogWriter() throws LogException {
		this.init();
	}
	private LogWriter(String fileName) throws LogException {
		this.logFileName = fileName;
		this.init();
	}
	
	//获取LogWriter的唯一实例
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
	 * 往日志文件中写一条日志信息
	 * 为了防止多线程同时操作写日志文件，造成文件的死锁，使用synchronized关键字
	 * @param LogMsg 日志小消息
	 */
	public synchronized void log(String logMsg) {
		this.writer.println(new java.util.Date() + ":" + logMsg);
	}
	
	/**
	 * 往日志文件中写一条异常信息
	 * 使用synchronized关键字
	 * @param ex 待写入的异常
	 */
	public synchronized void log(Exception ex) {
		writer.println(new java.util.Date() + ":");
	}
	
	/**
	 * 初始化LogWriter
	 */
	private void init() throws LogException{
		//如果用户没有在参数中指定日志文件名，则从配置文件中获取
		if(this.logFileName == null) {
			this.logFileName = this.getLogFileNameFromConfigFile();
			if(this.logFileName == null) {
				this.logFileName = DEFAULT_LOG_FILE_NAME;
			}
		}
		File logFile = new File(this.logFileName);
		
		try {
			writer = new PrintWriter(new FileWriter(logFile,true),true);
			System.out.println("日志文件的位置：" + logFile.getAbsolutePath());
		} catch (IOException e) {
			String errmsg = "无法打开日志文件" + logFile.getAbsolutePath();
			throw new LogException(errmsg);
		}
	}
	
	/**
	 * 从配置文件中获取日志文件名
	 * @return
	 */
	private String getLogFileNameFromConfigFile() {
			try {
				Properties pro = new Properties();
				//在类的当前位置，查找属性配置文件log.properties
				InputStream fin = getClass().getResourceAsStream(LOG_CONFIGFILE_NAME);
				if(fin != null) {
					pro.load(fin);
					fin.close();
					return pro.getProperty(LOGFILE_TAG_NAME);
				}else {
					System.err.println("无法打开属性配置文件：log.properties");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("无法打开属性配置文件：log.properties");
			}//装入配置文件
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
			logger.log("第二个日志信息");
			logger.log("Third log:");
			logger.log("第四个日志信息");
			logger.close();
			ReadFromFile.readFileByLines(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		java.util.Date a = new java.util.Date();
		System.out.println("时间" + a);
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