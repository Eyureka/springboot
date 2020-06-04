package springboot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.dao.EmployeeDao;
import springboot.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	
	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeRestController(EmployeeDao theEmployeeDao) {
		employeeDao = theEmployeeDao;
	}	
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeDao.findAll();
	}
	
	
}
