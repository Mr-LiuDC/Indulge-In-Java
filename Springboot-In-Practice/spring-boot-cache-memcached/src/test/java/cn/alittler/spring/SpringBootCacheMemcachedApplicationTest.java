package cn.alittler.spring;

import cn.alittler.spring.entity.DemoEntity;
import cn.alittler.spring.repository.DemoEntityRepository;
import cn.alittler.spring.service.DemoEntityService;
import cn.alittler.spring.utils.cache.CacheUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author LiuDeCai
 * @date 2018/05/08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCacheMemcachedApplicationTest {

    @Autowired
    private DemoEntityRepository demoEntityRepository;
    @Autowired
    private DemoEntityService demoEntityService;

    @Test
    public void testMemcached() {
        CacheUtils.put("userCache", "liudecai", "刘德财", 6000);
        Assert.assertEquals("刘德财", CacheUtils.get("userCache", "liudecai", String.class));
    }

    public void testRepo() {

    }

    @Test
    public void testService() {
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setId(1L);
        demoEntity.setName("刘德财");
        demoEntity.setDescription("缓存对象测试");
        demoEntityService.save(demoEntity);

        System.out.println(demoEntityService.findById(1L));
        System.out.println(demoEntityService.findById(1L));
        System.out.println(demoEntityService.findById(1L));
        System.out.println("++++++++++++++++++++++++");
        System.out.println(demoEntityService.findByIdWithoutCache(1L));
        System.out.println(demoEntityService.findByIdWithoutCache(1L));
        System.out.println(demoEntityService.findByIdWithoutCache(1L));
    }

    @Test
    public void testServiceList() {
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setId(1L);
        demoEntity.setName("刘德财");
        demoEntity.setDescription("缓存测试");
        demoEntityService.save(demoEntity);
        DemoEntity demoEntity2 = new DemoEntity();
        demoEntity2.setId(2L);
        demoEntity2.setName("刘川枫");
        demoEntity2.setDescription("测试对象");
        demoEntityService.save(demoEntity2);

        // 缓存列表测试
        System.out.println(demoEntityService.findByName("刘"));
        System.out.println(demoEntityService.findByName("刘"));
        System.out.println(demoEntityService.findByName("刘"));
        System.out.println("++++++++++++++++++++++++");
        System.out.println(demoEntityService.findAll());
        System.out.println(demoEntityService.findAll());
        System.out.println(demoEntityService.findAll());
        System.out.println("++++++++++++++++++++++++");
        System.out.println(demoEntityService.findAllWithoutCache());
        System.out.println(demoEntityService.findAllWithoutCache());
        System.out.println(demoEntityService.findAllWithoutCache());
    }

    // TODO Memcached事务测试

}
