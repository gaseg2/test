package azaz.nong.model;

import java.sql.Timestamp;

public class userDTO {
	
	private int join;
	private int rating;
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String address;
	private String bank_num;
	private String business_sellnum;
	private String business_holder;
	private String business_name;
	private String business_person;
	private String business_num;
	private Timestamp insert_date;
	
	
	
	
	public String getBank_num() {
		return bank_num;
	}
	public void setBank_num(String bank_num) {
		this.bank_num = bank_num;
	}
	public String getBusiness_sellnum() {
		return business_sellnum;
	}
	public void setBusiness_sellnum(String business_sellnum) {
		this.business_sellnum = business_sellnum;
	}
	public String getBusiness_holder() {
		return business_holder;
	}
	public void setBusiness_holder(String business_holder) {
		this.business_holder = business_holder;
	}
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public String getBusiness_person() {
		return business_person;
	}
	public void setBusiness_person(String business_person) {
		this.business_person = business_person;
	}
	public String getBusiness_num() {
		return business_num;
	}
	public void setBusiness_num(String business_num) {
		this.business_num = business_num;
	}
	public int getJoin() {
		return join;
	}
	public void setJoin(int join) {
		this.join = join;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Timestamp getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(Timestamp insert_date) {
		this.insert_date = insert_date;
	}
	
	
	
	
	
}
