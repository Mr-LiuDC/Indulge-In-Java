package cn.alittler.ssmbase.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.alittler.ssmbase.entity.Person;
import cn.alittler.ssmbase.entity.QueryCondition;
import cn.alittler.ssmbase.service.PersonService;

/**
 * @description: 浏览器访问 http://127.0.0.1:8080/ProjectName/person/listPerson.do
 * @date: Created on 2016年11月20日
 * @author: Mr-LiuDC
 *
 */
@Controller
@RequestMapping("/person") // 模块命名空间,便于浏览器URL中的访问
public class PersonController {

	@Autowired // 注入Service
	private PersonService personService;

	@RequestMapping("/listPerson.do")
	public String listPerson(QueryCondition qc, Model model) {
		System.out.println("=============>" + qc);
		List<Person> pList = personService.selectPersonByCondition(qc);
		model.addAttribute("pList", pList); // 用于将结果传到前端显示
		model.addAttribute("qc", qc); // 用于结果回显
		return "list"; // 根据list最后返回到list.jsp页面
	}

	/**
	 * 跳转到添加页面
	 * 
	 * @return
	 */
	@RequestMapping("/toSaveUI.do")
	public String toSaveUI() {
		return "saveUI"; // 返回到saveUI.jsp页面
	}

	/**
	 * 执行添加操作,添加完后跳转到list页面
	 * 
	 * @return
	 */
	@RequestMapping("/save.do")
	public String tosave(Person person) {
		personService.savePerson(person);
		return "redirect:listPerson.do";
	}

	/**
	 * 根据id查询Person，然后转到updateUI.jsp页面
	 * 
	 * @return
	 */
	@RequestMapping("/toUpdateUI.do")
	public String selectPer(Integer personId, Model model) {
		Person p = personService.selectPersonById(personId);
		model.addAttribute("person", p);
		return "updateUI";
	}

	/**
	 * 执行修改操作
	 * 
	 * @param person
	 * @return
	 */
	@RequestMapping("/update.do")
	public String doUpdate(Person person) {
		personService.update(person);
		return "redirect:listPerson.do";
	}

	/**
	 * 删除操作
	 * 
	 * @param person
	 * @return
	 */
	@RequestMapping("/delete.do")
	public String doDelete(Integer personId) {
		personService.delete(personId);
		return "redirect:listPerson.do";
	}

	/**
	 * 时间格式转换：yyyy-MM-dd
	 * 
	 * @param servletRequestDataBinder
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder servletRequestDataBinder) {
		servletRequestDataBinder.registerCustomEditor(Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

}
