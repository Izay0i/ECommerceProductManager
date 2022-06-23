package io.ecommerce.Credentials;

import javax.swing.*;

public class EmptyCredentialsHandler extends AbstractHandler {
    public EmptyCredentialsHandler(JFrame frame) {
        super(frame);
    }

    @Override
    public boolean handleCredentials(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(
                    _frame,
                    "Email và mật khẩu không được để trống.",
                    "!!!",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        return super.handleCredentials(email, password);
    }
}