package book.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

/**
 * 统计文件的字符数
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         StatisFileChars
 * 创建时间： 2018年1月17日下午3:09:19
 * 修改人：     Jefy
 * 类描述：     使用StreamTokenizer来统计文件中的字符数
 */
public class StatisFileChars {
	/**
	 * 使用StreamTokenizer来统计文件中的字符数
	 * @param fileName 文件名
	 * @return 返回字符数
	 * @throws IOException 
	 */
	public static long statis(String fileName) throws IOException {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(fileName);
			//创建分析给定字符流的标记生成器
			StreamTokenizer st = new StreamTokenizer(new BufferedReader(fileReader));
			
			//ordinaryChar方法指定字符参数在此标记生成器中是"普通"字符
			//下面指定单引号、双引号和注释符号是普通字符
			st.ordinaryChar('\'');
			st.ordinaryChar('\"');
			st.ordinaryChar('/');
			
//			String s;
//			int numberSum = 0;
//			int wordSum = 0;
//			int symbolSum = 0;
//			int total = 0;
			
			//nextToken方法读取下一个Token
			//TT_EOL指示已读到流末尾的常量
			while(st.nextToken() != StreamTokenizer.TT_EOF) {
				//>>>未完待续......
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
