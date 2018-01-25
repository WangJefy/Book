package book.string;

/**
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         StringAlign
 * ����ʱ�䣺 2018��1��25������10:22:45
 * �޸��ˣ�     Jefy
 * ��������     �ַ���������������ָ���ַ�������ʾʱ�Ķ����ʽ��������롢���С��Ҷ������ָ�ʽ�������ܹ�ָ��һ�������ʾ���ַ���
 */
public class StringAlign {
	public static final int JUST_LEFT = 0;
	public static final int JUST_CENTER = 1;
	public static final int JUST_RIGHT = 2;
	private int just;//��ǰ�����ʽ
	private int maxChars;//һ�е���󳤶�
	
	public StringAlign() {
		//Ĭ�Ͼ��ж��룬һ�е���󳤶�Ϊ80
		this.just = JUST_CENTER;
		this.maxChars = 80;
	}
	 
	public StringAlign(int maxChars,int just) {
		this();
		//���ݴ���Ĳ����޸��ַ���������������
		this.setJust(just);
		this.setMaxChars(maxChars);
	}

	public int getJust() {
		return just;
	}

	public void setJust(int just) {
		this.just = just;
	}

	public int getMaxChars() {
		return maxChars;
	}

	public void setMaxChars(int maxChars) {
		this.maxChars = maxChars;
	}
	
	
	
	
	
}

