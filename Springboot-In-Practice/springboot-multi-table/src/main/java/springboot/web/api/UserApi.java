package springboot.web.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import springboot.domain.User;
import springboot.repositroy.UserRepository;

/**
 * 用户操作API
 *
 * @author LiuDeCai
 */
@RestController
@RequestMapping(value = "/api/user")
@Api("用户操作接口")
public class UserApi {

    @Autowired
    private UserRepository userRepository;

    /**
     * 新增用户信息
     *
     * @param name
     * @param password
     * @return
     */
    @PostMapping()
    @ApiOperation(value = "新增用户", notes = "新增用户信息")
    public ModelMap saveUser(@RequestParam String name, @RequestParam String password) {
        ModelMap modelMap = new ModelMap();
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        User saveResult = userRepository.save(user);
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
     * @return
     */
    @DeleteMapping("{id}")
    @ApiOperation(value = "删除用户", notes = "删除用户信息")
    public ModelMap deleteUserById(@PathVariable String id) {
        ModelMap modelMap = new ModelMap();
        try {
            Long idNum = Long.parseLong(id);
            User user = userRepository.findOne(idNum);
            if (user == null) {
                modelMap.addAttribute("message", "要删除的用户不存在");
            }
            userRepository.delete(user);
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
     * @return
     */
    @PutMapping("{id}")
    @ApiOperation(value = "更新用户", notes = "更新用户信息")
    public ModelMap updateUserById(@PathVariable String id, @RequestParam String name, @RequestParam String password) {
        ModelMap modelMap = new ModelMap();
        try {
            Long idNum = Long.parseLong(id);
            User user = userRepository.findOne(idNum);
            if (user == null) {
                modelMap.addAttribute("message", "要更新的用户不存在");
            }
            user.setName(name);
            user.setPassword(password);
            User saveResult = userRepository.save(user);
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

    /**
     * 根据ID查询用户信息
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    @ApiOperation(value = "查询用户", notes = "根据ID查询用户信息")
    public ModelMap getUserById(@PathVariable String id) {
        ModelMap modelMap = new ModelMap();
        try {
            Long idNum = Long.parseLong(id);
            User user = userRepository.findOne(idNum);
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
     * @return
     */
    @GetMapping
    @ApiOperation(value = "分页查询用户", notes = "分页查询用户信息")
    public ModelMap listUserPage(@RequestParam(value = "pageNo", required = false, defaultValue = "0") String pageNoStr,
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
        Page<User> userPage = userRepository.findAll(pageable);
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
        Page<User> userPage = userRepository.findUsersByNameContains(name, pageable);
        modelMap.addAttribute("page", userPage);
        return modelMap;
    }

    /**
     * 获取一条最新记录
     *
     * @return
     */
    @GetMapping("/new")
    public ModelMap getLast() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("last", userRepository.findFirstByOrderByCreateTimeDesc());
        return modelMap;
    }

    /**
     * 获取一条最旧记录
     *
     * @return
     */
    @GetMapping("/oldest")
    public ModelMap getOldest() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("last", userRepository.findFirstByOrderByCreateTimeAsc());
        return modelMap;
    }

}
