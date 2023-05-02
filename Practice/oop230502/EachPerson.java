package oop20230502;

public class EachPerson {

	private String name;
	private String phonenum;
	private String birth;
	
	public EachPerson() {
		super();
	}

	public EachPerson(String name, String phonenum, String birth) {
		super();
		this.name = name;
		this.phonenum = phonenum;
		this.birth = birth;
	}

	public EachPerson(String name, String phonenum) {
		super();
		this.name = name;
		this.phonenum = phonenum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}
    
	
	
	
}
