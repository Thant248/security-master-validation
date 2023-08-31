package com.example.securitymastervalidation.controller;

import com.example.securitymastervalidation.annotation.customer.CustomerCreate;
import com.example.securitymastervalidation.annotation.customer.CustomerDelete;
import com.example.securitymastervalidation.annotation.customer.CustomerRead;
import com.example.securitymastervalidation.annotation.customer.CustomerUpdate;
import com.example.securitymastervalidation.entity.Customer;
import com.example.securitymastervalidation.service.CustomerService;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
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
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;


    @CustomerCreate
    @GetMapping("/create")
    public String customerForm(Model model){
        model.addAttribute("customer",new Customer());
        return "customerForm";
    }

    @CustomerCreate
    @PostMapping("/save")
    public String saveCustomer(Customer customer, BindingResult result){
        if (result.hasErrors()){
            return "customerForm";
        }
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @CustomerRead
    @GetMapping("/list")
    public String listAllCustomer(Model model){
       model.addAttribute("customers", customerService.findAllCustomer());
        return "customerList";
    }

    @CustomerDelete
    @GetMapping("/delete")
    public String deleteById(@RequestParam("id")int id){
        customerService.deleteCustomerById(id);
        return "redirect:/customer/list";
    }

    int id;
    @CustomerUpdate
    @GetMapping("/update")
    public String updateCustomer(@RequestParam("id")int id,Model model){
        model.addAttribute("customerU",customerService.findCustomerById(id));
        this.id = id;
        return "updateCustomer";
    }

    @CustomerUpdate
    @PostMapping("/save-update")
    public String  saveUpdate(Customer customer,BindingResult result){
        if (result.hasErrors()){
            return "updateCustomer";
        }
        customer.setId(id);
        customerService.updateCustomer(customer);
        return "redirect:/customer/list";
    }

}
