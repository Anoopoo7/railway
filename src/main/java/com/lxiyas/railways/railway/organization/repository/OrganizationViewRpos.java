package com.lxiyas.railways.railway.organization.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lxiyas.railways.railway.organization.modals.OrganizationView;

@Repository
public interface OrganizationViewRpos extends MongoRepository<OrganizationView, String> {

    boolean existsByServiceUrl(String url);

    OrganizationView findByCodeAndBrandId(String string, String brandId);

}