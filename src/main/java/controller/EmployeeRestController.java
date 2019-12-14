package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import entity.Employee;
import service.EmployeeService;

@RestController
public class EmployeeRestController {
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE })
	@ResponseBody
	public List<Employee> getAllEmpl() {

		return employeeService.getAllEmpl();
	}

}
