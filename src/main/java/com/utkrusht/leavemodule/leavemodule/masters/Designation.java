package com.utkrusht.leavemodule.masters;

/*
 * Department.java
 *
 * Created on November 3, 2007, 12:53 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

import com.utkrusht.leavemodule.connection.ConnectionAgent;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manjunath
 */
public class Designation {
    private String companyCode;
    private String code;
    private String name;
    private String modifiedBy;
    private String modifiedOn;
    /** Creates a new instance of Department */
    public Designation() {

    }
    public void setCompanyCode(String companyCode)
    {
        this.companyCode = companyCode;
    }
    public String getCompanyCode()
    {
        return companyCode;
    }
    public String getCode()
    {
        return code;
    }
    public void setCode(String code)
    {
        this.code = code;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getModifiedBy()
    {
        return modifiedBy;
    }
    public void setModifiedBy(String modifiedBy)
    {
        this.modifiedBy = modifiedBy;
    }
    public String getModifiedOn()
    {
        return modifiedOn;
    }
    public void setModifiedOn(String modifiedOn)
    {
        this.modifiedOn = modifiedOn;
    }
    public void create() throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        try
        {
            String insertString = "insert into designation(code,name,modified_by,modified_on) values(?,?,?,current_timestamp)";
            PreparedStatement ps = con.prepareStatement(insertString);
            ps.setString(1,code);
            ps.setString(2,name);
            ps.setString(3,modifiedBy);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public void read() throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        try
        {

            String queryString = "select * from designatiion where code = ?";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setString(1,code);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                code = rs.getString("CODE");
                name = rs.getString("NAME");
                modifiedBy = rs.getString("MODIFIED_BY");
                modifiedOn = rs.getString("MODIFIED_ON");
            }
            rs.close();
            ps.close();
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public static boolean exists(String code) throws SQLException
    {
        boolean exists = false;
        Connection con = ConnectionAgent.getConnection();
        try
        {

            String queryString = "select * from designation where code = ?";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setString(1,code);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                exists = true;
            }
            rs.close();
            ps.close();
            return exists;
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public void update() throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        try
        {
            String updateString = "update designation set name=?,modified_by=?,modified_on=current_timestamp where code = ?";
            PreparedStatement ps = con.prepareStatement(updateString);
            ps.setString(1,name);
            ps.setString(2,modifiedBy);
            ps.setString(3,code);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public void delete() throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        try
        {
            String deleteString = "delete from designation where code = ?";
            PreparedStatement ps = con.prepareStatement(deleteString);
            ps.setString(1,code);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage()) ;
        }

    }
    public static List readAll() throws SQLException
    {
        List designationsList = new ArrayList<Designation>();

        Connection con = ConnectionAgent.getConnection();
        try
        {
            String queryString = "select * from designation order by code";
            PreparedStatement ps = con.prepareStatement(queryString);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Designation designation = new Designation();
                designation.setCode(rs.getString("CODE"));
                designation.setName(rs.getString("NAME"));
                designationsList.add(designation);
            }
            ps.close();
            rs.close();
            return designationsList;
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
}
