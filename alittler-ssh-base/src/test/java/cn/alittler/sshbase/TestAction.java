package cn.alittler.sshbase;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class TestAction extends ActionSupport {

	@Resource
	private TestService testService;

	@Override
	public String execute() throws Exception {
		System.out.println("---->TestAction.execute()");
		// testService.saveTwoUsers(); // 整合成功与否测试,测试Hibernate事务
		return "success";
	}

}
