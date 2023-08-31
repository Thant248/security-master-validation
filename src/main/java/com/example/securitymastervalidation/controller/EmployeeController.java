package com.example.securitymastervalidation.controller;

import com.example.securitymastervalidation.annotation.employee.EmployeeCreate;
import com.example.securitymastervalidation.annotation.employee.EmployeeDelete;
import com.example.securitymastervalidation.annotation.employee.EmployeeRead;
import com.example.securitymastervalidation.annotation.employee.EmployeeUpdate;
import com.example.securitymastervalidation.entity.Employee;
import com.example.securitymastervalidation.repository.EmployeeDao;
import com.example.securitymastervalidation.service.EmployeeService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeDao employeeDao;

    @EmployeeCreate
    @GetMapping("/employee/form")
    public String employeeForm(Model model){
        model.addAttribute("employee",new Employee());
        return "employee";
    }
    @EmployeeCreate
    @PostMapping("/save-employee")
    public String saveEmployee(Employee employee, BindingResult result){
        if (result.hasErrors()){
            return "employee";
        }
        employeeDao.save(employee);
        return  "redirect:/employees/employee/list";

    }

    @EmployeeRead
    @GetMapping("/employee/list")
    public String listEmployee(Model model){
        model.addAttribute("employees",employeeService.findAllEmployee());
        return "employees-list";
    }

    @EmployeeDelete
    @GetMapping("/delete")
    public String deleteById(@RequestParam("id")int id){
        employeeService.deleteById(id);
        return "redirect:/employees/employee/list";
    }

    int id;

    @EmployeeUpdate
    @GetMapping("/employee/update")
    public String updateEmployee(@RequestParam("id")int id,Model model){
        model.addAttribute("employeeU",employeeService.findEmployeeById(id));
        this.id= id;
        return "updateForm";
    }

    @EmployeeUpdate
    @PostMapping("/save-update")
    public String  saveUpdate(Employee employee,BindingResult result){
        if (result.hasErrors()){
            return "updateForm";
        }
        employee.setId(id);
        employeeService.updateEmployee(employee);
        return "redirect:/employees/employee/list";
    }




}
