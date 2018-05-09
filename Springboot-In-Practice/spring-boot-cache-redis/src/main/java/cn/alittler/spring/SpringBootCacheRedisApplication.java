package cn.alittler.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author LiuDeCai
 * @date 2018/05/08
 */
@SpringBootApplication
@EnableCaching
public class SpringBootCacheRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCacheRedisApplication.class, args);
    }
}
