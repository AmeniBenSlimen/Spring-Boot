package com.isikef.shop.service;

import com.isikef.shop.entities.Marque;
import com.isikef.shop.entities.Product;
import com.isikef.shop.exception.DuplicateEntity;
import com.isikef.shop.exception.MissingEntity;
import com.isikef.shop.form.MarqueForm;
import com.isikef.shop.form.ProductForm;

import java.util.List;
import java.util.Map;

public interface MarqueService {
    public List<Marque> getMarques() throws DuplicateEntity;
    public Marque addMarque(String nom) throws DuplicateEntity;
    public Marque getMarque(Long id) throws DuplicateEntity;
    public Marque updateMarque(Long id, MarqueForm form) throws DuplicateEntity;
    public Map<String,Boolean> deleteMarque(Long id) throws DuplicateEntity;

}
