package book.basic;
/*
 * Java中，命令行参数是通过main中的args参数传入的，args是一个字符串数组，保存了命令名后面所有的参数值。
 * System类中的exit方法关闭Java虚拟机，退出应用程序，当exit方法的参数为0时，表示程序正常退出，为其他值时表示异常退出。
 */
public class CommandArgs {
	/**
	 * 遇到错误时，打印错误信息，并退出程序
	 * @param errmsg 错误信息
	 */
	/*
	 * javac CommandArgs.java
	 * java  CommandArgs -help //显示帮助信息
	 * java  CommandArgs -n name -v reader
	 * 
	 * args[0]就是-n;args[1]就是name;
	 *   
	 */
	public static void error(String errmsg) {
		System.err.println(errmsg);
		System.exit(1);
	}
	
	public static void main(String[] args) {
		
		//命令行下的帮助信息
		String usageMsg = "Usage: CommandArgs [ options]\n"
				+ "Where [options] are:\n"
				+ " -help         显示帮助信息\n"
				+ " -n <name>     设置参数的名字\n"
				+ " -v <value>    设置参数的值\n";
		String name = null;
		String value = null;
		
		//用for循环遍历输入的参数数组
		for (int i = 0; i < args.length; i++) {
			if(args[i].equals("-n")) {
				//处理-n参数，后面接的是name值
				if((i + 1) ==args.length) {
					error("Error: -n requires an argument.");
				}
				name = args[++i];
			}else if(args[i].equals("-v")) {
				//处理-v参数，后面接的是value值
				if((i + 1) == args.length) {
					error("Error: -v requires an argument.");
				}
				value = args[++i];
			}else if(args[i].equalsIgnoreCase("-help")) {
				//如果是-help参数，则输出帮助信息，并退出程序
				System.out.println(usageMsg);
				System.exit(0);
			}else {
				//如果是其他参数，则提示参数不合法
				error("Error: argument not recognized:" + args[i]);
			}
		}
		System.out.println("name: " + name + "; " + "value: " + value);
	}
}
