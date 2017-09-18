package com.fantabel.yhab.model.entity;


import com.fantabel.yhab.model.util.IdUtil;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

public class BudgetTest {
    @Test
    public void testDefaultConstructor() {
        Budget budget = new Budget();
        
        assertNotNull("Name must be present", budget.getName());
        assertNotNull("Created date must be present", budget.getCreated());
        assertNotNull("Id must be present", budget.getId());
        assertEquals("There shouldn't be any accounts", 0, budget.getAccounts().size());
        assertEquals("There shouldn't be any groups", 0, budget.getGroups().size());
        System.out.println(budget.toString());
    }
    
    @Test
    public void testConstructorId() {
        Budget budget = new Budget(1L);
        assertNotNull("Id Must be present", budget.getId());
        assertEquals("Id should be equal to 1", new Long(1L), budget.getId());
    }
    
    @Test
    public void testConstructorIdName() {
        Budget budget = new Budget(1L, "MyAccount");

        assertNotNull("Id Must be present", budget.getId());
        assertEquals("Id should be equal to 1", new Long(1), budget.getId());
        
        assertNotNull("Name must be present", budget.getName());
        assertEquals("Name must be MyAccount", "MyAccount", budget.getName());
    }
    
    @Test
    public void testConstructorIdNameCreated() {
        LocalDateTime now = LocalDateTime.now();
        Budget budget = new Budget(1L, "MyAccount", now);

        assertNotNull("Id Must be present", budget.getId());
        assertEquals("Id should be equal to 1", new Long(1), budget.getId());
        
        assertNotNull("Name must be present", budget.getName());
        assertEquals("Name must be MyAccount", "MyAccount", budget.getName());
        
        assertNotNull("Created date/time should be present", budget.getCreated());
        assertEquals("Created date/time should be equal to " + now.toString(), now, budget.getCreated());
    }
    
    @Test
    public void testConstructorIdNameCreatedAccounts() {
        LocalDateTime now = LocalDateTime.now();
        List<Account> accounts = new ArrayList<>();
        
        for (int i = 0 ; i < 5 ; i++) {
            accounts.add(new Account());
        }
        
        Budget budget = new Budget(1L, "MyAccount", now, accounts);

        assertNotNull("Id Must be present", budget.getId());
        assertEquals("Id should be equal to 1", new Long(1), budget.getId());
        
        assertNotNull("Name must be present", budget.getName());
        assertEquals("Name must be MyAccount", "MyAccount", budget.getName());
        
        assertNotNull("Created date/time should be present", budget.getCreated());
        assertEquals("Created date/time should be equal to " + now.toString(), now, budget.getCreated());
        
        assertNotNull("Accounts should be present", budget.getAccounts());
        assertEquals("There should be 5 accounts", 5, budget.getAccounts().size());
    }
    
    @Test
    public void testConstructorIdNameCreatedAccountsGroups() {
        LocalDateTime now = LocalDateTime.now();
        List<Account> accounts = new ArrayList<>();
        List<Group> groups = new ArrayList<>();
        
        for (int i = 0 ; i < 5 ; i++) {
            accounts.add(new Account());
            groups.add(new Group());
        }
        
        Budget budget = new Budget(1L, "MyAccount", now, accounts);

        assertNotNull("Id Must be present", budget.getId());
        assertEquals("Id should be equal to 1", new Long(1), budget.getId());
        
        assertNotNull("Name must be present", budget.getName());
        assertEquals("Name must be MyAccount", "MyAccount", budget.getName());
        
        assertNotNull("Created date/time should be present", budget.getCreated());
        assertEquals("Created date/time should be equal to " + now.toString(), now, budget.getCreated());
        
        assertNotNull("Accounts should be present", budget.getAccounts());
        assertEquals("There should be 5 accounts", 5, budget.getAccounts().size());
    }

    @Test
    public void testIdGetterSetter() {
        Budget budget = new Budget();
        budget.setId(1L);
        assertEquals("Budget id should be 1", new Long(1), budget.getId());
        
        budget.setId(-1L);
        assertEquals("Budget id should be -1", new Long(-1), budget.getId());
        
        budget.setId(500L);
        assertEquals("Budget id should be 500", new Long(500), budget.getId());
        
        long i = IdUtil.getNextPositiveLong();
        budget.setId(i);
        assertEquals("Budget id should be " + i, new Long(i), budget.getId());
    }
    
    @Test
    public void testNameGetterSetter() {
        Budget budget = new Budget();
        budget.setName("MyAccount");
        assertEquals("Budget id should be MyAccount", "MyAccount", budget.getName());

        budget.setName("A Very Long Account Name, There Should Be No Problem With That");
        assertEquals("Budget id should be A Very Long Account Name, There Should Be No Problem With That", 
                     "A Very Long Account Name, There Should Be No Problem With That", budget.getName());

        budget.setName("\uE52B"); // Cow Emoji
        assertEquals("Budget id should be \uE52B", "\uE52B", budget.getName());
        
        budget.setName("");
        assertEquals("Budget id should be empty", "", budget.getName());
    }
    
    @Test
    public void testCreatedGetterSetter() {
        Budget budget = new Budget();
        budget.setCreated(LocalDateTime.now());
        
        assertTrue("The date should be in the past", budget.getCreated().isBefore(LocalDateTime.now()) || 
                                                     budget.getCreated().isEqual(LocalDateTime.now()));
        
        LocalDateTime fiveDays = LocalDateTime.now().plusDays(5);
        budget.setCreated(fiveDays);
        assertEquals("The date should be 5 days from now", fiveDays, budget.getCreated());
    }
    
    @Test
    public void testAccountsGetterSetter() {
        //return new ArrayList<Account>(accounts);
    }
    
    @Test
    public void testAddAccount() {
        //accounts.add(account);
    }
    
    @Test
    public void testRemoveAccount() {
        //accounts.remove(account);
    }
    
    @Test
    public void testGroupsGetterSetter() {
        //return new ArrayList<Group>(groups);
    }
    
    @Test
    public void testAddGroup() {
        //groups.add(group);
    }
    
    @Test
    public void testRemoveGroup() {
        //groups.remove(group);
    }
}
