package com.isikef.shop.service;

import com.isikef.shop.entities.Commentaire;
import com.isikef.shop.entities.Product;
import com.isikef.shop.exception.MissingEntity;
import com.isikef.shop.form.CommentaireForm;
import com.isikef.shop.repository.CommentaireRepository;
import com.isikef.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class CommentaireServiceImpl implements CommentaireService {
    @Autowired
    CommentaireRepository commentaireRepository;
    @Autowired
    ProductRepository productRepository;
    @Override

    public List<Commentaire> getCommentaires() {
        return commentaireRepository.findAll();
    }

    public Product getProductById(Long id) throws MissingEntity {
        Optional<Product> product = productRepository.findById(id);
        if(!product.isPresent()){
            throw new MissingEntity("Product not found with id : "+id);
        }
        return product.get();
    }
    @Override
    public Commentaire addCommentaire(CommentaireForm form) throws MissingEntity {
        Product product = getProductById(form.getProductId());
        Commentaire commentaire = new Commentaire();
        commentaire.setProduct(product);
        commentaire.setDateCreate(form.getDateC());
        commentaire.setDateUpdate(form.getDateU());
        commentaire.setText(form.getTxt());
        return commentaireRepository.save(commentaire);
    }

    @Override
    public Commentaire getCommentaire(Long id) throws MissingEntity {
        Optional<Commentaire> commentaire = commentaireRepository.findById(id);
        if (!commentaire.isPresent()){
            throw new MissingEntity("Commentaire not found with id : "+id);
        }
        return commentaire.get();
    }

    @Override
    public Commentaire updateCommentaire(Long id, CommentaireForm form) throws MissingEntity {
        Commentaire commentaire = getCommentaire(id);
        commentaire.setDateCreate(form.getDateC());
        commentaire.setDateUpdate(form.getDateU());
        commentaire.setText(form.getTxt());
        return commentaireRepository.save(commentaire);
    }

    @Override
    public Map<String, Boolean> deleteCommentaire(Long id) throws MissingEntity {
        Commentaire commentaire = getCommentaire(id);
        //check details
        commentaireRepository.delete(commentaire);
        Map<String,Boolean> map = new HashMap<>();
        map.put("deleted",Boolean.TRUE);
        return map;
    }
}
