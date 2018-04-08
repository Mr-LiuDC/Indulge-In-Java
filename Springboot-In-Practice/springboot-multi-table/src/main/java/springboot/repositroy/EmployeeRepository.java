package springboot.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.domain.Employee;

/**
 * EmployeeRepository
 *
 * @author LiuDeCai
 * @date 2018/04/08
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
