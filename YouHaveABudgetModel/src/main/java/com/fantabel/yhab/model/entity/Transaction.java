package com.fantabel.yhab.model.entity;

import com.fantabel.yhab.model.util.IdUtil;

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
    
    public Transaction() {
        this(IdUtil.getNextPositiveLong(),
             new Payee(),
             LocalDateTime.now(),
             BigDecimal.TEN,
             "Note " + IdUtil.getPositiveInteger("Note"),
             new Category(),
             false);
    }
    
    public Transaction(Long id, Payee payee, LocalDateTime date,
                       BigDecimal amount, String note, Category category, 
                       Boolean cleared) {
        this.id = id;
        this.payee = payee;
        this.date = date;
        this.amount = amount;
        this.note = note;
        this.category = category;
        this.cleared = cleared;
        
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPayee(Payee payee) {
        this.payee = payee;
    }

    public Payee getPayee() {
        return payee;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCleared(Boolean cleared) {
        this.cleared = cleared;
    }

    public Boolean getCleared() {
        return cleared;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(id);
        sb.append('\t');
        sb.append(payee);
        sb.append('\t');
        sb.append(date);
        sb.append('\t');
        sb.append(amount);
        sb.append('\t');
        sb.append(note);
        sb.append('\t');
        sb.append(category.getName());
        sb.append('\t');
        sb.append(cleared);
        
        return sb.toString();
    }
}
