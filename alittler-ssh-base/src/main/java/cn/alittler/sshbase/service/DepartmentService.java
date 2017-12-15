package cn.alittler.sshbase.service;

import java.util.List;

import cn.alittler.sshbase.bean.Department;

public interface DepartmentService {

	List<Department> findAll();

	void delete(Long id);

	void save(Department model);

	Department getById(Long id);

	void update(Department department);

}
