package com.fantabel.yhab.model.entity;

import java.io.Serializable;

import java.util.UUID;

public class ReccurentTransaction implements Serializable {
    private static final long serialVersionUID = 1L;
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}
