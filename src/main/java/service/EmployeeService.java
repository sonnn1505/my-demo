package service;

import java.util.List;

import entity.Employee;

public interface EmployeeService {
	List<Employee> getAllEmpl();

	void saveEmpl(Employee empl);

	void delEmpl(int id);

}
