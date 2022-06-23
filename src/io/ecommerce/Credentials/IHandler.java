package io.ecommerce.Credentials;

public interface IHandler {
    IHandler setNext(IHandler handler);
    boolean handleCredentials(String email, String password);
}