package springboot.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import springboot.domain.User;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/user", produces = APPLICATION_JSON_VALUE)
@Api(description = "用户管理")
@Log
public class UserRestController {

    private static Map<String, User> users = null;

    static {
        users = new HashMap<>();
        users.put("id-001", new User("id-001", "张三", "pwd-zhangsan", 29, "zhangsan@qq.com", new Date()));
        users.put("id-002", new User("id-002", "李四", "pwd-lisi", 30, "lisi@qq.com", new Date()));
        users.put("id-003", new User("id-003", "王五", "pwd-wangwu", 45, "wangwu@qq.com", new Date()));
        users.put("id-004", new User("id-004", "小米", "pwd-xiaomi", 20, "xiaomi@qq.com", new Date()));
        users.put("id-005", new User("id-005", "小东", "pwd-xiaodong", 21, "xiaodong@qq.com", new Date()));
        users.put("id-006", new User("id-006", "小明", "pwd-xiaoming", 12, "xiaoming@qq.com", new Date()));
        users.put("id-007", new User("id-007", "小西", "pwd-xiaoxi", 13, "xiaoxi@qq.com", new Date()));
        users.put("id-008", new User("id-008", "刘明", "pwd-liuming", 22, "liuming@qq.com", new Date()));
        users.put("id-009", new User("id-009", "张峰", "pwd-zhangfeng", 26, "zhangfeng@qq.com", new Date()));
        users.put("id-010", new User("id-010", "刘杰", "pwd-liujie", 18, "liujie@qq.com", new Date()));
        users.put("id-011", new User("id-011", "王小二", "pwd-wangxiaoer", 45, "wangxiaoer@qq.com", new Date()));
        users.put("id-012", new User("id-012", "赵东", "pwd-zhaodong", 27, "zhaodong@qq.com", new Date()));
    }

    @ApiOperation(value = "创建用户", notes = "将新增用户对象保存到数据库")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PostMapping
    //	public User insert(User user) {
    //		users.put(user.getId(), user);
    //		return user;
    //	}
    public User insert(@Valid @RequestBody User user, BindingResult bindingResults) {
        if (bindingResults.hasErrors()) {
            bindingResults.getAllErrors().forEach(bindingResult -> log.info(bindingResult.getDefaultMessage()));
        }
        users.put(user.getId(), user);
        return user;
    }

    @ApiOperation(value = "创建用户", notes = "另一种方式创建用户")
    @PostMapping("post")
    public User save(@RequestParam("id") String id, @RequestParam("username") String username,
                     @RequestParam("password") String password, @RequestParam("email") String email,
                     @RequestParam("age") Integer age, @RequestParam("createTime") Date createTime) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setAge(age);
        user.setCreateTime(createTime);
        users.put(id, user);
        return user;
    }

    @ApiOperation(value = "删除用户", notes = "根据ID删除用户信息")
    @DeleteMapping("/{id}")
    public Collection<User> delete(@PathVariable String id) {
        users.remove(id);
        return users.values();
    }

    @ApiOperation(value = "更新用户", notes = "根据ID更新用户信息")
    @PutMapping("/{id}")
    public User update(@PathVariable String id, @Valid @RequestBody User user, BindingResult bindingResults) {
        if (bindingResults.hasErrors()) {
            bindingResults.getAllErrors().forEach(bindingResult -> log.info(bindingResult.getDefaultMessage()));
        }
        users.put(id, user);
        return user;
    }

    @ApiOperation(value = "获取单个用户", notes = "根据ID获取单个用户信息")
    @GetMapping("/{id}")
    public User user(@PathVariable String id) {
        return users.get(id);
    }

    @ApiOperation(value = "用户列表", notes = "获取所有用户信息")
    @GetMapping
    public Collection<User> users() {
        return users.values();
    }

    @InitBinder
    public void initBinder(ServletRequestDataBinder servletRequestDataBinder) {
        servletRequestDataBinder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
    }

}
