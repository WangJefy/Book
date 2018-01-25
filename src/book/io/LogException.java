package book.io;

/**
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         LogException
 * ����ʱ�䣺 2018��1��24������11:25:31
 * �޸��ˣ�     Jefy
 * ��������    Log���������е��쳣
 */
public class LogException extends Exception {
	/**
	 * �������к�
	 */
	private static final long serialVersionUID = 1039733132712279656L;
	public LogException() {
		super();
	}
	public LogException(String msg) {
		super(msg);
	}
	public LogException(String msg,Throwable cause) {
		super(msg,cause);
	}
	public LogException(Throwable cause) {
		super(cause);
	}
}
