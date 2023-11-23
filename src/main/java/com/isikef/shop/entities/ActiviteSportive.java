package com.isikef.shop.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "activite_sportive")
public class ActiviteSportive implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", nullable=false)
    private long id;
    private String nom;

    /*@OneToMany(mappedBy = "activiteSportive")
    List<Product> products; */
}
