package book.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* 泛型用在编译期，编译过后泛型擦除（消失掉）。所以是可以通过反射越过泛型检查的
 * 通过反射越过泛型检查
 * 例如：有一个String泛型集合，怎么能向这个集合中添加一个Integer类型的值？
 */
public class Demo {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		ArrayList<String> strList = new ArrayList<>();
		strList.add("aaa");
		strList.add("bbb");
		
		//获取ArrayList的Class对象，反向调用add方法，添加数据
		Class<?> listClass = strList.getClass();
		//获取add()方法
		Method m = listClass.getMethod("add", Object.class);
		//调用add()方法
		m.invoke(strList, 100);
		
		//遍历集合
		for (Object obj : strList) {
			System.out.println(obj);
		}
	}
}
