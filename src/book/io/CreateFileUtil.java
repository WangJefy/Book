package book.io;

import java.io.File;
import java.io.IOException;

/**
 * 创建文件和目录
 */
public class CreateFileUtil {
	/**
	 * 创建单个文件
	 * @param destFileName 目标文件名
	 * @return 创建成功，返回true,创建失败，返回false
	 */
	public static boolean createFile(String destFileName) {
		File file = new File(destFileName);//将目标文件封装成File对象
		if(file.exists()) {
			System.out.println("创建单个文件" + destFileName + "失败，目标文件已存在！");
			return false;
		}
		if(destFileName.endsWith(File.separator)) {
			System.out.println("创建单个文件" + destFileName + "失败，目标文件不能为目录！");
			return false;
		}
		//判断目标文件所在的目录是否存在
		if(!file.getParentFile().exists()) {
			//如果目标文件所在的目录不存在，则创建父目录
			System.out.println("目标文件所在目录不存在，准备创建它！");
			if(!file.getParentFile().mkdirs()) {
				System.out.println("创建目标文件所在的目录失败！");
				return false;
			}
		}
		//创建目标文件
		try {
			if(file.createNewFile()) {
				System.out.println("创建单个文件" + destFileName + " 成功！");
				return true;
			}else {
				System.out.println("创建单个文件" + destFileName + "失败！");
				return false;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("创建单个文件" + destFileName + "失败！ " + e.getMessage());
		}
		return false;
	}
	
	/**
	 * 创建目录
	 * @param destDirName 目标目录名
	 * @return 目录创建成功返回true,创建失败返回false
	 */
	public static boolean createDir(String destDirName) {
		File dir = new File(destDirName);//将目录抽象目标路径封装成对象
		if(dir.exists()) {
			System.out.println("创建目录" + destDirName + "失败，目标目录已存在！");
			return false;
		}
		if(!destDirName.endsWith(File.separator)) {
			destDirName = destDirName + File.separator;
		}
		if(dir.mkdirs()) {
			System.out.println("创建目录" + destDirName + "成功！" );
			return true;
		}else {
			System.out.println("创建目录" + destDirName + "失败！" );
			return false;
		}
	}
	/**
	 * 创建临时文件
	 * @param prefix 临时文件名的前瞻
	 * @param suffix 临时文件的后缀
	 * @param dirName 临时文件所在的目录，如果输入null，则在用户的文档目录下创建临时文件
	 * @return 临时文件创建成功返回true,否则返回false
	 */
	public static String createTempFile(String prefix,String suffix,String dirName) {
		File tempFile = null;
		if(dirName == null) {
			
			try {
				//在默认文件夹下创建临时文件
				tempFile = File.createTempFile(prefix, suffix);
				//返回临时文件的路径
				return tempFile.getCanonicalPath();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("创建临时文件失败，不能创建临时文件所在的目录！");
				return null;
			}
		}else {
			File dir = new File(dirName);
			//如果临时文件所在目录不存在，首先创建
			if(!dir.exists()) {
				if(CreateFileUtil.createDir(dirName)) {
					System.out.println("创建临时文件失败，不能创建临时文件所在的目录！");
					return null;
				}
			}
			try {
				//在指定目录下创建临时文件
				tempFile = File.createTempFile(prefix, suffix,dir);
				return tempFile.getCanonicalPath();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("创建临时文件失败！" + e.getMessage());
				return null;
			}
		}
	}
	/**
	 * 主函数
	 * @param args 命令行参数：字符串数组
	 * @throws IOException 声明IO异常
	 */
	public static void main(String[] args) throws IOException {
		//创建目录
		String dirName = "F:/MuLu/";
		CreateFileUtil.createDir(dirName);
		//创建文件
		String fileName = dirName + "aa.txt";
		CreateFileUtil.createFile(fileName);
		//创建临时文件
		String prefix = "temp";
		String suffix = ".txt";
		for(int i = 0; i < 10;i++) {
			System.out.println("创建了临时文件：" + CreateFileUtil.createTempFile(prefix, suffix, dirName));
		}
	}
}
