package com.utkrusht.leavemodule.masters;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */




import com.utkrusht.leavemodule.connection.ConnectionAgent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prasad
 */
public class Branch {
    private String companyCode;
    private String code;
    private String name;
    private String address;
    private String modifiedBy;
    private String modifiedOn;
    public Branch(){
    }


    /**Setter & Getter Methods of all instance variables, related to Branch
     *
     *
     */

    public void setCompanyCode(String companyCode)
    {
        this.companyCode = companyCode;
    }
    public String getCompanyCode()
    {
        return companyCode;
    }
    public void setCode(String code)
    {
        this.code = code;
    }
    public String getCode()
    {
        return code;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public String getAddress()
    {
        return address;
    }
    public void setModifiedBy(String modifiedBy)
    {
        this.modifiedBy = modifiedBy;
    }
    public String getModifiedBy()
    {
        return modifiedBy;
    }
    public void setModifiedOn(String modifiedOn)
    {
        this.modifiedOn = modifiedOn;
    }
    public String getModifiedOn()
    {
        return modifiedOn;
    }

    /**UPdate one Branch's details in the DB
     *
     */
    public void update() throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        try
        {
            String query = "update branch set name = ?, address = ?,modified_by = ?,modified_on = ? where code = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,name);
            ps.setString(2,address);
            ps.setString(3,modifiedBy);
            ps.setDate(4,new java.sql.Date(new java.util.Date().getTime()));
            ps.setString(5,code);
            System.out.println(ps.toString());
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }

    /**Create a new Banbk - record in the DB
     *
     */
    public void create() throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        try
        {
            String query = "insert into branch(code, name,address,modified_by,modified_on) values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,code);
            ps.setString(2,name);
            ps.setString(3,address);
            ps.setString(4,modifiedBy);
            ps.setDate(5,new java.sql.Date(new java.util.Date().getTime()));
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }

    /**Read one Branch's Details from the DB
     *

     */
    public void read() throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        try
        {
            String query = "select * from branch where code = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,this.code);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                this.name = rs.getString("NAME");
                this.address = rs.getString("ADDRESS");
                this.modifiedBy = rs.getString("MODIFIED_BY");
                this.modifiedOn = rs.getString("MODIFIED_ON");
            }
            rs.close();
            ps.close();
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public static List<Branch> readAll() throws SQLException
    {
        List branchesList = new ArrayList<Branch>();
        Connection con = ConnectionAgent.getConnection();
        try
        {
            String query = "select * from branch order by code";
            PreparedStatement ps = con.prepareStatement(query);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Branch branch = new Branch();
                branch.setCode(rs.getString("CODE"));
                branch.setName(rs.getString("NAME"));
                branch.setAddress(rs.getString("ADDRESS"));
                branchesList.add(branch);
            }
            rs.close();
            ps.close();
            return branchesList;
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }

    /** Delete one Branch's Details from the DB
     *
     */
    public void delete()
            throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        try
        {
            String query = "delete from branch where code = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,code);
            System.out.println(ps.toString());
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public static boolean branchExists(String branchCode) throws SQLException
    {

        List BranchsList = new ArrayList<Branch>();
        Connection con = ConnectionAgent.getConnection();
        boolean found = false;
        String queryString = "select * from branch where code = ?";
        PreparedStatement ps = con.prepareStatement(queryString);
        ps.setString(1,branchCode);
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            found = true;
        }
        ps.close();
        rs.close();
        return found;
    }
}

