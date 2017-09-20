package com.fantabel.yhab.model.entity;

import com.fantabel.yhab.model.util.IdUtil;

import java.io.Serializable;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Budget implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private LocalDateTime created;
    private List<Account> accounts;
    private List<Group> groups;

    private static int defaultNameCounter = 1;

    public Budget() {
        this(IdUtil.getNextPositiveLong());
    }
    
    public Budget(Long id) {
        this(id, "Budget" + defaultNameCounter++);
    }
    
    public Budget(Long id, String name) {
        this(id, name, LocalDateTime.now());
    }

    public Budget(Long id, String name, LocalDateTime created) {
        this(id, name, created, new ArrayList<Account>());
    }
    
    public Budget(Long id, String name, LocalDateTime created, List<Account> accounts) {
        this(id, name, created, accounts, new ArrayList<Group>());
    }
    
    public Budget(Long id, String name, LocalDateTime created, List<Account> accounts, List<Group> groups) {
        this.id = id;
        this.name = name;
        this.created = created;
        
        this.accounts = accounts;
        this.groups = groups;
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    
    public List<Account> getAccounts() {
        return new ArrayList<>(accounts);
    }
    
    public void setAccounts(List<Account> accounts) {
        if (accounts == null) {
            this.accounts = new ArrayList<>();
        }
        else {
            this.accounts = new ArrayList<>(accounts);
        }
    }
    
    public List<Group> getGroups() {
        return new ArrayList<>(groups);
    }

    public void setGroups(List<Group> groups) {
        if (groups == null) {
            this.groups = new ArrayList<>();
        }
        else {
            this.groups = new ArrayList<>(groups);
        }
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }
    
    public void addGroup(Group group) {
        groups.add(group);
    }
    
    public void removeGroup(Group group) {
        groups.remove(group);
    }
    
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("id : ");
        buffer.append(getId());
        buffer.append('\n');
        buffer.append("name : ");
        buffer.append(getName());
        buffer.append('\n');
        buffer.append("created : ");
        buffer.append(getCreated());
        buffer.append('\n');
        
        if (accounts.size() == 0) {
            buffer.append("No accounts in this budget.");
            buffer.append("\n");
        }
        
        if (groups.size() == 0) {
            buffer.append("No groups in this budget.");
            buffer.append("\n");
        }
        
        for (Account a : accounts) {
            buffer.append(a.toString());
        }
        for (Group g : groups) {
            buffer.append(g.toString());
        }
        return buffer.toString();
    }
}
