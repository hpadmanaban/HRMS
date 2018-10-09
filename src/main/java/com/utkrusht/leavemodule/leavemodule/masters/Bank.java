package com.utkrusht.leavemodule.masters;

import com.utkrusht.leavemodule.connection.ConnectionAgent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String companyCode;
    private String code;
    private String name;
    private String branch;
    private String ifsc;
    private String address;
    private String city;
    private String modifiedBy;
    private String modifiedOn;
    public Bank(){
    }


    /**Setter & Getter Methods of all instance variables, related to Bank
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
    public void setBranch(String branch)
    {
        this.branch = branch;
    }
    public String getBranch()
    {
        return branch;
    }
    public void setIfsc(String ifsc)
    {
        this.ifsc = ifsc;
    }
    public String getIfsc()
    {
        return ifsc;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public String getAddress()
    {
        return address;
    }

    public void setCity(String city)
    {
        this.city = city;
    }
    public String getCity()
    {
        return city;
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


    public void update() throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        try
        {
            String query = "update bank set name = ?,modified_by = ?,modified_on = current_timestamp where code = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,name);
            ps.setString(2,modifiedBy);
            ps.setString(3,code);
            System.out.println(ps.toString());
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }


    public void create() throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        try
        {
            String query = "insert into bank(code, name,modified_by,modified_on) values(?,?,?,current_timestamp)";
            PreparedStatement ps = con.prepareStatement(query);
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
            String query = "select * from bank where code = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,this.code);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                this.name = rs.getString("NAME");
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


    public void delete() throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        try
        {
            String query = "delete from bank where code = ?";
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
    public static List<Bank> readAll() throws SQLException
    {

        List banksList = new ArrayList<Bank>();
        Connection con = ConnectionAgent.getConnection();
        try
        {
            String queryString = "select * from bank order by code";
            PreparedStatement ps = con.prepareStatement(queryString);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Bank bank = new Bank();
                bank.setCode(rs.getString("CODE"));
                bank.setName(rs.getString("NAME"));
                banksList.add(bank);
            }
            ps.close();
            rs.close();
            return banksList;
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public static boolean bankExists(String bankCode) throws SQLException
    {

        List banksList = new ArrayList<Bank>();
        Connection con = ConnectionAgent.getConnection();
        boolean found = false;
        String queryString = "select * from bank where code = ?";
        PreparedStatement ps = con.prepareStatement(queryString);
        ps.setString(1,bankCode);
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
