package book.io;

import java.io.File;
import java.util.Date;

/**
 * 获取文件的基本信息
 */
public class GetFileInfos {
	public static void main(String[] args) {
		//用文件路径新建一个文件对象。路径可以是绝对路径也可以是相对路径
		//传入的参数被当做文件的抽象路径
		File file = new File("F:/myfile/readme.txt");//将抽象路径参数封装成File对象。
		System.out.println("获得文件标准化路径：" + file.getPath());
		
		//获取文件名
		System.out.println("文件名：\t" + file.getName());
		//获取文件的绝对路径
		System.out.println("文件绝对路径：\t" + file.getAbsolutePath());
		//获取抽象路径名的父级抽象路径
		System.out.println("文件父级抽象路径： \t" + file.getParent());
		//判断文件是否存在
		System.out.println("文件是否存在：\t" + file.exists());//如果物理设备中没有该文件，则返回false
		System.out.println("文件是否可读:\t" + file.canRead());
		System.out.println("文件是否可写：\t" + file.canWrite());
		System.out.println("文件是否是隐藏文件：\t" + file.isHidden());
		System.out.println("文件是否是普通文件：\t" + file.isFile());
		System.out.println("文件是否是目录： \t" + file.isDirectory());
		System.out.println("文件路径是否是绝对路径：\t" + file.isAbsolute());
		System.out.println("文件路径的URI: \t" + file.toURI());
		System.out.println("文件的最后修改时间：\t" + new Date(file.lastModified()));
		System.out.println("文件大小：\t" + file.length());
		System.out.println("文件名后缀是否为指定类型txt：\t" + file.getName().endsWith("txt"));
		System.out.println("文件的分隔符：\t" + File.separator);
		boolean b = file.toURI().toString().endsWith("myfile");
		System.out.println("判断文件是否以文件分隔符结尾：" + b);
		File file2 = new File("F:/GOOD/BOY/GOOD/GIRL");
		boolean c = file2.mkdirs();//包括创建含必需但不存在的父目录
		System.out.println(c);
		System.out.println(file2.getAbsolutePath());
		System.out.println("是否为目录： " + file2.isDirectory());
		System.out.println("文件大小：" + file.length() + " 个字节");
		
		String str = "a";
		System.out.println(str.getBytes().length);
		
	}
}
