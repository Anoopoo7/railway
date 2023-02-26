package com.lxiyas.railways.railway.pages.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lxiyas.railways.railway.common.Response;
import com.lxiyas.railways.railway.pages.messages.PageMessages;
import com.lxiyas.railways.railway.pages.service.PageConfigService;

@RestController
@RequestMapping("/page")
@CrossOrigin(origins = "*")
public class PageConfigController {
    @Autowired
    private PageConfigService pageConfigService;

    @GetMapping("/{pageType}")
    public ResponseEntity<Response> getPageConfigByPageType(@PathVariable String pageType, HttpServletRequest request) throws Exception {
        return new ResponseEntity<Response>(
                new Response(true, pageConfigService.getPageConfigByPageType(pageType), PageMessages.CONFIG_FETCHED,
                        null),
                HttpStatus.OK);
    }
}
