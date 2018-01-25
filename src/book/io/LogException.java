package book.io;

/**
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         LogException
 * 创建时间： 2018年1月24日上午11:25:31
 * 修改人：     Jefy
 * 类描述：    Log操作过程中的异常
 */
public class LogException extends Exception {
	/**
	 * 生成序列号
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
