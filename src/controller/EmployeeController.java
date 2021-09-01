package controller;

import entity.Employee;
import service.Service;
import service.ServiceImpl;

public class EmployeeController {
	Service sv = new ServiceImpl();
	
	public void addEmployee(Employee epl) {
		sv.add(epl);
	}
	public void showMainExp() {
		sv.showInfoExp();

	}
	public void showMainAll() {
		sv.showInfoAll();

	}
	public void showMainFresh() {
		sv.showInfoFresher();

	}
	public void showMainIntern() {

		sv.showInfoIntern();
	}
	
	public boolean removeById(int id) {
		return sv.deleteById(id);
	}
	public void saveToFile() {
		sv.saveFile();
	}
	
	public boolean updateBy(int id) {
		return sv.updateById(id);
	}
	public void readFromFile() {
		sv.readFile();
		} // read sao lai co object b 
	public void countEpl() {
		
		System.out.println("Tong so nhan vien la: "+sv.count());
	}
}
