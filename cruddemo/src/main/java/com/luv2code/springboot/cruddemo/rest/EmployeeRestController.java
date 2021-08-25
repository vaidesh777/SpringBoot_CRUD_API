package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;import.java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeDAO employeeDAO;

	// inject employeeDAO
	Autowired

	public EmployeeRestController(EmployeeDAO theEmployeeDAO) 
	{
		employeeDAO=theEmployeeDAO;
	}

	// expose "/employees" and return list of employees

	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeDAO.findAll();

	}

}
