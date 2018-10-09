package com.utkrusht.leavemodule.masters;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.utkrusht.leavemodule.masters.Department;

import java.sql.SQLException;

import static org.testng.Assert.*;

public class DepartmentTest {

    Department department;
    @BeforeMethod
    public void setUp() {
        department = new Department();
    }


    @AfterMethod
    public void tearDown() {
        department = null;
    }


    @Test
    public void testSetCompanyCode() {
    }

    @Test
    public void testGetCompanyCode() {
    }

    @Test
    public void testGetCode() {
    }

    @Test
    public void testSetCode() {
    }

    @Test
    public void testGetName() {
    }

    @Test
    public void testSetName() {
    }

    @Test
    public void testGetModifiedBy() {
    }

    @Test
    public void testSetModifiedBy() {
    }

    @Test
    public void testGetModifiedOn() {
    }

    @Test
    public void testSetModifiedOn() {
    }

    @Test
    public void testCreate() throws SQLException {
        department.setCode("HR");
        department.setName("Human Resource");
        department.setModifiedBy("SYSADMIN");
        department.create();
    }

    @Test
    public void testRead() {
    }

    @Test
    public void testExists() {
    }

    @Test
    public void testUpdate() throws SQLException{
        department.setName("Administration");
        department.setCode("HR");
        department.setModifiedBy("SYSADMIN");
        department.update();
    }

    @Test
    public void testDelete() {
    }

    @Test
    public void testReadAll() {
    }
}