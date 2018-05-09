package cn.alittler.spring.service;

import cn.alittler.spring.entity.DemoEntity;

import java.util.List;

/**
 * DemoEntityService
 *
 * @author LiuDeCai
 * @date 2018/5/8.
 */
public interface DemoEntityService {

    /**
     * 保存对象
     *
     * @param demoEntity 对象
     * @return 对象
     */
    DemoEntity save(DemoEntity demoEntity);

    /**
     * 删除对象
     *
     * @param id 对象ID
     */
    void deleteById(Long id);

    /**
     * 根据ID更新对象
     *
     * @param demoEntity 对象
     * @return 对象
     */
    DemoEntity update(DemoEntity demoEntity);

    /**
     * 根据ID查找对象
     *
     * @param id 对象ID
     * @return 对象
     */
    DemoEntity findById(Long id);

    /**
     * 根据ID查找对象
     *
     * @param id 对象ID
     * @return 对象
     */
    DemoEntity findByIdWithoutCache(Long id);

    /**
     * 根据名称模糊查询
     *
     * @param name 对象名称
     * @return 对象列表
     */
    List<DemoEntity> findByName(String name);

    /**
     * 查询所有对象
     *
     * @return 对象列表
     */
    List<DemoEntity> findAll();
}
