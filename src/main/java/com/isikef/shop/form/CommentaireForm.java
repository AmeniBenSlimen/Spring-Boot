package com.isikef.shop.form;

import com.isikef.shop.entities.Commentaire;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class CommentaireForm {
    private LocalDateTime dateC;
    private LocalDateTime dateU;
    private String txt;

    public Long getProductId() {
        return ProductId;
    }

    public void setProductId(Long productId) {
        ProductId = productId;
    }

    private Long ProductId;
    public CommentaireForm(){

    }
    public CommentaireForm(Commentaire commentaire){
        this.dateC = commentaire.getDateCreate();
        this.dateU = commentaire.getDateUpdate();
        this.txt = commentaire.getText();
    }
}
