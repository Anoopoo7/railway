package com.lxiyas.railways.railway.products.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lxiyas.railways.railway.products.model.ProductOptions;

@Repository
public interface ProductOptionsRepos extends MongoRepository<ProductOptions, String> {

    List<ProductOptions> findByParentId(String productId);

}
