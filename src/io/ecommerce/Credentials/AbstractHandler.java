package io.ecommerce.Credentials;

import javax.swing.*;

public abstract class AbstractHandler implements IHandler {
    protected IHandler _nextHandler;
    protected JFrame _frame;

    public AbstractHandler(JFrame frame) {
        _frame = frame;
    }

    @Override
    public IHandler setNext(IHandler handler) {
        _nextHandler = handler;
        return _nextHandler;
    }

    @Override
    public boolean handleCredentials(String email, String password) {
        if (_nextHandler != null) {
            return _nextHandler.handleCredentials(email, password);
        }
        return false;
    }
}