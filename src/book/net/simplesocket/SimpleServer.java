package book.net.simplesocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         SimpleServer
 * ����ʱ�䣺 2018��1��22������10:51:55
 * �޸��ˣ�     Jefy
 * ��������     ʵ��Socket�������ˣ��ܹ����ܿͻ������󣬲������󷵻ظ��ͻ���
 */
public class SimpleServer {
	ServerSocket serverSkt = null;//�������˼�����Socket
	Socket clientSkt = null;//�ͻ���
	BufferedReader in = null;//�ͻ���������
	PrintStream out = null;//�ͻ��������
	
	public SimpleServer(int port) {
		System.out.println("�������������ڼ������˿ڣ�" + port);
		
		try {
			serverSkt = new ServerSocket(port);//��������socket
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("�����˿ڣ�" + port + "ʧ��");
		}
		try {
			clientSkt = serverSkt.accept();//������������
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("����ʧ��");
		}
		
		try {
			in = new BufferedReader(new InputStreamReader(clientSkt.getInputStream()));
			out = new PrintStream(clientSkt.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//�յ��ͻ�������
	public String getRequest() {
		String frmClt = null;
		try {
			frmClt = in.readLine();
			System.out.println("Server �յ�����"  + frmClt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("�޷���ȡ�˿�...");
			System.exit(0);
		}
		return frmClt;
	}
	//������Ӧ���ͻ���
	public void sendResponse(String response) {
		out.println(response);//�ڿͻ����������д����
		System.out.println("Server ��Ӧ����" + response);
	}
	
	public static void main(String[] args) {
		SimpleServer sa = new SimpleServer(8888);//����������
		while(true) {
			//��ȡ�ͻ��˵����벢���ظ��ͻ���
			sa.sendResponse(sa.getRequest());
		}
	}
}
