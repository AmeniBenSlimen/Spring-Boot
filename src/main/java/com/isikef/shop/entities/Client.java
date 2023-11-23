package com.isikef.shop.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "clients")

public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", nullable=false)
    private long id;

    @Column(name="nom_client")
    private String nom;
    @Column(name="prenom_client")
    private String prenom;
    private String email;
    private String numTel;

    @Embedded
    Address address;


}
