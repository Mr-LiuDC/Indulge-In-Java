package cn.alittler.spring;

import cn.alittler.spring.entity.DemoEntity;
import cn.alittler.spring.repository.DemoEntityRepository;
import cn.alittler.spring.service.DemoEntityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author LiuDeCai
 * @date 2018/05/08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCacheRedisApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private DemoEntityRepository demoEntityRepository;
    @Autowired
    private DemoEntityService demoEntityService;
    @Autowired
    RedisTemplate<Object, Object> template;

    @Test
    public void testTemplate() {
        template.opsForValue().set("test-key", "刘德财", 10, TimeUnit.SECONDS);
        System.out.println(template.opsForValue().get("test-key"));
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(template.opsForValue().get("test-key"));
    }

    public void testRepo() {

    }

    @Test
    public void testService() {
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setId(1L);
        demoEntity.setName("刘德财");
        demoEntity.setDescription("缓存测试");
        demoEntityService.save(demoEntity);

        System.out.println(demoEntityService.findById(1L));
        System.out.println(demoEntityService.findById(1L));
        System.out.println(demoEntityService.findById(1L));
        System.out.println("++++++++++++++++++++++++");
        System.out.println(demoEntityService.findByIdWithoutCache(1L));
        System.out.println(demoEntityService.findByIdWithoutCache(1L));
        System.out.println(demoEntityService.findByIdWithoutCache(1L));
    }

    // TODO Redis事务测试

}
