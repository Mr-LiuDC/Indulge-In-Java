package cn.alittler.ssmbase.dao;

import java.util.List;

import cn.alittler.ssmbase.entity.Person;
import cn.alittler.ssmbase.entity.QueryCondition;

/**
 * @description: PersonDao接口类
 * @date: Created on 2016年11月20日
 * @author: Mr-LiuDC
 *
 */
public interface PersonDao {

	public void insert(Person person);

	public Person selectPersonById(Integer personId);

	public void update(Person person);

	public void delete(Integer personId);

	public List<Person> selectPersonByCondition(QueryCondition qc);

}
