package com.isikef.shop.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "marque")
public class Marque implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", nullable=false)
    private long id;
    @Column(unique = true)
    private String nom;

   @OneToMany(mappedBy = "marque")
    List<Product> products;
}
