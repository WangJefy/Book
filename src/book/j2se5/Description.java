package book.j2se5;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         Description
 * 创建时间： 2018年1月22日下午7:33:43
 * 修改人：     Jefy
 * 类描述：     自定义注解
 */
/*
 * 自定义注解语法要求：
 * 1.使用 @interface 关键字定义注解
 * 2.成员变量以无参无异常方式声明
 * 3.可以用default为成员指定一个默认值
 * 4.成员类型是受限制的，合法的类型包括：基本类型、String、Class、Annotation、Enum以及这些类型对应的数组
 * 5.如果注解只有一个成员，则成员名必须取名为value(),且在使用时可以忽略成员名和赋值号
 * 6.注解可以没有成员，没有成员的注解称为标识注解。如 @Override
 */
/* 主要的元注解(meta-annotation)如下：
 * @Target 是注解的作用域：CONSTRCTOR----构造方法的声明
 * 					  FIELD---------字段声明
 *                    LOCAL_VARIABLE---局部变量声明
 *                    METHOD--------方法声明
 *                    PACKAGE-------包声明
 *                    PARAMETER-----方法参数声明
 *                    TYPE----------类、接口声明
 *                    ANNOTATION_TYPE--标明注解可以用于注解声明(应用于另一个注解上)
 *                    TYPE_PARAMETER--标明注解可以用于类型参数声明（1.8新加入）
 *                    TYPE_USE---类型使用声明（1.8新加入)
 *                    
 *                    ++请注意，当注解未指定Target值时，则此注解可以用于任何元素之上，多个值使用{}包含并用逗号隔开
 *                    Java所有注解都继承了Annotation接口
 * @Retention 该注解的生命周期：SOURCE----只在源码显示，编译时会丢弃
 *                        CLASS-----编译时会记录到class中，运行时忽略.当注解未定义Retention值时，默认值是CLASS
 *                        RUNTIME---运行时存在，可以通过反射读取
 * @Inherited 此注解是标示性的元注解：表示
 * @Documented  被修饰的注解会生成到javadoc中
 */
/*
 * 如何使用自定义的注解
 * 使用注解的语法---  @注解名(成员1 = 成员值,成员2 = 成员值,...)
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
