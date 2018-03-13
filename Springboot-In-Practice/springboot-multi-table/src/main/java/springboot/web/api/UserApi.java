package springboot.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springboot.domain.User;
import springboot.repositroy.UserRepositroy;

/**
 * 用户操作API
 * 
 * @author LiuDeCai
 *
 */
@RestController
@RequestMapping(value = "/api/user")
@Api("用户操作接口")
public class UserApi {

	@Autowired
	private UserRepositroy userRepositroy;

	/**
	 * 新增用户信息
	 * 
	 * @param name
	 * @param password
	 * @param modelMap
	 * @return
	 */
	@PostMapping()
	@ApiOperation(value = "新增用户", notes = "新增用户信息")
	public ModelMap saveUser(@RequestParam String name, @RequestParam String password) {
		ModelMap modelMap = new ModelMap();
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		User saveResult = userRepositroy.save(user);
		if (saveResult != null) {
			modelMap.addAttribute("message", "成功添加用户信息");
			modelMap.addAttribute("user", saveResult);
		} else {
			modelMap.addAttribute("message", "添加用户信息失败");
		}
		return modelMap;
	}

	/**
	 * 根据ID删除用户信息
	 * 
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@DeleteMapping("{id}")
	@ApiOperation(value = "删除用户", notes = "删除用户信息")
	public ModelMap deleteUserById(@PathVariable String id) {
		ModelMap modelMap = new ModelMap();
		try {
			Long idNum = Long.parseLong(id);
			User user = userRepositroy.findOne(idNum);
			if (user == null) {
				modelMap.addAttribute("message", "要删除的用户不存在");
			}
			userRepositroy.delete(user);
			return modelMap.addAttribute("message", "成功删除用户");
		} catch (Exception e) {
			return modelMap.addAttribute("message", "参数不合法");
		}
	}

	/**
	 * 根据ID更新用户信息
	 * 
	 * @param id
	 * @param name
	 * @param password
	 * @param modelMap
	 * @return
	 */
	@PutMapping("{id}")
	@ApiOperation(value = "更新用户", notes = "更新用户信息")
	public ModelMap deleteUserById(@PathVariable String id, @RequestParam String name, @RequestParam String password) {
		ModelMap modelMap = new ModelMap();
		try {
			Long idNum = Long.parseLong(id);
			User user = userRepositroy.findOne(idNum);
			if (user == null) {
				modelMap.addAttribute("message", "要更新的用户不存在");
			}
			user.setName(name);
			user.setPassword(password);
			User saveResult = userRepositroy.save(user);
			if (saveResult != null) {
				modelMap.addAttribute("message", "成功更新用户信息");
				modelMap.addAttribute("user", saveResult);
			} else {
				modelMap.addAttribute("message", "更新用户信息失败");
			}
			return modelMap;
		} catch (Exception e) {
			return modelMap.addAttribute("message", "参数不合法");
		}
	}

	@GetMapping("{id}")
	@ApiOperation(value = "查询用户", notes = "根据ID查询用户信息")
	public ModelMap getUserById(@PathVariable String id) {
		ModelMap modelMap = new ModelMap();
		try {
			Long idNum = Long.parseLong(id);
			User user = userRepositroy.findOne(idNum);
			if (user == null) {
				modelMap.addAttribute("message", "要查询的用户不存在");
			}
			return modelMap.addAttribute("user", user);
		} catch (Exception e) {
			return modelMap.addAttribute("message", "参数不合法");
		}
	}

	/**
	 * 分页查询用户信息
	 * 
	 * @param pageNoStr
	 * @param pageSizeStr
	 * @param sortStr
	 * @param modelMap
	 * @return
	 */
	@GetMapping
	@ApiOperation(value = "分页查询用户", notes = "分页查询用户信息")
	public ModelMap listUserPage(
			@RequestParam(value = "pageNo", required = false, defaultValue = "0") String pageNoStr,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") String pageSizeStr) {
		ModelMap modelMap = new ModelMap();
		int pageNo = 1;
		int pageSize = Integer.parseInt(pageSizeStr);
		try {
			pageNo = Integer.parseInt(pageNoStr);
			if (pageNo < 0) {
				pageNo = 0;
			}
		} catch (Exception e) {
		}

		PageRequest pageable = new PageRequest(pageNo, pageSize);
		Page<User> userPage = userRepositroy.findAll(pageable);
		modelMap.addAttribute("page", userPage);
		return modelMap;
	}

	/**
	 * 按用户名条件分页查询用户信息
	 * 
	 * @param pageNoStr
	 * @param pageSizeStr
	 * @param name
	 * @return
	 */
	@GetMapping("p")
	@ApiOperation(value = "条件查询用户", notes = "按用户名条件分页查询用户信息")
	public ModelMap listUserPageByParameter(
			@RequestParam(value = "pageNo", required = false, defaultValue = "0") String pageNoStr,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") String pageSizeStr,
			@RequestParam(value = "name", required = false, defaultValue = "") String name) {
		ModelMap modelMap = new ModelMap();
		int pageNo = 1;
		int pageSize = Integer.parseInt(pageSizeStr);
		try {
			pageNo = Integer.parseInt(pageNoStr);
			if (pageNo < 0) {
				pageNo = 0;
			}
		} catch (Exception e) {
		}

		PageRequest pageable = new PageRequest(pageNo, pageSize);
		Page<User> userPage = userRepositroy.findUsersByNameContains(name, pageable);
		modelMap.addAttribute("page", userPage);
		return modelMap;
	}

}
