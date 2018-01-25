package book.j2se5.item;

public class Test {
	public static void main(String[] args) {
		Filter f1 = new Filter();
		f1.setId(10);//查询id为10的用户
		
		Filter f2 = new Filter();
		f2.setUserName("lucy");//查询用户名为lucy的用户
		
		Filter f3 = new Filter();
		f3.setEmail("2581133711@qq.com");
		
		String sql1 = query(f1);
		String sql2 = query(f2);
		String sql3 = query(f3);
		
		System.out.println(sql1);
		System.out.println(sql2);
		System.out.println(sql3);
	}

	private static String query(Filter f1) {
		// TODO Auto-generated method stub
		return null;
	}
}
