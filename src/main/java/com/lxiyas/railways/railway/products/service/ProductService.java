package com.lxiyas.railways.railway.products.service;

import org.springframework.stereotype.Service;

import com.lxiyas.railways.railway.products.model.ProductOptions;
import com.lxiyas.railways.railway.products.model.ProductView;

@Service
public interface ProductService {

    ProductView createProduct(ProductView productView);

    ProductOptions createVarientProduct(ProductOptions productOptions);

    Object getProductByUrl(String url);

    ProductView getProductById(String id);
    
}
