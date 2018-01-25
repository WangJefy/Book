package book.net.simplesocket;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         ClientFrame
 * 创建时间： 2018年1月22日下午12:17:44
 * 修改人：     Jefy
 * 类描述：     客户端的图形界面
 */
public class ClientFrame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5435041383134570760L;
	JButton sendButton;//"发送"按钮
	JTextField inputField;//发送内容的输入框
	JTextArea outputArea;//服务器返回内容的文本域
	SimpleClient client;//客户端socket对象
	
	//在咋构造函数中完成图形界面的初始化
	public ClientFrame() {
		JLabel label1 = new JLabel("输入：");
		inputField = new JTextField(20);
		JPanel panel1 = new JPanel();
		panel1.add(label1);
		panel1.add(inputField);
		
		JLabel label2 = new JLabel("服务器返回：");
		outputArea = new JTextArea(6,20);
		JScrollPane crollPane = new JScrollPane(outputArea);
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		panel2.add(label2, BorderLayout.NORTH);
		panel2.add(crollPane,BorderLayout.CENTER);
		
		sendButton = new JButton("发 送");
		sendButton.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(panel1,BorderLayout.NORTH);
		panel.add(sendButton,BorderLayout.CENTER);
		panel.add(panel2,BorderLayout.PAGE_END);
		
		setTitle("Socket 客户端");
		this.getContentPane().add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		//判断事件源控件是否是“发送”按钮
		if(ae.getSource() == sendButton) {
			client.sendRequest(inputField.getText());//发送文本框中的文本
			outputArea.append(client.getResponse() + "\n");
		}
	}
	
	public static void main(String[] args) {
		ClientFrame clientFrame = new ClientFrame();
		clientFrame.pack();
		
		//连接服务器
		try {
			clientFrame.client = new SimpleClient("127.0.0.1",8888);
			clientFrame.setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
