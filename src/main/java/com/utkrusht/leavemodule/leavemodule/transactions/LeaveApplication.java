package com.utkrusht.leavemodule.transactions;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.utkrusht.leavemodule.connection.ConnectionAgent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


/**
 *
 * @author comp
 */
public class LeaveApplication {
    private String companyCode;
    private String employeeCode;
    private String employeeName;
    private String leaveCode;
    private Date   applicationDate;
    private String applicationDateAsString;
    private Date   startDate;
    private String startDateAsString;
    private String startMorningOrAfterNoon;
    private double numberOfDays;
    private String reason;
    private int    applicationNumber;
    private String modifiedBy;
    private Date   endDate;
    private String endDateAsString;
    private String endAfterNoonOrEvening;
    private String status;
    private int approverNumber;
    private String approverCode;
    private String approverName;
    private String alternateApproverCode;
    private String reasonForRejection;
    private boolean selected;
    private SimpleDateFormat dateFormat;
    public LeaveApplication()
    {
        dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
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

    /**
     * @return the applicationDate
     */
    public Date getApplicationDate() {
        return applicationDate;
    }

    /**
     * @param applicationDate the applicationDate to set
     */
    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the startMorningOrAfterNoon
     */
    public String getStartMorningOrAfterNoon() {
        return startMorningOrAfterNoon;
    }

    /**
     * @param startMorningOrAfterNoon the startMorningOrAfterNoon to set
     */
    public void setStartMorningOrAfterNoon(String startMorningOrAfterNoon) {
        this.startMorningOrAfterNoon = startMorningOrAfterNoon;
    }

    /**
     * @return the numberOfDays
     */
    public double getNumberOfDays() {
        return numberOfDays;
    }

    /**
     * @param numberOfDays the numberOfDays to set
     */
    public void setNumberOfDays(double numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * @return the applicationNumber
     */
    public int getApplicationNumber() {
        return applicationNumber;
    }

    /**
     * @param applicationNumber the applicationNumber to set
     */
    public void setApplicationNumber(int applicationNumber) {
        this.applicationNumber = applicationNumber;
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
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the endAfterNoonOrEvening
     */
    public String getEndAfterNoonOrEvening() {
        return endAfterNoonOrEvening;
    }

    /**
     * @param endAfterNoonOrEvening the endAfterNoonOrEvening to set
     */
    public void setEndAfterNoonOrEvening(String endAfterNoonOrEvening) {
        this.endAfterNoonOrEvening = endAfterNoonOrEvening;
    }
    public void create() throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        try
        {
            String queryString = "select application_number from employee_leave_application where employee_code = ? and leave_code = ? order by application_number desc";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setString(1,employeeCode);
            ps.setString(2,leaveCode);
            ResultSet rs = ps.executeQuery();
            int applicationNumber = 0;
            while(rs.next())
            {
                applicationNumber = rs.getInt("application_number");
                break;
            }
            applicationNumber = applicationNumber + 1;
            String insertString = "insert into employee_leave_application(employee_code,leave_code,application_number,application_date,leave_start_date,start_morning_or_after_noon,leave_end_date,end_after_noon_or_evening,number_of_days,reason,status,approver_code,alternate_approver_code,approver_number,modified_by,modified_on) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(insertString);
            ps.setString(1,employeeCode);
            ps.setString(2,leaveCode);
            ps.setInt(3,applicationNumber);
            ps.setDate(4,new java.sql.Date(applicationDate.getTime()));
            ps.setDate(5,new java.sql.Date(startDate.getTime()));
            ps.setString(6,startMorningOrAfterNoon);
            ps.setDate(7,new java.sql.Date(endDate.getTime()));
            ps.setString(8,endAfterNoonOrEvening);
            ps.setDouble(9,numberOfDays);
            ps.setString(10,reason);
            ps.setString(11,status);
            ps.setString(12,approverCode);
            ps.setString(13,alternateApproverCode);
            ps.setInt(14,approverNumber);
            ps.setString(15,modifiedBy);
            ps.setTimestamp(16,new java.sql.Timestamp(new Date().getTime()));
            ps.executeUpdate();
            this.applicationNumber = applicationNumber;
            ps.close();
            rs.close();
            ps = null;
            rs = null;
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public void updateLeaveApplicationAndStatus() throws SQLException
    {

        Connection con = ConnectionAgent.getConnection();
        try
        {
            String updateString = "update employee_leave_application set application_date = ?,leave_start_date = ?,start_morning_or_after_noon = ?,leave_end_date = ?,end_after_noon_or_evening = ?,number_of_days = ?,reason = ?,status = ?,approver_code = ?,approver_number = ?,modified_by = ?,modified_on=? where employee_code = ? and leave_code = ? and application_number = ?";
            PreparedStatement ps = con.prepareStatement(updateString);
            ps.setDate(1,new java.sql.Date(applicationDate.getTime()));
            ps.setDate(2,new java.sql.Date(startDate.getTime()));
            ps.setString(3,startMorningOrAfterNoon);
            ps.setDate(4,new java.sql.Date(endDate.getTime()));
            ps.setString(5,endAfterNoonOrEvening);
            ps.setDouble(6,numberOfDays);
            ps.setString(7,reason);
            ps.setString(8,status);
            ps.setString(9,approverCode);
            ps.setInt(10,approverNumber);
            ps.setString(11,modifiedBy);
            ps.setTimestamp(12,new java.sql.Timestamp(new Date().getTime()));
            ps.setString(13,employeeCode);
            ps.setString(14,leaveCode);
            ps.setInt(15,applicationNumber);
            ps.executeUpdate();
            ps.close();
            ps = null;
        }
        catch(SQLException e)
        {
            System.out.println("Error updating Leave Application " + e.getMessage());
            throw new SQLException(e.getMessage());
        }
    }
    public void updateStatus() throws SQLException
    {

        Connection con = ConnectionAgent.getConnection();
        try
        {
            String updateStatusString = "update employee_leave_application set status = ?,reason_for_rejection = ? where employee_code = ? and leave_code = ? and application_number = ?";
            PreparedStatement ps = con.prepareStatement(updateStatusString);
            ps.setString(1,status);
            ps.setString(2,reasonForRejection);
            ps.setString(3,employeeCode);
            ps.setString(4,leaveCode);
            ps.setInt(5,applicationNumber);
            ps.executeUpdate();
            ps.close();
            ps = null;
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public static List<LeaveApplication> readAllApplicationsForAnEmployee(String employeeCode) throws SQLException
    {
        List leaveApplicationsList = new ArrayList<LeaveApplication>();

        Connection con = ConnectionAgent.getConnection();
        try
        {
            String queryString = "select * from employee_leave_application where employee_code = ? order by leave_start_date desc";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setString(1,employeeCode);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                LeaveApplication leaveApplication = new LeaveApplication();
                leaveApplication.setApplicationDate(new Date(rs.getDate("application_date").getTime()));
                leaveApplication.setApplicationNumber(rs.getInt("application_number"));
                leaveApplication.setApproverCode(rs.getString("approver_code"));
                leaveApplication.setApproverNumber(rs.getInt("approver_number"));
                leaveApplication.setEmployeeCode(rs.getString("employee_code"));
                leaveApplication.setEndAfterNoonOrEvening(rs.getString("end_after_noon_or_evening"));
                leaveApplication.setEndDate(new Date(rs.getDate("leave_end_date").getTime()));
                leaveApplication.setLeaveCode(rs.getString("leave_code"));
                leaveApplication.setNumberOfDays(rs.getDouble("number_of_days"));
                leaveApplication.setReason(rs.getString("reason"));
                leaveApplication.setStartDate(new Date(rs.getDate("leave_start_date").getTime()));
                leaveApplication.setStartMorningOrAfterNoon(rs.getString("start_morning_or_after_noon"));
                leaveApplication.setStatus(rs.getString("status"));
                leaveApplication.setReasonForRejection(rs.getString("reason_for_rejection"));
                leaveApplicationsList.add(leaveApplication);
            }
            ps.close();
            rs.close();
            ps = null;
            rs = null;
            return leaveApplicationsList;
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public static List<LeaveApplication> readAllODApplicationsForAnEmployee(String employeeCode) throws SQLException
    {
        List leaveApplicationsList = new ArrayList<LeaveApplication>();

        Connection con = ConnectionAgent.getConnection();
        try
        {
            String queryString = "select * from employee_leave_application where employee_code = ? and leave_code = 'OD' order by leave_start_date desc";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setString(1,employeeCode);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                LeaveApplication leaveApplication = new LeaveApplication();
                leaveApplication.setApplicationDate(new Date(rs.getDate("application_date").getTime()));
                leaveApplication.setApplicationNumber(rs.getInt("application_number"));
                leaveApplication.setApproverCode(rs.getString("approver_code"));
                leaveApplication.setApproverNumber(rs.getInt("approver_number"));
                leaveApplication.setEmployeeCode(rs.getString("employee_code"));
                leaveApplication.setEndAfterNoonOrEvening(rs.getString("end_after_noon_or_evening"));
                leaveApplication.setEndDate(new Date(rs.getDate("leave_end_date").getTime()));
                leaveApplication.setLeaveCode(rs.getString("leave_code"));
                leaveApplication.setNumberOfDays(rs.getDouble("number_of_days"));
                leaveApplication.setReason(rs.getString("reason"));
                leaveApplication.setStartDate(new Date(rs.getDate("leave_start_date").getTime()));
                leaveApplication.setStartMorningOrAfterNoon(rs.getString("start_morning_or_after_noon"));
                leaveApplication.setStatus(rs.getString("status"));
                leaveApplication.setReasonForRejection(rs.getString("reason_for_rejection"));
                leaveApplicationsList.add(leaveApplication);
            }
            ps.close();
            rs.close();
            ps = null;
            rs = null;
            return leaveApplicationsList;
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public static List<LeaveApplication> readAllNotRejectedApplicationsForAnEmployee(String employeeCode,Date dateFrom,Date dateTo) throws SQLException
    {
        List leaveApplicationsList = new ArrayList<LeaveApplication>();

        Connection con = ConnectionAgent.getConnection();
        try
        {
            String queryString = "select * from employee_leave_application where employee_code = ? and ((leave_start_date between ? and ?) or (leave_end_date between ? and ?)) and (status = 'PENDING' or status = 'APPROVED' or status= 'CANCELREJECTED' or status='CANDELPENDING') order by leave_start_date";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setString(1,employeeCode);
            ps.setDate(2,new java.sql.Date(dateFrom.getTime()));
            ps.setDate(3,new java.sql.Date(dateTo.getTime()));
            ps.setDate(4,new java.sql.Date(dateFrom.getTime()));
            ps.setDate(5,new java.sql.Date(dateTo.getTime()));
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                LeaveApplication leaveApplication = new LeaveApplication();
                leaveApplication.setApplicationDate(new Date(rs.getDate("application_date").getTime()));
                leaveApplication.setApplicationNumber(rs.getInt("application_number"));
                leaveApplication.setApproverCode(rs.getString("approver_code"));
                leaveApplication.setApproverNumber(rs.getInt("approver_number"));
                leaveApplication.setEmployeeCode(rs.getString("employee_code"));
                leaveApplication.setEndAfterNoonOrEvening(rs.getString("end_after_noon_or_evening"));
                leaveApplication.setEndDate(new Date(rs.getDate("leave_end_date").getTime()));
                leaveApplication.setLeaveCode(rs.getString("leave_code"));
                leaveApplication.setNumberOfDays(rs.getDouble("number_of_days"));
                leaveApplication.setReason(rs.getString("reason"));
                leaveApplication.setStartDate(new Date(rs.getDate("leave_start_date").getTime()));
                leaveApplication.setStartMorningOrAfterNoon(rs.getString("start_morning_or_after_noon"));
                leaveApplication.setStatus(rs.getString("status"));
                leaveApplication.setReasonForRejection(rs.getString("reason_for_rejection"));
                leaveApplicationsList.add(leaveApplication);
            }
            ps.close();
            rs.close();
            ps = null;
            rs = null;
            return leaveApplicationsList;
        }
        catch(SQLException e)
        {
            System.out.println("Error reading leave applications " + e.getMessage());
            throw new SQLException(e.getMessage());
        }

    }
    public static List<LeaveApplication> readAllApplicationsForAnApproverWithStatusAsPending(String employeeCode) throws SQLException
    {
        List leaveApplicationsList = new ArrayList<LeaveApplication>();

        Connection con = ConnectionAgent.getConnection();
        try
        {
            String queryString = "select a.*,b.first_name,b.middle_name,b.last_name from employee_leave_application a,employee_master b where (approver_code = ? or alternate_approver_code = ?)";
            queryString = queryString + " and (status = ? or status = ?)";
            queryString = queryString + "  and a.employee_code = b.code order by a.leave_start_date desc";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setString(1,employeeCode);
            ps.setString(2,employeeCode);
            ps.setString(3,"PENDING");
            ps.setString(4,"CANCEL-PENDING");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                LeaveApplication leaveApplication = new LeaveApplication();
                leaveApplication.setApplicationDate(new Date(rs.getDate("application_date").getTime()));
                leaveApplication.setApplicationNumber(rs.getInt("application_number"));
                leaveApplication.setApproverCode(rs.getString("approver_code"));
                leaveApplication.setAlternateApproverCode(rs.getString("alternate_approver_code"));
                leaveApplication.setApproverNumber(rs.getInt("approver_number"));
                leaveApplication.setEmployeeCode(rs.getString("employee_code"));
                leaveApplication.setEndAfterNoonOrEvening(rs.getString("end_after_noon_or_evening"));
                leaveApplication.setEndDate(new Date(rs.getDate("leave_end_date").getTime()));
                leaveApplication.setLeaveCode(rs.getString("leave_code"));
                leaveApplication.setNumberOfDays(rs.getDouble("number_of_days"));
                leaveApplication.setReason(rs.getString("reason"));
                leaveApplication.setStartDate(new Date(rs.getDate("leave_start_date").getTime()));
                leaveApplication.setStartMorningOrAfterNoon(rs.getString("start_morning_or_after_noon"));
                leaveApplication.setStatus(rs.getString("status"));
                String employeeFullName = rs.getString("first_name");
                if(rs.getString("middle_name") != null)
                {
                    employeeFullName = employeeFullName + " " + rs.getString("middle_name");
                }
                if(rs.getString("last_name") != null)
                {
                    employeeFullName = employeeFullName + " " + rs.getString("last_name");
                }
                leaveApplication.setEmployeeName(employeeFullName);
                leaveApplication.setSelected(false);
                leaveApplicationsList.add(leaveApplication);
            }
            ps.close();
            rs.close();
            ps = null;
            rs = null;
            return leaveApplicationsList;
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public static List<LeaveApplication> readAllODApplicationsForAnApproverWithStatusAsPending(String employeeCode) throws SQLException
    {
        List leaveApplicationsList = new ArrayList<LeaveApplication>();

        Connection con = ConnectionAgent.getConnection();
        try
        {
            String queryString = "select a.*,b.first_name,b.middle_name,b.last_name from employee_leave_application a,employee_master b where approver_code = ? and a.leave_code = 'OD'";
            queryString = queryString + " and (status = ? or status = ?)";
            queryString = queryString + "  and a.employee_code = b.code and a.leave_code = 'OD' order by a.leave_start_date desc";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setString(1,employeeCode);
            ps.setString(2,"PENDING");
            ps.setString(3,"CANCEL-PENDING");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                LeaveApplication leaveApplication = new LeaveApplication();
                leaveApplication.setApplicationDate(new Date(rs.getDate("application_date").getTime()));
                leaveApplication.setApplicationNumber(rs.getInt("application_number"));
                leaveApplication.setApproverCode(rs.getString("approver_code"));
                leaveApplication.setApproverNumber(rs.getInt("approver_number"));
                leaveApplication.setEmployeeCode(rs.getString("employee_code"));
                leaveApplication.setEndAfterNoonOrEvening(rs.getString("end_after_noon_or_evening"));
                leaveApplication.setEndDate(new Date(rs.getDate("leave_end_date").getTime()));
                leaveApplication.setLeaveCode(rs.getString("leave_code"));
                leaveApplication.setNumberOfDays(rs.getDouble("number_of_days"));
                leaveApplication.setReason(rs.getString("reason"));
                leaveApplication.setStartDate(new Date(rs.getDate("leave_start_date").getTime()));
                leaveApplication.setStartMorningOrAfterNoon(rs.getString("start_morning_or_after_noon"));
                leaveApplication.setStatus(rs.getString("status"));
                String employeeFullName = rs.getString("first_name");
                if(rs.getString("middle_name") != null)
                {
                    employeeFullName = employeeFullName + " " + rs.getString("middle_name");
                }
                if(rs.getString("last_name") != null)
                {
                    employeeFullName = employeeFullName + " " + rs.getString("last_name");
                }
                leaveApplication.setEmployeeName(employeeFullName);
                leaveApplication.setSelected(false);
                leaveApplicationsList.add(leaveApplication);
            }
            ps.close();
            rs.close();
            ps = null;
            rs = null;
            return leaveApplicationsList;
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public static List<LeaveApplication> readAllODApplicationsForAnApproverWithStatusAsApproved(String employeeCode) throws SQLException
    {
        List leaveApplicationsList = new ArrayList<LeaveApplication>();

        Connection con = ConnectionAgent.getConnection();
        try
        {
            String queryString = "select a.*,b.first_name,b.middle_name,b.last_name from employee_leave_application a,employee_master b where approver_code = ?";
            queryString = queryString + " and (status = ? or status = ?)";
            queryString = queryString + "  and a.employee_code = b.code and a.leave_code = 'OD' order by a.leave_start_date desc";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setString(1,employeeCode);
            ps.setString(2,"APPROVED");
            ps.setString(3,"CANCEL-APPROVED");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                LeaveApplication leaveApplication = new LeaveApplication();
                leaveApplication.setApplicationDate(new Date(rs.getDate("application_date").getTime()));
                leaveApplication.setApplicationNumber(rs.getInt("application_number"));
                leaveApplication.setApproverCode(rs.getString("approver_code"));
                leaveApplication.setApproverNumber(rs.getInt("approver_number"));
                leaveApplication.setEmployeeCode(rs.getString("employee_code"));
                leaveApplication.setEndAfterNoonOrEvening(rs.getString("end_after_noon_or_evening"));
                leaveApplication.setEndDate(new Date(rs.getDate("leave_end_date").getTime()));
                leaveApplication.setLeaveCode(rs.getString("leave_code"));
                leaveApplication.setNumberOfDays(rs.getDouble("number_of_days"));
                leaveApplication.setReason(rs.getString("reason"));
                leaveApplication.setStartDate(new Date(rs.getDate("leave_start_date").getTime()));
                leaveApplication.setStartMorningOrAfterNoon(rs.getString("start_morning_or_after_noon"));
                leaveApplication.setStatus(rs.getString("status"));
                String employeeFullName = rs.getString("first_name");
                if(rs.getString("middle_name") != null)
                {
                    employeeFullName = employeeFullName + " " + rs.getString("middle_name");
                }
                if(rs.getString("last_name") != null)
                {
                    employeeFullName = employeeFullName + " " + rs.getString("last_name");
                }
                leaveApplication.setEmployeeName(employeeFullName);
                leaveApplication.setSelected(false);
                leaveApplicationsList.add(leaveApplication);
            }
            ps.close();
            rs.close();
            ps = null;
            rs = null;
            return leaveApplicationsList;
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public static List<LeaveApplication> readAllApplicationsForAnApproverWithStatusAsApproved(String employeeCode) throws SQLException
    {
        List leaveApplicationsList = new ArrayList<LeaveApplication>();

        Connection con = ConnectionAgent.getConnection();
        try
        {
            String queryString = "select a.*,b.first_name,b.middle_name,b.last_name from employee_leave_application a,employee_master b where (approver_code = ? or alternate_approver_code = ?)";
            queryString = queryString + " and (status = ? or status = ?)";
            queryString = queryString + "  and a.employee_code = b.code order by a.leave_start_date desc";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setString(1,employeeCode);
            ps.setString(2,employeeCode);
            ps.setString(3,"APPROVED");
            ps.setString(4,"CANCEL-APPROVED");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                LeaveApplication leaveApplication = new LeaveApplication();
                leaveApplication.setApplicationDate(new Date(rs.getDate("application_date").getTime()));
                leaveApplication.setApplicationNumber(rs.getInt("application_number"));
                leaveApplication.setApproverCode(rs.getString("approver_code"));
                leaveApplication.setAlternateApproverCode(rs.getString("alternate_approver_code"));
                leaveApplication.setApproverNumber(rs.getInt("approver_number"));
                leaveApplication.setEmployeeCode(rs.getString("employee_code"));
                leaveApplication.setEndAfterNoonOrEvening(rs.getString("end_after_noon_or_evening"));
                leaveApplication.setEndDate(new Date(rs.getDate("leave_end_date").getTime()));
                leaveApplication.setLeaveCode(rs.getString("leave_code"));
                leaveApplication.setNumberOfDays(rs.getDouble("number_of_days"));
                leaveApplication.setReason(rs.getString("reason"));
                leaveApplication.setStartDate(new Date(rs.getDate("leave_start_date").getTime()));
                leaveApplication.setStartMorningOrAfterNoon(rs.getString("start_morning_or_after_noon"));
                leaveApplication.setStatus(rs.getString("status"));
                String employeeFullName = rs.getString("first_name");
                if(rs.getString("middle_name") != null)
                {
                    employeeFullName = employeeFullName + " " + rs.getString("middle_name");
                }
                if(rs.getString("last_name") != null)
                {
                    employeeFullName = employeeFullName + " " + rs.getString("last_name");
                }
                leaveApplication.setEmployeeName(employeeFullName);
                leaveApplication.setSelected(false);
                leaveApplicationsList.add(leaveApplication);
            }
            ps.close();
            rs.close();
            ps = null;
            rs = null;
            return leaveApplicationsList;
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public static List<LeaveApplication> readAllODApplicationsForAnApprover(String employeeCode) throws SQLException
    {
        List leaveApplicationsList = new ArrayList<LeaveApplication>();

        Connection con = ConnectionAgent.getConnection();
        try
        {
            String queryString = "select a.*,b.first_name,b.middle_name,b.last_name from employee_leave_application a,employee_master b where approver_code = ? and a.employee_code = b.code and a.leave_code = 'OD' order by a.leave_start_date desc";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setString(1,employeeCode);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                LeaveApplication leaveApplication = new LeaveApplication();
                leaveApplication.setApplicationDate(new Date(rs.getDate("application_date").getTime()));
                leaveApplication.setApplicationNumber(rs.getInt("application_number"));
                leaveApplication.setApproverCode(rs.getString("approver_code"));
                leaveApplication.setApproverNumber(rs.getInt("approver_number"));
                leaveApplication.setEmployeeCode(rs.getString("employee_code"));
                leaveApplication.setEndAfterNoonOrEvening(rs.getString("end_after_noon_or_evening"));
                leaveApplication.setEndDate(new Date(rs.getDate("leave_end_date").getTime()));
                leaveApplication.setLeaveCode(rs.getString("leave_code"));
                leaveApplication.setNumberOfDays(rs.getDouble("number_of_days"));
                leaveApplication.setReason(rs.getString("reason"));
                leaveApplication.setStartDate(new Date(rs.getDate("leave_start_date").getTime()));
                leaveApplication.setStartMorningOrAfterNoon(rs.getString("start_morning_or_after_noon"));
                leaveApplication.setStatus(rs.getString("status"));
                String employeeFullName = rs.getString("first_name");
                if(rs.getString("middle_name") != null)
                {
                    employeeFullName = employeeFullName + " " + rs.getString("middle_name");
                }
                if(rs.getString("last_name") != null)
                {
                    employeeFullName = employeeFullName + " " + rs.getString("last_name");
                }
                leaveApplication.setEmployeeName(employeeFullName);
                leaveApplication.setSelected(false);
                leaveApplicationsList.add(leaveApplication);
            }
            ps.close();
            rs.close();
            ps = null;
            rs = null;
            return leaveApplicationsList;
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public static List<LeaveApplication> readAllApplicationsForAnApprover(String employeeCode) throws SQLException
    {
        List leaveApplicationsList = new ArrayList<LeaveApplication>();

        Connection con = ConnectionAgent.getConnection();
        try
        {
            String queryString = "select a.*,b.first_name,b.middle_name,b.last_name from employee_leave_application a,employee_master b where (approver_code = ? or alternate_approver_code =?) and a.employee_code = b.code order by a.leave_start_date desc";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setString(1,employeeCode);
            ps.setString(2,employeeCode);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                LeaveApplication leaveApplication = new LeaveApplication();
                leaveApplication.setApplicationDate(new Date(rs.getDate("application_date").getTime()));
                leaveApplication.setApplicationNumber(rs.getInt("application_number"));
                leaveApplication.setApproverCode(rs.getString("approver_code"));
                leaveApplication.setAlternateApproverCode(rs.getString("alternate_approver_code"));
                leaveApplication.setApproverNumber(rs.getInt("approver_number"));
                leaveApplication.setEmployeeCode(rs.getString("employee_code"));
                leaveApplication.setEndAfterNoonOrEvening(rs.getString("end_after_noon_or_evening"));
                leaveApplication.setEndDate(new Date(rs.getDate("leave_end_date").getTime()));
                leaveApplication.setLeaveCode(rs.getString("leave_code"));
                leaveApplication.setNumberOfDays(rs.getDouble("number_of_days"));
                leaveApplication.setReason(rs.getString("reason"));
                leaveApplication.setStartDate(new Date(rs.getDate("leave_start_date").getTime()));
                leaveApplication.setStartMorningOrAfterNoon(rs.getString("start_morning_or_after_noon"));
                leaveApplication.setStatus(rs.getString("status"));
                String employeeFullName = rs.getString("first_name");
                if(rs.getString("middle_name") != null)
                {
                    employeeFullName = employeeFullName + " " + rs.getString("middle_name");
                }
                if(rs.getString("last_name") != null)
                {
                    employeeFullName = employeeFullName + " " + rs.getString("last_name");
                }
                leaveApplication.setEmployeeName(employeeFullName);
                leaveApplication.setSelected(false);
                leaveApplicationsList.add(leaveApplication);
            }
            ps.close();
            rs.close();
            ps = null;
            rs = null;
            return leaveApplicationsList;
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }

    public static LeaveApplication readApprovedOrPendingForAnEmployee(String employeeCode,int date,int month,int year) throws SQLException
    {
        GregorianCalendar dateGc = new GregorianCalendar();
        dateGc.set(year, month, date);
        dateGc.add(GregorianCalendar.MONTH,-1);

        Connection con = ConnectionAgent.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
//        String queryString = "select * from employee_leave_application where employee_code = ? and ((leave_start_date >= ? and leave_start_date <= ?) or (leave_start_date >= ? and leave_start_date <= ?)) and (status='APPROVED' or status='PENDING')";
        String queryString = "select * from employee_leave_application where employee_code = ? and ? between leave_start_date and leave_end_date and (status='APPROVED' or status='PENDING')";
        try
        {
            ps = con.prepareStatement(queryString);
            ps.setString(1,employeeCode);
            ps.setDate(2,new java.sql.Date(dateGc.getTime().getTime()));
            rs = ps.executeQuery();
            LeaveApplication leaveApplication = null;
            while(rs.next())
            {
                leaveApplication = new LeaveApplication();
                leaveApplication.setEmployeeCode(rs.getString("employee_code"));
                leaveApplication.setApplicationNumber(rs.getInt("application_number"));
                leaveApplication.setApproverCode(rs.getString("approver_code"));
                leaveApplication.setStartDate(rs.getDate("leave_start_date"));
                leaveApplication.setEndDate(rs.getDate("leave_end_date"));
                leaveApplication.setStartMorningOrAfterNoon(rs.getString("start_morning_or_after_noon"));
                leaveApplication.setEndAfterNoonOrEvening(rs.getString("end_after_noon_or_evening"));
                leaveApplication.setLeaveCode(rs.getString("leave_code"));
            }
            return leaveApplication;
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
        finally
        {
            ps.close();
            rs.close();
            ps = null;
            rs = null;
        }

    }
    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
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
     * @return the approverCode
     */
    public String getApproverCode() {
        return approverCode;
    }

    /**
     * @param approverCode the approverCode to set
     */
    public void setApproverCode(String approverCode) {
        this.approverCode = approverCode;
    }

    /**
     * @return the approverName
     */
    public String getApproverName() {
        return approverName;
    }

    /**
     * @param approverName the approverName to set
     */
    public void setApproverName(String approverName) {
        this.approverName = approverName;
    }

    /**
     * @return the employeeName
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * @param employeeName the employeeName to set
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * @return the reasonForRejection
     */
    public String getReasonForRejection() {
        return reasonForRejection;
    }

    /**
     * @param reasonForRejection the reasonForRejection to set
     */
    public void setReasonForRejection(String reasonForRejection) {
        this.reasonForRejection = reasonForRejection;
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
     * @return the applicationDateAsString
     */
    public String getApplicationDateAsString() {
        if(applicationDate != null)
        {
            applicationDateAsString =  dateFormat.format(applicationDate);
        }
        else
        {
            applicationDateAsString = null;
        }
        return applicationDateAsString;
    }

    /**
     * @param applicationDateAsString the applicationDateAsString to set
     */
    public void setApplicationDateAsString(String applicationDateAsString) {
        this.applicationDateAsString = applicationDateAsString;
    }

    /**
     * @return the startDateAsString
     */
    public String getStartDateAsString() {

        if(startDate != null)
        {
            startDateAsString =  dateFormat.format(startDate);
        }
        else
        {
            startDateAsString = null;
        }

        return startDateAsString;
    }

    /**
     * @param startDateAsString the startDateAsString to set
     */
    public void setStartDateAsString(String startDateAsString) {
        this.startDateAsString = startDateAsString;
    }

    /**
     * @return the endDateAsString
     */
    public String getEndDateAsString() {
        if(endDate != null)
        {
            endDateAsString =  dateFormat.format(endDate);
        }
        else
        {
            endDateAsString = null;
        }
        return endDateAsString;
    }

    /**
     * @param endDateAsString the endDateAsString to set
     */
    public void setEndDateAsString(String endDateAsString) {
        this.endDateAsString = endDateAsString;
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
}

