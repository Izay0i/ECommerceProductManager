package io.ecommerce.DAL;

import io.ecommerce.ConnectionConfigurator;
import io.ecommerce.DTO.Product;

import java.sql.*;
import java.util.ArrayList;

public class ProductDAL implements ConnectionConfigurator {
    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();
        String query = "SELECT * FROM Products;";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        )
        {
            while (resultSet.next()) {
                Product product = new Product();
                //TODO:
                //product's properties
                products.add(product);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return products;
    }

    public Product getProductByIdOrName(String key) {
        Product product = new Product();
        String query = "SELECT * FROM Products WHERE product_id = ? OR name = ?;";

        try (Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {
            preparedStatement.setString(1, key);
            preparedStatement.setString(2, key);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                while (resultSet.next()) {
                    //TODO:
                    //product's properties
                }
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return product;
    }

    public boolean addProduct(Product product) {
        int rowInserted = 0;
        String query = """
                INSERT INTO Products (product_id, name, description, origin, manufacture_date, quantity, price, insurance_duration, discount_percentage, image_reference) 
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
                """;

        try (Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {
            preparedStatement.setString(1, product.getProductId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4, product.getOrigin());
            preparedStatement.setDate(5, (Date)product.getManufactureDate());
            preparedStatement.setLong(6, product.getQuantity());
            preparedStatement.setDouble(7, product.getPrice());
            preparedStatement.setLong(8, product.getInsuranceDuration());
            preparedStatement.setDouble(9, product.getDiscountPercentage());
            preparedStatement.setString(10, product.getImageReference());
            rowInserted = preparedStatement.executeUpdate();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return rowInserted > 0;
    }

    public boolean updateProductById(String id, Product product) {
        int rowUpdated = 0;
        String query = """
                UPDATE Products SET 
                name = ?, 
                description = ?, 
                origin = ?, 
                manufacture_date = ?, 
                quantity = ?, 
                price = ?, 
                insurance_duration = ?, 
                discount_percentage = ?, 
                image_reference = ? 
                WHERE product_id = ?;
                """;

        try (Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setString(3, product.getOrigin());
            preparedStatement.setDate(4, (Date)product.getManufactureDate());
            preparedStatement.setLong(5, product.getQuantity());
            preparedStatement.setDouble(6, product.getPrice());
            preparedStatement.setLong(7, product.getInsuranceDuration());
            preparedStatement.setDouble(8, product.getDiscountPercentage());
            preparedStatement.setString(9, product.getImageReference());
            preparedStatement.setString(10, product.getProductId());
            rowUpdated = preparedStatement.executeUpdate();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return rowUpdated > 0;
    }

    public boolean deleteProductById(String id) {
        int rowDeleted = 0;
        String query = "DELETE FROM Products WHERE product_id = ?;";

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

        return false;
    }
}