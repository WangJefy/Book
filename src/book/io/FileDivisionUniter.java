package book.io;

import java.io.File;

/**
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         FileDivisionUniter
 * 创建时间： 2018年1月17日下午2:22:52
 * 修改人：     Jefy
 * 类描述：     文件的分割与合并。
 * 文件分割合并器，将大文件分割成若干个小文件；
 * 将多个小文件合并到一个大文件
 */
public class FileDivisionUniter {
	public static final String SUFFIX = ".pp";//分割后的文件名后缀
	
	public static String[] divide(String fileName,long size) throws Exception {
		File inFile = new File(fileName);
		if(!inFile.exists() || (!inFile.isFile())) {
			throw new Exception("指定文件不存在");
		}
		//>>>未完待续......
		return null;
	}
	
}
