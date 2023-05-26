package member.vo;

import java.util.Date;

public class MemberVO {

	private String mid;
	private String mname;
	private int mage;
	private String mphone;
	private Date mdate;
	
	
	public MemberVO() {
			
		}

	public MemberVO(String mid, String mname, int mage, String mphone, Date mdate) {
	
		this.mid = mid;
		this.mname = mname;
		this.mage = mage;
		this.mphone = mphone;
		this.mdate = mdate;
	}

	public String getMid() {
		return mid;
	}


	public void setMid(String mid) {
		this.mid = mid;
	}


	public String getMname() {
		return mname;
	}


	public void setMname(String mname) {
		this.mname = mname;
	}


	public int getMage() {
		return mage;
	}


	public void setMage(int mage) {
		this.mage = mage;
	}


	public String getMphone() {
		return mphone;
	}


	public void setMphone(String mphone) {
		this.mphone = mphone;
	}


	public Date getMdate() {
		return mdate;
	}


	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}	
	
	
	}
