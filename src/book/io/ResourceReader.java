package book.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import book.basic.HelloWorld;

/**
 * 从jar包中读资源文件，如配置文件等
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         ResourceReader
 * 创建时间： 2018年1月17日下午5:51:27
 * 修改人：     Jefy
 * 类描述：
 */
public class ResourceReader {
	/**
	 * 第一种方法读jar包中的资源信息，首先读取资源的URL，在读取URL对应的文件信息。
	 * @param class1 类
	 * @param fileName 文件名
	 * @throws IOException 
	 */
	public static void readFromJarA(Class<?> class1,String fileName) throws IOException {
		//使用getResource得到一个URL对象来定位资源
		URL fileURL = class1.getResource(fileName);
		System.out.println("资源的URL:" + fileURL);
		//打开fileURL对应的文件流
		InputStream inputstream = fileURL.openStream();
		BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
		String str;
		while((str = bufferedreader.readLine()) != null) {
			System.out.println(str);
		}
		inputstream.close();
	}
	/**
	 * 第二种方法读jar包中的资源信息
	 * @param class1 类
	 * @param fileName 文件名
 	 */
	public static void readFromJarB(Class<?> class1,String fileName) {
		//getResourceAsStream取得该资源输入流的引用，保证程序可以从正确的位置抽取数据
		InputStream inputStream = class1.getResourceAsStream(fileName);
		if(inputStream != null) {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String str;
			 
			//按行读取流中的数据
			try {
				while((str = bufferedReader.readLine()) != null) {
					System.out.println(str);
				}
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Class<?> class1 = HelloWorld.class;
		//如果文件相对路径前没有"/",则表示相对于该class文件的位置
		String fileName = "config0.conf";
		try {
			ResourceReader.readFromJarA(class1, fileName);
			System.out.println();
			
			fileName = "Resource/config1.conf";
			ResourceReader.readFromJarB(class1, fileName);
			System.out.println();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
