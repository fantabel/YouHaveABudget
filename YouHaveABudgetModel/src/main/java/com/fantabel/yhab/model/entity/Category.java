package com.fantabel.yhab.model.entity;

import com.fantabel.yhab.model.util.IdUtil;

import java.io.Serializable;

import java.util.UUID;

public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    Goal goal;
    
    public Category() {
        this(IdUtil.getNextPositiveLong());
    }
    
    public Category(Long id) {
        this(id, "Category" + 1);
    }
    
    public Category(Long id, String name) {
        this(id, name, null);
    }
    
    public Category(Long id, String name, Goal goal) {
        this.id = id;
        this.name = name;
        this.goal = goal;
    }
    
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

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public Goal getGoal() {
        return goal;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id);
        sb.append('\t');
        sb.append(name);
        sb.append('\n');
        sb.append(goal.toString());
        return sb.toString();
    }
}
