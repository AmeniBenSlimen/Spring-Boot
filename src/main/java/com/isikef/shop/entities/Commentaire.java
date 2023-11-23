package com.isikef.shop.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name="comments")
@Getter
@Setter
public class Commentaire  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", nullable=false)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id", referencedColumnName = "id_prod")
    Product product;

   /* @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="client_id", referencedColumnName = "id")
    Client client;*/

    String text;

    LocalDateTime dateCreate;
    LocalDateTime dateUpdate;

}
