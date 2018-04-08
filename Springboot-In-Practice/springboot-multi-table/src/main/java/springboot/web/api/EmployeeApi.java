package springboot.web.api;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EmployeeApi
 *
 * @author LiuDeCai
 * @date 2018/04/08
 */
@RestController
@RequestMapping(value = "/api/employee")
@Api("员工信息操作接口")
public class EmployeeApi {



}
