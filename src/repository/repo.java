package repository;

import java.util.ArrayList;
import java.util.List;

import entity.Certificate;
import entity.Employee;
import entity.Experience;
import entity.Fresher;
import entity.Intern;

public class repo {
//	public List<Experience> getListExp() {
//		return listExp;
//	}
//	public void setListExp(List<Experience> listExp) {
//		this.listExp = listExp;
//	}
//	public List<Fresher> getListFresh() {
//		return listFresh;
//	}
//	public void setListFresh(List<Fresher> listFresh) {
//		this.listFresh = listFresh;
//	}
//	public List<Intern> getListIntern() {
//		return listIntern;
//	}
//	public void setListIntern(List<Intern> listIntern) {
//		this.listIntern = listIntern;
//	}
//	List<Experience> listExp;
//	List<Fresher> listFresh;
//	List<Intern> listIntern;
	List<Certificate> listCer;
	List<Employee> listEpl;
	
	public List<Employee> getListEpl() {
		return listEpl;
	}
	public void setListEpl(List<Employee> listEpl) {
		this.listEpl = listEpl;
	}
	public List<Certificate> getListCer() {
		return listCer;
	}
	public void setListCer(List<Certificate> listCer) {
		this.listCer = listCer;
	}
	public repo() {
//		listExp = new ArrayList<>();
//		listFresh = new ArrayList<>();
//		listIntern = new ArrayList<>();
		listCer = new ArrayList<>();
		listEpl = new ArrayList<>();
	}

}
