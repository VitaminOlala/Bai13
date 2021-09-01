package entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;



public abstract class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private int id;
	private String fullname;
	private String birthday;
	private String phone;
	private String email;
	private String employee_type;
	static int employee_count = 0;
	
	
	public Employee(int id, String fullname, String birthday, String phone, String email) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;

	}

	public static int getEmployee_count() {
		return employee_count;
	}

	public static void setEmployee_count(int employee_count) {
		Employee.employee_count = employee_count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



//	public static int getEmployee_count() {
//		return employee_count ;
//	}


	public String getEmployee_type() {
		return employee_type;
	}

	public void setEmployee_type(String employee_type) {
		this.employee_type = employee_type;
	}

	public Employee() {
		super();
//		employee_count++;
//		System.out.println("hellloo");
		
	}
	
	public void forIntern(Employee it, String name1, String ngaysinh, String dt, String email, String nganh, int ki, String tentruong) {	
		if(it instanceof Intern) {
			((Intern) it).setFullname(name1);;
			((Intern) it).setBirthday(ngaysinh);;
			((Intern) it).setPhone(dt);;
			((Intern) it).setEmail(email);;
			((Intern) it).setMajors(nganh);
			((Intern) it).setSemester(ki);;
			((Intern) it).setUniversity_name(tentruong);;
		}
	}
	public void forExp(Employee it, String name1, String ngaysinh, String dt, String email, int ki, String proskill) {	
		if(it instanceof Experience) {
			((Experience) it).setFullname(name1);;
			((Experience) it).setBirthday(ngaysinh);;
			((Experience) it).setPhone(dt);;
			((Experience) it).setEmail(email);;
			((Experience) it).setExplnYear(ki);;
			((Experience) it).setProSkill(proskill);;;
		}
	}
	public void forFresher(Employee it, String name1, String ngaysinh, String dt, String email, String ngaytn, String rank, String edu) {	
		if(it instanceof Fresher) {
			((Fresher) it).setFullname(name1);;
			((Fresher) it).setBirthday(ngaysinh);;
			((Fresher) it).setPhone(dt);;
			((Fresher) it).setEmail(email);;
			((Fresher) it).setGraduation_date(ngaytn);;
			((Fresher) it).setGraduation_rank(rank);;;
			((Fresher) it).setEducation(edu);;;
		}
	}
	List<Certificate> listCer;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fullname=" + fullname + ", birthday=" + birthday + ", phone=" + phone
				+ ", email=" + email + ", employee_type=" + employee_type + "]";
	}

	public abstract void ShowInfo();


//	
//	public void BirthdayException() throws RuntimeException {
//		throw new RuntimeException("Nhap sai dinh dang ngay sinh");
//	}
	
}
