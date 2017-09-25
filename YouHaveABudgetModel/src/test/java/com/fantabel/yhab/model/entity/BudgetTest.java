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
        LocalDateTime now = LocalDateTime.now();
        budget.setCreated(now);
        
        assertTrue("The date should be in the past\nCreated: " + budget.getCreated().toString() + "\nnow: " + now.toString(), budget.getCreated().isBefore(now) || 
                                                     budget.getCreated().isEqual(now));
        
        LocalDateTime fiveDays = LocalDateTime.now().plusDays(5);
        budget.setCreated(fiveDays);
        assertEquals("The date should be 5 days from now", fiveDays, budget.getCreated());
    }
    
    @Test
    public void testAccountsGetterSetter() {
        Budget budget = new Budget();
        List<Account> accounts = new ArrayList<>();
        
        for (int i = 0 ; i < 5 ; i++) {
            accounts.add(new Account());
        }
        
        budget.setAccounts(accounts);
        
        // TODO Test cloning and method side effects
        assertNotNull("Account list should be present.", budget.getAccounts());
        assertEquals("Account lists should be equals", accounts, budget.getAccounts());
        assertEquals("There should be 5 accounts in the list", 5, budget.getAccounts().size());
    }
    
    @Test
    public void testGroupsGetterSetter() {
        Budget budget = new Budget();
        List<Group> groups = new ArrayList<>();
        
        for (int i = 0 ; i < 5 ; i++) {
            groups.add(new Group());
        }
        
        budget.setGroups(groups);
        
        // TODO Test cloning and method side effects
        assertNotNull("Group list should be present.", budget.getGroups());
        assertEquals("Group lists should be equals", groups, budget.getGroups());
        assertEquals("There should be 5 groups in the list", 5, budget.getGroups().size());
    }
    
    @Test
    public void testAddAccount() {
        Budget budget = new Budget();
        List<Account> accounts = new ArrayList<>();
        
        for (int i = 0 ; i < 5 ; i++) {
            accounts.add(new Account());
        }
        
        budget.setAccounts(accounts);
        
        assertNotNull("Account list should be present.", budget.getAccounts());
        assertEquals("There should be 5 accounts in the list", 5, budget.getAccounts().size());
    }
    
    @Test
    public void testRemoveAccount() {
        Budget budget = new Budget();
        List<Account> accounts = new ArrayList<>();
        
        for (int i = 0 ; i < 5 ; i++) {
            accounts.add(new Account());
        }
        
        budget.setAccounts(accounts);
        budget.removeAccount(accounts.get(0));
        
        assertNotNull("Account list should be present.", budget.getAccounts());
        assertEquals("There should be 4 accounts in the list", 4, budget.getAccounts().size());
        assertTrue("Account " + accounts.get(0).getName() + " should not be present.", !budget.getAccounts().contains(accounts.get(0)));
    }
    
    @Test
    public void testAddGroup() {
        Budget budget = new Budget();
        for (int i = 0 ; i < 5 ; i++) {
            budget.addGroup(new Group());
        }
        
        assertNotNull("Group list should be present.", budget.getGroups());
        assertEquals("There should be 5 groups in the list", 5, budget.getGroups().size());
    }
    
    @Test
    public void testRemoveGroup() {
        Budget budget = new Budget();
        List<Group> groups = new ArrayList<>();
        
        for (int i = 0 ; i < 5 ; i++) {
            groups.add(new Group());
        }
        
        budget.setGroups(groups);
        budget.removeGroup(groups.get(0));
        
        assertNotNull("Group list should be present.", budget.getGroups());
        assertEquals("There should be 4 groups in the list", 4, budget.getGroups().size());
        assertTrue("Group " + groups.get(0).getName() + " should not be present.", budget.getGroups().contains(groups.get(0)));
    }
    
    @Test
    public void testToString() {
        Budget budget = new Budget();
        assertNotNull("Default budget", budget.toString());
        budget.setId(null);
        assertNotNull("Budget Id null", budget.toString());
        budget.setName(null);
        assertNotNull("Budget Name null", budget.toString());
        budget.setCreated(null);
        assertNotNull("Budget Created null", budget.toString());
        budget.setGroups(null);
        assertNotNull("Default budget", budget.toString());
        budget.setAccounts(null);
        assertNotNull("Default budget", budget.toString());
        
    }
}
