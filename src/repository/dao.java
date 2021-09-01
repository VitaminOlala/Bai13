package repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import entity.Employee;
import entity.Fresher;

public class dao {
	static repo re = new repo();
	List<Employee> e ;


	public static void write(Employee epl) throws IOException {
		System.out.println("Start");

		FileOutputStream out = null;
		ObjectOutputStream outO =null;
		try {
				
				if(!hasObject()) {
					out = new FileOutputStream("list2.txt");
					outO = new ObjectOutputStream(out);

				}else {
					out = new FileOutputStream("list2.txt", true);
					outO = new ObjectOutputStream(out) {
						@Override
						protected void writeStreamHeader() throws IOException {
							reset();
						}
					};

				}
//				for(Object i : a) {
					outO.writeObject(epl);
//					System.out.println();
//				}

			outO.close();
		 }catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void read() {

		try (FileInputStream fis = new FileInputStream("list2.txt");
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			Object	k;
			int i =0;

    	while(true) {
    		k = ois.readObject();
    		System.out.println(++i+ ":" +k.toString());
    	}

		} catch (Exception e) {
        }
	
	}
	
	// kiểm tra file có object lưu vào hay chưa
	public static boolean hasObject() {
		FileInputStream fi;
		boolean check = true;
		try {
			fi = new FileInputStream("list2.txt");
			ObjectInputStream inStream = new ObjectInputStream(fi);
			if (inStream.readObject() == null) {
				check = false;
			}
			inStream.close();
		} catch (FileNotFoundException e) {
			check = false;
		} catch (IOException e) {
			check = false;
		} catch (ClassNotFoundException e) {
			check = false;
			e.printStackTrace();
		}
		return check;
	}
	
	// viet vao file
//	public static void write(Object emp) throws IOException {
//		System.out.println("Start");
//		
////		List<Employee> list = new ArrayList<>();
////		list.add(emp);
//		try (FileOutputStream out = new FileOutputStream("list2.txt", true);
//				ObjectOutputStream outO = new ObjectOutputStream(out)) {
//				
//			outO.writeObject(emp);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
//	public static void write2() throws IOException {
//		System.out.println("Start");
//		
//		List<Employee> emp = re.getListEpl();
////		emp.add(new Fresher(1, "s", "s", "s", "s", "s", "s","s"));
////		emp.add(new Fresher(2, "s2", "s", "s","s", "s", "s", "s"));
//		try (FileOutputStream out = new FileOutputStream("list2.txt", true);
//				ObjectOutputStream outO = new ObjectOutputStream(out)) {
//
//			outO.writeObject(emp);
//			out.close();
//			outO.close();
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}


//	public static void read() {
////		try {
////			write(a);
////		} catch (IOException e1) {
////			// TODO Auto-generated catch block
////			e1.printStackTrace();
////		}
//		try (FileInputStream fis = new FileInputStream("list2.txt");
//				ObjectInputStream ois = new ObjectInputStream(fis)) {
//			Object	k;
//			int i =0;
////while((k = ois.readObject())!= null){
////    a.add(k);
//    	while(true) {
//    		k = ois.readObject();
//    		System.out.println(++i+ ":" +k.toString());
//    	}
//
////			List<Employee> listemp =  (List<Employee>) ois.readObject();
////			for (Employee employee : listemp) {
////				System.out.println(employee);
////			}
////			
////			return listemp;
////}
//		} catch (Exception e) {
//        }
////		return null;
//	
//	}

}
