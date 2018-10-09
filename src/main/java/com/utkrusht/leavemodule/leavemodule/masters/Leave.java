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
import java.util.List;


/**
 *
 * @author comp
 */
public class Leave {
    private String companyCode;
    private String code;
    private String name;
    private double maxLeaveInStretch;
    private boolean uploadProof;
    private boolean uploadProofMandatory;
    private List notPrefixesList;
    private List notSuffixesList;
    private boolean includeInterveningHolidays;
    private boolean includeInterveningWeeklyOffs;
    private String modifiedBy;
    private boolean show;
    public Leave()
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
    public void setMaxLeaveInStretch(double maxLeaveInStretch)
    {
        this.maxLeaveInStretch = maxLeaveInStretch;
    }
    public double getMaxLeaveInStretch()
    {
        return maxLeaveInStretch;
    }
    public void setUploadProof(boolean uploadProof)
    {
        this.uploadProof = uploadProof;
    }
    public boolean getUploadProof()
    {
        return uploadProof;
    }
    public void setUploadProofMandatory(boolean uploadProofMandatory)
    {
        this.uploadProofMandatory = uploadProofMandatory;
    }
    public boolean getUploadProofMandatory()
    {
        return uploadProofMandatory;
    }
    public void setModifiedBy(String modifiedBy)
    {
        this.modifiedBy = modifiedBy;
    }
    public String getModifiedBy()
    {
        return modifiedBy;
    }
    public void setShow(boolean show)
    {
        this.show = show;
    }
    public boolean getShow()
    {
        return show;
    }
    public void create() throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        String queryString = "select * from leave_master where code = ?";
        PreparedStatement ps = con.prepareStatement(queryString);
        ps.setString(1,code);
        ResultSet rs = ps.executeQuery();
        int count = 0;
        while(rs.next())
        {
            count = count + 1;
        }
        if(count > 0)
        {
            String updateString = "update leave_master set name = ?,max_leave_in_stretch = ?,upload_proof = ?,upload_proof_mandatory = ?,include_intervening_holidays = ?,include_intervening_weekly_offs = ?,modified_by = ?,modified_on = current_timestamp where code = ?";
            ps= con.prepareStatement(updateString);
            ps.setString(1,name);
            ps.setDouble(2,maxLeaveInStretch);
            if(uploadProof)
            {
                ps.setString(3,"Y");
            }
            else
            {
                ps.setString(3,"N");
            }
            if(uploadProofMandatory)
            {
                ps.setString(4,"Y");
            }
            else
            {
                ps.setString(4,"N");
            }
            if(includeInterveningHolidays)
            {
                ps.setString(5,"Y");
            }
            else
            {
                ps.setString(5,"N");
            }
            if(includeInterveningWeeklyOffs)
            {
                ps.setString(6,"Y");
            }
            else
            {
                ps.setString(6,"N");
            }
            ps.setString(7,modifiedBy);
            ps.setString(8,code);
            ps.executeUpdate();
        }
        else
        {
            String insertString = "insert into leave_master(code,name,max_leave_in_stretch,upload_proof,upload_proof_mandatory,include_intervening_holidays,include_intervening_weekly_offs,modified_by,modified_on) value(?,?,?,?,?,?,?,?,current_timestamp)";
            ps = con.prepareStatement(insertString);
            ps.setString(1,code);
            ps.setString(2,name);
            ps.setDouble(3,maxLeaveInStretch);
            if(uploadProof)
            {
                ps.setString(4,"Y");
            }
            else
            {
                ps.setString(4,"N");
            }
            if(uploadProofMandatory)
            {
                ps.setString(5,"Y");
            }
            else
            {
                ps.setString(5,"N");
            }
            if(includeInterveningHolidays)
            {
                ps.setString(6,"Y");
            }
            else
            {
                ps.setString(6,"N");
            }
            if(includeInterveningWeeklyOffs)
            {
                ps.setString(7,"Y");
            }
            else
            {
                ps.setString(7,"N");
            }
            ps.setString(8,modifiedBy);
            ps.executeUpdate();
        }
        rs.close();
        ps.close();
    }
    public void read() throws SQLException
    {

        Connection con = ConnectionAgent.getConnection();
        try
        {
            String queryString = "select * from leave_master where code = ?";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setString(1,code);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                code = rs.getString("code");
                name = rs.getString("name");
                maxLeaveInStretch = rs.getDouble("max_leave_in_stretch");
                if(rs.getString("upload_proof").equalsIgnoreCase("Y"))
                {
                    uploadProof =true;
                }
                else
                {
                    uploadProof =false;
                }
                if(rs.getString("upload_proof_mandatory").equalsIgnoreCase("Y"))
                {
                    uploadProofMandatory = true;
                }
                else
                {
                    uploadProofMandatory = false;
                }
                if(rs.getString("include_intervening_holidays").equalsIgnoreCase("Y"))
                {
                    includeInterveningHolidays =true;
                }
                else
                {
                    includeInterveningHolidays =false;
                }
                if(rs.getString("include_intervening_weekly_offs").equalsIgnoreCase("Y"))
                {
                    includeInterveningWeeklyOffs =true;
                }
                else
                {
                    includeInterveningWeeklyOffs =false;
                }
            }
            ps.close();
            rs.close();
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public void readNotSuffixesLeaves()
    {

        notSuffixesList = new ArrayList<Leave>();
        Connection con = ConnectionAgent.getConnection();
        try
        {
//            String queryString = "SELECT a.*,b.NAME AS LEAVE_NOT_SUFFIX_NAME FROM LEAVE_NOT_SUFFIX a,LEAVE_MASTER b where NOT_SUFFIX_LEAVE_CODE <> ? AND a.LEAVE_CODE = b.CODE ORDER BY LEAVE_CODE";
            String queryString = "select a.*,b.name as leave_not_suffix_name from leave_not_suffix a,leave_master b where leave_code = ? and a.leave_code = b.code order by not_suffix_leave_code";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setString(1,code);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                notSuffixesList.add(rs.getString("NOT_SUFFIX_LEAVE_CODE"));
            }
            ps.close();
            rs.close();
        }
        catch(SQLException e)
        {
            System.out.println("Error reading not suffiexes list" + e.getMessage());
        }

    }
    public void readNotPrefixesLeaves()
    {
        notPrefixesList = new ArrayList<Leave>();
        Connection con = ConnectionAgent.getConnection();
        try
        {
//            String queryString = "SELECT a.*,b.NAME AS LEAVE_NOT_PREFIX_NAME FROM LEAVE_NOT_PREFIX a,LEAVE_MASTER b where NOT_PREFIX_LEAVE_CODE <> ? AND a.LEAVE_CODE = b.CODE ORDER BY LEAVE_CODE";
            String queryString = "select a.*,b.name as leave_not_prefix_name from leave_not_prefix a,leave_master b where leave_code = ? and a.leave_code = b.code order by not_prefix_leave_code";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setString(1,code);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                notPrefixesList.add(rs.getString("NOT_PREFIX_LEAVE_CODE"));
            }
            ps.close();
            rs.close();
        }
        catch(SQLException e)
        {
            System.out.println("Error reading not prefixes list");
        }

    }
    public static List<Leave> readAll() throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        try
        {
            List leavesList = new ArrayList<Leave>();
            String queryString = "select * from leave_master order by code";
            PreparedStatement ps = con.prepareStatement(queryString);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Leave leaveMaster = new Leave();
                leaveMaster.setCode(rs.getString("code"));
                leaveMaster.setName(rs.getString("name"));
                leaveMaster.setMaxLeaveInStretch(rs.getDouble("max_leave_in_stretch"));
                if(rs.getString("upload_proof").equalsIgnoreCase("Y"))
                {
                    leaveMaster.setUploadProof(true);
                }
                else
                {
                    leaveMaster.setUploadProof(false);
                }
                if(rs.getString("upload_proof_mandatory").equalsIgnoreCase("Y"))
                {
                    leaveMaster.setUploadProofMandatory(true);
                }
                else
                {
                    leaveMaster.setUploadProofMandatory(false);
                }
                if(rs.getString("include_intervening_holidays").equalsIgnoreCase("Y"))
                {
                    leaveMaster.setIncludeInterveningHolidays(true);
                }
                else
                {
                    leaveMaster.setIncludeInterveningHolidays(false);
                }
                if(rs.getString("include_intervening_weekly_offs").equalsIgnoreCase("Y"))
                {
                    leaveMaster.setIncludeInterveningWeeklyOffs(true);
                }
                else
                {
                    leaveMaster.setIncludeInterveningWeeklyOffs(false);
                }
                leaveMaster.readNotPrefixesLeaves();
                leaveMaster.readNotSuffixesLeaves();
                leavesList.add(leaveMaster);
            }
            ps.close();
            rs.close();
            ps = null;
            rs = null;
            return leavesList;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            throw new SQLException(e.getMessage());
        }


    }
    public void delete() throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        String deleteString = "delete from leave_master where code = ?";
        PreparedStatement ps = con.prepareStatement(deleteString);
        ps.setString(1,code);
        ps.executeUpdate();
        ps.close();
    }

    /**
     * @return the notPrefixesList
     */
    public List getNotPrefixesList() {
        return notPrefixesList;
    }

    /**
     * @param notPrefixesList the notPrefixesList to set
     */
    public void setNotPrefixesList(List notPrefixesList) {
        this.notPrefixesList = notPrefixesList;
    }

    /**
     * @return the notSuffixesList
     */
    public List getNotSuffixesList() {
        return notSuffixesList;
    }

    /**
     * @param notSuffixesList the notSuffixesList to set
     */
    public void setNotSuffixesList(List notSuffixesList) {
        this.notSuffixesList = notSuffixesList;
    }

    /**
     * @return the includeInterveningHolidays
     */
    public boolean getIncludeInterveningHolidays() {
        return includeInterveningHolidays;
    }

    /**
     * @param includeInterveningHolidays the includeInterveningHolidays to set
     */
    public void setIncludeInterveningHolidays(boolean includeInterveningHolidays) {
        this.includeInterveningHolidays = includeInterveningHolidays;
    }

    /**
     * @return the includeInterveningWeeklyOffs
     */
    public boolean getIncludeInterveningWeeklyOffs() {
        return includeInterveningWeeklyOffs;
    }

    /**
     * @param includeInterveningWeeklyOffs the includeInterveningWeeklyOffs to set
     */
    public void setIncludeInterveningWeeklyOffs(boolean includeInterveningWeeklyOffs) {
        this.includeInterveningWeeklyOffs = includeInterveningWeeklyOffs;
    }
}

