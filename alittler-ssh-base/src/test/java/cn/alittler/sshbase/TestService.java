package cn.alittler.sshbase;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.alittler.sshbase.bean.User;

@Service("testService")
public class TestService {

	// @Resource 注入bean
	@Resource
	private SessionFactory sessionFactory;

	@Transactional
	public void saveTwoUsers() {
		Session session = sessionFactory.getCurrentSession();

		session.save(new User());
		@SuppressWarnings("unused")
		int a = 1 / 0; // 这行会抛异常 ，用于测试事务
		session.save(new User());
		Class<? extends Session> classname = session.getClass();
		System.out.println(classname);

		System.out.println("Successfully Saveed Two Users ! ");
	}

}
