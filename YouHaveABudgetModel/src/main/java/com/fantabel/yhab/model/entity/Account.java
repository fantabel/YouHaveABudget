package com.fantabel.yhab.model.entity;

import java.io.Serializable;

import com.fantabel.yhab.model.enumeration.AccountType;

import com.fantabel.yhab.model.util.IdUtil;

import java.math.BigDecimal;

import java.text.NumberFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private BigDecimal balance;
    private String name;
    private AccountType type;
    private List<Transaction> transactions;

    

    public Account() {
        this(IdUtil.getNextPositiveLong());
    }

    public Account(Long id) {
        this(id, "Account" + IdUtil.getPositiveInteger(Account.class.getSimpleName()));
    }

    public Account(Long id, String name) {
        this(id, name, BigDecimal.ZERO);
    }

    public Account(Long id, String name, BigDecimal balance) {
        this(id, name, balance, AccountType.Checking);
    }

    public Account(Long id, String name, BigDecimal balance, AccountType accountType) {
        this(id, name, balance, accountType, new ArrayList<Transaction>());
    }

    public Account(Long id, String name, BigDecimal balance, AccountType type, List<Transaction> transactions) {
        this.id = id;
        this.balance = balance;
        this.name = name;
        this.type = type;
        this.transactions = transactions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }
    
    public void addTransaction(Transaction t) {
        transactions.add(t);
    }
    
    public boolean removeTransaction(Transaction t) {
        return transactions.remove(t);
    }
    
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = new ArrayList<Transaction>(transactions);
    }

    public List<Transaction> getTransactions() {
        return new ArrayList<Transaction>(transactions);
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id);
        sb.append('\t');
        sb.append(name);
        sb.append('\t');
        sb.append(NumberFormat.getCurrencyInstance().format(balance));
        sb.append('\t');
        sb.append(type);
        sb.append('\t');
        transactions.forEach(t -> sb.append(t.toString()));
        return sb.toString();
    }
}
