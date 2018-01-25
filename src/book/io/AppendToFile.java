package book.io;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 向文件尾部追加内容
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         AppendToFile
 * 创建时间： 2018年1月17日下午1:18:19
 * 修改人：     Jefy
 * 类描述：
 */
public class AppendToFile {
	/**
	 * A方法追加文件：使用RandomAccessFile
	 * @param fileName 文件名
	 * @param content 追加的内容
	 * @throws IOException 
	 */
	public static void appendMethodA(String fileName,String content) throws IOException {
		try {
			RandomAccessFile randomFile = new RandomAccessFile(fileName,"rw");
			long fileLength = randomFile.length();//文件长度：字节数
			randomFile.seek(fileLength);
			randomFile.writeBytes(content);
			randomFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
	/**
	 * B方法追加文件，使用FileWriter
	 * @param fileName 文件名
	 * @param content 追加内容
	 */
	public static void appendMethodB(String fileName,String content) {
		try {
			FileWriter writer = new FileWriter(fileName,true);
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 客户端主函数
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String fileName = "C:\\Users\\Jefy\\Desktop\\demo\\test.txt";
		String content = "new append!";
		//按A方法追加文件
		AppendToFile.appendMethodA(fileName, content);
		AppendToFile.appendMethodA(fileName, "append end. \n");
		ReadFromFile.readFileByLines(fileName);//显示文件内容
		
		//按B方法追加文件
		AppendToFile.appendMethodB(fileName, content);
		AppendToFile.appendMethodB(fileName, "append end. \n");
		ReadFromFile.readFileByLines(fileName);//读取文件内容
		
	}
}
