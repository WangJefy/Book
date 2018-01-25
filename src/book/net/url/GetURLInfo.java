package book.net.url;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         GetURLInfo
 * ����ʱ�䣺 2018��1��21������9:14:50
 * �޸��ˣ�     Jefy
 * ��������     ͨ��URL�ܹ��õ�����Ϣ
 */
public class GetURLInfo {
	/**
	 * ���һ��URL�����Ϣ����Ҫʹ��URLConnection��
	 * @param url
	 * @throws IOException 
	 */
	public static void printInfo(URL url) throws IOException {
		//URL������Ϣ
		System.out.println(" File:" + url.getFile());//public String getFile(); return the file name of this URL  
		System.out.println(" Protocol:" + url.getProtocol());//public String getProtocol(); return the protocol of this URL
		System.out.println(" Host:" + url.getHost());//public String getHost(); return the host name of this URL
		System.out.println(" Port:" + url.getPort());//public int getPort(); return the port number or -1 if the port is not set
		
		//��ȡURLConnection����Ҫע��
		URLConnection c = url.openConnection();
		//���ӵ�URL,�����������URL�������ֳ�ʱ��Ϣ
		System.out.println(" c ����Ϣ��" + c.toString()); 
		c.connect();
		//��ʾ��Ϣ
		System.out.println(" Content Type:" + c.getContentType());//public String getContentType(); return the content type of the resource that the URL references
		
		//�����HTTP���ӡ�����HttpURLConnection��URLConnection������.
		if(c instanceof HttpURLConnection) {
			HttpURLConnection h = (HttpURLConnection) c;
			System.out.println(" Request Method:" + h.getRequestMethod());
			System.out.println(" Response Message:" + h.getResponseMessage());
			System.out.println(" Response Code: " + h.getResponseCode());
			
		}
	}
	public static void main(String[] args) throws IOException {
		String url = "http://www.baidu.com:80/index.html";
		URL url2 = new URL(url);
		printInfo(url2);
	}
}
