package com.example.midterm.Controllers;

import com.example.midterm.Dao.CustomersDao;
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

    @Autowired
    CustomersDao customersDao;

    // Returns home.html
    @RequestMapping("/home")
    public String getHomePage() {
        return "home";
    }

    // Retrieves all customers in table
    @GetMapping("/customers")
    public String getAllCustomers(Model model) {
        List<Customers> customers = customersRepository.findAll();

        if (customers != null) {
            model.addAttribute("customers", customers);
        }

        return "customers";
    }

    @GetMapping("/addcustomer")
    public String getAddCustomerPage() {
        return "add_customer";
    }

    // Add new customer into table
    @PostMapping("/addcustomer")
    public String addCustomer(@RequestBody Customers customers) {
//        customersDao.create(customers);
        customersRepository.save(customers);
        return "redirect:/customers";
    }
}
