package springboot.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.domain.Role;

/**
 * RoleRepository
 *
 * @author LiuDeCai
 * @date 2018/04/08
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

}
