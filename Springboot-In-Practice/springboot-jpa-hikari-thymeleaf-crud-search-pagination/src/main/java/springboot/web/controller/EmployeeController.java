package springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import springboot.domain.Employee;
import springboot.repository.EmployeeRepository;
import springboot.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/employee/initial")
	public String testData() {
		for (int i = 1; i <= 200; i++) {
			Employee employee = new Employee();
			employee.setEmpName("--" + i + "--");
			employee.setEmpPosition("--" + i + "--");
			double salary = i * Math.random() * 10000;
			employee.setEmpSalary((float) salary);
			employeeService.saveEmployee(employee);
		}
		return "redirect:/";
	}

	@GetMapping("/")
	public ModelAndView list(@PageableDefault(size = 9) Pageable pageable,
			@RequestParam(name = "name", required = false, defaultValue = "") String name,
			@RequestParam(name = "position", required = false, defaultValue = "") String position, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("position", position);
		//return new ModelAndView("index", "allEmployees",
		//		employeeRepository.findEmployeesByEmpNameContainingAndEmpPositionContaining(name, position, pageable));
		return new ModelAndView("index", "allEmployees",
				employeeService.findEmployeesByEmpNameContainingAndEmpPositionContaining(name, position, pageable));
	}

	@GetMapping("/employee/formUI")
	public String formUI(Model model) {
		model.addAttribute("editEmployee", new Employee());
		return "editPage";
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
