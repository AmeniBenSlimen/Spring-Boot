package com.isikef.shop.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity  // obligatoire
@Table(name = "products")  //table dans la base avec nom products, si on l'écrit pas prend par defaut Product
@Getter
@Setter

public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto incriment, si indique par l'utilisaion c'est pas la peine d'ecrire
    // auto  : cle primaire par fournisseur persistance hibernate ( un seul compteur pour tous entites donc pas obligatoire d'etre dans un entite cle primaire est auto incriment. kol mara entite)
    // /identity : contraire auto , hibernate s'appuie sur le mécanisme propre au SGBD , chaque table par son propre compteur par table.
    // sequence : comme code à barre , strategy par defaut du table
    // table : sequence comme code à barre , enti tet7akm fih à 100%
    @Column(name = "id_prod")
    private long id ;

    @Column(nullable = false, unique=true, length = 200)
    private String refProduct;
    private String nomProduct;
    @Column(name = "prix_produit")

    private double prixUnitaireHt;
    private int qteStock;
    @Enumerated(EnumType.STRING)
    private Couleur couleur;
    private String description;


    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="activie_id", referencedColumnName = "id")
    ActiviteSportive activiteSportive;*/

    // relation one to many avec marque
// optional =false : obliger nit null et l valeur lezm tkoun mawjouda f table , fetch = FetchType.LAZY
    @ManyToOne(optional =false  , fetch = FetchType.LAZY)
    @JoinColumn(name ="marque_id", referencedColumnName = "id")
    Marque marque;

}
