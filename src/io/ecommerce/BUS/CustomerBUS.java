package io.ecommerce.BUS;

import io.ecommerce.DAL.CustomerDAL;
import io.ecommerce.DTO.Customer;

import java.util.ArrayList;

public class CustomerBUS {
    private CustomerDAL _customerDAL = new CustomerDAL();

    public ArrayList<Customer> getAllCustomers() {
        return _customerDAL.getAllCustomers();
    }

    public ArrayList<Customer> getCustomerByIdOrName(String key) {
        return _customerDAL.getCustomerByIdOrName(key);
    }

    public boolean addCustomer(Customer customer) {
        return _customerDAL.addCustomer(customer);
    }

    public boolean updateCustomerById(Customer customer) {
        return _customerDAL.updateCustomerById(customer);
    }

    public boolean deleteCustomerById(String id) {
        return _customerDAL.deleteCustomerById(id);
    }
}