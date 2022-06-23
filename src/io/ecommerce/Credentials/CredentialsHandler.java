package io.ecommerce.Credentials;

import io.ecommerce.BUS.EmployeeBUS;
import io.ecommerce.DTO.Employee;

import javax.swing.*;

public class CredentialsHandler extends AbstractHandler {
    public CredentialsHandler(JFrame frame) {
        super(frame);
    }

    @Override
    public boolean handleCredentials(String email, String password) {
        EmployeeBUS employeeBUS = new EmployeeBUS();
        Employee employee = employeeBUS.getEmployeeByCredentials(email, password);
        if (employee != null) {
            return true;
        }

        JOptionPane.showMessageDialog(
                _frame,
                "Đăng nhập không thành công. Kiểm tra email và mật khẩu.",
                "!!!",
                JOptionPane.ERROR_MESSAGE
        );
        return super.handleCredentials(email, password);
    }
}