package book.net.simplesocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * һ���򵥵�socket�ͻ��ˣ��ܹ�������������socket����
 */
public class SimpleClient {
	//�ͻ������������
	PrintStream out;
	BufferedReader in;
	
	public SimpleClient(String serverName,int port) throws IOException {
		//���ݷ��������Ͷ˿ںţ����ӷ�����
		Socket clientSocket = new Socket(serverName,port);
		try {
			//��ȡsocket�����������
			OutputStream outStream = clientSocket.getOutputStream();
			out = new PrintStream(outStream);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�޷����ӷ�����");
			
			clientSocket.close();
			out.close();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//��������
	public void sendRequest(String request) {
		out.println(request);//��socket�������д����
		System.out.println("Client ��������" + request);
	}
	
	public String getResponse() {
		String str = null;
		try {
			str = in.readLine();
			System.out.println("Client �յ�Server���أ�" + str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//��socket��������д����
		return str;
	}
}
