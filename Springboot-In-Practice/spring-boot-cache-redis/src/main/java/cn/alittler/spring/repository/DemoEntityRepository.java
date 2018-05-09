package cn.alittler.spring.repository;

import cn.alittler.spring.entity.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * DemoEntityRepository
 *
 * @author LiuDeCai
 * @date 2018/5/8.
 */
public interface DemoEntityRepository extends JpaRepository<DemoEntity, Long> {

    List<DemoEntity> findByNameContains(String name);

}
