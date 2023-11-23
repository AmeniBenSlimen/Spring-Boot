package com.isikef.shop.dto;

import com.isikef.shop.entities.Marque;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class MarqueDto {
    private final Long id;
    private final String nom;
    public static MarqueDto of(Marque marque){
        return new MarqueDto(marque);
    }

    //convertir liste de dto appel de MarqueDto retourner la liste de marqueDto
    //appel de la methode MarqueDto elli lfou9 map(MarqueDto::of
    public static List<MarqueDto> of(List<Marque> marques){
        return marques.stream().map(MarqueDto::of).collect(Collectors.toList());
    }
    public MarqueDto(Marque marque){
        this.id= marque.getId();
        this.nom= marque.getNom();
    }

}
