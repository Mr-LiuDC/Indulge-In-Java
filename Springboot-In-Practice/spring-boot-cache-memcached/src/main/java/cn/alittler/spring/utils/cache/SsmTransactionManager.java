package cn.alittler.spring.utils.cache;

import com.google.code.ssm.PrefixedCacheImpl;
import com.google.code.ssm.spring.SSMCache;
import com.google.code.ssm.spring.SSMCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.transaction.AbstractTransactionSupportingCacheManager;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * 事务支持的memcached manager
 *
 * @author wangh
 * @date 16/1/9.
 */
public class SsmTransactionManager extends AbstractTransactionSupportingCacheManager {

    @Autowired
    private SSMCacheManager cacheManager;

    public SsmTransactionManager() {
    }

    public void setCacheManager(SSMCacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public SSMCacheManager getCacheManager() {
        return this.cacheManager;
    }

    @Override
    public void afterPropertiesSet() {
        if (getCacheManager() == null) {
            throw new RuntimeException("请检查缓存配置文件是否正确");
        }
        super.afterPropertiesSet();
    }

    @Override
    protected Collection<? extends Cache> loadCaches() {
        Collection<String> names = getCacheManager().getCacheNames();
        Collection<Cache> caches = new LinkedHashSet<Cache>(names.size());
        for (String name : names) {
            caches.add(getCacheManager().getCache(name));
        }
        return caches;
    }

    @Override
    protected Cache getMissingCache(String name) {
        SSMCache ssmCache = getCacheManager().getCache(name);
        if (ssmCache != null) {
            return new SSMCache(new PrefixedCacheImpl(ssmCache.getCache(),
                    name,
                    ssmCache.getCache().getProperties().getKeyPrefixSeparator()),
                    ssmCache.getExpiration(),
                    ssmCache.isAllowClear());
        }
        return null;
    }
}
