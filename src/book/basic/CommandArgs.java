package book.basic;
/*
 * Java�У������в�����ͨ��main�е�args��������ģ�args��һ���ַ������飬�������������������еĲ���ֵ��
 * System���е�exit�����ر�Java��������˳�Ӧ�ó��򣬵�exit�����Ĳ���Ϊ0ʱ����ʾ���������˳���Ϊ����ֵʱ��ʾ�쳣�˳���
 */
public class CommandArgs {
	/**
	 * ��������ʱ����ӡ������Ϣ�����˳�����
	 * @param errmsg ������Ϣ
	 */
	/*
	 * javac CommandArgs.java
	 * java  CommandArgs -help //��ʾ������Ϣ
	 * java  CommandArgs -n name -v reader
	 * 
	 * args[0]����-n;args[1]����name;
	 *   
	 */
	public static void error(String errmsg) {
		System.err.println(errmsg);
		System.exit(1);
	}
	
	public static void main(String[] args) {
		
		//�������µİ�����Ϣ
		String usageMsg = "Usage: CommandArgs [ options]\n"
				+ "Where [options] are:\n"
				+ " -help         ��ʾ������Ϣ\n"
				+ " -n <name>     ���ò���������\n"
				+ " -v <value>    ���ò�����ֵ\n";
		String name = null;
		String value = null;
		
		//��forѭ����������Ĳ�������
		for (int i = 0; i < args.length; i++) {
			if(args[i].equals("-n")) {
				//����-n����������ӵ���nameֵ
				if((i + 1) ==args.length) {
					error("Error: -n requires an argument.");
				}
				name = args[++i];
			}else if(args[i].equals("-v")) {
				//����-v����������ӵ���valueֵ
				if((i + 1) == args.length) {
					error("Error: -v requires an argument.");
				}
				value = args[++i];
			}else if(args[i].equalsIgnoreCase("-help")) {
				//�����-help�����������������Ϣ�����˳�����
				System.out.println(usageMsg);
				System.exit(0);
			}else {
				//�������������������ʾ�������Ϸ�
				error("Error: argument not recognized:" + args[i]);
			}
		}
		System.out.println("name: " + name + "; " + "value: " + value);
	}
}
