package book.string;

/**
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         StringAlign
 * 创建时间： 2018年1月25日上午10:22:45
 * 修改人：     Jefy
 * 类描述：     字符串对齐器：可以指定字符串在显示时的对齐格式，有左对齐、居中、右对齐三种格式，并且能够指定一行最多显示的字符数
 */
public class StringAlign {
	public static final int JUST_LEFT = 0;
	public static final int JUST_CENTER = 1;
	public static final int JUST_RIGHT = 2;
	private int just;//当前对齐格式
	private int maxChars;//一行的最大长度
	
	public StringAlign() {
		//默认居中对齐，一行的最大长度为80
		this.just = JUST_CENTER;
		this.maxChars = 80;
	}
	 
	public StringAlign(int maxChars,int just) {
		this();
		//根据传入的参数修改字符串对齐器的属性
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

