package com.example.midterm.Controllers;

import com.example.midterm.Dao.CustomersDao;
import com.example.midterm.Models.Customers;
import com.example.midterm.Repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public @ResponseBody Iterable<Customers> getAllUsers() {
        // This returns a JSON or XML with the users
        return customersRepository.findAll();
    }

    // Add new customer into table
    @PostMapping("/addcustomer")
    public String addCustomer(@RequestBody Customers customers) {
        customersDao.create(customers);

        return "redirect:customers";
    }
}
