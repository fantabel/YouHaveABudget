package com.fantabel.yhab.tests.entity;

import com.fantabel.yhab.model.entity.Budget;

import org.junit.Test;
import static org.junit.Assert.*;

public class BudgetTest {
    @Test
    public void testDefaultConstructor() {
        Budget budget = new Budget();
        System.out.println(budget.toString());
        assertNotNull(budget.getName());
        assertNotNull(budget.getCreated());
        assertNotNull(budget.getId());
    }
    
    @Test
    public void testConstructorName() {
        fail("Not implemented");
    }
    
    @Test
    public void testConstructorNameAndCreated() {
        fail("Not implemented");
    }
    
    @Test
    public void testNameGetter() {
        fail("Not implemented");
    }
    
    @Test
    public void testNameSetter() {
        fail("Not implemented");
    }
    
    @Test
    public void testCreatedGetter() {
        fail("Not implemented");
    }
    
    @Test
    public void testCreatedSetter() {
        fail("Not implemented");
    }
    
    
    @Test
    public void testIdGetter() {
        fail("Not implemented");
    }
    
    @Test
    public void testIdSetter() {
        fail("Not implemented");
    }
}
