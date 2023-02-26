package com.lxiyas.railways.railway.products.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lxiyas.railways.railway.common.Response;
import com.lxiyas.railways.railway.products.messages.ProductMessages;
import com.lxiyas.railways.railway.products.model.ProductOptions;
import com.lxiyas.railways.railway.products.model.ProductView;
import com.lxiyas.railways.railway.products.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<Response> createProduct(@RequestBody ProductView productView, HttpServletRequest request)
            throws Exception {
        return new ResponseEntity<Response>(
                new Response(true, productService.createProduct(productView),
                        ProductMessages.PRODUCT_CREATED,
                        null),
                HttpStatus.OK);
    }

    @PostMapping("/varient")
    public ResponseEntity<Response> createVarientProduct(@RequestBody ProductOptions productOptions,
            HttpServletRequest request)
            throws Exception {
        return new ResponseEntity<Response>(
                new Response(true, productService.createVarientProduct(productOptions),
                        ProductMessages.PRODUCT_CREATED,
                        null),
                HttpStatus.OK);
    }

    @GetMapping("/{url}")
    public ResponseEntity<Response> getProductByUrl(@PathVariable String url,
            HttpServletRequest request)
            throws Exception {
        return new ResponseEntity<Response>(
                new Response(true, productService.getProductByUrl(url),
                        ProductMessages.PRODUCT_FETCHED,
                        null),
                HttpStatus.OK);
    }
}
