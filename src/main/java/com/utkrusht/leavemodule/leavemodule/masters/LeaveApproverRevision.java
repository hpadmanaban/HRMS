package com.utkrusht.leavemodule.masters;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.utkrusht.leavemodule.connection.ConnectionAgent;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author comp
 */
public class LeaveApproverRevision{
    private String companyCode;
    private String employeeCode;
    private String leaveCode;
    private int revisionNumber;
    private Date revisionDate;
    private String revisionDescription;
    private boolean selected;
    private String modifiedBy;
    private List<LeaveApprover> leaveApproversList;

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
     * @return the revisionDescription
     */
    public String getRevisionDescription() {
        return revisionDescription;
    }

    /**
     * @param revisionDescription the revisionDescription to set
     */
    public void setRevisionDescription(String revisionDescription) {
        this.revisionDescription = revisionDescription;
    }

    /**
     * @return the modifiedBy
     */
    public String getModifiedBy() {
        return modifiedBy;
    }

    /**
     * @param modifiedBy the modifiedBy to set
     */
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * @return the revisionNumber
     */
    public int getRevisionNumber() {
        return revisionNumber;
    }

    /**
     * @param revisionNumber the revisionNumber to set
     */
    public void setRevisionNumber(int revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    /**
     * @return the leaveApproversList
     */
    public List<LeaveApprover> getLeaveApproversList() {
        return leaveApproversList;
    }

    /**
     * @param leaveApproversList the leaveApproversList to set
     */
    public void setLeaveApproversList(List<LeaveApprover> leaveApproversList) {
        this.leaveApproversList = leaveApproversList;
    }

    /**
     * @return the mailCCsList
     */
    public void create() throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        try
        {
            String insertString = "insert into leave_approver_revision(employee_code,leave_code,revision_date,description,modified_by,modified_on) values(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(insertString);
            ps.setString(1,employeeCode);
            ps.setString(2,leaveCode);
            ps.setDate(3,new java.sql.Date(revisionDate.getTime()));
            ps.setString(4,revisionDescription);
            ps.setString(5,modifiedBy);
            ps.setTimestamp(6,new Timestamp(new Date().getTime()));
            ps.executeUpdate();
            ps.close();
            ps = null;
            createLeaveApprovers();

        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    private void createLeaveApprovers() throws SQLException
    {
        System.out.println("Leave Approvers List is " + leaveApproversList);
        for(int i=0; i < leaveApproversList.size();i++)
        {
            LeaveApprover leaveApprover = (LeaveApprover)leaveApproversList.get(i);
            leaveApprover.setCompanyCode(companyCode);
            leaveApprover.setEmployeeCode(employeeCode);
            leaveApprover.setLeaveCode(leaveCode);
            leaveApprover.setRevisionDate(revisionDate);
            leaveApprover.setModifiedBy(modifiedBy);
            leaveApprover.create();
        }
    }
    public static List<LeaveApproverRevision> readAll(String employeeCode,String leaveCode) throws SQLException
    {
        List<LeaveApproverRevision> leaveApproverRevisionsList = new ArrayList<LeaveApproverRevision>();
        Connection con = ConnectionAgent.getConnection();
        try
        {
            String queryString = "select * from leave_approver_revision where employee_code = ? and leave_code = ? order by revision_date desc;";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setString(1,employeeCode);
            ps.setString(2,leaveCode);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                LeaveApproverRevision leaveApproverRevision = new LeaveApproverRevision();
                leaveApproverRevision.setEmployeeCode(employeeCode);
                leaveApproverRevision.setLeaveCode(leaveCode);
                leaveApproverRevision.setRevisionDescription(rs.getString("description"));
                leaveApproverRevision.setRevisionDate(new Date(rs.getDate("revision_date").getTime()));
                leaveApproverRevision.setLeaveApproversList(LeaveApprover.readAll(employeeCode, leaveCode,new Date(rs.getDate("revision_date").getTime())));
                leaveApproverRevisionsList.add(leaveApproverRevision);
            }
            ps.close();
            rs.close();
            ps = null;
            rs = null;
            return leaveApproverRevisionsList;
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public static Date getRelevantRevisionDate(String employeeCode,String leaveCode,Date leaveStartDate) throws SQLException
    {
        Date relevantDate = null;

        Connection con = ConnectionAgent.getConnection();
        try
        {
            String queryString = "select revision_date from leave_approver_revision where employee_code = ? and leave_code = ? and revision_date <= ? order by revision_date desc";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setString(1,employeeCode);
            ps.setString(2,leaveCode);
            ps.setDate(3,new java.sql.Date(leaveStartDate.getTime()));
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                relevantDate = new Date(rs.getDate("revision_date").getTime());
                break;
            }
            ps.close();
            rs.close();
            ps = null;
            rs = null;
            return relevantDate;
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public static void delete(String employeeCode,String leaveCode) throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        try
        {
            String deleteString = "delete from leave_approver_revision where employee_code = ? and leave_code = ?";
            PreparedStatement ps = con.prepareStatement(deleteString);
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
            String deleteString = "delete from leave_approver_revision where employee_code = ?";
            PreparedStatement ps = con.prepareStatement(deleteString);
            ps.setString(1,employeeCode);
            ps.executeUpdate();
            ps.close();
            ps = null;
            LeaveApprover.deleteAll(employeeCode);
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public void addLeaveApprover()
    {
        if(leaveApproversList == null)
        {
            leaveApproversList = new ArrayList<LeaveApprover>();
        }
        LeaveApprover leaveApprover = new LeaveApprover();
        leaveApprover.setApproverNumber(leaveApproversList.size()+1);
        leaveApproversList.add(leaveApprover);
    }
    public static List<LeaveApprover> getDistinctApprovers(Date revisionDate,String employeeCode) throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        List allLeaveApproversList = new ArrayList<LeaveApprover>();
        try
        {
            List leavesList = Leave.readAll();
            String queryString = "select * from leave_approver_revision where revision_date <= ? and employee_code = ? and leave_code = ? order by revision_date desc";
            PreparedStatement ps = con.prepareStatement(queryString);
            ResultSet rs = null;
            ps.setDate(1,new java.sql.Date(revisionDate.getTime()));
            ps.setString(2,employeeCode);

            for(int i =0; i < leavesList.size();i++)
            {
                Leave leave = (Leave)leavesList.get(i);
                ps.setString(3,leave.getCode());
                rs = ps.executeQuery();
                Date relevantRevisionDate = null;
                while(rs.next())
                {
                    relevantRevisionDate = new Date(rs.getDate("revision_date").getTime());
                    break;
                }
                List leaveApproversList = LeaveApprover.readAll(employeeCode, leave.getCode(), relevantRevisionDate);
                for(int j=0; j < leaveApproversList.size();j++)
                {
                    LeaveApprover leaveApprover = (LeaveApprover)leaveApproversList.get(j);
                    boolean found = false;
                    for(int k=0; k < allLeaveApproversList.size();k++)
                    {
                        LeaveApprover allLeaveApprover = (LeaveApprover)(LeaveApprover)leaveApproversList.get(k);
                        if(leaveApprover.getApproverCode().equalsIgnoreCase(allLeaveApprover.getApproverCode()))
                        {
                            found = true;
                            break;
                        }
                    }
                    allLeaveApproversList.add(leaveApprover);
                }
            }
            ps.close();
            rs.close();
            ps = null;
            rs = null;
            return allLeaveApproversList;

        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }


    }
    /**
     * @return the companyCode
     */
    public String getCompanyCode() {
        return companyCode;
    }

    /**
     * @param companyCode the companyCode to set
     */
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    /**
     * @return the employeeCode
     */
    public String getEmployeeCode() {
        return employeeCode;
    }

    /**
     * @param employeeCode the employeeCode to set
     */
    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    /**
     * @return the leaveCode
     */
    public String getLeaveCode() {
        return leaveCode;
    }

    /**
     * @param leaveCode the leaveCode to set
     */
    public void setLeaveCode(String leaveCode) {
        this.leaveCode = leaveCode;
    }
}

