package com.lxiyas.railways.railway.pages.service;

import org.springframework.stereotype.Service;

@Service
public interface PageConfigService {

    Object getPageConfigByPageType(String pageType) throws Exception;
    
}
