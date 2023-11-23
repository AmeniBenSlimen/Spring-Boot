package com.isikef.shop.repository;

import com.isikef.shop.entities.Marque;
import com.isikef.shop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarqueRepository extends JpaRepository<Marque,Long> {
    public boolean existsByNom(String nom);

}
