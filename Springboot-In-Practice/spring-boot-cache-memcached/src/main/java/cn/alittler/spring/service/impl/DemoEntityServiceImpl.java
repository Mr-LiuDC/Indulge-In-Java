package cn.alittler.spring.service.impl;

import cn.alittler.spring.constant.CacheKeyConstant;
import cn.alittler.spring.constant.CacheNameConstant;
import cn.alittler.spring.entity.DemoEntity;
import cn.alittler.spring.repository.DemoEntityRepository;
import cn.alittler.spring.service.DemoEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DemoEntityServiceImpl
 *
 * @author LiuDeCai
 * @date 2018/5/8.
 */
@Service
@CacheConfig(cacheNames = CacheNameConstant.USER)
public class DemoEntityServiceImpl implements DemoEntityService {

    @Autowired
    private DemoEntityRepository demoEntityRepository;

    @Override
    @CachePut(key = CacheKeyConstant.USER + "+ 'id:' + #demoEntity.id")
    public DemoEntity save(DemoEntity demoEntity) {
        return demoEntityRepository.save(demoEntity);
    }

    @Override
    @CacheEvict(key = CacheKeyConstant.USER + " + 'id:' + #id")
    public void deleteById(Long id) {
        demoEntityRepository.delete(id);
    }

    @Override
    @CachePut(key = CacheKeyConstant.USER + " + 'id:' + #demoEntity.id")
    public DemoEntity update(DemoEntity demoEntity) {
        return demoEntityRepository.saveAndFlush(demoEntity);
    }

    @Override
    @Cacheable(key = CacheKeyConstant.USER + " + 'id:' + #id")
    public DemoEntity findById(Long id) {
        return demoEntityRepository.findOne(id);
    }

    @Override
    public DemoEntity findByIdWithoutCache(Long id) {
        return demoEntityRepository.findOne(id);
    }

    @Override
    @Cacheable(key = "#root.targetClass.toString()+#name", unless = "#result == null")
    public List<DemoEntity> findByName(String name) {
        return demoEntityRepository.findByNameContains(name);
    }

    @Override
    @Cacheable(key = "#root.targetClass.toString()", unless = "#result == null")
    public List<DemoEntity> findAll() {
        return demoEntityRepository.findAll();
    }

    @Override
    public List<DemoEntity> findAllWithoutCache() {
        return demoEntityRepository.findAll();
    }
}
