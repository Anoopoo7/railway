package com.lxiyas.railways.railway.products.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lxiyas.railways.railway.products.model.ProductView;

@Repository
public interface ProductRepos extends MongoRepository<ProductView, String> {

    ProductView findByLandingPageUrlAndActiveAndEnabled(String absUrl, boolean b, boolean c);

}
