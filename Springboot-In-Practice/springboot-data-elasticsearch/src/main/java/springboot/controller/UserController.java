package springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import springboot.domain.User;
import springboot.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	// http://localhost:8080/get/es/user?id=AWAcnLU0Ff2hBMG1wH25
	/**
	 * 测试根据id查询elasticsearch数据
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/get/es/user")
	@ResponseBody
	public ResponseEntity<Object> get(@RequestParam(name = "id", defaultValue = "") String id) {
		if (id.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		User user = userRepository.findOne(id);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(user, HttpStatus.OK);
	}

	// http://localhost:8080/get/es/users
	/**
	 * 查询所有
	 * 
	 * @return
	 */
	@GetMapping("/get/es/users")
	@ResponseBody
	public ResponseEntity<Object> getAll() {
		Iterable<User> users = userRepository.findAll();
		List<User> us = new ArrayList<>();
		for (User user : users) {
			us.add(user);
		}
		return new ResponseEntity<Object>(us, HttpStatus.OK);
	}

}
