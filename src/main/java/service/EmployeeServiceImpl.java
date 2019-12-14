package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.EmployeeDAO;
import entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public List<Employee> getAllEmpl() {
		return employeeDAO.getAllEmpl();
	}

	@Override
	public void saveEmpl(Employee empl) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delEmpl(int id) {
		// TODO Auto-generated method stub

	}

}
