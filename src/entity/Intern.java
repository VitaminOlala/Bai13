package entity;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class Intern extends Employee {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Intern() {
		// TODO Auto-generated constructor stub
	}

	public Intern(int id, String fullname, String birthday, String phone, String email, String majors, int semester,
			String university_name) {
		super(id, fullname, birthday, phone, email);
		this.majors = majors;
		this.semester = semester;
		this.university_name = university_name;
	}

	public String getMajors() {
		return majors;
	}
	public void setMajors(String majors) {
		this.majors = majors;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getUniversity_name() {
		return university_name;
	}
	public void setUniversity_name(String university_name) {
		this.university_name = university_name;
	}
	private String majors;
	private int semester;
	private String university_name;
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
		System.out.println("Ten truong dang hoc: "+university_name);
		System.out.println("Hoc ki dang hoc: "+semester);
		System.out.println("Ten nganh: "+majors);
	}

	@Override
	public String toString() {
		return "Intern [majors=" + majors + ", semester=" + semester + ", university_name=" + university_name
				+ ", getId()=" + getId() + ", getFullname()=" + getFullname() + ", getBirthday()=" + getBirthday()
				+ ", getPhone()=" + getPhone() + ", getEmail()=" + getEmail() + ", getEmployee_type()="
				+ getEmployee_type() + "]";
	}
	
}
