package book.net.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         HttpClient
 * 创建时间： 2018年1月22日上午10:02:04
 * 修改人：     Jefy
 * 类描述：     访问HTTP的客户端，将网页内容显示在控制台，得到一堆HTML代码
 */
public class HttpClient {
	String urlString ;
	public HttpClient(String urlString) {
		this.urlString = urlString;
	}
	
	public void run() throws IOException {
		URL url = new URL(urlString);//生成一个URL对象
		//打开URL
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		//打印头信息
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
		//得到输入流，即获得网页内容
		BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String line;
		System.out.println("------------CONTENT------------");
		//读取输入流数据，并显示
		while((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		reader.close();
		
	}
	
	public static void main(String[] args) {
		//第一个参数为网址
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
