package com.isikef.shop.form;

import com.isikef.shop.entities.Marque;
import com.isikef.shop.entities.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarqueForm {
    private String nomMarque;
    public MarqueForm() {
    }

    public MarqueForm(Marque marque) {
        this.nomMarque = marque.getNom();
    }


}
