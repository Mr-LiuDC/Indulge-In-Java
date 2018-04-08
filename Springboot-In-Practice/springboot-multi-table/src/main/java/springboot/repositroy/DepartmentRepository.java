package springboot.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.domain.Department;

/**
 * DepartmentRepository
 *
 * @author LiuDeCai
 * @date 2018/04/08
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
