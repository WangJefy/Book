package book.xml;

/**
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         StudentBean
 * ����ʱ�䣺 2018��1��22������1:23:38
 * �޸��ˣ�     Jefy
 * ��������     ����ѧ����JavaBean
 */
public class StudentBean {
	private String name;
	private String gender;
	private int age;
	private String phone;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("������ ").append(this.name).append(";");
		sb.append("�Ա� ").append(gender).append(";"	);
		sb.append("���䣺 ").append(age).append(";");		
		sb.append("�绰�� ").append(phone);
		return sb.toString();
	}
}
