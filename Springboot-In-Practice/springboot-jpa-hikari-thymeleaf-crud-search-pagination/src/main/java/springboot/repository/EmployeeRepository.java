package springboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import springboot.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

    Page<Employee> findEmployeesByEmpNameContainingAndEmpPositionContaining(String name, String position, Pageable pageable);

}
