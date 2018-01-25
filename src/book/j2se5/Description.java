package book.j2se5;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         Description
 * ����ʱ�䣺 2018��1��22������7:33:43
 * �޸��ˣ�     Jefy
 * ��������     �Զ���ע��
 */
/*
 * �Զ���ע���﷨Ҫ��
 * 1.ʹ�� @interface �ؼ��ֶ���ע��
 * 2.��Ա�������޲����쳣��ʽ����
 * 3.������defaultΪ��Աָ��һ��Ĭ��ֵ
 * 4.��Ա�����������Ƶģ��Ϸ������Ͱ������������͡�String��Class��Annotation��Enum�Լ���Щ���Ͷ�Ӧ������
 * 5.���ע��ֻ��һ����Ա�����Ա������ȡ��Ϊvalue(),����ʹ��ʱ���Ժ��Գ�Ա���͸�ֵ��
 * 6.ע�����û�г�Ա��û�г�Ա��ע���Ϊ��ʶע�⡣�� @Override
 */
/* ��Ҫ��Ԫע��(meta-annotation)���£�
 * @Target ��ע���������CONSTRCTOR----���췽��������
 * 					  FIELD---------�ֶ�����
 *                    LOCAL_VARIABLE---�ֲ���������
 *                    METHOD--------��������
 *                    PACKAGE-------������
 *                    PARAMETER-----������������
 *                    TYPE----------�ࡢ�ӿ�����
 *                    ANNOTATION_TYPE--����ע���������ע������(Ӧ������һ��ע����)
 *                    TYPE_PARAMETER--����ע������������Ͳ���������1.8�¼��룩
 *                    TYPE_USE---����ʹ��������1.8�¼���)
 *                    
 *                    ++��ע�⣬��ע��δָ��Targetֵʱ�����ע����������κ�Ԫ��֮�ϣ����ֵʹ��{}�������ö��Ÿ���
 *                    Java����ע�ⶼ�̳���Annotation�ӿ�
 * @Retention ��ע����������ڣ�SOURCE----ֻ��Դ����ʾ������ʱ�ᶪ��
 *                        CLASS-----����ʱ���¼��class�У�����ʱ����.��ע��δ����Retentionֵʱ��Ĭ��ֵ��CLASS
 *                        RUNTIME---����ʱ���ڣ�����ͨ�������ȡ
 * @Inherited ��ע���Ǳ�ʾ�Ե�Ԫע�⣺��ʾ
 * @Documented  �����ε�ע������ɵ�javadoc��
 */
/*
 * ���ʹ���Զ����ע��
 * ʹ��ע����﷨---  @ע����(��Ա1 = ��Աֵ,��Ա2 = ��Աֵ,...)
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description{
	String desc();
	String author();
	int age() default 18;
}
