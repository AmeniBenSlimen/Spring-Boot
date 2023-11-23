package com.isikef.shop.controller;

import com.isikef.shop.dto.MarqueDto;
import com.isikef.shop.dto.ProductDto;
import com.isikef.shop.entities.Marque;
import com.isikef.shop.entities.Product;
import com.isikef.shop.exception.DuplicateEntity;
import com.isikef.shop.exception.MissingEntity;
import com.isikef.shop.form.MarqueForm;
import com.isikef.shop.form.ProductForm;
import com.isikef.shop.service.MarqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/marques")
@CrossOrigin(origins = "*" , allowedHeaders = "*")
public class MarqueController {
    //injecter le service @Autowired
    //le contrainte d'integrite teb3a couche métier
    //sta3meelna Dto bch ma nodkhlouch f probleme de redandance
    @Autowired
    MarqueService marqueService;
    @GetMapping
    public List<MarqueDto> getMarques() throws DuplicateEntity {
        List<Marque> marques = marqueService.getMarques();
        return MarqueDto.of(marques);
    }
    @PostMapping
    public MarqueDto createMarque(@RequestParam(name ="nom", required = true) String nom) throws DuplicateEntity{
        Marque marque = marqueService.addMarque(nom);
        return MarqueDto.of(marque);
    }
    @GetMapping(value = "/get")
    public MarqueDto getMarque(@RequestParam(name = "id") Long marqueId) throws  DuplicateEntity {
        Marque marque = marqueService.getMarque(marqueId);
        return MarqueDto.of(marque);
    }
    @PutMapping
    public MarqueDto updateMarque(@RequestParam(name ="id") Long marqueId, @Valid @RequestBody MarqueForm form) throws DuplicateEntity {
        Marque marque = marqueService.updateMarque(marqueId,form);
        return MarqueDto.of(marque);
    }
    @DeleteMapping
    public Map<String,Boolean> deleteMarque(@RequestParam(name = "id") Long marqueId) throws DuplicateEntity {
        return marqueService.deleteMarque(marqueId);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)

    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
