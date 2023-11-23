package com.isikef.shop.dto;

import com.isikef.shop.entities.Product;
import com.isikef.shop.form.ProductForm;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Getter
@Setter
public class ProductDto extends ProductForm {
    private Long id;
    private  MarqueDto marque;
    public ProductDto(Product product){
        super(product);
        this.id = product.getId();
        this.marque=MarqueDto.of(product.getMarque());
    }
    public static ProductDto of(Product product){
        return new ProductDto(product);
    }

    public static List<ProductDto> of(List<Product> products){
        return products.stream().map(ProductDto::of).collect(Collectors.toList());
    }
}
