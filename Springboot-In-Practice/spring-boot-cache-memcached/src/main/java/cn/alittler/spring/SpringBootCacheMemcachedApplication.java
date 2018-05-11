package cn.alittler.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;

/**
 * @author LiuDeCai
 * @date 2018/05/08
 */
@SpringBootApplication
@ImportResource({"classpath:config/cache-context.xml"})
public class SpringBootCacheMemcachedApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCacheMemcachedApplication.class, args);
    }
}
