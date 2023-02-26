package com.lxiyas.railways.railway.organization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lxiyas.railways.railway.organization.modals.OrganizationView;
import com.lxiyas.railways.railway.organization.repository.OrganizationViewRpos;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationViewRpos organizationViewRpos;

    @Override
    public boolean verifyServiceUrl(String url) {
        return organizationViewRpos.existsByServiceUrl(url);
    }

    @Override
    public OrganizationView getPageconfiguration(String brandId) {
        return organizationViewRpos.findByCodeAndBrandId("PageConfigurations", brandId);
    }

}
