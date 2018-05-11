package cn.alittler.spring.utils.cache;

import cn.alittler.spring.utils.spring.SpringUtils;
import com.google.code.ssm.providers.CacheException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.util.Objects;
import java.util.concurrent.TimeoutException;

/**
 * 缓存工具类CacheUtils
 *
 * @author wangh
 * @date 2016/7/18.
 */
public class CacheUtils {

    private static CacheManager cacheManager = SpringUtils.getBean("cacheManager");
    private static final Logger logger = LoggerFactory.getLogger(CacheUtils.class);

    /**
     * 获取缓存数据
     *
     * @param cacheName 缓存的名称,如果缓存不存在,将会新建一个缓存
     * @param key       缓存的key
     * @param type      返回对象的类型
     * @param <T>       返回对象,如果不存在,返回null
     * @return
     */
    public static <T> T get(String cacheName, Object key, Class<T> type) {
        Cache cache = cacheManager.getCache(cacheName);
        if (cache == null || key == null) {
            return null;
        }
        return cache.get(key, type);
    }

    /**
     * 设置缓存
     *
     * @param cacheName 缓存的名称,如果缓存不存在,将会新建一个缓存
     * @param key       缓存的key
     * @param value     缓存的值
     */
    public static void put(String cacheName, Object key, Object value) {
        Cache cache = cacheManager.getCache(cacheName);
        if (cache == null) {
            return;
        }
        cache.put(key, value);
    }

    /**
     * 设置缓存
     *
     * @param cacheName  缓存的名称,如果缓存不存在,将会新建一个缓存
     * @param key        缓存的key
     * @param value      缓存的值
     * @param expiration 缓存过期时间
     */
    public static void put(String cacheName, Object key, Object value, int expiration) {
        Objects.requireNonNull(cacheName, "cacheName不能为空");
        Objects.requireNonNull(key, "缓存的key不能为空");
        Objects.requireNonNull(value, "缓存的值不能为空");
        assert expiration >= 1;

        Cache cache = cacheManager.getCache(cacheName);
        if (cache == null) {
            return;
        }
        com.google.code.ssm.Cache ssmCache = (com.google.code.ssm.Cache) cache.getNativeCache();
        try {
            ssmCache.set(key.toString(), expiration, value, null);
        } catch (TimeoutException | CacheException e) {
            logger.error(String.format("写入数据到缓存失败,cacheName is: %s,key is %s", cacheName, key.toString()));
        }
    }

    /**
     * 设置缓存,并返回修改之前的值
     *
     * @param cacheName 缓存的名称,如果缓存不存在,将会新建一个缓存
     * @param key       缓存的key
     * @param value     缓存的值
     * @return
     */
    public static Object putIfAbsent(String cacheName, Object key, Object value) {
        Cache cache = cacheManager.getCache(cacheName);
        if (cache == null) {
            return null;
        }
        return cache.putIfAbsent(key, value).get();
    }

    /**
     * 清除某个指定的缓存
     *
     * @param cacheName 缓存的名称,如果缓存不存在,将会新建一个缓存
     * @param key       缓存的key
     */
    public static void evict(String cacheName, Object key) {
        Cache cache = cacheManager.getCache(cacheName);
        if (cache == null) {
            return;
        }
        cache.evict(key);
    }

}
