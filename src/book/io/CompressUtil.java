package book.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * 使用ZipOutputStream可以实现文件压缩，所有写入到ZipOutputStream输出流中的数据，都会被Zip格式压缩
 *  
 * 使用ZipOutputStream和ZipInputStream等，会对InputStream或OutputStream进行装饰（体现在创建对象时的传参）
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         CompressUtil
 * 创建时间： 2018年1月18日上午8:53:29
 * 修改人：     Jefy
 * 类描述：
 */
public class CompressUtil {
	/**
	 * 压缩文件或目录
	 * @param baseDirName 压缩的根目录
	 * @param fileName 根目录下待压缩的文件或目录，使用*号，表示压缩根目录下的全部文件
	 * @param targetFileName 目标ZIP文件
	 * @throws IOException 
	 */
	public static void zipFile(String baseDirName,String fileName,String targetFileName) throws IOException {
		//检测根目录是否存在
		if(baseDirName == null) {
			System.out.println("压缩失败，根目录不存在： " + baseDirName);
			return;
		}
		File baseDir = new File(baseDirName);
		if(!baseDir.exists() || (!baseDir.isDirectory())) {
			System.out.println("压缩失败，根目录不存在：" + baseDirName);
			return;
		}
		String baseDirPath = baseDir.getAbsolutePath();
		//目标文件
		File targetFile = new File(targetFileName);
		//创建一个zip输出流来压缩数据并写入zip文件
		try {
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(targetFile));
			if(fileName.equals("*")) {
				//将baseDir目录下的所有文件压缩到ZIP
				CompressUtil.dirToZip(baseDirPath,baseDir,out);
			}else {
				File file = new File(baseDir,fileName);
				if(file.isFile()) {
					CompressUtil.fileToZip(baseDirPath,file,out);
				}else {
					CompressUtil.dirToZip(baseDirPath, file, out);
				}
			}
			out.close();
			System.out.println("压缩文件成功，目标文件名：" + targetFileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("压缩失败：" + e);
			e.printStackTrace();
		}
	}
	/**
	 * 解压缩ZIP文件，将ZIP文件里的内容解压到targetDIR目录下
	 * @param zipFileName
	 * @param targetBaseDirName
	 */
	public static void upzipFile(String zipFileName,String targetBaseDirName) {
		if(!targetBaseDirName.endsWith(File.separator)) {
			targetBaseDirName += File.separator;
		}
		try {
			//根据ZIP文件创建ZipFile对象
			ZipFile zipFile = new ZipFile(zipFileName);
			ZipEntry entry = null;
			String entryName = null;
			String targetFileName = null;
			byte[] buffer = new byte[4096];
			int bytes_read;
			//获取ZIP文件里所有的entry
			Enumeration<?> entrys = zipFile.entries();
			//遍历所有的entry
			while(entrys.hasMoreElements()) {
				entry = (ZipEntry) entrys.nextElement();
				//获得entry的名字
				entry.getName();
				targetFileName = targetBaseDirName + entryName;
				if(entry.isDirectory()) {
					//如果entry是一个目录，则创建目录
					new File(targetFileName).mkdirs();
					continue;
				}else {
					//如果entry是一个文件，则创建父目录
					new File(targetFileName).getParentFile().mkdirs();
				}
				//否则创建文件
				File targetFile = new File(targetFileName);
				System.out.println("创建文件：" + targetFile.getAbsolutePath());
				//打开文件输出流
				FileOutputStream os = new FileOutputStream(targetFile);
				//从ZipFile对象中打开entry的输出流
				InputStream is = zipFile.getInputStream(entry);
				while((bytes_read = is.read(buffer)) != -1) {
					os.write(buffer, 0, bytes_read);
				}
				//关闭流
				os.close();
				is.close();
				zipFile.close();
			}
			System.out.println("解压缩文件成功！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("解压缩文件失败：");
			e.printStackTrace();
		}
	}
	/**
	 * 将文件压缩到ZIP文件中
	 * @param baseDirPathd
	 * @param file
	 * @param out
	 * @throws IOException 
	 */
	public static void fileToZip(String baseDirPath, File file, ZipOutputStream out) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream in = null;
		ZipEntry entry = null;
		
		//创建复制缓冲区
		byte[] buffer = new byte[4096];
		int bytes_read;
		if(file.isFile()) {
			try {
				in = new FileInputStream(file);//创建一个文件输入流
				//构造一个ZipEntry
				entry = new ZipEntry(getEntryName(baseDirPath,file));
				out.putNextEntry(entry);//存储项信息到压缩文件
				//复制字节到压缩文件
				while((bytes_read = in.read(buffer)) != -1) {
					out.write(buffer, 0, bytes_read);
				}
				out.closeEntry();
				in.close();
				System.out.println("添加文件" + file.getAbsolutePath() + "到Zip文件中！");
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	/**
	 * 将目录压缩到ZIP输出流
	 * @param baseDirPath
	 * @param dir
	 * @param out
	 * @throws IOException 
	 */
	public static void dirToZip(String baseDirPath, File dir, ZipOutputStream out) throws IOException {
		// TODO Auto-generated method stub
		if(dir.isDirectory()) {
			//列出dir目录下所有文件
			File[] files = dir.listFiles();
			//如果是空文件
			if(files.length == 0) {
				ZipEntry entry = new ZipEntry(getEntryName(baseDirPath, dir));
				//存储目录信息
				out.putNextEntry(entry);
				out.closeEntry();
				return;
			}
			for (int i = 0; i < files.length; i++) {
				if(files[i].isFile()) {
					//如果是文件，调用fileToZip方法
					CompressUtil.dirToZip(baseDirPath, files[i], out);
				}else {
					//如果是目录，递归调用
					CompressUtil.dirToZip(baseDirPath, files[i], out);
				}
					
			}
		}
		
	}
	public static String getEntryName(String baseDirPath, File file) {
		// TODO Auto-generated method stub
		if(!baseDirPath.endsWith(File.separator)) {
			baseDirPath += File.separator;
		}
		String filePath = file.getAbsolutePath();
		//对于目录，必须在entry名字后面加上"/"，表示它将以目录项存储
		if(file.isDirectory()) {
			filePath += "/";
			
		}
		int index = filePath.indexOf(baseDirPath);
		return filePath.substring(index + baseDirPath.length());
	}
	
	public static void main(String[] args) {
		//压缩
		String baseDirName = "C:";
		String fileName = "";
		String zipFileName = "";
		try {
			CompressUtil.zipFile(baseDirName, fileName, zipFileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//解压缩
		System.out.println();
		fileName = "";
		CompressUtil.upzipFile(zipFileName, fileName);
		
	}
}
