package book.string;
/**
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         IDCard
 * 创建时间： 2018年1月24日下午5:21:19
 * 修改人：     Jefy
 * 类描述：     18位身份证的验证
 */
public class IDCard {
	private static final int[] weight = new int[] {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1};
	private static final int[] checkDigit = new int[] { 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2};
	
	public boolean verify(String idcard) {
		if(idcard.length() == 15) {
			idcard = this.update2eighteen(idcard);
		}
		if(idcard.length() != 18) {
			return false;
		}
		String checkDigit = idcard.substring(17, 18);
		if(checkDigit.equals(this.getCheckDigit(idcard))) {
			return true;
		}
		return false;
	}

	private Object getCheckDigit(String eighteenCardID) {
		// TODO Auto-generated method stub
		int remaining = 0;
		if(eighteenCardID.length() == 18) {
			eighteenCardID = eighteenCardID.substring(0, 17);
		}
		if(eighteenCardID.length() == 17) {
			int sum = 0;
			int[] a = new int[17];
			//先对前17位数字的权求和
			for(int i = 0; i < 17;i++) {
				String k = eighteenCardID.substring(i,i+1);
				a[i] = Integer.parseInt(k);
			}
			for(int i = 0; i < 17; i++) {
				sum = sum + weight[i] * a[i];
			}
			remaining = sum % 11;
		}
		return remaining == 2 ? "X" : String.valueOf(checkDigit[remaining]);
	}

	private String update2eighteen(String fifteenCardID) {
		// TODO Auto-generated method stub
		String eighteenCardID = fifteenCardID.substring(0, 6) + "19";
		eighteenCardID += fifteenCardID.substring(6, 15);
		eighteenCardID += this.getCheckDigit(eighteenCardID);
		return eighteenCardID;
	}
	public static void main(String[] args) {
		IDCard test = new IDCard();
		
		String idCardStr = "41092819920303241X";
		System.out.println("身份证" + idCardStr + "\n验证是否合法？   " + test.verify(idCardStr));
	}
}
