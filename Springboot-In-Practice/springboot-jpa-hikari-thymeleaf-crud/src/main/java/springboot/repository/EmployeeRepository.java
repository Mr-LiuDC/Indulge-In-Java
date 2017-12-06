package springboot.repository;

import org.springframework.data.repository.CrudRepository;

import springboot.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

}
