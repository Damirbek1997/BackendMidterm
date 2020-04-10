package com.example.midterm.Controllers;

import com.example.midterm.Models.Customers;
import com.example.midterm.Repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    CustomersRepository customersRepository;

    // Retrieves all customers from database
    @GetMapping("/customers")
    public String getAllCustomers(Model model) {
        List<Customers> customers = customersRepository.findAll();

        if (customers != null)
            model.addAttribute("customers", customers);

        return "customers";
    }

    // Get page add customer
    @GetMapping("/add_customer")
    public String getAddCustomerPage() {
        return "add_customer";
    }

    // Add new customer into table
    @PostMapping("/add_customer")
    public String addCustomer(Customers customers) {
        customersRepository.save(customers);
        return "redirect:/customers";
    }
}
