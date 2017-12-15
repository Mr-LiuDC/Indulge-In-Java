package cn.alittler.ssmbase;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.alittler.ssmbase.entity.Person;
import cn.alittler.ssmbase.entity.QueryCondition;
import cn.alittler.ssmbase.service.PersonService;

public class SSMTest {

	private PersonService personService = null;

	@SuppressWarnings("resource")
	@Before
	public void before() {
		String[] strArray = new String[] { "classpath:spring.xml", "classpath:spring-mybatis.xml" };
		ApplicationContext ac = new ClassPathXmlApplicationContext(strArray);
		personService = (PersonService) ac.getBean("personServiceImpl");
	}

	@Test
	public void SelectPersonByConditions() {
		QueryCondition qc = new QueryCondition();
		// 这些查询条件会自动生成 (见PersonMapper.xml中的动态sql)
		// qc.setName("刘");
		qc.setGender(1);
		qc.setPersonAddr("重庆");
		// qc.setBirthday(new Date());
		System.out.println("=============>" + qc);
		List<Person> persons = personService.selectPersonByCondition(qc);
		for (Person person : persons) {
			System.out.println(person);
		}
	}

}
