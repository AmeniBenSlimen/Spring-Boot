package com.isikef.shop.service;

import com.isikef.shop.entities.Product;
import com.isikef.shop.exception.MissingEntity;
import com.isikef.shop.form.ProductForm;

import java.util.List;
import java.util.Map;


public interface ProductService {

    public List<Product> getProducts() throws MissingEntity;
    public Product addProduct(ProductForm form) throws MissingEntity;

    public Product getProduct(Long id) throws MissingEntity;
    public Product updateProduct(Long id, ProductForm form) throws MissingEntity;

    //On commence par service, interface delete
    public Map<String,Boolean> deleteProduct(Long id) throws MissingEntity;
    public List<Product> searchByProductName(String text);
    public List<Product> searchByPrice(double min , double max) throws MissingEntity;
    public List<Product> searchByPriceAndName(String name,double min,double max) throws MissingEntity;
    public List<Product> searchByMarque(String text) throws MissingEntity;
}
