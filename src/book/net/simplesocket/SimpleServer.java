package book.net.simplesocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         SimpleServer
 * 创建时间： 2018年1月22日上午10:51:55
 * 修改人：     Jefy
 * 类描述：     实现Socket服务器端，能够接受客户端请求，并将请求返回给客户端
 */
public class SimpleServer {
	ServerSocket serverSkt = null;//服务器端监听的Socket
	Socket clientSkt = null;//客户端
	BufferedReader in = null;//客户端输入流
	PrintStream out = null;//客户端输出流
	
	public SimpleServer(int port) {
		System.out.println("服务器代理正在监听，端口：" + port);
		
		try {
			serverSkt = new ServerSocket(port);//创建监听socket
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("监听端口：" + port + "失败");
		}
		try {
			clientSkt = serverSkt.accept();//接收连接请求
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("连接失败");
		}
		
		try {
			in = new BufferedReader(new InputStreamReader(clientSkt.getInputStream()));
			out = new PrintStream(clientSkt.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//收到客户端请求
	public String getRequest() {
		String frmClt = null;
		try {
			frmClt = in.readLine();
			System.out.println("Server 收到请求："  + frmClt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("无法读取端口...");
			System.exit(0);
		}
		return frmClt;
	}
	//发送响应给客户端
	public void sendResponse(String response) {
		out.println(response);//在客户端输出流中写数据
		System.out.println("Server 响应请求：" + response);
	}
	
	public static void main(String[] args) {
		SimpleServer sa = new SimpleServer(8888);//启动服务器
		while(true) {
			//读取客户端的输入并返回给客户端
			sa.sendResponse(sa.getRequest());
		}
	}
}
