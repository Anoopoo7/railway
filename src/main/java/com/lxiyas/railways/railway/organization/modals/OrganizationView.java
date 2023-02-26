package com.lxiyas.railways.railway.organization.modals;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "railways_organization")
public class OrganizationView {
    @Id
    private String id;
    private String code;
    private String serviceUrl;
    private String brandId;
    private Map<String, String> pageConfigurations;
}
