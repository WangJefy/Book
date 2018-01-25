package book.oo;
/*
 * ������
 */
public class ComplexNumber {
	private double realPart;//���帴����ʵ��
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

	private double imaginaryPart;//���帴�����鲿
	
	public ComplexNumber() {
		this.realPart = 0.0;
		this.imaginaryPart = 0.0;
	}
	
	/**
	 * ���캯��
	 * @param a ʵ��
	 * @param b �鲿
	 */
	public ComplexNumber(double a,double b) {
		this.realPart = a;
		this.imaginaryPart = b;
	}
	
	/**
	 * �����ļӼ�����
	 * c = a + b���㷨���ǣ�
	 * c.ʵ��  = a.ʵ�� + b.ʵ���� c.�鲿 = a.�鲿 + b.�鲿��
	 * @param aComNum ����
	 * @return �ӷ�����Ľ����Ϊһ����������
	 */
	public ComplexNumber add(ComplexNumber aComNum) {
		if(aComNum == null) {
			System.err.println("������Ϊnull��  ");
			return new ComplexNumber();
		}
		return new ComplexNumber(this.realPart + aComNum.getRealPart() , 
				this.imaginaryPart + aComNum.getImaginaryPart());
	}
	/**
	 * �����ļ�������
	 * @param aComNum ����
	 * @return ������������һ����������
	 */
	
	/**
	 * 
	 */
}
