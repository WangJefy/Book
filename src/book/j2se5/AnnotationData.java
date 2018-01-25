package book.j2se5;

/**
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         AnnotationData
 * ����ʱ�䣺 2018��1��22������4:58:40
 * �޸��ˣ�     Jefy
 * ��������     ʹ��ע��
 */
public class AnnotationData {
	@Deprecated 
	private String name;
	public AnnotationData(String name) {
		this.name = name;
	}
	
	//����������ʹ�������õ�@OverrideԪ���ݣ���ʾ�÷��������˸����ͬ��ͬ��������
	//������಻���ڸ÷���������벻ͨ��
	@Override 
	public String toString() {
		return super.toString() + this.name;
	}
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	
	/**
	 * ������ʹ�������õ�@DeprecatedԪ���ݣ���ʾ�÷����Ѿ������Ƽ�ʹ����
	 * @return
	 */
	@Deprecated
	public String getName() {
		return name;
	}
	public String getAnnotationDataName() {
		return this.name;
	}
	
	
	//�����Զ���Ԫ��������
	//ʹ��@interface����Annotation����
	public @interface MyAnnotation{
		//��Ԫ�������п��Զ���������
		public enum Severity{
			CRITICAL,IMPORTANT,TRIVIAL,DOCUMENTATION
		};
		//�������ݳ�Ա����Ҫ����getter��setter����,ֻ�趨��һ���Գ�Ա���������ķ�������ָ����������Ϊ��Ҫ����������
		//default�ؼ���ΪAnnotation���͵ĳ�Ա����Ĭ��ֵ
		Severity severity() default Severity.IMPORTANT;
		String item();
		String assignedTo();
		String dateAssigned();
	}
	
	//ʹ���Զ���Annotation���ͣ���ʹ��ʱ��
	//���Annotation�����������İ��£���Ҫ��ʹ����һ����import��
	@MyAnnotation(severity = MyAnnotation.Severity.CRITICAL,
				  item = "Must finish this method carefully",
				  assignedTo = "Programmer A",
				  dateAssigned = "2006/09/10")
	public void doFuction() {
		
	}
	
}
