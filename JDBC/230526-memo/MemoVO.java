package memo.vo;

import java.util.Date;

public class MemoVO {
	
	private int mno;
	private String memo;
	private String mid;
	private Date regdate;
	
	public MemoVO() {}
	
	public MemoVO(int mno, String memo, String mid, Date regdate) {
		super();
		this.mno = mno;
		this.memo = memo;
		this.mid = mid;
		this.regdate = regdate;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	

}// class end
