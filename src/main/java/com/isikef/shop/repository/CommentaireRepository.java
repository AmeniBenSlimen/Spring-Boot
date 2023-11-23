package com.isikef.shop.repository;

import com.isikef.shop.entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire,Long> {

    List<Commentaire> findAllById(Iterable<Long> longs);
}
