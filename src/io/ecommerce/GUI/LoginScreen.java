package io.ecommerce.GUI;

import io.ecommerce.Credentials.CredentialsHandler;
import io.ecommerce.Credentials.EmptyCredentialsHandler;
import io.ecommerce.Credentials.IHandler;

import javax.swing.*;
import java.awt.*;

public class LoginScreen extends JFrame {
    private JPanel loginPanel;
    private JTextField emailTextField;
    private JTextField passwordTextField;
    private JButton loginButton;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JButton exitButton;

    private static volatile LoginScreen _loginScreenInstance = null;

    private LoginScreen() {
        setTitle("Đăng nhập");
        setContentPane(loginPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(400, 300));
        pack();

        EmptyCredentialsHandler emptyCredentialsHandler = new EmptyCredentialsHandler(this);
        CredentialsHandler credentialsHandler = new CredentialsHandler(this);
        emptyCredentialsHandler.setNext(credentialsHandler);

        loginButton.addActionListener(e -> _validateCredentials(emptyCredentialsHandler));

        exitButton.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void _validateCredentials(IHandler handler) {
        Thread thread = new Thread(() -> {
            if (handler.handleCredentials(emailTextField.getText().trim(), passwordTextField.getText().trim())) {
                ProductScreen.getProductScreenInstance();
                dispose();
            }
        });
        thread.start();
    }

    public static LoginScreen getLoginScreenInstance() {
        synchronized (LoginScreen.class) {
            if (_loginScreenInstance == null) {
                _loginScreenInstance = new LoginScreen();
            }
        }
        return _loginScreenInstance;
    }

    public static void main(String[] args) {
        LoginScreen.getLoginScreenInstance();
    }
}