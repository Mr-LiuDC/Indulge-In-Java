package springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
	/**
	 * 通过年龄来查询 方法名固定
	 *
	 * @param age
	 * @return
	 */
	public List<Person> findByAge(Integer age);
}
