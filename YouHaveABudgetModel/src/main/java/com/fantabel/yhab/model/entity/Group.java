package com.fantabel.yhab.model.entity;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Group implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String description;
    private List<Category> categories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setCategories(List<Category> categories) {
        this.categories = new ArrayList<Category>(categories);
    }

    public List<Category> getCategories() {
        return new ArrayList<Category>(categories);
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id);
        sb.append('\t');
        sb.append(description);
        sb.append('\n');
        categories.forEach(c -> sb.append(c.toString()));
        return sb.toString();
    }
}
