package com.isikef.shop.dto;

import com.isikef.shop.entities.Commentaire;
import com.isikef.shop.entities.Product;
import com.isikef.shop.form.CommentaireForm;

import java.util.List;
import java.util.stream.Collectors;

public class CommentaireDto extends CommentaireForm {

    private Long id;
    private ProductDto product;
    public CommentaireDto(Commentaire commentaire){
        super(commentaire);
        this.id = commentaire.getId();
        this.product=ProductDto.of(commentaire.getProduct());

    }
    public static CommentaireDto of(Commentaire commentaire){
        return new CommentaireDto(commentaire);
    }
    public static List<CommentaireDto> of(List<Commentaire> commentaires){
        return commentaires.stream().map(CommentaireDto::of).collect(Collectors.toList());
    }
}
