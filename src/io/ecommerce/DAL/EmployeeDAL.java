package io.ecommerce.DAL;

import io.ecommerce.Connection;
import io.ecommerce.DTO.Employee;

import java.util.ArrayList;

public class EmployeeDAL implements Connection {
    public ArrayList<Employee> getAllEmployees() {
        return null;
    }

    public Employee getEmployeeByIdOrName(String key) {
        return null;
    }

    public boolean updateEmployeeById(String id) {
        return false;
    }

    public boolean deleteEmployeeById(String id) {
        return false;
    }
}