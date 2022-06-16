package io.ecommerce.DTO;

import io.ecommerce.Gender;
import io.ecommerce.Utility;

import java.util.Date;

public class Employee {
    private String _employeeId;
    private String _email;
    private String _name;
    private Date _birthDate;
    private Gender _gender;

    public Employee() {}

    public Employee(
            String employeeId,
            String email,
            String name,
            Date birthDate,
            Gender gender)
    {
        _employeeId = employeeId;
        _email = email;
        _name = name;
        _birthDate = birthDate;
        _gender = gender;
    }

    public String getEmployeeId() {
        return _employeeId;
    }

    public void setEmployeeId(String employeeId) {
        if (!employeeId.isEmpty()) {
            _employeeId = employeeId;
        }
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        if (Utility.validateEmail(email)) {
            _email = email;
        }
    }

    public Date getBirthdate() {
        return _birthDate;
    }

    public void setBirthdate(Date birthDate) {
        _birthDate = birthDate;
    }

    public Gender getGender() {
        return _gender;
    }

    public void setGender(Gender gender) {
        _gender = gender;
    }
}