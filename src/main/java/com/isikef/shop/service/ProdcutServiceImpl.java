package com.isikef.shop.service;

import com.isikef.shop.entities.Marque;
import com.isikef.shop.entities.Product;
import com.isikef.shop.exception.MissingEntity;

import com.isikef.shop.form.ProductForm;
import com.isikef.shop.repository.ProductRepository;
import com.isikef.shop.repository.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProdcutServiceImpl implements ProductService{
    //Une classe qui implement l'interface

    @Autowired
    ProductRepository productRepository;
    @Autowired
    MarqueRepository marqueRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
    public Marque getMarqueById(Long id) throws MissingEntity{
        Optional<Marque> marque = marqueRepository.findById(id);
        if(!marque.isPresent()){
            throw new MissingEntity("Marque not found with id : "+id);
        }
        return marque.get();
    }
    @Override // entrain d'implementer une methode d'interface ProdcutService
    public Product addProduct(ProductForm form) throws MissingEntity {
        Marque marque = getMarqueById(form.getMarqueId());
        Product product = new Product();
        product.setMarque(marque);       //check profanity for product name
        product.setRefProduct(form.getRef());
        product.setNomProduct(form.getNom());
        product.setCouleur(form.getCouleur());
        product.setPrixUnitaireHt(form.getPrix());
        product.setQteStock(form.getQte());
        product.setDescription(form.getDescription());
        return productRepository.save(product);
    }

    @Override
    public Product getProduct(Long id) throws MissingEntity {

        Optional<Product> product = productRepository.findById(id);
        if (!product.isPresent()){
            throw new MissingEntity("Product not found with id : "+id);
        }
        return product.get();
    }



    @Override
    public Map<String, Boolean> deleteProduct(Long id) throws MissingEntity {
        Product product = getProduct(id);
        //check details
        productRepository.delete(product);
        Map<String,Boolean> map = new HashMap<>();
        map.put("deleted",Boolean.TRUE);
        return map;
    }

    @Override
    public List<Product> searchByProductName(String text) {
        return productRepository.findByNomProductLike("%"+text+"%");
    }

    @Override
    public List<Product> searchByPrice(double min, double max) throws MissingEntity {
        return null;
    }
    @Override
    public List<Product> searchByPriceAndName(String text, double min, double max) throws MissingEntity {
        return productRepository.findByNomProductLikeAndPrixUnitaireHtBetween("%"+text+"%",min,max);
    }

    @Override
    public List<Product> searchByMarque(String text) throws MissingEntity {
        return productRepository.findByMarqueNomLike("%"+text+"%");
    }


    @Override
    public Product updateProduct(Long id, ProductForm form) throws MissingEntity {
        //check profanity for product name
        Product product = getProduct(id);
        product.setRefProduct(form.getRef());
        product.setNomProduct(form.getNom());
        product.setCouleur(form.getCouleur());
        product.setPrixUnitaireHt(form.getPrix());
        product.setQteStock(form.getQte());
        product.setDescription(form.getDescription());
        return productRepository.save(product);
    }
}
