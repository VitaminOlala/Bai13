package entity;

import java.io.Serializable;

public class Fresher extends Employee {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getGraduation_date() {
		return graduation_date;
	}
	public void setGraduation_date(String graduation_date) {
		this.graduation_date = graduation_date;
	}
	public String getGraduation_rank() {
		return graduation_rank;
	}
	public void setGraduation_rank(String graduation_rank) {
		this.graduation_rank = graduation_rank;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	private String graduation_date;
	private String graduation_rank;
	private String education;
	
	

	
	public Fresher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fresher(int id, String fullname, String birthday, String phone, String email, String graduation_date,
			String graduation_rank, String education) {
		super(id, fullname, birthday, phone, email);
		this.graduation_date = graduation_date;
		this.graduation_rank = graduation_rank;
		this.education = education;
	}
	@Override
	public
	void ShowInfo() {
		// TODO Auto-generated method stub
		System.out.println("Id: "+getId());
		System.out.println("Fullname: "+getFullname());
		System.out.println("Birthday: "+getBirthday());
		System.out.println("Phone: "+getPhone());
		System.out.println("email: "+getEmail());
		System.out.println("Employee type: "+getEmployee_type());
		System.out.println("Employee count: "+getEmployee_count());  //static
		System.out.println("Thoi gian tot nghiep: "+graduation_date);
		System.out.println("Xep loai tot nghiep: "+graduation_rank);
		System.out.println("Truong tot nghiep: "+education);
	}
	@Override
	public String toString() {
		return "Fresher [graduation_date=" + graduation_date + ", graduation_rank=" + graduation_rank + ", education="
				+ education + ", getId()=" + getId() + ", getFullname()=" + getFullname() + ", getBirthday()="
				+ getBirthday() + ", getPhone()=" + getPhone() + ", getEmail()=" + getEmail() + ", getEmployee_type()="
				+ getEmployee_type() + "]";
	}
	

}
