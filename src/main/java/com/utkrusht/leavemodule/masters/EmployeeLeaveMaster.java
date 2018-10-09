package com.utkrusht.leavemodule.masters;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.utkrusht.leavemodule.connection.ConnectionAgent;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author comp
 */
public class EmployeeLeaveMaster {
    private String companyCode;
    private String employeeCode;
    private String employeeName;
    private String leaveCode;
    private String leaveName;
    private double totalLeave;
    private String startingFrom;
    private String creditFrequency;
    private String creditTime;
    private String negativeBalanceAllowed;
    private String allowCarryForward;
    private double maxCarryForward;
    private List<LeaveApproverRevision> leaveApproverRevisionsList;
//    private List<LeaveMailCCRevision>leaveMailCCRevisionsList;
    private String modifiedBy;
    private String rowClass;
    private String errorString;
    public EmployeeLeaveMaster()
    {

    }
    public void setCompanyCode(String companyCode)
    {
        this.companyCode = companyCode;
    }
    public String getCompanyCode()
    {
        return companyCode;
    }
    public void setEmployeeCode(String employeeCode)
    {
        this.employeeCode = employeeCode;
    }
    public String getEmployeeCode()
    {
        return employeeCode;
    }
    public void setEmployeeName(String employeeName)
    {
        this.employeeName = employeeName;
    }
    public String getEmployeeName()
    {
        return employeeName;
    }
    public void setLeaveCode(String leaveCode)
    {
        this.leaveCode = leaveCode;
    }
    public String getLeaveCode()
    {
        return leaveCode;
    }
    public void setLeaveName(String leaveName)
    {
        this.leaveName = leaveName;
    }
    public String getLeaveName()
    {
        return leaveName;
    }
    public void setTotalLeave(double totalLeave)
    {
        this.totalLeave = totalLeave;
    }
    public double getTotalLeave()
    {
        return totalLeave;
    }
    public void setStartingFrom(String startingFrom)
    {
        this.startingFrom = startingFrom;
    }
    public String getStartingFrom()
    {
        return startingFrom;
    }
    public void setCreditFrequency(String creditFrequency)
    {
        this.creditFrequency = creditFrequency;
    }
    public String getCreditFrequency()
    {
        return creditFrequency;
    }
    public void setCreditTime(String creditTime)
    {
        this.creditTime = creditTime;
    }
    public String getCreditTime()
    {
        return creditTime;
    }
    public void setNegativeBalanceAllowed(String negativeBalanceAllowed)
    {
        this.negativeBalanceAllowed = negativeBalanceAllowed;
    }
    public String getNegativeBalanceAllowed()
    {
        return negativeBalanceAllowed;
    }
    public void setAllowCarryForward(String allowCarryForward)
    {
        this.allowCarryForward = allowCarryForward;
    }
    public String getAllowCarryForward()
    {
        return allowCarryForward;
    }
    public void setMaxCarryForward(double maxCarryForward)
    {
        this.maxCarryForward = maxCarryForward;
    }
    public double getMaxCarryForward()
    {
        return maxCarryForward;
    }
    public void setModifiedBy(String modifiedBy)
    {
        this.modifiedBy = modifiedBy;
    }
    public String getModifiedBy()
    {
        return modifiedBy;
    }
    public void setRowClass(String rowClass)
    {
        this.rowClass = rowClass;
    }
    public String getRowClass()
    {
        if(errorString == null)
        {
            rowClass = "errorRow";
        }
        else
        {
            if(!errorString.isEmpty())
            {
                rowClass = "errorRow";
            }
            else
            {
                rowClass = "normalRow";
            }
        }
        return rowClass;
    }
    public static List<EmployeeLeaveMaster> readAll(String employeeCode) throws SQLException
    {
        List employeeLeaveMastersList = new ArrayList<EmployeeLeaveMaster>();

        Connection con = ConnectionAgent.getConnection();
        try
        {
            String queryString = "select a.employee_code,a.leave_code,a.total_leave_for_the_year,a.starting_from,a.credit_frequency,a.credit_time,a.negative_balance_allowed,concat(b.first_name,' ',b.middle_name,' ',b.last_name) as employee_name,c.name as leave_name,a.allow_carry_forward,a.max_carry_forward from employee_leave_master a,employee_master b,leave_master c where a.employee_code = ? and a.employee_code = b.code and a.leave_code = c.code order by leave_code";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setString(1,employeeCode);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                EmployeeLeaveMaster employeeLeaveMaster = new EmployeeLeaveMaster();
                employeeLeaveMaster.setEmployeeCode(employeeCode);
                employeeLeaveMaster.setLeaveCode(rs.getString("leave_code"));
                employeeLeaveMaster.setEmployeeName(rs.getString("employee_name"));
                employeeLeaveMaster.setLeaveName(rs.getString("leave_name"));
                employeeLeaveMaster.setTotalLeave(rs.getDouble("total_leave_for_the_year"));
                employeeLeaveMaster.setCreditFrequency(rs.getString("credit_frequency"));
                employeeLeaveMaster.setNegativeBalanceAllowed(rs.getString("negative_balance_allowed"));
                employeeLeaveMaster.setAllowCarryForward(rs.getString("allow_carry_forward"));
                employeeLeaveMaster.setMaxCarryForward(rs.getDouble("max_carry_forward"));
                employeeLeaveMaster.setLeaveApproverRevisionsList(LeaveApproverRevision.readAll(employeeCode,rs.getString("leave_code")));
//                employeeLeaveMaster.setLeaveMailCCRevisionsList(LeaveMailCCRevision.readAll(employeeCode,rs.getString("leave_code")));
                employeeLeaveMastersList.add(employeeLeaveMaster);
            }
            ps.close();
            rs.close();
            ps = null;
            rs = null;
            return employeeLeaveMastersList;
        }
        catch(SQLException e)
        {
            System.out.println("Error reading employee leave master " + e.getMessage());
            throw new SQLException(e.getMessage());
        }


    }
    public void read()
    {
        try
        {
            Connection con = ConnectionAgent.getConnection();
            String queryString = "select a.employee_code,a.leave_code,a.total_leave_for_the_year,a.starting_from,a.credit_frequency,a.credit_time,a.negative_balance_allowed,concat(b.first_name,' ',b.middle_name,' ',b.last_name) as employee_name,c.name as leave_name,a.allow_carry_forward,a.max_carry_forward from employee_leave_master a,employee_master b,leave_master c where a.employee_code = ? and a.leave_code = ? and a.employee_code = b.code and a.leave_code = c.code";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setString(1,employeeCode);
            ps.setString(2,leaveCode);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                employeeCode = rs.getString("employee_code");
                leaveCode = rs.getString("leave_code");
                employeeName = rs.getString("employee_name");
                leaveName = rs.getString("leave_name");
                totalLeave = rs.getDouble("total_leave_for_the_year");
                startingFrom = rs.getString("starting_from");
                creditFrequency = rs.getString("credit_frequency");
                creditTime = rs.getString("credit_time");
                negativeBalanceAllowed = rs.getString("negative_balance_allowed");
                allowCarryForward = rs.getString("allow_carry_forward");
                maxCarryForward = rs.getDouble("max_carry_forward");
            }
            ps.close();
            rs.close();

            readLeaveApproverRevisions();
//            readLeaveMailCCRevisions();
        }
        catch(SQLException e)
        {
            System.out.println("Error while reading Employee Leave Master " + e.getMessage());
        }
    }
    private void readLeaveApproverRevisions() throws SQLException
    {
        try
        {
            leaveApproverRevisionsList = LeaveApproverRevision.readAll(employeeCode,leaveCode);
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
    }
/*    private void readLeaveMailCCRevisions() throws SQLException
    {
        try
        {
            leaveMailCCRevisionsList = LeaveMailCCRevision.readAll(employeeCode,leaveCode);
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
    } */
    public void create() throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        String queryString = "select * from employee_leave_master where employee_code = ? and leave_code = ?";
        PreparedStatement ps = con.prepareStatement(queryString);
        ps.setString(1,employeeCode);
        ps.setString(2,leaveCode);
        ResultSet rs = ps.executeQuery();
        int count = 0;
        while(rs.next())
        {
            count = count + 1;
        }
        if(count > 0)
        {
            String updateString = "update employee_leave_master set total_leave_for_the_year = ?,starting_from = ?,credit_frequency = ?,credit_time = ?,negative_balance_allowed = ?,allow_carry_forward = ?,max_carry_forward = ?,modified_by = ?,modified_on = current_timestamp where employee_code = ? and leave_code = ?";
            ps = con.prepareStatement(updateString);
            ps.setDouble(1,totalLeave);
            ps.setString(2,startingFrom);
            ps.setString(3,creditFrequency);
            ps.setString(4,creditTime);
            ps.setString(5,negativeBalanceAllowed);
            ps.setString(6,allowCarryForward);
            ps.setDouble(7,maxCarryForward);
            ps.setString(8,modifiedBy);
            ps.setString(9,employeeCode);
            ps.setString(10,leaveCode);
            ps.executeUpdate();
        }
        else
        {
            String insertString = "insert into employee_leave_master(employee_code,leave_code,total_leave_for_the_year,starting_from,credit_frequency,credit_time,negative_balance_allowed,allow_carry_forward,max_carry_forward,modified_by,modified_on) values(?,?,?,?,?,?,?,?,?,?,current_timestamp)";

            ps = con.prepareStatement(insertString);
            ps.setString(1,employeeCode);
            ps.setString(2,leaveCode);
            ps.setDouble(3,totalLeave);
            ps.setString(4,startingFrom);
            ps.setString(5,creditFrequency);
            ps.setString(6,creditTime);
            ps.setString(7,negativeBalanceAllowed);
            ps.setString(8,allowCarryForward);
            ps.setDouble(9,maxCarryForward);
            ps.setString(10,modifiedBy);
            ps.executeUpdate();
        }
        ps.close();
        deleteApproverRevisions();
        createApproverRevisions();
//        deleteLeaveMailCCRevisions();
//        createLeaveMailCCRevisions();
    }
    public void createApproverRevisions() throws SQLException
    {
        try
        {
            for(int i=0; i < leaveApproverRevisionsList.size();i++)
            {
                LeaveApproverRevision leaveApproverRevision = (LeaveApproverRevision)leaveApproverRevisionsList.get(i);
                leaveApproverRevision.setCompanyCode(companyCode);
                leaveApproverRevision.setEmployeeCode(employeeCode);
                leaveApproverRevision.setLeaveCode(leaveCode);
                leaveApproverRevision.create();
            }
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
    }
    public void deleteApproverRevisions() throws SQLException
    {
        try
        {
            LeaveApproverRevision.delete(employeeCode, leaveCode);
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
    }
/*    public void createLeaveMailCCRevisions() throws SQLException
    {
        try
        {
            for(int i=0; i < leaveMailCCRevisionsList.size();i++)
            {
                LeaveMailCCRevision leaveMailCCRevision = (LeaveMailCCRevision)leaveMailCCRevisionsList.get(i);
                leaveMailCCRevision.setCompanyCode(companyCode);
                leaveMailCCRevision.setEmployeeCode(employeeCode);
                leaveMailCCRevision.setLeaveCode(leaveCode);
                leaveMailCCRevision.setModifiedBy(modifiedBy);
                leaveMailCCRevision.create();
            }
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
    } */
/*    public void deleteLeaveMailCCRevisions() throws SQLException
    {
        try
        {
            LeaveMailCCRevision.delete(employeeCode, leaveCode);
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
    } */
    public static List<EmployeeLeaveMaster> readAll(String employeeCode,String leaveCode) throws SQLException
    {

        Connection con = ConnectionAgent.getConnection();
        List employeeLeavesList = new ArrayList();
        try
        {

            String queryString = "select a.*,concat(b.first_name,' ',middle_name,' ',last_name) as employee_name,c.name as leave_name from employee_leave_master a,employee_master b,leave_master c where a.employee_code = b.code and a.leave_code = c.code";
            if(!employeeCode.equalsIgnoreCase("-1"))
            {
                queryString = queryString + " and a.employee_code = ?";
            }
            if(!leaveCode.equalsIgnoreCase("-1"))
            {
                queryString = queryString + " and a.leave_code = ?";
            }
            queryString = queryString + " order by a.employee_code,a.leave_code";
            System.out.println("Query to execute is " + queryString);
            PreparedStatement ps = con.prepareStatement(queryString);
            if(!employeeCode.equalsIgnoreCase("-1") && leaveCode.equalsIgnoreCase("-1"))
            {
                ps.setString(1,employeeCode);
            }
            if(employeeCode.equalsIgnoreCase("-1") && !leaveCode.equalsIgnoreCase("-1"))
            {
                ps.setString(1,leaveCode);
            }
            if(!employeeCode.equalsIgnoreCase("-1") && !leaveCode.equalsIgnoreCase("-1"))
            {
                System.err.println("Selected employee is not -1 and selected leave is not -1");
                ps.setString(1,employeeCode);
                ps.setString(2,leaveCode);
            }
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {

                EmployeeLeaveMaster employeeLeave = new EmployeeLeaveMaster();
                employeeLeave.setEmployeeCode(rs.getString("employee_code"));
                employeeLeave.setEmployeeName(rs.getString("employee_name"));
                employeeLeave.setLeaveCode(rs.getString("leave_code"));
                employeeLeave.setLeaveName(rs.getString("leave_name"));
                employeeLeave.setCreditFrequency(rs.getString("credit_frequency"));
                employeeLeave.setCreditTime(rs.getString("credit_time"));
                employeeLeave.setStartingFrom(rs.getString("starting_from"));
                employeeLeave.setNegativeBalanceAllowed(rs.getString("negative_balance_allowed"));
                employeeLeave.setTotalLeave(rs.getDouble("total_leave_for_the_year"));
                employeeLeavesList.add(employeeLeave);
            }
            rs.close();
            ps.close();
            rs = null;
            ps = null;
            return employeeLeavesList;
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public static void deleteAll(String employeeCode) throws SQLException
    {

        Connection con = ConnectionAgent.getConnection();
        try
        {
            String deleteString = "delete from employee_leave_master where employee_code = ?";
            PreparedStatement ps = con.prepareStatement(deleteString);
            ps.setString(1,employeeCode);
            ps.executeUpdate();
            ps.close();
            ps = null;
            LeaveApproverRevision.deleteAll(employeeCode);
//            LeaveMailCCRevision.deleteAll(employeeCode);
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public void delete()
    {
        try
        {
            String deleteString = "delete from employee_leave_master where employee_code = ? and leave_code = ?";
            Connection con = ConnectionAgent.getConnection();
            PreparedStatement ps = con.prepareStatement(deleteString);
            ps.setString(1,employeeCode);
            ps.setString(2,leaveCode);
            ps.executeUpdate();
            ps.close();
            deleteApproverRevisions();
//            deleteLeaveMailCCRevisions();
        }
        catch(SQLException e)
        {
            System.out.println("Error while deleting employee leave master " + e.getMessage());
        }
    }
    public ArrayList listAllLeavesForTheEmployee() throws SQLException
    {
        ArrayList leavesList = new ArrayList();
        Connection con = ConnectionAgent.getConnection();
        String queryString = "select leave_code from employee_leave_master where employee_code = ?";
        PreparedStatement ps = con.prepareStatement(queryString);
        ps.setString(1,employeeCode);
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            leavesList.add(rs.getString("LEAVE_CODE"));
        }
        ps.close();
        rs.close();
        return leavesList;
    }
    public void addLeaveApproverRevision()
    {
        if(leaveApproverRevisionsList == null)
        {
            leaveApproverRevisionsList = new ArrayList<LeaveApproverRevision>();
        }
        LeaveApproverRevision leaveApproverRevision = new LeaveApproverRevision();
        leaveApproverRevisionsList.add(leaveApproverRevision);
    }
/*    public void addLeaveMailCCRevision()
    {
        if(leaveMailCCRevisionsList == null)
        {
            leaveMailCCRevisionsList = new ArrayList<LeaveMailCCRevision>();
        }
        LeaveMailCCRevision leaveMailCCRevision = new LeaveMailCCRevision();
        leaveMailCCRevisionsList.add(leaveMailCCRevision);
    } */
    public void removeLeaveApproverRevision(LeaveApproverRevision leaveApproverRevision)
    {
        leaveApproverRevisionsList.remove(leaveApproverRevision);
    }
/*    public void removeLeaveMailCCRevision(LeaveMailCCRevision leaveMailCCRevision)
    {
        leaveMailCCRevisionsList.remove(leaveMailCCRevision);
    } */
    /**
     * @return the errorString
     */
    public String getErrorString() {
        return errorString;
    }

    /**
     * @param errorString the errorString to set
     */
    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }

    /**
     * @return the leaveMailCCsList
     */
/*    public List getLeaveMailCCRevisionsList() {
        return leaveMailCCRevisionsList;
    } */

    /**
     * @param leaveMailCCsList the leaveMailCCsList to set
     */

    /**
     * @return the leaveApproverRevisionsList
     */
    public List<LeaveApproverRevision> getLeaveApproverRevisionsList() {
        return leaveApproverRevisionsList;
    }

    /**
     * @param leaveApproverRevisionsList the leaveApproverRevisionsList to set
     */
    public void setLeaveApproverRevisionsList(List<LeaveApproverRevision> leaveApproverRevisionsList) {
        this.leaveApproverRevisionsList = leaveApproverRevisionsList;
    }

    /**
     * @param leaveMailCCRevisionsList the leaveMailCCRevisionsList to set
     */
/*    public void setLeaveMailCCRevisionsList(List<LeaveMailCCRevision> leaveMailCCRevisionsList) {
        this.leaveMailCCRevisionsList = leaveMailCCRevisionsList;
    } */



}

