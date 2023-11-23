package com.isikef.shop.form;

import com.isikef.shop.entities.Couleur;
import com.isikef.shop.entities.Product;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
//C'est une classe de traitement
//Pas besion de Entity ( pas de classe generer dans bd)
public class ProductForm {
    @NotBlank(message="la réferance doit etre non null")
    private String ref;
    private String nom;
    private double prix;
    private int qte;
    private Couleur couleur;
    private String description;

    public Long getMarqueId() {
        return marqueId;
    }

    public void setMarqueId(Long marqueId) {
        this.marqueId = marqueId;
    }


    @NotNull(message ="le produit doit etre non null")
    private Long marqueId;

    public ProductForm() {
    }

    public ProductForm(Product product) {
        this.ref = product.getRefProduct();
        this.nom = product.getNomProduct();
        this.prix = product.getPrixUnitaireHt();
        this.qte = product.getQteStock();
        this.couleur = product.getCouleur();
        this.description = product.getDescription();
    }
}
