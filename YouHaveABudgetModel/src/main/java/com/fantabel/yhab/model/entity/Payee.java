package com.fantabel.yhab.model.entity;

import com.fantabel.yhab.model.util.IdUtil;

import java.io.Serializable;

public class Payee implements Serializable {
    private static final long serialVersionUID = 1L;
    Long id;
    String name;
    
    public Payee() {
        this(IdUtil.getNextPositiveLong());
    }
    
    public Payee(Long id) {
        this(id, "Payee" + IdUtil.getPositiveInteger(Payee.class.getSimpleName()));
        
    }
    
    public Payee(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id);
        sb.append('\t');
        sb.append(name);
        return sb.toString();
    }
}
