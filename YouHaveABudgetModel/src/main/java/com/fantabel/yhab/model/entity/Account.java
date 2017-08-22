package com.fantabel.yhab.model.entity;

import java.io.Serializable;

import java.util.UUID;

import com.fantabel.yhab.model.enumeration.AccountType;

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private Double balance;
    private String name;
    private AccountType type;

    private static int defaultNameCounter = 1;
    
    public Account() {
    		this(UUID.randomUUID().toString());
    }
    
    public Account(String id) {
    		this(id, "Account" + defaultNameCounter++);
    }
    
    public Account(String id, String name) {
    		this(id, name, 0d);
    }
    
    public Account(String id, String name, Double balance) {
    		this(id, name, balance, AccountType.Checking);
    }

    public Account(String id, String name, Double balance, AccountType type) {
        this.id = UUID.fromString(id);
        this.balance = balance;
        this.name = name;
        this.type = type;
    }

	public String getId() {
		return id.toString();
	}

	public void setId(String id) {
		this.id = UUID.fromString(id);
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
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
    
    
}
