package springboot.web.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import springboot.domain.Employee;
import springboot.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/")
	public String savePage(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("allEmployees", (ArrayList<Employee>) employeeService.getAllEmployees());
		return "index";
	}

	@PostMapping("/employee/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee,
			final RedirectAttributes redirectAttributes) {
		if (employeeService.saveEmployee(employee) != null) {
			redirectAttributes.addFlashAttribute("saveEmployee", "success");
		} else {
			redirectAttributes.addFlashAttribute("saveEmployee", "unsuccess");
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/employee/{operation}/{empId}", method = RequestMethod.GET)
	public String editRemoveEmployee(@PathVariable("operation") String operation, @PathVariable("empId") String empId,
			final RedirectAttributes redirectAttributes, Model model) {
		if (operation.equals("delete")) {
			if (employeeService.deleteEmployee(empId)) {
				redirectAttributes.addFlashAttribute("deletion", "success");
			} else {
				redirectAttributes.addFlashAttribute("deletion", "unsuccess");
			}
		} else if (operation.equals("edit")) {
			Employee editEmployee = employeeService.findEmployee(empId);
			if (editEmployee != null) {
				model.addAttribute("editEmployee", editEmployee);
				return "editPage";
			} else {
				redirectAttributes.addFlashAttribute("status", "notfound");
			}
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/employee/update", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("editEmployee") Employee editEmployee,
			final RedirectAttributes redirectAttributes) {
		if (employeeService.editEmployee(editEmployee) != null) {
			redirectAttributes.addFlashAttribute("edit", "success");
		} else {
			redirectAttributes.addFlashAttribute("edit", "unsuccess");
		}
		return "redirect:/";
	}

}
