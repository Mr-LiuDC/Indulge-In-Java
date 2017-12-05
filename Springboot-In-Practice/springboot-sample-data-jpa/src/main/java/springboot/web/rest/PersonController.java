package springboot.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot.domain.Person;
import springboot.repository.PersonRepository;
import springboot.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	PersonRepository personRepository;
	@Autowired
	private PersonService personService;

	/**
	 * 查询所有人员列表
	 *
	 * @return
	 */
	@GetMapping(value = "/person")
	private List<Person> personList() {
		return personRepository.findAll();
	}

	/**
	 * 添加一个人员
	 *
	 * @param name
	 * @param age
	 * @return
	 */
	@PostMapping(value = "/person")
	public Person personAdd(@RequestParam("name") String name, @RequestParam("age") Integer age) {
		Person person = new Person();
		person.setName(name);
		person.setAge(age);

		return personRepository.save(person);
	}

	/**
	 * 查询一个人员
	 *
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/person/{id}")
	public Person personFindOne(@PathVariable("id") Integer id) {
		return personRepository.findOne(id);
	}

	/**
	 * 删除一个人员
	 *
	 * @param id
	 */
	@DeleteMapping(value = "/person/{id}")
	public void personDelete(@PathVariable("id") Integer id) {
		personRepository.delete(id);
	}

	/**
	 * 更新一个人员
	 *
	 * @param id
	 * @param name
	 * @param age
	 * @return
	 */
	@PutMapping(value = "/person/{id}")
	public Person personUpdate(@PathVariable("id") Integer id, @RequestParam("name") String name,
			@RequestParam("age") Integer age) {
		Person person = new Person();
		person.setId(id);
		person.setName(name);
		person.setAge(age);
		return personRepository.save(person);
	}

	/**
	 * 通过年龄来查询
	 *
	 * @param age
	 * @return
	 */
	@GetMapping(value = "/person/age/{age}")
	public List<Person> personListByAge(@PathVariable("age") Integer age) {
		return personRepository.findByAge(age);
	}

	/**
	 * 事务测试
	 */
	@PostMapping("/person/two")
	public void personTwo() {
		personService.insertTwo();
	}
}
