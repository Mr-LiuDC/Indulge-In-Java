package cn.alittler.sshbase.service.impl;

import org.springframework.stereotype.Service;

import cn.alittler.sshbase.service.XxxService;

//使用Spring提供的@Service注解将UserServiceImpl标注为一个Service
@Service("xxxService")
public class XxxServiceImpl implements XxxService {

	public void just_test() {
		System.out.println("Hello Word ! This is a test off XxxServiceImpl's just_test method.");
	}

}
