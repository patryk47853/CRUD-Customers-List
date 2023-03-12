package pl.patrykjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.patrykjava.SortingValues;
import pl.patrykjava.entity.Customer;
import pl.patrykjava.service.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/home")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String customersList(Model theModel,
                                @RequestParam(required = false) String sort) {

        List<Customer> myCustomers = null;

        if(sort != null) {
            int sortField = Integer.parseInt(sort);
            myCustomers = customerService.getCustomers(sortField);
        } else {
            myCustomers = customerService.getCustomers(SortingValues.LAST_NAME);
        }

        theModel.addAttribute("customers", myCustomers);

        return "customers";
    }

    @GetMapping("/search")
    public String searchCustomer(@RequestParam("customerName") String customerName,
                                 Model theModel) {
        List<Customer> myCustomers = customerService.searchCustomers(customerName);

        theModel.addAttribute("customers", myCustomers);

        return "customers";
    }

    @GetMapping("/addCustomer")
    public String addCustomer(Model theModel) {

        Customer theCustomer = new Customer();

        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

        customerService.saveCustomer(theCustomer);

        return "redirect:/home/list";
    }

    @GetMapping("/updateCustomer")
    public String updateCustomer(@RequestParam("customerId") int customerId, Model theModel) {

        Customer myCustomer = customerService.getCustomer(customerId);

        theModel.addAttribute("customer", myCustomer);

        return "customer-form";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId") int customerId) {

        customerService.deleteCustomer(customerId);

        return "redirect:/home/list";
    }
}
