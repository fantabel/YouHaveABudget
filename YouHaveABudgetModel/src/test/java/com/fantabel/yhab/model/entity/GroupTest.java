package com.fantabel.yhab.model.entity;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

public class Group implements Serializable {
    @SuppressWarnings("compatibility:-6343981648249688491")
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String description;
    private List<Category> categories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
