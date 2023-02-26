package com.lxiyas.railways.railway.products.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "railways_product_options")
public class ProductOptions {
    @Id
    private String id;
    private String parentId;
    private String varient;
    private int price;
    private int quantity;
    private int off;
    private List<String> pictures;
}
