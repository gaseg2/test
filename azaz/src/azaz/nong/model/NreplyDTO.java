package azaz.nong.model;

import java.sql.Timestamp;

public class NreplyDTO {

	private int num;
	private int re_no;
	private String rcontent;
	private String id;
	private Timestamp reg;
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getRe_no() {
		return re_no;
	}
	public void setRe_no(int re_no) {
		this.re_no = re_no;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Timestamp getReg() {
		return reg;
	}
	public void setReg(Timestamp reg) {
		this.reg = reg;
	}
	
	@Override
	public String toString() {
		return "ReplyVO [num=" + num + ", re_no=" + re_no + ", rcontent=" + rcontent + ", id=" + id + ", reg="
				+ reg + "]";
	}
}














