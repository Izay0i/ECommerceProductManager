package io.ecommerce.DAL;

import io.ecommerce.ConnectionConfigurator;
import io.ecommerce.DTO.TransactionLog;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TransactionLogDAL implements ConnectionConfigurator {
    public ArrayList<TransactionLog> getAllTransactionLogs() {
        ArrayList<TransactionLog> transactionLogs = new ArrayList<>();
        String query = "SELECT * FROM TransactionLogs;";

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        )
        {
            while (resultSet.next()) {
                TransactionLog transactionLog = new TransactionLog();
                transactionLog.setTransactionId(resultSet.getString(1));
                transactionLog.setEmployeeId(resultSet.getString(2));
                transactionLog.setCustomerId(resultSet.getString(3));
                transactionLog.setProductId(resultSet.getString(4));
                transactionLog.setEmployeeName(resultSet.getString(5));
                transactionLog.setCustomerName(resultSet.getString(6));
                transactionLog.setProductName(resultSet.getString(7));
                transactionLog.setQuantity(resultSet.getLong(8));
                transactionLog.setPrice(resultSet.getDouble(9));
                transactionLog.setTransactionTime((LocalDate)resultSet.getObject(10));

                transactionLogs.add(transactionLog);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return transactionLogs;
    }

    public ArrayList<TransactionLog> getTransactionLogByIdOrDate(String key) {
        ArrayList<TransactionLog> transactionLogs = new ArrayList<>();
        String formattedKey = '%' + key + '%';
        String query = "SELECT * FROM TransactionLogs WHERE transaction_id LIKE ? OR transaction_time LIKE ?;";

        try (Connection connection = DriverManager.getConnection(url);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {
            preparedStatement.setString(1, formattedKey);
            preparedStatement.setString(2, formattedKey);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    TransactionLog transactionLog = new TransactionLog();
                    transactionLog.setTransactionId(resultSet.getString(1));
                    transactionLog.setEmployeeId(resultSet.getString(2));
                    transactionLog.setCustomerId(resultSet.getString(3));
                    transactionLog.setProductId(resultSet.getString(4));
                    transactionLog.setEmployeeName(resultSet.getString(5));
                    transactionLog.setCustomerName(resultSet.getString(6));
                    transactionLog.setProductName(resultSet.getString(7));
                    transactionLog.setQuantity(resultSet.getLong(8));
                    transactionLog.setPrice(resultSet.getDouble(9));
                    transactionLog.setTransactionTime((LocalDate)resultSet.getObject(10));

                    transactionLogs.add(transactionLog);
                }
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return transactionLogs;
    }

    public boolean addTransactionLog(TransactionLog transactionLog) {
        int rowInserted = 0;
        String query = """
                INSERT INTO TransactionLogs (transaction_id, employ_id, customer_id, product_id, employee_name, customer_name, name, quantity, price) 
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) 
                ON CONFLICT DO NOTHING;
                """;

        try (Connection connection = DriverManager.getConnection(url);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {
            preparedStatement.setString(1, transactionLog.getTransactionId());
            preparedStatement.setString(2, transactionLog.getEmployeeId());
            preparedStatement.setString(3, transactionLog.getCustomerId());
            preparedStatement.setString(4, transactionLog.getProductId());
            preparedStatement.setString(5, transactionLog.getEmployeeName());
            preparedStatement.setString(6, transactionLog.getCustomerName());
            preparedStatement.setString(7, transactionLog.getProductName());
            preparedStatement.setLong(8, transactionLog.getQuantity());
            preparedStatement.setDouble(9, transactionLog.getPrice());
            rowInserted = preparedStatement.executeUpdate();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return rowInserted > 0;
    }

    public boolean updateTransactionLogById(TransactionLog transactionLog) {
        int rowUpdated = 0;
        String query = """
                UPDATE TransactionLogs SET 
                employ_id = ?, 
                customer_id = ?, 
                product_id = ?, 
                employee_name = ?, 
                customer_name = ?, 
                name = ?, 
                quantity = ?, 
                price = ? 
                WHERE transaction_id = ?;
                """;

        try (Connection connection = DriverManager.getConnection(url);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {
            preparedStatement.setString(1, transactionLog.getEmployeeId());
            preparedStatement.setString(2, transactionLog.getCustomerId());
            preparedStatement.setString(3, transactionLog.getProductId());
            preparedStatement.setString(4, transactionLog.getEmployeeName());
            preparedStatement.setString(5, transactionLog.getCustomerName());
            preparedStatement.setString(6, transactionLog.getProductName());
            preparedStatement.setLong(7, transactionLog.getQuantity());
            preparedStatement.setDouble(8, transactionLog.getPrice());
            preparedStatement.setString(9, transactionLog.getTransactionId());
            rowUpdated = preparedStatement.executeUpdate();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return rowUpdated > 0;
    }

    public boolean deleteTransactionLogById(String id) {
        int rowDeleted = 0;
        String query = "DELETE FROM TransactionLogs WHERE transaction_id = ?;";

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