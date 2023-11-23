package com.isikef.shop.controller;

import com.isikef.shop.dto.CommentaireDto;
import com.isikef.shop.dto.MarqueDto;
import com.isikef.shop.dto.ProductDto;
import com.isikef.shop.entities.Commentaire;
import com.isikef.shop.entities.Marque;
import com.isikef.shop.entities.Product;
import com.isikef.shop.exception.DuplicateEntity;
import com.isikef.shop.exception.MissingEntity;
import com.isikef.shop.form.CommentaireForm;
import com.isikef.shop.form.ProductForm;
import com.isikef.shop.service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/commentaire")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class CommentaireController {
    @Autowired
    CommentaireService commentaireService;
    @GetMapping
    List<CommentaireDto> getAll() throws MissingEntity {
        List<Commentaire> commentaires = commentaireService.getCommentaires();
        return CommentaireDto.of(commentaires);
    }
    @PostMapping
    public CommentaireDto addProduct(@Valid @RequestBody CommentaireForm form) throws MissingEntity { // au body on a des request de format json
        Commentaire commentaire =  commentaireService.addCommentaire(form); // yejbed beha m repository
        return CommentaireDto.of(commentaire);
    }
    @GetMapping(value = "/get")
    public CommentaireDto getCommentaire(@RequestParam(name = "id") Long commentaireId) throws MissingEntity {
        Commentaire commentaire = commentaireService.getCommentaire(commentaireId);
        return CommentaireDto.of(commentaire);
    }
    @DeleteMapping
    public Map<String,Boolean> deleteCommentaire(@RequestParam(name = "id") Long commentaireId) throws MissingEntity {
        return commentaireService.deleteCommentaire(commentaireId);
    }
    @PutMapping
    public CommentaireDto updateCommentaire(@RequestParam(name ="id") Long commentaireId, @Valid @RequestBody CommentaireForm form) throws MissingEntity{
        Commentaire commentaire = commentaireService.updateCommentaire(commentaireId,form);
        return CommentaireDto.of(commentaire);

    }
}
