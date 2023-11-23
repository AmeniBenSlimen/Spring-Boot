package com.isikef.shop.controller;

import com.isikef.shop.dto.ProductDto;
import com.isikef.shop.entities.Product;
import com.isikef.shop.exception.MissingEntity;
import com.isikef.shop.form.ProductForm;
import com.isikef.shop.service.ProductService;
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
@RequestMapping("/products")
@CrossOrigin(origins = "*" , allowedHeaders = "*")

public class ProductController {
    @Autowired
    ProductService productService;
    //ProductRepository
    // prestation de service assuré par les dépendances : pour optimiser les ressources
    //Au lien ProductRepository en met productservice

    @GetMapping //API GET
    List<ProductDto> getAll() throws MissingEntity {
        List<Product> products = productService.getProducts();
        return ProductDto.of(products);
    }

    @PostMapping
    public ProductDto addProduct(@Valid @RequestBody ProductForm form) throws MissingEntity { // au body on a des request de format json
        Product product =  productService.addProduct(form); // yejbed beha m repository
        return ProductDto.of(product);
    }


    @GetMapping(value = "/get")
    public ProductDto getProduct(@RequestParam(name = "id") Long productId) throws MissingEntity {
        Product product = productService.getProduct(productId);
        return ProductDto.of(product);
    }

    @DeleteMapping
    public Map<String,Boolean> deleteProduct(@RequestParam(name = "id") Long productId) throws MissingEntity {
        return productService.deleteProduct(productId);
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
    @PutMapping
    public ProductDto updateProduct(@RequestParam(name ="id") Long productId, @Valid @RequestBody ProductForm form) throws MissingEntity{
        Product product = productService.updateProduct(productId,form);
        return ProductDto.of(product);

    }
    //jpa specification :: recherche par critére kima l mawjoud f mytek
    @GetMapping(value = "/search")
    //nraja3 liste ProductDto List<ProductDto> retour
    public List<ProductDto> searchByNomProduct(@RequestParam(name = "text") String text) throws MissingEntity {
        List<Product> products = productService.searchByProductName(text);
        return ProductDto.of(products);
    }
    @GetMapping(value = "/advancedSearch")
    public List<ProductDto> advancedSearch(@RequestParam(name = "text") String text,
                                           @RequestParam(name = "min", required = true)Double min,
                                           @RequestParam(name = "max" , required = true) Double max) throws MissingEntity {
        List<Product> products = productService.searchByPriceAndName(text,min,max);
        return ProductDto.of(products);
    }
    @GetMapping(value = "/searchByMarque")
    public List<ProductDto> searchByMarque (@RequestParam(name = "text") String text) throws MissingEntity {
        List<Product> products = productService.searchByMarque(text);
        return ProductDto.of(products);
    }
}
