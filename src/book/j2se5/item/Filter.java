package book.j2se5.item;
/**
 * 
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         Filter
 * 创建时间： 2018年1月22日下午10:22:30
 * 修改人：     Jefy
 * 类描述：
 */
@Table("user")
public class Filter {
	@Column("id")
	private int id;
	@Column("user_name")
	private String userName;
	@Column("nick_name")
	private String nickName;
	@Column("age")
	private int age;
	@Column("city")
	private String city;
	
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
