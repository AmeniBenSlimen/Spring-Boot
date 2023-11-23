package com.isikef.shop.entities;

import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.StandardException;

@Getter
@Setter
@Embeddable
public class Address {
    private String rue;
    private String ville;
    private String codePostal;
}
