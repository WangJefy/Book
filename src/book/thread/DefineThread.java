package book.thread;
/**
 * ����������߳�
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         DefineThread
 * ����ʱ�䣺 2018��1��19������9:17:53
 * �޸��ˣ�     Jefy
 * ��������
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
