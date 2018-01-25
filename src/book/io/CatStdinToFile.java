package book.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * 从键盘接受数据并输出到文件
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         CatStdinToFile
 * 创建时间： 2018年1月17日下午2:30:41
 * 修改人：     Jefy
 * 类描述：     从标准输入流中读取数据，并存储到文件中
 */
public class CatStdinToFile {
	/**
	 * 从标准输入流中读取数据
	 * @param fileName 文件名
	 * @return 文件写成功，则返回true;否则返回false;
	 */
	public static boolean catStdinToFile(String fileName) {
		File file = new File(fileName);
		//将数据按照文本输出到 文件
		PrintWriter writer = null;
		BufferedReader in = null;
		try {
			writer = new PrintWriter(new FileWriter(file));
			System.out.println("请输入文件内容，输入quit结束");
			//用BufferedReader封装标准输入流
			in = new BufferedReader(new InputStreamReader(System.in));
			String inputLine = null;
			while(((inputLine = in.readLine()) != null) && (!inputLine.equals("quit"))) {
				writer.println(inputLine);
			}
			
			//如果采用new PrintWriter(new FileWriter(file),true)则会自动flush
			writer.flush();
			writer.close();
			return true;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String fileName = "C:\\Users\\Jefy\\Desktop\\demo\\test1.txt";
		CatStdinToFile.catStdinToFile(fileName);
		
		System.out.println();
		System.out.println("输出文件的内容");
		ReadFromFile.readFileByLines(fileName);
	}
}
