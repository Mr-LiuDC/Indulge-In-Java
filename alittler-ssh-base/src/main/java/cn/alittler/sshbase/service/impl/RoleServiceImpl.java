package cn.alittler.sshbase.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.alittler.sshbase.bean.Role;
import cn.alittler.sshbase.dao.RoleDao;
import cn.alittler.sshbase.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDao roleDao;

	public void delete(Long id) {
		roleDao.delete(id);
	}

	public List<Role> findAll() {
		return roleDao.findAll();
	}

	public void save(Role role) {
		roleDao.save(role);
	}

	public Role getById(Long id) {
		return roleDao.getById(id);
	}

	public void update(Role role) {
		roleDao.update(role);
	}

}
