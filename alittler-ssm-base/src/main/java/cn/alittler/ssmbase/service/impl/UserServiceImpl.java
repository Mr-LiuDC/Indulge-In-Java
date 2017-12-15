package cn.alittler.ssmbase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.alittler.ssmbase.dao.UserDao;
import cn.alittler.ssmbase.entity.User;
import cn.alittler.ssmbase.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public int insertUser(User user) {
		return userDao.insertUser(user);
	}

}