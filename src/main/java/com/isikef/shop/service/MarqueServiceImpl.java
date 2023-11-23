package com.isikef.shop.service;

import com.isikef.shop.entities.Marque;
import com.isikef.shop.entities.Product;
import com.isikef.shop.exception.DuplicateEntity;
import com.isikef.shop.exception.MissingEntity;
import com.isikef.shop.form.MarqueForm;
import com.isikef.shop.form.ProductForm;
import com.isikef.shop.repository.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MarqueServiceImpl implements MarqueService{
    //Autowired : objet injecter
    @Autowired
    MarqueRepository marqueRepository;
    @Override
    public List<Marque> getMarques(){
        return marqueRepository.findAll();
    }


    public void chekNameNotUsed(String nom) throws DuplicateEntity{
        if (marqueRepository.existsByNom(nom))
            throw new DuplicateEntity("le nom est déja utilisé");
    }
    @Override
    public Marque addMarque(String nom) throws DuplicateEntity{

        chekNameNotUsed(nom);
       Marque marque = new Marque();
       marque.setNom(nom);
       return marqueRepository.save(marque);
    }



    @Override
    public Marque getMarque(Long id) throws DuplicateEntity{

        Optional<Marque> marque = marqueRepository.findById(id);
        if (!marque.isPresent()){
            throw new DuplicateEntity("Marque not found with id : "+id);
        }
        return marque.get();
    }

    @Override
    public Marque updateMarque(Long id, MarqueForm form) throws DuplicateEntity {
            //check profanity for product name
            Marque marque = getMarque(id);
            marque.setNom(form.getNomMarque());
            return marqueRepository.save(marque);
        }
    @Override
    public Map<String, Boolean> deleteMarque(Long id) throws DuplicateEntity {
        Marque marque = getMarque(id);
        //check details
        marqueRepository.delete(marque);
        Map<String,Boolean> map = new HashMap<>();
        map.put("deleted",Boolean.TRUE);
        return map;
    }


}
