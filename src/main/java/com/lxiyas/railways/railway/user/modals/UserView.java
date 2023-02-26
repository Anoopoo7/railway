package com.lxiyas.railways.railway.user.modals;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "railway_user")
public class UserView {
    @Id
    private String id;
    private String brandId;
    private String firstName;
    private String lastName;
    private String email;
    private String pin;
    private String password;
    private boolean active;
    private boolean firstLogin;
    private boolean firstOrder;
}
