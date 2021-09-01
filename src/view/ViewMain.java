package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import controller.EmployeeController;
import entity.Employee;
import entity.Experience;
import entity.Fresher;
import entity.Intern;
import repository.dao;

public class ViewMain {
	public static Scanner sc = new Scanner(System.in);
	static EmployeeController employeeController = new EmployeeController();
//	static List<Employee> liste = new ArrayList<>();
	static Employee epl;
	public static void main(String[] args) {
		String choose = null;
		boolean exit = false;
		
		while (true) {
			show1();
			choose = sc.nextLine();
			switch (choose) {
			case "1":
				showAddButton();
				break;
			case "2":
				System.out.println("Nhap id de sua: ");
				int id1 = Integer.parseInt(sc.nextLine());
				employeeController.updateBy(id1);
				break;
			case "3":
				System.out.println("Input id to remove: ");
				int id = sc.nextInt();
				System.out.println(employeeController.removeById(id) ? "Xoa thanh cong" : "Xoa that bai");
				break;
				
			case "4":	
				employeeController.showMainAll();
				break;
			case "5":	
				employeeController.showMainIntern();
				break;
			case "6":	
				employeeController.showMainFresh();
				break;
			case "7":	
				employeeController.showMainExp();;
				break;				
			case "8":	
				employeeController.countEpl();
				break;
			case "9":	
				employeeController.saveToFile();;
				break;
			case "10":	
				employeeController.readFromFile();;
				break;
			case "11":	
				employeeController.countEpl();;
				break;
			case "0":
				System.out.println("exited");
				exit = true;
				break;
			default:
				System.out.println("u havent choosen any actions, pls choose");
				break;
			}
		// cai loi nay la vi trong file b ko luu no la 1 list nen khi doc ra no ko hieu lan
			//  sau neu b doc file thi doc het data ra luu vao list r them vao lai day lai thi no moi hieu odek cast sang list 
			//nhu
			if (exit) {
				return; 
			}
		}
	}
	
	public static void show1() {
		System.out.println("----menu-------");
		System.out.println("1. Add .");
		System.out.println("2. Update.");
		System.out.println("3. Delete.");
		System.out.println("4. Show All.");
		System.out.println("5. Show Thuc tap sinh.");
		System.out.println("6. Show Fresher.");
		System.out.println("7. Show Chuyen vien.");
		System.out.println("8. So luong nhan vien.");
		System.out.println("9. Luu file txt.");
		System.out.println("10. Show data trong txt.");
		System.out.println("11. Tong so nhan vien.");
		System.out.println("0. exit.");

		System.out.print("Choose: ");	
	}

	// luu o dau day b vao di
	public static void showAddButton() {

		System.out.print("Nhap v�o so luong can them: ");
		int q = Integer.parseInt(sc.nextLine());
		for(int i=0; i<q; i++){
			System.out.println("1. Thuc tap sinh .");
			System.out.println("2. Fresher.");
			System.out.println("3. Chuyen vien.");	
//			System.out.println("4. All.");
			
			System.out.print("Choose: ");

			int pick = Integer.parseInt(sc.nextLine());

			switch (pick) {

			case 1:

				nhapThongTinIntern();
				
				break;
			case 2:

				
				nhapThongTinFresher();
				
				break;
			case 3:

				
				nhapThongTinExp();
				
				break;

		}			
		}
	}

	private dao employeeDao = new dao();

	public static void nhapThongTinIntern() {
		
		int id ;
		String fullname ;
		String birthday;
		String phone;
		String email ;
		String university_name;
		String majors;
		int semester;	

		
		System.out.println("Nhap id :");
		id = Integer.parseInt(sc.nextLine());
		
		System.out.println("Nhap ho ten: ");
		fullname = sc.nextLine();

		while (true) {
			System.out.println("Nhap ngay sinh: ");
			birthday = sc.nextLine();
			if (birthday.matches("[0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4}")) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

				try {
					Date d = sdf.parse(birthday);
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
	  
		
		System.out.println("Nhap email: ");
		email = sc.nextLine();

		
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
		
		System.out.println("Nhap nganh: ");
		majors = sc.nextLine();
		System.out.println("Nhap ki hoc: ");
		semester = Integer.parseInt(sc.nextLine());
		System.out.println("Nhap ten truong: ");
		university_name = sc.nextLine();	
		Intern epl1 = new Intern(id, fullname, birthday, phone, email, majors, semester, university_name);
		epl1.setEmployee_type("Thuc tap sinh");
		employeeController.addEmployee(epl1);
	}
	


	public static void nhapThongTinFresher() {
		int id ;
		String fullname ;
		String birthday;
		String phone ;
		String email ;
		String graduation_date ;
		String graduation_rank;
		String education;


		System.out.println("Nhap id :");
		id = Integer.parseInt(sc.nextLine());
		System.out.println("Nhap ho ten: ");
		fullname = sc.nextLine();

		while (true) {
			System.out.println("Nhap ngay sinh: ");
			birthday = sc.nextLine();
			if (birthday.matches("[0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4}")) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

				try {
					Date d = sdf.parse(birthday);
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
	  
		
		System.out.println("Nhap email: ");
		email = sc.nextLine();

		
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
		
		System.out.println("Nhap thoi gian tot nghiep: ");
		graduation_date = sc.nextLine();
		System.out.println("Nhap xep loai tot nghiep: ");
		graduation_rank = sc.nextLine();
		System.out.println("Nhap truong tot nghiep: ");
		education = sc.nextLine();
		Employee epl1 = new Fresher(id, fullname, birthday, phone, email, graduation_date, graduation_rank, education);
		epl1.setEmployee_type("Fresher");
		employeeController.addEmployee(epl1);
	}
	

	public static void nhapThongTinExp() {
		int id ;
		String fullname ;
		String birthday;
		String phone ;
		String email;
		int explnYear ;
		String proSkill ;
	

		System.out.println("Nhap id :");
		id = Integer.parseInt(sc.nextLine());
		System.out.println("Nhap ho ten: ");
		fullname = sc.nextLine();

		while (true) {
			System.out.println("Nhap ngay sinh: ");
			birthday = sc.nextLine();
			if (birthday.matches("[0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4}")) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

				try {
					Date d = sdf.parse(birthday);
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

		System.out.println("Nhap email: ");
		email = sc.nextLine();

		
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
		
		System.out.println("Nhap so nam kinh nghiem: ");
		explnYear = Integer.parseInt(sc.nextLine());
		System.out.println("Nhap ki nang: ");
		proSkill = sc.nextLine();
		Employee epl1 = new Experience(id, fullname, birthday, phone, email, explnYear, proSkill);
		epl1.setEmployee_type("Chuyen vien");
		employeeController.addEmployee(epl1);
	}
	
	public static void showShow() {

		System.out.println("1. Thuc tap sinh .");
		System.out.println("2. Fresher.");
		System.out.println("3. Chuyen vien.");	
		System.out.println("4. All.");
		
		System.out.print("Choose: ");

		int pick = sc.nextInt();

		switch (pick) {

		case 1:
			
			employeeController.showMainIntern();;
			break;
		case 2:
			
			employeeController.showMainFresh();;
			break;
		case 3:
			employeeController.showMainExp();;
			break;

	}

}
}

//	class hello {
//		ViewMain t = new ViewMain();
//		
//	}
