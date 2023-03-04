package pl.patrykjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.patrykjava.dao.CustomerDAO;
import pl.patrykjava.entity.Customer;

import java.util.List;

@Controller
@RequestMapping("/home")
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @GetMapping("/list")
    public String customersList(Model theModel) {

        List<Customer> myCustomers = customerDAO.getCustomers();

        theModel.addAttribute("customers", myCustomers);

        return "customers";
    }
}
