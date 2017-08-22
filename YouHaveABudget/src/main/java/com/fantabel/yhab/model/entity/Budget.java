package com.fantabel.yhab.model.entity;

import java.io.Serializable;

import java.time.LocalDateTime;

import java.util.UUID;


public class Budget implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private UUID id;
    private LocalDateTime created;
    private String name;
    
    private static int defaultNameCounter = 1;

    public Budget() {
        this("Budget" + defaultNameCounter++);
    }
    
    public Budget(String name) {
        this(name, LocalDateTime.now());
    }
    
    public Budget(String name, LocalDateTime created) {
        this.id = UUID.randomUUID();
        this.created = created;
        this.name = name;
    }

    public String getId() {
        return id.toString();
    }

    public void setId(String id) {
        this.id = UUID.fromString(id);
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getClass().getName() + "@" + Integer.toHexString(hashCode()));
        buffer.append('[');
        buffer.append("created=");
        buffer.append(getCreated());
        buffer.append(',');
        buffer.append("id=");
        buffer.append(getId());
        buffer.append(',');
        buffer.append("name=");
        buffer.append(getName());
        buffer.append(']');
        return buffer.toString();
    }
}
