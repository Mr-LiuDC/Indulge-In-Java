package cn.alittler.sshbase;

import org.junit.Test;

import cn.alittler.sshbase.dao.DepartmentDao;
import cn.alittler.sshbase.dao.RoleDao;
import cn.alittler.sshbase.dao.UserDao;
import cn.alittler.sshbase.dao.impl.DepartmentDaoImpl;
import cn.alittler.sshbase.dao.impl.RoleDaoImpl;
import cn.alittler.sshbase.dao.impl.UserDaoImpl;

public class BaseDaoTest {

	@Test
	public void test_Dao() {
		UserDao userDao = new UserDaoImpl();
		System.out.println(userDao);
		RoleDao roleDao = new RoleDaoImpl();
		System.out.println(roleDao);
		DepartmentDao departmentDao = new DepartmentDaoImpl();
		System.out.println(departmentDao);

	}

}
