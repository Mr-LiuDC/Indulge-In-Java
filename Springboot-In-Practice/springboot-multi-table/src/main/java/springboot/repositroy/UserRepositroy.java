package springboot.repositroy;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import springboot.domain.User;

/**
 * @author LiuDeCai
 */
public interface UserRepositroy extends JpaRepository<User, Long> {

    /**
     * 根据name分页查询
     *
     * @param name
     * @param pageable
     * @return
     */
    Page<User> findUsersByNameContains(String name, Pageable pageable);

    /**
     * 获取一条最新记录
     *
     * @return
     */
    User findFirstByOrderByCreateTimeDesc();

    /**
     * 获取一条最旧记录
     *
     * @return
     */
    User findFirstByOrderByCreateTimeAsc();

}
