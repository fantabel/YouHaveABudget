package com.fantabel.yhab.model.entity;

import java.util.List;
import java.util.UUID;

public class Group {
    private UUID id;
    private List<Category> categories;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}