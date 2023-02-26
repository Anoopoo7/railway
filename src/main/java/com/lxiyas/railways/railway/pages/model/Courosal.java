package com.lxiyas.railways.railway.pages.model;

import java.util.List;

import lombok.Data;

@Data
public class Courosal {
    private boolean active;
    private String type;
    private boolean hideTitle;
    private String title;
    private List<String> items;
}
