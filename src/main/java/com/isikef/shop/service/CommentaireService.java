package com.isikef.shop.service;

import com.isikef.shop.entities.Commentaire;
import com.isikef.shop.exception.MissingEntity;
import com.isikef.shop.form.CommentaireForm;

import java.util.List;
import java.util.Map;

public interface CommentaireService {
    public List<Commentaire> getCommentaires();
    //methode pour réqupérer liste de commentaire
    public Commentaire addCommentaire(CommentaireForm form) throws MissingEntity;
    public Commentaire getCommentaire(Long id) throws MissingEntity;
    public Commentaire updateCommentaire(Long id, CommentaireForm form) throws MissingEntity;
    public Map<String,Boolean> deleteCommentaire(Long id) throws MissingEntity;
}
