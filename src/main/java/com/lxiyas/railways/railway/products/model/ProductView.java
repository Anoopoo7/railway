package com.lxiyas.railways.railway.products.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "railways_products")
public class ProductView {
    @Id
    private String id;
    private String name;
    private List<String> offers;
    private List<String> categories;
    private List<String> related;
    private List<ProductOptions> productOptions;
    private boolean active;
    private boolean enabled;
    private String landingPageUrl;
    private String brandId;
    private String disableSitemap;
    private Date createdDate;
    private Date updatedDate;
}
