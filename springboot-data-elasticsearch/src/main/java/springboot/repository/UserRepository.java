package springboot.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import springboot.domain.User;

/**
 * @description: UserRepository接口
 * @dateTime: Create On 2017-12-03 21:48:31
 * @author: Mr-LiuDC
 * @email: 1911939348@qq.com
 *
 */
public interface UserRepository extends ElasticsearchRepository<User, String> {

	public User findByName(String name);

	public List<User> findByMotto(String motto);

	public List<User> findByBirthdayBetween(Date start, Date end);

	Page<User> findDistinctUserByNameContainingOrMottoContaining(String name, String motto, Pageable pageable);

	Page<User> findDistinctUserByNameContainingAndMottoContaining(String name, String motto, Pageable pageable);

}
