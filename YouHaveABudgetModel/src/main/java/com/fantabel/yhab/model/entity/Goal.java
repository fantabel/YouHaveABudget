package com.fantabel.yhab.model.entity;

import com.fantabel.yhab.model.util.IdUtil;

import java.io.Serializable;

import java.math.BigDecimal;

import java.time.LocalDate;

import java.util.UUID;

public class Goal implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String description;
    private Boolean minimumBalanceGoal;
    private LocalDate byDate;
    private BigDecimal balance;
    
    public Goal() {
        this(IdUtil.getNextPositiveLong());
    }
    
    public Goal(Long id) {
        this(id, "Goal" + IdUtil.getPositiveInteger(Goal.class.getSimpleName()));
    }
    
    public Goal(Long id, String description) {
        this(id, description, false);
    }
    
    public Goal(Long id, String description, Boolean minimumBalanceGoal) {
        this(id, description, minimumBalanceGoal, minimumBalanceGoal ? LocalDate.now().plusMonths(1) : null);
        
    }
    
    public Goal(Long id, String description, Boolean minimumBalanceGoal, LocalDate byDate) {
        this(id, description, minimumBalanceGoal, byDate, BigDecimal.ZERO);
    }
    
    public Goal(Long id, String description, Boolean minimumBalanceGoal, LocalDate byDate, BigDecimal balance) {
        this.id = id;
        this.description = description;
        this.minimumBalanceGoal = minimumBalanceGoal;
        this.byDate = byDate;
        this.balance = balance;
    }

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

    public void setMinimumBalanceGoal(Boolean minimumBalanceGoal) {
        this.minimumBalanceGoal = minimumBalanceGoal;
    }

    public Boolean getMinimumBalanceGoal() {
        return minimumBalanceGoal;
    }

    public void setByDate(LocalDate byDate) {
        this.byDate = byDate;
    }

    public LocalDate getByDate() {
        return byDate;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id);
        sb.append('\t');
        sb.append(description);
        sb.append('\t');
        sb.append(minimumBalanceGoal);
        sb.append('\t');
        sb.append(byDate);
        sb.append('\t');
        sb.append(balance);
        return sb.toString();
    }
}
