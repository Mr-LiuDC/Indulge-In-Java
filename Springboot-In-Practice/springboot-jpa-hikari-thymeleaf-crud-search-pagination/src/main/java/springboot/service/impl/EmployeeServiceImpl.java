package springboot.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.domain.Employee;
import springboot.repository.EmployeeRepository;
import springboot.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	protected EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

	@Override
	public Boolean deleteEmployee(String empId) {
		Employee temp = employeeRepository.findOne(empId);
		if (temp != null) {
			employeeRepository.delete(temp);
			return true;
		}
		return false;
	}

	@Override
	public Employee editEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

	@Override
	public Employee findEmployee(String empId) {
		return employeeRepository.findOne(empId);
	}

	@Override
	public Collection<Employee> getAllEmployees() {
		Iterable<Employee> itr = employeeRepository.findAll();
		return (Collection<Employee>) itr;
	}

	@Override
	public Page<Employee> findEmployeesByEmpNameContainingAndEmpPositionContaining(String name, String position, Pageable pageable) {
		return employeeRepository.findEmployeesByEmpNameContainingAndEmpPositionContaining(name, position, pageable);
	}

}
