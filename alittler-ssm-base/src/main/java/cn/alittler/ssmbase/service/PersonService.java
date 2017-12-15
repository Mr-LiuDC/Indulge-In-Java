package cn.alittler.ssmbase.service;

import java.util.List;

import cn.alittler.ssmbase.entity.Person;
import cn.alittler.ssmbase.entity.QueryCondition;

public interface PersonService {
	
	public void savePerson(Person person);

	public Person selectPersonById(Integer personId);

	public void update(Person person);

	public void delete(Integer personId);

	public List<Person> selectPersonByCondition(QueryCondition qc);

}
