package book.oo;
/*
 * 复数类
 */
public class ComplexNumber {
	private double realPart;//定义复数的实部
	public double getRealPart() {
		return realPart;
	}

	public void setRealPart(double realPart) {
		this.realPart = realPart;
	}

	public double getImaginaryPart() {
		return imaginaryPart;
	}

	public void setImaginaryPart(double imaginaryPart) {
		this.imaginaryPart = imaginaryPart;
	}

	private double imaginaryPart;//定义复数的虚部
	
	public ComplexNumber() {
		this.realPart = 0.0;
		this.imaginaryPart = 0.0;
	}
	
	/**
	 * 构造函数
	 * @param a 实部
	 * @param b 虚部
	 */
	public ComplexNumber(double a,double b) {
		this.realPart = a;
		this.imaginaryPart = b;
	}
	
	/**
	 * 复数的加减运算
	 * c = a + b运算法则是：
	 * c.实部  = a.实部 + b.实部； c.虚部 = a.虚部 + b.虚部；
	 * @param aComNum 加数
	 * @return 加法运算的结果，为一个复数对象
	 */
	public ComplexNumber add(ComplexNumber aComNum) {
		if(aComNum == null) {
			System.err.println("对象不能为null！  ");
			return new ComplexNumber();
		}
		return new ComplexNumber(this.realPart + aComNum.getRealPart() , 
				this.imaginaryPart + aComNum.getImaginaryPart());
	}
	/**
	 * 复数的减法运算
	 * @param aComNum 减数
	 * @return 减法运算结果是一个复数对象
	 */
	
	/**
	 * 
	 */
}
