package cn.alittler.sshbase.dao.impl;

import org.springframework.stereotype.Repository;

import cn.alittler.sshbase.base.BaseDaoImpl;
import cn.alittler.sshbase.bean.User;
import cn.alittler.sshbase.dao.UserDao;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	
}
