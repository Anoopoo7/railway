package com.lxiyas.railways.railway.pages.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxiyas.railways.railway.common.Logger;
import com.lxiyas.railways.railway.common.UserContext;
import com.lxiyas.railways.railway.organization.modals.OrganizationView;
import com.lxiyas.railways.railway.organization.service.OrganizationService;
import com.lxiyas.railways.railway.pages.messages.PageErrors;
import com.lxiyas.railways.railway.pages.model.PageConfigurations;
import com.lxiyas.railways.railway.pages.repository.PageConfigRepository;


@Service
public class PageConfigServiceImpl implements PageConfigService {

    @Autowired
    private UserContext userContext;
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private PageConfigRepository pageConfigRepository;

    @Override
    public PageConfigurations getPageConfigByPageType(String pageType) throws Exception {
        Logger.log("37adbad2-b04d-11ed-9e8a-325096b39f47", "finding page configuration for " + pageType);
        String brandId = userContext.getuserContext().getBrandId();
        OrganizationView pageConfigurations = organizationService.getPageconfiguration(brandId);
        Logger.log("37adbad2-b04d-11ed-9e8a-325096b39f47",
                "fetched pageconfigurations for brand " + brandId + " : " + pageConfigurations);
        return populatePageconfigurations(pageConfigurations, pageType);
    }

    private PageConfigurations populatePageconfigurations(OrganizationView pageConfigurations, String pageType) throws Exception {
        if (null == pageConfigurations) {
            throw new Exception(PageErrors.PAGECONFIGURATIONS_NOT_FOUND.name());
        }
        Map<String, String> pageConfiguration = pageConfigurations.getPageConfigurations();
        String pageConfigurationId = pageConfiguration.get(pageType);
        if (null == pageConfigurationId) {
            throw new Exception(PageErrors.INVALID_PAGETYPE.name());
        }
        PageConfigurations PageLayout = pageConfigRepository.findById(pageConfigurationId).get();
        return PageLayout;
    }

}
