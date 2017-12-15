package cn.alittler.ssmbase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: 说明：浏览器访问 http://127.0.0.1:8080/ProjectName/mytest/index.do
 * @date: Created on 2016年11月20日
 * @author: Mr-LiuDC
 *
 */
@Controller
@RequestMapping("/mytest") // 模块命名空间
public class UserController {

	@RequestMapping("index") // mytest模块下面的index方法
	public String index() {
		return "test/test"; // 返回到jsp/test/test.jsp页面
	}

}
