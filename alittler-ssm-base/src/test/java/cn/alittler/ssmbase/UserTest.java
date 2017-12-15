package cn.alittler.ssmbase;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.alittler.ssmbase.entity.User;
import cn.alittler.ssmbase.service.UserService;

public class UserTest {

	private UserService userService;

	@SuppressWarnings("resource")
	@Before
	public void before() {
		String[] strArray = new String[] { "classpath:spring.xml", "classpath:spring-mybatis.xml" };
		ApplicationContext ac = new ClassPathXmlApplicationContext(strArray);
		userService = (UserService) ac.getBean("userServiceImpl");
	}

	@Test
	public void addUser() {
		User user = new User();
		user.setState(2);
		user.setNickname("刘大帅");
		System.out.println(user);
		System.out.println(userService.hashCode());
		// System.out.println(userService.insertUser(user));
	}

}
