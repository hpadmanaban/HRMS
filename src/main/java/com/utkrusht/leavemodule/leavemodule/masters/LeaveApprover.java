package com.utkrusht.leavemodule.masters;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.utkrusht.leavemodule.connection.ConnectionAgent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author comp
 */
public class LeaveApprover {
    private String  companyCode;
    private String  employeeCode;
    private String  leaveCode;
    private Date revisionDate;
    private String  approverCode;
    private String  approverName;
    private int     approverNumber;
    private String alternateApproverCode;
    private String alternateApproverName;
    private String  skipApproval;
    private int     daysWaitBeforeSkipApproval;
    private String  modifiedBy;
    private String employeeName;
    public LeaveApprover()
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
    public void setApproverCode(String approverCode)
    {
        this.approverCode = approverCode;
    }
    public String getApproverCode()
    {
        return approverCode;
    }
    public void setApproverName(String approverName)
    {
        this.approverName = approverName;
    }
    public String getApproverName()
    {
        return approverName;
    }
    public void setSkipApproval(String skipApproval)
    {
        this.skipApproval = skipApproval;
    }
    public String getSkipApproval()
    {
        return skipApproval;
    }
    public void setDaysWaitBeforeSkipApproval(int daysWaitBeforeSkipApproval)
    {
        this.daysWaitBeforeSkipApproval = daysWaitBeforeSkipApproval;
    }
    public int getDaysWaitBeforeSkipApproval()
    {
        return daysWaitBeforeSkipApproval;
    }
    public void setModifiedBy(String modifiedBy)
    {
        this.modifiedBy = modifiedBy;
    }
    public String getModifiedBy()
    {
        return modifiedBy;
    }
    public void create() throws SQLException
    {
        System.out.println("About to create leave approver for leave " + leaveCode);
        System.out.println("Company Code now os " + companyCode);
        Connection con = ConnectionAgent.getConnection();
        try
        {
            String insertString = "insert into leave_approver(employee_code,leave_code,revision_date,approver_code,approver_number,alternate_approver_code,modified_by,modified_on) values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(insertString);
            ps.setString(1,employeeCode);
            ps.setString(2,leaveCode);
            ps.setDate(3,new java.sql.Date(revisionDate.getTime()));
            ps.setString(4,approverCode);
            ps.setInt(5,approverNumber);
            ps.setString(6,alternateApproverCode);
            ps.setString(7,modifiedBy);
            ps.setTimestamp(8,new java.sql.Timestamp(new Date().getTime()));
            ps.executeUpdate();
            ps.close();
            ps = null;
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public static List<LeaveApprover> readAll(String employeeCode,String leaveCode,Date revisionDate) throws SQLException
    {

        Connection con = ConnectionAgent.getConnection();
        List leaveApproversList = new ArrayList();
        try
        {
            String queryString = "select a.*,concat(b.first_name,' ',b.middle_name,' ',b.last_name) as approver_name from leave_approver a,employee_master b where a.employee_code = ? and a.leave_code = ? and a.revision_date = ? and a.approver_code = b.code order by approver_number";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setString(1,employeeCode);
            ps.setString(2,leaveCode);
            ps.setDate(3,new java.sql.Date(revisionDate.getTime()));
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                LeaveApprover leaveApprover = new LeaveApprover();
                leaveApprover.setEmployeeCode(rs.getString("employee_code"));
                leaveApprover.setLeaveCode(rs.getString("leave_code"));
                leaveApprover.setDaysWaitBeforeSkipApproval(rs.getInt("days_wait_before_skip_approval"));
                leaveApprover.setSkipApproval(rs.getString("skip_approval"));
                leaveApprover.setApproverCode(rs.getString("approver_code"));
                leaveApprover.setApproverName(rs.getString("approver_name"));
                leaveApprover.setApproverNumber(rs.getInt("approver_number"));
                leaveApprover.setAlternateApproverCode(rs.getString("alternate_approver_code"));
                leaveApproversList.add(leaveApprover);
            }
            ps.close();
            rs.close();
            ps = null;
            rs = null;
            return leaveApproversList;
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }

    public static void deleteAll(String employeeCode,String leaveCode) throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        try
        {
            String deleteString = "delete from leave_approver where employee_code = ? and leave_code = ?";
            PreparedStatement ps = con.prepareStatement(deleteString);
            System.out.println("About to delete approvers of employee " + employeeCode);
            System.out.println("and the leave code " + leaveCode);
            ps.setString(1,employeeCode);
            ps.setString(2,leaveCode);
            ps.executeUpdate();
            ps.close();
            ps = null;
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
            String deleteString = "delete from leave_approver where employee_code = ?";
            PreparedStatement ps = con.prepareStatement(deleteString);
            System.out.println("About to delete approvers of employee " + employeeCode);
            ps.setString(1,employeeCode);
            ps.executeUpdate();
            ps.close();
            ps = null;
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    /**
     * @return the approverNumber
     */
    public int getApproverNumber() {
        return approverNumber;
    }

    /**
     * @param approverNumber the approverNumber to set
     */
    public void setApproverNumber(int approverNumber) {
        this.approverNumber = approverNumber;
    }

    /**
     * @return the revisionDate
     */
    public Date getRevisionDate() {
        return revisionDate;
    }

    /**
     * @param revisionDate the revisionDate to set
     */
    public void setRevisionDate(Date revisionDate) {
        this.revisionDate = revisionDate;
    }

    /**
     * @return the alternateApproverCode
     */
    public String getAlternateApproverCode() {
        return alternateApproverCode;
    }

    /**
     * @param alternateApproverCode the alternateApproverCode to set
     */
    public void setAlternateApproverCode(String alternateApproverCode) {
        this.alternateApproverCode = alternateApproverCode;
    }

    /**
     * @return the alternateApproverName
     */
    public String getAlternateApproverName() {
        return alternateApproverName;
    }

    /**
     * @param alternateApproverName the alternateApproverName to set
     */
    public void setAlternateApproverName(String alternateApproverName) {
        this.alternateApproverName = alternateApproverName;
    }
}


