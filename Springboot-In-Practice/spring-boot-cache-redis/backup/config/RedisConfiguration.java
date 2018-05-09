package cn.alittler.spring.config;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * RedisConfiguration Redis配置
 *
 * @author LiuDeCai
 * @date 2018/05/09
 */
@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {

    /**
     * 通用RedisTemplate
     *
     * @param jedisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        ///
        //template.setHashKeySerializer(template.getKeySerializer());
        //template.setHashValueSerializer(template.getValueSerializer());
        return template;
    }

    /**
     * 定制RedisCacheManager
     *
     * @return
     */
    @Bean
    public CacheManagerCustomizer<RedisCacheManager> cacheManagerCustomizer() {
        return new CacheManagerCustomizer<RedisCacheManager>() {
            @Override
            public void customize(RedisCacheManager cacheManager) {
                //事实上这是Spring Boot的默认设置，为了避免key冲突
                cacheManager.setUsePrefix(true);
                // 设置过期时间 key is cache-name
                Map<String, Long> expires = new HashMap<>(2);
                expires.put("myLittleCache", 12L * 60 * 60);
                expires.put("myBiggerCache", 24L * 60 * 60);
                cacheManager.setExpires(expires);
                // 默认过期时间：24 hours
                cacheManager.setDefaultExpiration(24 * 60 * 60);
            }
        };
    }

    /**
     * @return
     */
    @Bean
    public KeyGenerator customKeyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder sb = new StringBuilder();
                sb.append(o.getClass().getName());
                sb.append(method.getName());
                for (Object obj : objects) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }

}
