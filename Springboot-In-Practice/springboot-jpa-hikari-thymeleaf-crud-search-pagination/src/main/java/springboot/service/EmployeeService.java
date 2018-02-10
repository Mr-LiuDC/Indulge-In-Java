package springboot.service;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import springboot.domain.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee emp);

	Boolean deleteEmployee(String empId);

	Employee editEmployee(Employee emp);

	Employee findEmployee(String empId);

	Collection<Employee> getAllEmployees();

	Page<Employee> findEmployeesByEmpNameContainingAndEmpPositionContaining(String name, String position, Pageable pageable);

}
