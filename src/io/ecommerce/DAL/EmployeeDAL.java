package io.ecommerce.DAL;

import io.ecommerce.ConnectionConfigurator;
import io.ecommerce.DTO.Employee;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAL implements ConnectionConfigurator {
    public ArrayList<Employee> getAllEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM Employees;";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        )
        {
            while (resultSet.next()) {
                Employee employee = new Employee();
                //TODO:
                //employee's properties
                employees.add(employee);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return employees;
    }

    public Employee getEmployeeByIdOrName(String key) {
        Employee employee = new Employee();
        String query = "SELECT * FROM Employees WHERE employee_id = ? OR full_name = ?;";

        try (Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {
            preparedStatement.setString(1, key);
            preparedStatement.setString(2, key);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                while (resultSet.next()) {
                    //TODO:
                    //employee's properties
                }
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return employee;
    }

    public boolean updateEmployeeById(String id, Employee employee) {
        int rowUpdated = 0;
        String query = """
                UPDATE Employees SET 
                full_name = ?, 
                email = ?, 
                birth_date = ?, 
                gender = ? 
                WHERE employ_id = ?;
                """;

        try (Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {
            preparedStatement.setString(1, employee.getFullName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setDate(3, (Date)employee.getBirthdate());
            preparedStatement.setString(4, employee.getGender().toString());
            preparedStatement.setString(5, employee.getEmployeeId());
            rowUpdated = preparedStatement.executeUpdate();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return rowUpdated > 0;
    }

    public boolean deleteEmployeeById(String id) {
        int rowDeleted = 0;
        String query = "DELETE FROM Employees WHERE employ_id = ?;";

        try (Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {
            preparedStatement.setString(1, id);
            rowDeleted = preparedStatement.executeUpdate();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return rowDeleted > 0;
    }
}