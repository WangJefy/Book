package book.thread;
/**
 * 定义和启动线程
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         DefineThread
 * 创建时间： 2018年1月19日上午9:17:53
 * 修改人：     Jefy
 * 类描述：
 */
public class DefineThread implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("ddd");
	}
	public static void main(String[] args) {
		Runnable tb = new DefineThread();
		Thread thread = new Thread(tb);
		Thread thread2 = new Thread(tb);
		thread.start();
		thread2.start();
	}
}
