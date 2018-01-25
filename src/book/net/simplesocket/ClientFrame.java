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
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         ClientFrame
 * ����ʱ�䣺 2018��1��22������12:17:44
 * �޸��ˣ�     Jefy
 * ��������     �ͻ��˵�ͼ�ν���
 */
public class ClientFrame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5435041383134570760L;
	JButton sendButton;//"����"��ť
	JTextField inputField;//�������ݵ������
	JTextArea outputArea;//�������������ݵ��ı���
	SimpleClient client;//�ͻ���socket����
	
	//��զ���캯�������ͼ�ν���ĳ�ʼ��
	public ClientFrame() {
		JLabel label1 = new JLabel("���룺");
		inputField = new JTextField(20);
		JPanel panel1 = new JPanel();
		panel1.add(label1);
		panel1.add(inputField);
		
		JLabel label2 = new JLabel("���������أ�");
		outputArea = new JTextArea(6,20);
		JScrollPane crollPane = new JScrollPane(outputArea);
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		panel2.add(label2, BorderLayout.NORTH);
		panel2.add(crollPane,BorderLayout.CENTER);
		
		sendButton = new JButton("�� ��");
		sendButton.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(panel1,BorderLayout.NORTH);
		panel.add(sendButton,BorderLayout.CENTER);
		panel.add(panel2,BorderLayout.PAGE_END);
		
		setTitle("Socket �ͻ���");
		this.getContentPane().add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		//�ж��¼�Դ�ؼ��Ƿ��ǡ����͡���ť
		if(ae.getSource() == sendButton) {
			client.sendRequest(inputField.getText());//�����ı����е��ı�
			outputArea.append(client.getResponse() + "\n");
		}
	}
	
	public static void main(String[] args) {
		ClientFrame clientFrame = new ClientFrame();
		clientFrame.pack();
		
		//���ӷ�����
		try {
			clientFrame.client = new SimpleClient("127.0.0.1",8888);
			clientFrame.setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
