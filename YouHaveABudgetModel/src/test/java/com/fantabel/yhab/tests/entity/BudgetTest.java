package com.fantabel.yhab.tests.entity;

import com.fantabel.yhab.model.entity.Budget;

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
    public void testConstructorName() {
        //fail("Not implemented");
    }
    
    @Test
    public void testConstructorNameAndCreated() {
        //fail("Not implemented");
    }
    
    @Test
    public void testConstructorNameCreatedAndId() {
        
    }
    
    @Test
    public void testNameGetter() {
        //fail("Not implemented");
    }
    
    @Test
    public void testNameSetter() {
        //fail("Not implemented");
    }
    
    @Test
    public void testCreatedGetter() {
        //fail("Not implemented");
    }
    
    @Test
    public void testCreatedSetter() {
        //fail("Not implemented");
    }

    @Test
    public void testIdGetter() {
        //fail("Not implemented");
    }
    
    @Test
    public void testIdSetter() {
        //fail("Not implemented");
    }
}
