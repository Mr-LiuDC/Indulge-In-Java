package springboot.repositroy;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import springboot.domain.User;

public interface UserRepositroy extends JpaRepository<User, Long> {

    Page<User> findUsersByNameContains(String name, Pageable pageable);

}
