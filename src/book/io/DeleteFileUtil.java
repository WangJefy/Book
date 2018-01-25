package book.io;

import java.io.File;

/**
 * 删除文件和目录
 */
public class DeleteFileUtil {
	/**
	 * 删除文件，可以是单个文件或文件夹
	 * @param fileName  待删除的文件
	 * @return 文件删除成功则返回true,删除失败则返回false
	 */
	public static boolean delete(String fileName) {
		File file = new File(fileName);//封装
		if(!file.exists()) {
			System.out.println("删除文件失败：" + fileName + "文件不存在");
			return false;
		}else {
			if(file.isFile()) {
				return DeleteFileUtil.deleteFile(fileName);
			}else {
				return DeleteFileUtil.deleteDirectory(fileName);
			}
		}
	}
	/**
	 * 删除单个文件
	 * @param fileName 被删除文件的文件名
	 * @return 单个文件删除成功，则返回true，否则反回false
	 */
	private static boolean deleteFile(String fileName) {
		// TODO Auto-generated method stub
		File file = new File(fileName);//封装
		//如果文件路径对应的文件存在，并且是一个文件，则直接删除
		if(file.exists() && file.isFile()) {
			if(file.delete()) {
				System.out.println("删除单个文件" + fileName + "成功！ ");
				return true;
			}else {
				System.out.println("删除单个文件" + fileName + "失败");
				return false;
			}
		}else {
			System.out.println("删除单个文件失败：" + fileName + "文件不存在");
			return false;
		}
	}
	/**
	 * 删除目录(文件夹)以及目录下的文件
	 * @param dir 被删除目录的文件路径
	 * @return 目录删除成功则返回true,否则返回false;
	 */
	private static boolean deleteDirectory(String dir) {
		// TODO Auto-generated method stub
		//如果dir不以文件分隔符结尾，自动添加文件分隔符
		if(!dir.endsWith(File.separator)) {
			dir = dir + File.separator;
		}
		File dirFile = new File(dir);
		//如果dir对应的文件不存在，或者不是一个目录，则退出
		if(!dirFile.exists() || (!dirFile.isDirectory())) {
			System.out.println("删除目录失败：" + dir + "目录不存在！");
			return false;
		}
		boolean flag = true;
		//删除文件夹下的所有文件（包括子目录）
		File[] files = dirFile.listFiles();
		for(int i = 0;i < files.length; i++) {
			//删除子文件
			if(files[i].isFile()) {
				flag = DeleteFileUtil.deleteFile(files[i].getAbsolutePath());
				if(!flag) {
					break;
				}
			}
			//删除子目录
			else if(files[i].isDirectory()) {
				flag = DeleteFileUtil.deleteDirectory(files[i].getAbsolutePath());
				if(!flag) {
					break;
				}
			}
		}
		if(!flag) {
			System.out.println("删除目录失败");
			return false;
		}
		//删除当前目录
		if(dirFile.delete()) {
			System.out.println("删除目录：" + dir + "成功！");
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 主函数
	 * @param args
	 */
	public static void main(String[] args) {
		//删除单个文件
		String file = "F:\\GOOD\\BOY\\GOOD\\aaa.txt";
		DeleteFileUtil.deleteFile(file);
		System.out.println();
		
		//删除一个目录
		String dir = "F:\\GOOD\\BOY\\GOOD";
		DeleteFileUtil.deleteDirectory(dir);
		System.out.println();
		
		//删除文件
		dir = "F:\\GOOD";
		DeleteFileUtil.delete(dir);
	}
}
