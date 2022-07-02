package io.ecommerce.DTO;

import java.time.LocalDate;

public class TransactionLog {
    private String _transactionId;
    private String _employeeId;
    private String _customerId;
    private String _productId;
    private String _employeeName;
    private String _customerName;
    private String _productName;
    private long _quantity;
    private double _price;
    private LocalDate _transactionTime;

    public TransactionLog() {}

    public TransactionLog(
            String transactionId,
            String employeeId,
            String customerId,
            String productId,
            String employeeName,
            String customerName,
            String productName,
            long quantity,
            double price,
            LocalDate transactionTime)
    {
        _transactionId = transactionId;
        _employeeId = employeeId;
        _customerId = customerId;
        _productId = productId;
        _employeeName = employeeName;
        _customerName = customerName;
        _productName = productName;
        _quantity = quantity;
        _price = price;
        _transactionTime = transactionTime;
    }

    public String getTransactionId() {
        return _transactionId;
    }

    public void setTransactionId(String transactionId) {
        if (!transactionId.isEmpty()) {
            _transactionId = transactionId;
        }
    }

    public String getEmployeeId() {
        return _employeeId;
    }

    public void setEmployeeId(String employeeId) {
        if (!employeeId.isEmpty()) {
            _employeeId = employeeId;
        }
    }

    public String getCustomerId() {
        return _customerId;
    }

    public void setCustomerId(String customerId) {
        if (!customerId.isEmpty()) {
            _customerId = customerId;
        }
    }

    public String getProductId() {
        return _productId;
    }

    public void setProductId(String productId) {
        if (!productId.isEmpty()) {
            _productId = productId;
        }
    }

    public String getEmployeeName() {
        return _employeeName;
    }

    public void setEmployeeName(String employeeName) {
        if (!employeeName.isEmpty()) {
            _employeeName = employeeName;
        }
    }

    public String getCustomerName() {
        return _customerName;
    }

    public void setCustomerName(String customerName) {
        if (!customerName.isEmpty()) {
            _customerName = customerName;
        }
    }

    public String getProductName() {
        return _productName;
    }

    public void setProductName(String productName) {
        if (!productName.isEmpty()) {
            _productName = productName;
        }
    }

    public Long getQuantity() {
        return _quantity;
    }

    public void setQuantity(Long quantity) {
        _quantity = quantity;
    }

    public Double getPrice() {
        return _price;
    }

    public void setPrice(Double price) {
        _price = price;
    }

    public LocalDate getTransactionTime() {
        return _transactionTime;
    }

    public void setTransactionTime(LocalDate transactionTime) {
        _transactionTime = transactionTime;
    }
}