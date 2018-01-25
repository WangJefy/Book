package book.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * 写文件
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         WriteToFile
 * 创建时间： 2018年1月17日上午10:53:15
 * 修改人：     Jefy
 * 类描述： 用java程序写文件：按字节写、按字符写和按行写
 */
public class WriteToFile {
	/**
	 * 以字节为单位写文件，适合写二进制文件，如图片等
	 * @param fileName 文件名
	 * @throws IOException 
	 */
	public static void writeFileByBytes(String fileName) throws IOException {
		File file = new File(fileName);
		OutputStream out = null;
		
		try {
			//打开文件输出流
			out = new FileOutputStream(file);
			String content = "文件内容:This is a read file";
			byte[] bytes = content.getBytes();//读取输出流中的字节
			
			//写文件
			out.write(bytes);
			System.out.println("写文件" + file.getAbsolutePath() + "成功");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("写文件" + file.getAbsolutePath() + "失败");
		}finally {
			if(out != null) {
				out.close();
			}
		}
		return;
	}
	/**
	 * 以字符为单位写文件
	 * @param fileName 文件名
	 * @throws IOException 
	 */
	public static void writeFileByChars(String fileName) throws IOException {
		File file = new File(fileName);
		Writer writer = null;
		try {
			//打开文件输出流。将文件输出流封装成writer对象
			writer = new OutputStreamWriter(new FileOutputStream(file));
			String content = "文件内容：\n1,The First line;\n2,The second line.";
			writer.write(content);
			System.out.println("写文件" + file.getAbsolutePath() + "成功");
		} catch (FileNotFoundException e) {
			System.out.println("写文件" + file.getAbsolutePath() + "失败");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(writer != null) {
				writer.close();//关闭输出流
			}
		}
		return;
	}
	/**
	 * 以行为单位写文件
	 * @param fileName 文件名
	 */
	public static void writeFileByLines(String fileName) {
		File file = new File(fileName);
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileOutputStream(file));
			writer.println("文件内容"); //写字符串
//			写入各种基本类型
			writer.print(true);
			writer.print(155);
			writer.println();//换行
			writer.flush();//写入文件
			System.out.println("写文件：" + file.getAbsolutePath() + "成功");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("写文件： " + file.getAbsolutePath() + "失败");
		}finally {
			if(writer != null) {
				writer.close();
			}
		}
		return;
	}
	/**
	 * 主函数客户端
	 * @param args 参数数组
	 * @throws IOException 
	 */ 
	public static void main(String[] args) throws IOException {
		String fileName = "C:\\Users\\Jefy\\Desktop\\demo\\test.txt";
		writeFileByBytes(fileName);
		File file = new File(fileName);
		System.out.println(file.length());
	}
}
