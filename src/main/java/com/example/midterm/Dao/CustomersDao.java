package com.example.midterm.Dao;

import com.example.midterm.Models.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomersDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomersDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean create(Customers customer) {
        return jdbcTemplate.update("insert into customers (firstName, lastName, emailAddress, jobTitle, city, mobilePhone, webPage) " +
                "values (?, ?, ?, ?, ?, ?, ?)", customer.getFirstName(), customer.getLastName(), customer.getEmailAddress(), customer.getJobTitle(),
                customer.getCity(), customer.getMobilePhone(), customer.getWebPage()) == 1;
    }
}
