package springboot.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.domain.User;

public interface UserRepositroy extends JpaRepository<User, String> {

}
