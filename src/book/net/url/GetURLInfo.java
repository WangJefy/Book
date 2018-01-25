package book.net.url;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         GetURLInfo
 * 创建时间： 2018年1月21日下午9:14:50
 * 修改人：     Jefy
 * 类描述：     通过URL能够得到的信息
 */
public class GetURLInfo {
	/**
	 * 输出一个URL相关信息，主要使用URLConnection类
	 * @param url
	 * @throws IOException 
	 */
	public static void printInfo(URL url) throws IOException {
		//URL基本信息
		System.out.println(" File:" + url.getFile());//public String getFile(); return the file name of this URL  
		System.out.println(" Protocol:" + url.getProtocol());//public String getProtocol(); return the protocol of this URL
		System.out.println(" Host:" + url.getHost());//public String getHost(); return the host name of this URL
		System.out.println(" Port:" + url.getPort());//public int getPort(); return the port number or -1 if the port is not set
		
		//获取URLConnection对象。要注意
		URLConnection c = url.openConnection();
		//连接到URL,如果不能连接URL，则会出现超时信息
		System.out.println(" c 的信息：" + c.toString()); 
		c.connect();
		//显示信息
		System.out.println(" Content Type:" + c.getContentType());//public String getContentType(); return the content type of the resource that the URL references
		
		//如果是HTTP连接。其中HttpURLConnection是URLConnection的子类.
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
