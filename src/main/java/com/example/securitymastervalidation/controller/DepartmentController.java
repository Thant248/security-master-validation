package com.example.securitymastervalidation.controller;

import com.example.securitymastervalidation.annotation.department.DepartmentCreate;
import com.example.securitymastervalidation.annotation.department.DepartmentDelete;
import com.example.securitymastervalidation.annotation.department.DepartmentRead;
import com.example.securitymastervalidation.annotation.department.DepartmentUpdate;
import com.example.securitymastervalidation.entity.Dapartment;
import com.example.securitymastervalidation.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;


    @DepartmentCreate
    @GetMapping("/create")
    public String findAllDepartment(Model model){
        model.addAttribute("department",new Dapartment());
        return "departmentForm";
    }
    @DepartmentCreate
    @PostMapping("/save")
    public String saveDepartment(Dapartment dapartment, BindingResult result){
        if (result.hasErrors()){
            return "departmentForm";
        }
        departmentService.saveDepartment(dapartment);
        return  "redirect:/department/list";
    }

    @DepartmentRead
    @GetMapping("/list")
    public String listDepartment(Model model){
        model.addAttribute("departments",departmentService.listAllDepartment());
        return "DepartmentList";
    }

    @DepartmentDelete
    @GetMapping("/delete")
    public String deleteById(@RequestParam("id")int id){
        departmentService.deleteById(id);
        return "redirect:/department/list";
    }

    int id;
    @DepartmentUpdate
    @GetMapping("/update")
    public String updateForm(@RequestParam("id")int id,Model model){

        model.addAttribute("departmentU",departmentService.findDepartmentByid(id));
        this.id = id;
        return "departments";
    }

    @DepartmentUpdate
    @PostMapping("/save-update")
    public String saveUpdate(Dapartment dapartment,BindingResult result){

        if (result.hasErrors()){
            return "departments";
        }
        dapartment.setId(id);
        departmentService.updateDepartment(dapartment);
        return "redirect:/department/list";
    }
}
