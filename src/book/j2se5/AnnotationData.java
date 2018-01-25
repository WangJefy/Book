package book.j2se5;

/**
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         AnnotationData
 * 创建时间： 2018年1月22日下午4:58:40
 * 修改人：     Jefy
 * 类描述：     使用注解
 */
public class AnnotationData {
	@Deprecated 
	private String name;
	public AnnotationData(String name) {
		this.name = name;
	}
	
	//方法声明中使用了内置的@Override元数据，表示该方法覆盖了父类的同名同参数方法
	//如果父类不存在该方法，则编译不通过
	@Override 
	public String toString() {
		return super.toString() + this.name;
	}
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	
	/**
	 * 方法中使用了内置的@Deprecated元数据，表示该方法已经不被推荐使用了
	 * @return
	 */
	@Deprecated
	public String getName() {
		return name;
	}
	public String getAnnotationDataName() {
		return this.name;
	}
	
	
	//下面自定义元数据类型
	//使用@interface声明Annotation类型
	public @interface MyAnnotation{
		//在元数据类中可以定义其他类
		public enum Severity{
			CRITICAL,IMPORTANT,TRIVIAL,DOCUMENTATION
		};
		//定义数据成员不需要定义getter和setter方法,只需定义一个以成员名称命名的方法，并指定返回类型为需要的数据类型
		//default关键字为Annotation类型的成员设置默认值
		Severity severity() default Severity.IMPORTANT;
		String item();
		String assignedTo();
		String dateAssigned();
	}
	
	//使用自定义Annotation类型，在使用时，
	//如果Annotation类型在其他的包下，需要与使用类一样，import它
	@MyAnnotation(severity = MyAnnotation.Severity.CRITICAL,
				  item = "Must finish this method carefully",
				  assignedTo = "Programmer A",
				  dateAssigned = "2006/09/10")
	public void doFuction() {
		
	}
	
}
