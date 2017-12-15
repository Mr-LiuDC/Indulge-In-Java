package cn.alittler.ssmbase.dao;

import cn.alittler.ssmbase.entity.User;

/**
 * @description: UserDao接口类
 * @date: Created on 2016年11月20日
 * @author: Mr-LiuDC
 *
 */
public interface UserDao {
	/**
	 * 添加新用户
	 * 
	 * @return
	 */
	public int insertUser(User user);

}
