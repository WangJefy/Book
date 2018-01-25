package book.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;

/**
 * 读文件:将文件读入到内存（将文件系统中文件和目录的抽象路径封装成File类，并将该File类抽象为文件输入流FileInputStream,
 * 文件输入流FileInputStream对象是输入流InputStream抽象类的一个子类。将字节输入流InputStream读入内存，可以有四种方式：
 * 按字节读取文件内容，按字符读取文件内容，按行读取文件内容，随机读取文件内容）
 * @author Jefy
 *
 */
public class ReadFromFile {
	/**
	 * 以字节为单位读文件，常用于读二进制文件，如图片、声音、影像等文件
	 * 
	 * @param fileName 文件名
	 * @throws IOException 
	 */
	public static void readFileByBytes(String fileName) throws IOException {
		File file = new File(fileName);//封装成文件类
		InputStream in = null;
		//一次读一个字节
		try {
			System.out.println("以字节为单位读取文件内容，一次读一个字节：");
			in = new FileInputStream(file);//打开文件输入流(发生了向上转型)
			int tempbyte;
			/**
			 * 将读取的数据使用int接受，值就变成了0-255;如果没有可读数据，则返回-1；
			 * 不断地读取，直到文件结束
			 * read方法在输入数据可用、检测到流末尾或者抛出异常前，会一直阻塞。
			 * 即 程序一直停在read()方法这里，等待数据。没有数据就不继续往下执行，直到得到数据。程序会一直等待，直到有输入数据，才开始读。
			 * tempbyte = in.read()执行顺序是，先执行in.read(),即先读取数据，读完之后返回下一字节数据的字节值，并将该值赋值给tempbyte
			 */
			while((tempbyte = in.read()) != -1) {
				System.out.write(tempbyte);
			}
			in.close();//关闭文件输入流
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		try {
			
			System.out.println("以字节为单位读取文件，一次读多个字节");
			//一次读取多个字节
			byte[] tempbytes = new byte[100]; //作为字节缓冲区；字节数组
			int byteread = 0;
			in = new FileInputStream(fileName);
			ReadFromFile.showAvailableBytes(in);
			//读入多个字节到字节数组中，byteread为一次读入的字节数
			while((byteread = in.read(tempbytes)) != -1) {
				System.out.write(tempbytes,0,byteread);
			}
		}catch(Exception e1) {
			e1.printStackTrace();
			
		}finally {
			if(in != null) {
				in.close();
			}
		}
	}
	/**
	 * 以字节为单位读取文件，常用于读文本、数字等类型的文件
	 * @param fileName 文件名
	 */
	public static void readFileByChars(String fileName) {
		File file = new File(fileName);
		Reader reader = null;//Reader是字符输入流抽象类
		 try {
			 System.out.println("以字符为单位读取文件内容，一次读取一个字符");
			 //一次读取一个字符
			 reader = new InputStreamReader(new FileInputStream(file));
			 int tempchar;
			 while((tempchar = reader.read()) != -1) {
				 //在windows下，\r\n这两个字符在一起时，表示一个换行
				 //但如果这两个字符分开显示时，会换两次行
				 // 因此，屏蔽掉\r，或者屏蔽掉\n，否则会多出很多空行
				 if(((char)tempchar) != '\r') {
					 System.out.print((char)tempchar);
				 }
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			 System.out.println("以字符为单位读取文件内容，一次读取多个字符");
			 //一次读取多个字符
			 char[] tempchars = new char[30];
			 int charread = 0;
			 reader = new InputStreamReader(new FileInputStream(fileName));
			 //读入多个字符到字符数组中，charread为一次读取字符数
			while((charread = reader.read(tempchars)) != -1) {
				 //同样屏蔽掉\r不显示
				if((charread == tempchars.length) && (tempchars[tempchars.length - 1] != '\r')) {
					System.out.println(tempchars);
				}else {
					for (int i = 0; i < charread; i++) {
						if(tempchars[i] == '\r') {
							continue;
						}else {
							System.out.print(tempchars[i]);
						}
					}
				}
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		 
	}
	/**
	 * 以行为单位读取文件，常用于读取面向行的格式化文件
	 * @param fileName 文件名
	 * @throws IOException 
	 */
	public static void readFileByLines(String fileName) throws IOException {
		File file = new File(fileName);
		BufferedReader reader =  null;
		
		System.out.println("以行为单位读取文件内容，一次读取一行");
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			//一次读入一行，直到读入null为文件结束
			while((tempString = reader.readLine()) != null) {
				//显示行号
				System.out.println("Line " + line + ":" + tempString);
				line++;
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(reader != null) {
				reader.close();
			}
		}
	}
	/**
	 * 随机读取文件内容
	 * @param fileName 文件名
	 * @throws IOException 
	 */
	public static void readFileByRandomAccess(String fileName) throws IOException {
		RandomAccessFile randomFile = null;
		System.out.println("随机读取一段文件内容：");
		//打开一个随机访问文件流，按只读方式
		try {
			randomFile = new RandomAccessFile(fileName,"r");
			long fileLength = randomFile.length();
			int beginIndex = (fileLength > 4) ? 4 : 0;
			//将读文件的开始位置移动到beginIndex位置
			randomFile.seek(beginIndex);
			byte[] bytes = new byte[10];
			int byteread = 0;
			//一次读取10个字节，如果文件内容不足10个字节，则读剩下的字节
			//将一次读取的字节数赋值给byteread
			while((byteread = randomFile.read(bytes)) != -1) {
				System.out.write(bytes,0,byteread);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 显示输入流中还剩的字节数
	 * @param in 输入流对象
	 */
	public static void showAvailableBytes(InputStream in) {
		// TODO Auto-generated method stub
		try {
			System.out.println("当前字节输入流中的字节数为：" + in.available());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 主函数：程序入口
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String fileName = "C:/temp/newTemp.txt";
		ReadFromFile.readFileByBytes(fileName);
		ReadFromFile.readFileByChars(fileName);
		ReadFromFile.readFileByLines(fileName);
		ReadFromFile.readFileByRandomAccess(fileName);
	}
}
