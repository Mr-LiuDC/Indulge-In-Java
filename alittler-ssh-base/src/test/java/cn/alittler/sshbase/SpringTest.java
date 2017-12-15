package cn.alittler.sshbase;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.alittler.sshbase.service.XxxService;

public class SpringTest {

	private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

	@Test
	public void testBean() {
		TestAction testAction = (TestAction) ac.getBean("testAction");
		System.out.println(testAction);
	}

	@Test
	public void testXxxService() {
		// 从Spring的IOC容器中获取bean对象
		XxxService xxxService = (XxxService) ac.getBean("xxxService");
		// 执行测试方法
		xxxService.just_test();
	}

	// 测试SessionFactory
	@Test
	public void testSessionFactory() {
		SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
		System.out.println(sessionFactory);
	}

	@Test
	// 测试事务
	public void testTransaction() {
		TestService testService = (TestService) ac.getBean("testService");
		System.out.println(testService);
		// testService.saveTwoUsers(); // 打开这里进行事务测试
	}

}
