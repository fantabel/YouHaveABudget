package com.fantabel.yhab.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Payee payee;
    private LocalDateTime date;
    private BigDecimal amount;
    private String note;
    private Category category;
    private Boolean cleared;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    
}
