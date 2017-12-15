package cn.alittler.sshbase.service;

import java.util.List;

import cn.alittler.sshbase.bean.Role;

public interface RoleService {

	void delete(Long id);

	// 查询所有
	List<Role> findAll();

	void save(Role role);

	Role getById(Long id);

	void update(Role role);

}
