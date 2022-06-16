package io.ecommerce.DAL;

import io.ecommerce.Connection;
import io.ecommerce.DTO.Product;

import java.util.ArrayList;

public class ProductDAL implements Connection {
    public ArrayList<Product> getAllProducts() {
        return null;
    }

    public Product getProductByIdOrName(String key) {
        return null;
    }

    public boolean updateProductById(String id) {
        return false;
    }

    public boolean deleteProductById(String id) {
        return false;
    }
}