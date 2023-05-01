package override;

// 자바빈즈(beans) 클래스
public class PersonVO {
	private String name;
	private int age;
	private String tel;
	
	public PersonVO() {
		super();
	}
	
	@Override
	public String toString() {
		return "Person [ name = " + name + ",age = " + age + ",tel = "+ tel +"]";
	}

	public PersonVO(String name, int age, String tel) {
		super();
		this.name = name;
		this.age = age;
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
