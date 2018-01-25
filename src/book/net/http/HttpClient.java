package book.net.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         HttpClient
 * ����ʱ�䣺 2018��1��22������10:02:04
 * �޸��ˣ�     Jefy
 * ��������     ����HTTP�Ŀͻ��ˣ�����ҳ������ʾ�ڿ���̨���õ�һ��HTML����
 */
public class HttpClient {
	String urlString ;
	public HttpClient(String urlString) {
		this.urlString = urlString;
	}
	
	public void run() throws IOException {
		URL url = new URL(urlString);//����һ��URL����
		//��URL
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		//��ӡͷ��Ϣ
		System.out.println();
		System.out.println("THE HEADERS");
		System.out.println("--------------------");
		for(int i = 1;; ++i) {
			String key;
			String value;
			if((key = urlConnection.getHeaderFieldKey(i)) == null) {
				break;
			}
			if((value = urlConnection.getHeaderField(i)) == null) {
				break;
			}
			System.out.println(key);
			System.out.println(" is:" + value);
		}
		//�õ����������������ҳ����
		BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String line;
		System.out.println("------------CONTENT------------");
		//��ȡ���������ݣ�����ʾ
		while((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		reader.close();
		
	}
	
	public static void main(String[] args) {
		//��һ������Ϊ��ַ
		if(args.length != 1) {
			System.out.println("Usage:  java book.net.http.HttpClient url");
			System.exit(1);
		}
		HttpClient client = new HttpClient(args[0]);
		try {
			client.run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
