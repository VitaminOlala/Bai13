package service;

import java.util.List;

import entity.Employee;

public interface Service {
	public void add(Employee epl);
	public boolean updateById(int id);
	public boolean deleteById(int id);
	public void showInfoAll();
	public void showInfoExp();
	public void showInfoFresher();
	public void showInfoIntern();
	public void saveFile();

	public int count();
	public List<Employee> getListToFile();
	void readFile();
}
