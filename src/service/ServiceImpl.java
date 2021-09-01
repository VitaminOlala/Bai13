package service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import entity.Employee;
import entity.Experience;
import entity.Fresher;
import entity.Intern;
import repository.dao;
import repository.repo;

import java.util.stream.Collector;
import java.util.stream.Collectors;


public class ServiceImpl implements Service{
	public static Scanner sc = new Scanner(System.in);
	repo repos = new repo();
	static int count =0;
//	List<Experience> li3 = new ArrayList<>();
//	List<Fresher> li1 = repos.getListFresh();
//	List<Intern>li= repos.getListIntern();
	
	
	private dao employeeDao;
	List<Employee> list = repos.getListEpl();
	
	public ServiceImpl() {
		employeeDao = new dao();

	}

	@Override
	public void add(Employee epl) {
		 
		
		if(epl instanceof Experience) {
			Experience exp = (Experience) epl;
			list.add(exp);
			
			count++;

		}
		else if(epl instanceof Fresher) {
			Fresher fr = (Fresher) epl;
			list.add(fr);
			count++;

		
		}else if(epl instanceof Intern) {
			Intern in = (Intern) epl;
			list.add(in);
			count++;

		}
//		try {
//			dao.write(epl);
//		} catch (IOException e) {
//			System.err.println(e.getMessage().toString());
//			
//		}
	}

	public List<Employee> getListToFile(){
		return list;
		
	}

	@Override
	public boolean updateById(int id) {
		// TODO Auto-generated method stub
		Employee epl = null;
		boolean check  = false;
		for(int i=0; i<list.size(); i++) {
			if(id == list.get(i).getId()) {
				if(list.get(i).getEmployee_type() == "Thuc tap sinh") {
					list.get(i).forIntern(list.get(i), inputName(), inputBirthday(), inputPhone(), inputEmail(), inputNganh(), inputHocKiDangHoc(),inputTenTruongDangHoc() );;
				}
				else if(list.get(i).getEmployee_type() == "Experience") {
					list.get(i).forExp(list.get(i), inputName(), inputBirthday(), inputPhone(), inputEmail(), inputExplnYear(), inputKyNangChuyenMon() );
				}
				else if(list.get(i).getEmployee_type() == "Fresher") {
					list.get(i).forFresher(list.get(i), inputName(), inputBirthday(), inputPhone(), inputEmail(), inputThoiGianTotNghiep(), inputXepLoaiTotNghiep(), inputTruongTotNghiep() );
				}
				
//					System.out.println(list.get(i));	
						
				}
			}
		
		return false;
		
	}
	
	private String inputName() {
		System.out.println("Nhap lai fullname: ");
		return sc.nextLine();
	}

	private String inputBirthday() {
		String he;
		while (true) {
			
			System.out.println("Nhap ngay sinh: ");
			he = sc.nextLine();
			
			if (he.matches("[0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4}")) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

				try {
					Date d = sdf.parse(he);
					String b2 = sdf.format(d);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			} else {
				System.out.println("Sai ngay sinh hop le");
			}
		}
		return he;
	}
	private String inputEmail() {
		String phone;
		while(true) {
			try {
				System.out.println("Nhap phone number: ");
				phone = sc.nextLine();
				Pattern p = Pattern.compile("^[0-9]"); //Nhap dung 10 so {10}$
				if(p.matcher(phone).find()) {
					System.out.println("Phone valid");
					break;
				}				
			}catch(Exception e) {
				System.out.println("Sai dinh dang phone.Nhap lai:");
			}

//				throw new RuntimeException("Phone not valid");
			}
		return phone;
	}
	private int inputExplnYear() {
		System.out.println("Nhap lai so nam kinh nghiem: ");
		return sc.nextInt();
	}
	private String inputPhone() {
		System.out.println("Nhap lai phone: ");
		return sc.nextLine();
	}
	private String inputKyNangChuyenMon() {
		System.out.println("Nhap lai ky nang chuyen mon: ");
		return sc.nextLine();
	}
	private String inputThoiGianTotNghiep() {
		System.out.println("Nhap lai time tot nghiep: ");
		return sc.nextLine();
	}
	private String inputXepLoaiTotNghiep() {
		System.out.println("Nhap lai xep loai tot nghiep: ");
		return sc.nextLine();
	}
	private String inputTruongTotNghiep() {
		System.out.println("Nhap lai truong tot nghiep: ");
		return sc.nextLine();
	}
	private String inputTenTruongDangHoc() {
		System.out.println("Nhap lai Ten truong dang hoc: ");
		return sc.nextLine();
	}
	private int inputHocKiDangHoc() {
		System.out.println("Nhap lai hoc ki dang hoc: ");
		return sc.nextInt();
	}
	private String inputNganh() {
		System.out.println("Nhap lai nganh: ");
		return sc.nextLine();
	}	
	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub

		Employee em11 = this.list.stream().filter(epl -> epl.getId()== id).findFirst().orElse(null);
		
		if(em11 == null) {
			return false;
		}
		this.list.remove(em11);
		count--;
		return true;	
	}

	@Override
	public void showInfoExp() {
		
		for (Employee experience : list) {
			if(experience.getEmployee_type() == "Chuyen vien") {
			experience.ShowInfo();
			}
		}
	}

//	@Override
//	public void countEmployee() {
//		this.list.stream().map(epl -> epl.getId()).count();
//	}

	@Override
	public void showInfoFresher() {
		
		for (Employee epl : list) {
			if(epl.getEmployee_type() == "Fresher") {
			
				epl.ShowInfo();
			}
		}
//		return this.list.stream().filter(o -> o.getEmployee_type().contains("Fresher")).collect(Collectors.toList());
	}

	@Override
	public void showInfoIntern() {
		
		for (Employee epl : list) {
			if(epl.getEmployee_type() == "Thuc tap sinh") {
				
				epl.ShowInfo();
			}
		}
//		return this.list.stream().filter(o -> o.getEmployee_type().contains("Thuc tap sinh")).collect(Collectors.toList());
	}

	@Override
	public void showInfoAll() {

		 this.list.stream().forEach(epl -> epl.ShowInfo());
	}

//	@Override
	public void saveFile() {
		// TODO Auto-generated method stub
//		try {
//			employeeDao.write(epl);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//
//		}
	}
	
	@Override
	public void readFile() {		
//		List<Employee> listReturn = new ArrayList<>(); 
		dao.read();
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return count;
		
	}


	
	

}
