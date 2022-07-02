package io.ecommerce.DTO;

import io.ecommerce.Utility;

public class Customer {
    private String _customerId;
    private String _fullName;
    private String _phoneNumber;
    private String _email;
    private String _address;

    public Customer() {}

    public Customer(
            String customerId,
            String fullName,
            String phoneNumber,
            String email,
            String address)
    {
        _customerId = customerId;
        _fullName = fullName;
        _phoneNumber = phoneNumber;
        _email = email;
        _address = address;
    }

    public String getCustomerId() {
        return _customerId;
    }

    public void setCustomerId(String customerId) {
        if (!customerId.isEmpty()) {
            _customerId = customerId;
        }
    }

    public String getFullName() {
        return _fullName;
    }

    public void setFullName(String fullName) {
        if (!fullName.isEmpty()) {
            _fullName = fullName;
        }
    }

    public String getPhoneNumber() {
        return _phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!phoneNumber.isEmpty() && Utility.isPhoneNumberValid(phoneNumber)) {
            _phoneNumber = phoneNumber;
        }
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        if (!email.isEmpty() && Utility.isEmailValid(email)) {
            _email = email;
        }
    }

    public String getAddress() {
        return _address;
    }

    public void setAddress(String address) {
        if (!address.isEmpty()) {
            _address = address;
        }
    }
}