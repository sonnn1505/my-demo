package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public List<Employee> getAllEmpl() {
		Employee em1 = new Employee(1, "nam1", 20);
		Employee em2 = new Employee(2, "nam2", 21);
		Employee em3 = new Employee(3, "nam3", 22);
		List<Employee> res = new ArrayList<Employee>();
		res.add(em1);
		res.add(em2);
		res.add(em3);
		return res;
	}

}
