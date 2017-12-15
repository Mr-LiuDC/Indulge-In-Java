package cn.alittler.sshbase.view.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.alittler.sshbase.bean.Role;
import cn.alittler.sshbase.service.RoleService;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class RoleAction2 extends ActionSupport implements ModelDriven<Role> {

	@Resource
	private RoleService roleService;

	private Long id;
	private String name;
	private String description;

	private Role role = new Role();

	public Role getModel() {
		return role;
	}

	/** 列表 */
	public String list() throws Exception {
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}

	/** 删除 */
	public String delete() throws Exception {
		roleService.delete(id);
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {
		return "addUI";
	}

	/** 添加 */
	public String add() throws Exception {
		// 1.封装到对象中
		Role role = new Role();
		role.setName(name);
		role.setDescription(description);

		// 2.保存到数据库中
		roleService.save(role);
		// 3.最后跳转到数据显示页面
		return "toList";
	}

	/** 修改页面 */
	public String editUI() throws Exception {
		// 1.准备回显的数据
		Role role = roleService.getById(id);

		// 2.数据赋值
		// this.name = role.getName();
		// this.description = role.getDescription();
		// 下面这种方式更简单(使用栈的方式,OGNL表达式,要求jsp页面引入Struts标签库)
		ActionContext.getContext().getValueStack().push(role);

		// 3.带着数据跳转到编辑页面
		return "editUI";
	}

	/** 修改 */
	public String edit() throws Exception {
		// 1.从数据库获取原对象
		Role role = roleService.getById(id);
		// 2.设置要修改的属性
		role.setName(name);
		role.setDescription(description);
		// 3.更新到数据库
		roleService.update(role);
		// 4.修改成功后跳转到list页面
		return "toList";
	}

	// =======Getter And Setter=========

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
