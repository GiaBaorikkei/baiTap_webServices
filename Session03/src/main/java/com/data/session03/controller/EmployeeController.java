package com.data.session03.controller;

import com.data.session03.entity.Employee;
import com.data.session03.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public String listEmployees(
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) Double salary,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            Model model) {

        List<Employee> employees;
        boolean isSearch = false;

        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            employees = employeeService.findEmployeeByPhoneNumber(phoneNumber);
            isSearch = true;
        } else if (salary != null) {
            employees = employeeService.findEmployeesBySalaryGreaterThan(salary);
            isSearch = true;
        } else {
            Page<Employee> employeePage = employeeService.getEmployeesWithPaging(page, size);
            model.addAttribute("employeePage", employeePage);
            employees = employeePage.getContent();
        }

        model.addAttribute("employees", employees);
        model.addAttribute("isSearch", isSearch);
        return "list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            return "redirect:/employees";
        }
        model.addAttribute("employee", employee);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id, @ModelAttribute("employee") Employee employee) {
        employee.setId(id);
        employeeService.updateEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }
}