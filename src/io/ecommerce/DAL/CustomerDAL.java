package io.ecommerce.DAL;

import io.ecommerce.ConnectionConfigurator;
import io.ecommerce.DTO.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAL implements ConnectionConfigurator {
    public ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM Customers ORDER BY customer_id DESC;";

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        )
        {
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(resultSet.getString(1));
                customer.setFullName(resultSet.getString(2));
                customer.setPhoneNumber(resultSet.getString(3));
                customer.setEmail(resultSet.getString(4));
                customer.setAddress(resultSet.getString(5));

                customers.add(customer);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return customers;
    }

    public ArrayList<Customer> getCustomerByIdOrName(String key) {
        ArrayList<Customer> customers = new ArrayList<>();
        String formattedKey = '%' + key + '%';
        String query = "SELECT * FROM Customers WHERE customer_id LIKE ? OR full_name LIKE ?;";

        try (Connection connection = DriverManager.getConnection(url);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {
            preparedStatement.setString(1, formattedKey);
            preparedStatement.setString(2, formattedKey);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Customer customer = new Customer();
                    customer.setCustomerId(resultSet.getString(1));
                    customer.setFullName(resultSet.getString(2));
                    customer.setPhoneNumber(resultSet.getString(3));
                    customer.setEmail(resultSet.getString(4));
                    customer.setAddress(resultSet.getString(5));

                    customers.add(customer);
                }
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return customers;
    }

    public boolean addCustomer(Customer customer) {
        int rowInserted = 0;
        String query = """
                INSERT INTO Customers (customer_id, full_name, phone, email, address) 
                VALUES (?, ?, ?, ?, ?) 
                ON CONFLICT DO NOTHING;
                """;

        try (Connection connection = DriverManager.getConnection(url);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {
            preparedStatement.setString(1, customer.getCustomerId());
            preparedStatement.setString(2, customer.getFullName());
            preparedStatement.setString(3, customer.getPhoneNumber());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setString(5, customer.getAddress());
            rowInserted = preparedStatement.executeUpdate();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return rowInserted > 0;
    }

    public boolean updateCustomerById(Customer customer) {
        int rowUpdate = 0;
        String query = """
                UPDATE Customers SET 
                full_name = ?, 
                phone = ?, 
                email = ?, 
                address = ? 
                WHERE customer_id = ?;
                """;

        try (Connection connection = DriverManager.getConnection(url);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {
            preparedStatement.setString(1, customer.getFullName());
            preparedStatement.setString(2, customer.getPhoneNumber());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setString(4, customer.getAddress());
            preparedStatement.setString(5, customer.getCustomerId());
            rowUpdate = preparedStatement.executeUpdate();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return rowUpdate > 0;
    }

    public boolean deleteCustomerById(String id) {
        int rowDeleted = 0;
        String query = "DELETE FROM Customers WHERE customer_id = ?;";

        try (Connection connection = DriverManager.getConnection(url);
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