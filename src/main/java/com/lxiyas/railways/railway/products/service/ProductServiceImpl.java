package com.lxiyas.railways.railway.products.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxiyas.railways.railway.common.Logger;
import com.lxiyas.railways.railway.common.UserContext;
import com.lxiyas.railways.railway.products.model.ProductOptions;
import com.lxiyas.railways.railway.products.model.ProductView;
import com.lxiyas.railways.railway.products.repository.ProductOptionsRepos;
import com.lxiyas.railways.railway.products.repository.ProductRepos;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepos productRepos;
    @Autowired
    private UserContext userContext;
    @Autowired
    private ProductOptionsRepos productOptionsRepos;

    @Override
    public ProductView createProduct(ProductView productView) {
        Logger.log("a03d8b77-d5df-4344-a81c-80e112c1cdb1", "recieved product data: " + productView);
        productView.setLandingPageUrl(generateLandingPageUrl(productView.getName()));
        productView.setCreatedDate(new Date());
        productView.setUpdatedDate(new Date());
        productView.setBrandId(userContext.getuserContext().getBrandId());
        return productRepos.save(productView);
    }

    private String generateLandingPageUrl(String name) {
        return "/" + name.toLowerCase().replaceAll(" ", "-");
    }

    @Override
    public ProductOptions createVarientProduct(ProductOptions productOptions) {
        Logger.log("5ec1d786-54a8-460a-b997-2cde8ee0e46b", "recieved product varient data: " + productOptions);
        return productOptionsRepos.save(productOptions);
    }

    @Override
    public ProductView getProductByUrl(String url) {
        String absUrl = "/" + url;
        ProductView product = productRepos.findByLandingPageUrlAndActiveAndEnabled(absUrl, true, true);
        if (null == product) {
            Logger.log("52699240-41b7-4264-bc60-e7a5f4821da5", "no products found for " + absUrl);
            return null;
        }
        product.setProductOptions(populateProductOptionsByProductId(product.getId()));
        return product;
    }

    private List<ProductOptions> populateProductOptionsByProductId(String productId){
        return productOptionsRepos.findByParentId(productId);
    }

    @Override
    public ProductView getProductById(String id) {
        ProductView product = productRepos.findById(id).get();
        if (null == product) {
            Logger.log("52699240-41b7-4264-bc60-e7a5f4821da6", "no products found id " + id);
            return null;
        }
        product.setProductOptions(populateProductOptionsByProductId(product.getId()));
        return product;
    }

}
