package book.xml;

/**
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         StudentBean
 * 创建时间： 2018年1月22日下午1:23:38
 * 修改人：     Jefy
 * 类描述：     描述学生的JavaBean
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
		sb.append("姓名： ").append(this.name).append(";");
		sb.append("性别： ").append(gender).append(";"	);
		sb.append("年龄： ").append(age).append(";");		
		sb.append("电话： ").append(phone);
		return sb.toString();
	}
}
