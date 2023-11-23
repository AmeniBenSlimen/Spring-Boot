package com.isikef.shop.repository;

import com.isikef.shop.entities.Couleur;
import com.isikef.shop.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    @Query(value = "Select p FROM products p WHERE p.description LIKE %?1%", nativeQuery = true) // (requete sql) native:bas niveau envoie direct au sjbd
    List<Product> advancedNativeSearch(String text);

    @Query("Select p FROM Product p WHERE p.description LIKE %?1%")  //jpql
    List<Product> advancedSearch(String text);
    //select * from products where nom_product Like '%texte'; REQUETE DE RECHERCHE
    List<Product> findByNomProductLike(String nom);
    Page<Product> findByNomProductLike(String nom, Pageable pageable);

    List<Product> findByCouleurAndNomProductLike(Couleur couleur, String nom);
    List<Product> findByNomProductLikeAndPrixUnitaireHtBetween(String text , double min,double max);
    //jointure entre deux tables product et marque
    List<Product> findByMarqueNomLike(String text);


}
