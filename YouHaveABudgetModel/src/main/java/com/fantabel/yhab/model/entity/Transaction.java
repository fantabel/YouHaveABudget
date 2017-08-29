package com.fantabel.yhab.model.entity;

import java.io.Serializable;

import java.util.UUID;

public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;
    private UUID id;
    private Category category;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    
    
}
