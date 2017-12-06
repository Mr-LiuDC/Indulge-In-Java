package springboot.service;

import java.util.Collection;

import springboot.domain.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee emp);

	Boolean deleteEmployee(String empId);

	Employee editEmployee(Employee emp);

	Employee findEmployee(String empId);

	Collection<Employee> getAllEmployees();

}
