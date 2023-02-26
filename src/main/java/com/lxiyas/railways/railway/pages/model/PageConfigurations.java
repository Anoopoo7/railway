package com.lxiyas.railways.railway.pages.model;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "railways_pageconfigurations")
public class PageConfigurations {
    @Id
    private String id;
    private String pageType;
    private boolean active;
    private String brandId;
    private Map<Object, Object> configurations;
}
