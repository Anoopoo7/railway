package com.lxiyas.railways.railway.organization.service;

import org.springframework.stereotype.Service;

import com.lxiyas.railways.railway.organization.modals.OrganizationView;

@Service
public interface OrganizationService {
    public boolean verifyServiceUrl(String url);

    public OrganizationView getPageconfiguration(String brandId);
}
