package book.reflect;

import java.lang.reflect.Method;

/**
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         ViewClassInfoFrame
 * 创建时间： 2018年1月21日上午8:10:59
 * 修改人：     Jefy
 * 类描述：     查看类的信息
 */
public class ViewClassInfoFrame {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		try {
			Class<?>  a = Class.forName("book.reflect.InstanceOf");
			Method[] methods = a.getMethods();
			for (int i = 0; i < methods.length; i++) {
				System.out.println(methods[i]);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
