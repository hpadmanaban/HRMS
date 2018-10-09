package com.utkrusht.leavemodule.masters;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.utkrusht.leavemodule.utilities.DateUtilities;
import com.utkrusht.leavemodule.connection.ConnectionAgent;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


/**
 *
 * @author comp
 */
public class Employee {
    private String companyCode;
    private String code;
    private String firstName;
    private String middleName;
    private String lastName;
    private String name;
    private String branchCode;
    private String departmentCode;
    private String designationCode;
    private String bankCode;
    private String accountNumber;
    private String ifsc;
    private Date dateOfBirth;
    private Date dateOfJoining;
    private int probationaryPeriod;
    private Date dateOfConfirmation;
    private String sex;
    private String email;
    private String reportingManagerCode;
    private String metro;
    private String type;
    private String departmentName;
    private String designationName;
    private String password;
    private String modifiedBy;
    private String accountCode;
    private String bankName;
    private String deductIt;
    private String pan;
    private String deductProfessionalTax;
    private String state;
    private String deductProvidentFund;
    private String providentFundNumber;
    private String providentFundFatherOrHusbandName;
    private String providentFundRelationshipWithMember;
    private String deductESI;
    private String esiNumber;
    private Date dateOfSeparation;
    private Date dateOfSettlement;
    private String errorString;
    private String rowClass;
    private boolean selected;
    private String branchName;
    private String payrollPassword;
    private String canRaiseRecruitmentRequirementRequest;
    private String canRaiseTrainingRequest;
    private String allowDeclarationsToEdit;
    private long uan;
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
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }
    public String getMiddleName()
    {
        return middleName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public String getLastName()
    {
        return lastName;
    }

    /**
     * @return the branchCode
     */
    public String getBranchCode() {
        return branchCode;
    }

    /**
     * @param branchCode the branchCode to set
     */
    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }
    public void setDepartmentCode(String departmentCode)
    {
        this.departmentCode = departmentCode;
    }
    public String getDepartmentCode()
    {
        return departmentCode;
    }
    public void setDesignationCode(String designationCode)
    {
        this.designationCode = designationCode;
    }
    public String getDesignationCode()
    {
        return designationCode;
    }
    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }
    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }
    public void setDateOfJoining(Date dateOfJoining)
    {
        this.dateOfJoining = dateOfJoining;
    }
    public Date getDateOfJoining()
    {
        return dateOfJoining;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }
    public String getSex()
    {
        return sex;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getEmail()
    {
        return email;
    }
    public void setType(String type)
    {
        this.type = type;
    }
    public String getType()
    {
        return type;
    }
    public void setMetro(String metro)
    {
        this.metro = metro;
    }
    public String getMetro()
    {
        return metro;
    }
    public void setDepartmentName(String departmentName)
    {
        this.departmentName = departmentName;
    }
    public String getDepartmentName()
    {
        return departmentName;
    }
    public void setDesignationName(String designationName)
    {
        this.designationName = designationName;
    }
    public String getDesignationName()
    {
        return designationName;
    }
    public void setAccountCode(String accountCode)
    {
        this.accountCode = accountCode;
    }
    public String getAccountCode()
    {
        return accountCode;
    }
    public void setBankName(String bankName)
    {
        this.bankName = bankName;
    }
    public String getBankName()
    {
        return bankName;
    }
    public void setBankCode(String bankCode)
    {
        this.bankCode = bankCode;
    }
    public String getBankCode()
    {
        return bankCode;
    }

    /**
     * @return the ifsc
     */
    public String getIfsc() {
        return ifsc;
    }

    /**
     * @param ifsc the ifsc to set
     */
    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }
    public void setDeductIt(String deductIt)
    {
        this.deductIt = deductIt;
    }
    public String getDeductIt()
    {
        return deductIt;
    }
    public void setPan(String pan)
    {
        this.pan = pan;
    }
    public String getPan()
    {
        return pan;
    }
    public void setDeductProfessionalTax(String deductProfessionalTax)
    {
        this.deductProfessionalTax = deductProfessionalTax;
    }
    public String getDeductProfessionalTax()
    {
        return deductProfessionalTax;
    }
    public void setState(String state)
    {
        this.state = state;
    }
    public String getState()
    {
        return state;
    }
    public void setDeductProvidentFund(String deductProvidentFund)
    {
        this.deductProvidentFund = deductProvidentFund;
    }
    public String getDeductProvidentFund()
    {
        return deductProvidentFund;
    }
    public void setProvidentFundNumber(String providentFundNumber)
    {
        this.providentFundNumber = providentFundNumber;
    }
    public String getProvidentFundNumber()
    {
        return providentFundNumber;
    }
    public void setDeductESI(String deductESI)
    {
        this.deductESI = deductESI;
    }
    public String getDeductESI()
    {
        return deductESI;
    }
    public void setEsiNumber(String esiNumber)
    {
        this.esiNumber = esiNumber;
    }
    public String getEsiNumber()
    {
        return esiNumber;
    }
    public void setDateOfSeparation(Date dateOfSeparation)
    {
        this.dateOfSeparation = dateOfSeparation;
    }
    public Date getDateOfSeparation()
    {
        return dateOfSeparation;
    }
    public void setDateOfSettlement(Date dateOfSettlement)
    {
        this.dateOfSettlement = dateOfSettlement;
    }
    public Date getDateOfSettlement()
    {
        return dateOfSettlement;
    }
    public void setSelected(boolean selected)
    {
        this.selected = selected;
    }
    public boolean getSelected()
    {
        return selected;
    }
    public void setErrorString(String errorString)
    {
        this.errorString = errorString;
    }
    public String getErrorString()
    {
        return errorString;
    }
    public void setRowClass(String rowClass)
    {
        this.rowClass = rowClass;
    }
    public String getRowClass()
    {
        if(errorString != null)
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
        else
        {
            rowClass = "normalRow";
        }
        return rowClass;
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
        Connection con = ConnectionAgent.getConnection();
        try
        {
            String insertString = "insert into employee_master(code,first_name,middle_name,last_name,branch_code,department_code,designation_code,bank_code,account_code,ifsc,sex,date_of_birth,date_of_joining,probationary_period,date_of_confirmation,email,reporting_manager_code,type,metro,deduct_it,pan,deduct_professional_tax,state,deduct_provident_fund,provident_fund_number,uan,provident_fund_father_or_husband_name,provident_fund_relationship_with_member,deduct_esi,esi_number,can_raise_recruitment_requirement_request,can_raise_training_request,allow_declarations_to_edit,modified_by,modified_on) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,current_timestamp)";
            PreparedStatement ps = con.prepareStatement(insertString);
            ps.setString(1,code);
            ps.setString(2,firstName);
            ps.setString(3,middleName);
            ps.setString(4,lastName);
            ps.setString(5,branchCode);
            ps.setString(6,departmentCode);
            ps.setString(7,designationCode);
            ps.setString(8,bankCode);
            ps.setString(9,accountCode);
            ps.setString(10,ifsc);
            ps.setString(11,sex);
            ps.setDate(12,new java.sql.Date(dateOfBirth.getTime()));
            ps.setDate(13,new java.sql.Date(dateOfJoining.getTime()));
            ps.setInt(14,probationaryPeriod);
            if(dateOfConfirmation != null)
            {
                ps.setDate(15,new java.sql.Date(dateOfConfirmation.getTime()));
            }
            else
            {
                ps.setDate(15,null);
            }
            ps.setString(16,email);
            ps.setString(17,reportingManagerCode);
            ps.setString(18,type);
            ps.setString(19,metro);
            ps.setString(20,deductIt);
            ps.setString(21,pan);
            ps.setString(22,deductProfessionalTax);
            ps.setString(23,state);
            ps.setString(24,deductProvidentFund);
            ps.setString(25,providentFundNumber);
            ps.setLong(26,uan);
            ps.setString(27,providentFundFatherOrHusbandName);
            ps.setString(28,providentFundRelationshipWithMember);
            ps.setString(29,deductESI);
            ps.setString(30,esiNumber);
            ps.setString(31,canRaiseRecruitmentRequirementRequest);
            ps.setString(32,canRaiseTrainingRequest);
            ps.setString(33,"N");
            ps.setString(34,modifiedBy);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public void updateAllowDeclarationsToEdit() throws SQLException
    {
        System.out.println("About to update allow declarations to edit");
        System.out.println("Employee Code is " + code);
        System.out.println("Allow declarations to edit is " + allowDeclarationsToEdit);

        Connection con = ConnectionAgent.getConnection();
        String updateString = "update employee_master set allow_declarations_to_edit = ? where code = ?";
        PreparedStatement ps = con.prepareStatement(updateString);
        ps.setString(1,allowDeclarationsToEdit);
        ps.setString(2,code);
        ps.executeUpdate();
        ps.close();
        System.out.println("updated");
    }
    public void update() throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        try
        {
            String updateString = "update employee_master set first_name = ?,middle_name = ?,last_name = ?,branch_code = ?,department_code = ?,designation_code = ?,bank_code = ?,account_code = ?,ifsc = ?,sex = ?,date_of_birth = ?,date_of_joining = ?,probationary_period = ?,date_of_confirmation = ?,email = ?,reporting_manager_code = ?,type = ?,metro = ?,deduct_it = ?,pan=?,deduct_professional_tax = ?,state = ?,deduct_provident_fund = ?,uan = ?,provident_fund_number = ?,provident_fund_father_or_husband_name = ?,provident_fund_relationship_with_member = ?,deduct_esi = ?,esi_number = ?,can_raise_recruitment_requirement_request = ?,can_raise_training_request = ?,modified_by = ?,modified_on = current_timestamp where code = ?";
            PreparedStatement ps = con.prepareStatement(updateString);
            ps.setString(1,firstName);
            ps.setString(2,middleName);
            ps.setString(3,lastName);
            ps.setString(4,branchCode);
            ps.setString(5,departmentCode);
            ps.setString(6,designationCode);
            ps.setString(7,bankCode);
            ps.setString(8,accountCode);
            ps.setString(9, ifsc);
            ps.setString(10,sex);
            ps.setDate(11,new java.sql.Date(dateOfBirth.getTime()));
            ps.setDate(12,new java.sql.Date(dateOfJoining.getTime()));
            ps.setInt(13,probationaryPeriod);
            if(dateOfConfirmation !=null)
            {
                ps.setDate(14,new java.sql.Date(dateOfConfirmation.getTime()));
            }
            else
            {
                ps.setDate(14,null);
            }
            ps.setString(15,email);
            ps.setString(16,reportingManagerCode);
            ps.setString(17,type);
            ps.setString(18,metro);
            ps.setString(19,deductIt);
            ps.setString(20,pan);
            ps.setString(21,deductProfessionalTax);
            ps.setString(22,state);
            ps.setString(23,deductProvidentFund);
            ps.setLong(24,uan);
            ps.setString(25,providentFundNumber);
            ps.setString(26,providentFundFatherOrHusbandName);
            ps.setString(27,providentFundRelationshipWithMember);
            ps.setString(28,deductESI);
            ps.setString(29,esiNumber);
            ps.setString(30,canRaiseRecruitmentRequirementRequest);
            ps.setString(31,canRaiseTrainingRequest);
            ps.setString(32,modifiedBy);
            ps.setString(33,code);
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
            String queryString = "select a.*,b.name as department_name,c.name as designation_name,d.name as branch_name,a.account_code,a.bank_code from employee_master a,department b,designation c,branch d where a.code = ? and a.department_code = b.code and a.designation_code = c.code and a.branch_code = d.code";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setString(1,code);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                firstName = rs.getString("FIRST_NAME");
                middleName = rs.getString("MIDDLE_NAME");
                lastName = rs.getString("LAST_NAME");
                if(firstName !=null)
                {
                    name = firstName;
                }
                if(middleName != null)
                {
                    name = name + " " + middleName;
                }
                if(lastName != null)
                {
                    name = name + " " + lastName;
                }
                sex = rs.getString("SEX");
                departmentCode = rs.getString("DEPARTMENT_CODE");
                designationCode = rs.getString("DESIGNATION_CODE");
                dateOfBirth = new java.util.Date(rs.getDate("DATE_OF_BIRTH").getTime());
                dateOfJoining = new java.util.Date(rs.getDate("DATE_OF_JOINING").getTime());
                probationaryPeriod = rs.getInt("probationary_period");
                if(rs.getDate("date_of_confirmation") != null)
                {
                    dateOfConfirmation = new java.util.Date(rs.getDate("date_of_confirmation").getTime());
                }
                email = rs.getString("EMAIL");
                reportingManagerCode = rs.getString("reporting_manager_code");
                branchCode = rs.getString("BRANCH_CODE");
                departmentName = rs.getString("DEPARTMENT_NAME");
                designationName = rs.getString("DESIGNATION_NAME");
                branchName = rs.getString("BRANCH_NAME");
                type = rs.getString("TYPE");
                metro = rs.getString("METRO");
                accountCode = rs.getString("ACCOUNT_CODE");
                accountNumber = rs.getString("ACCOUNT_CODE");
                ifsc = rs.getString("IFSC");
                bankCode = rs.getString("BANK_CODE");
                bankName = getBankNameFromDB(rs.getString("BANK_CODE"));
                deductIt = rs.getString("DEDUCT_IT");
                pan = rs.getString("PAN");
                deductProfessionalTax = rs.getString("DEDUCT_PROFESSIONAL_TAX");
                state = rs.getString("STATE");
                deductProvidentFund = rs.getString("DEDUCT_PROVIDENT_FUND");
                providentFundNumber = rs.getString("PROVIDENT_FUND_NUMBER");
                uan = rs.getLong("uan");
                providentFundFatherOrHusbandName = rs.getString("provident_fund_father_or_husband_name");
                providentFundRelationshipWithMember = rs.getString("provident_fund_relationship_with_member");
                deductESI = rs.getString("DEDUCT_ESI");
                esiNumber = rs.getString("ESI_NUMBER");
                if(rs.getString("can_raise_recruitment_requirement_request") == null)
                {
                    canRaiseRecruitmentRequirementRequest = "N";
                }
                else
                {
                    canRaiseRecruitmentRequirementRequest = rs.getString("can_raise_recruitment_requirement_request");
                }
                if(rs.getString("can_raise_training_request") == null)
                {
                    canRaiseTrainingRequest = "N";
                }
                else
                {
                    canRaiseTrainingRequest = rs.getString("can_raise_training_request");
                }
                if(rs.getString("allow_declarations_to_edit") == null)
                {
                    allowDeclarationsToEdit = "N";
                }
                else
                {
                    allowDeclarationsToEdit = rs.getString("allow_declarations_to_edit");
                }
            }
            rs.close();
            ps.close();
            rs = null;
            ps = null;
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());

        }

    }
    public String getBankNameFromDB(String bankCode) throws SQLException
    {
        String bankName = new String();
        Connection con = ConnectionAgent.getConnection();
        try
        {
            String queryString = "select * from bank where code = ?";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setString(1,bankCode);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                bankName = rs.getString("NAME");
            }
            ps.close();
            rs.close();
            return bankName;
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }


    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getPassword()
    {
        return password;
    }
    public void updatePassword() throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        try
        {
            String updateString = "update employee_master set password = ? where code = ?";
            PreparedStatement ps = con.prepareStatement(updateString);
            ps.setString(1,password);
            ps.setString(2,code);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
    }
    public void updatePayrollPassword() throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        try
        {
            String updateString = "update employee_master set payroll_password = ? where code = ?";
            PreparedStatement ps = con.prepareStatement(updateString);
            ps.setString(1,payrollPassword);
            ps.setString(2,code);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
    }
    public String CheckValidUser() throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        try
        {
            String queryString = "select a.password,a.code,a.first_name,a.middle_name,a.last_name,a.type from employee_master a where a.code = ? and date_of_separation = 0";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setString(1,code);
            ResultSet rs = ps.executeQuery();
            String passwordInDB = new String();
            int count = 0;
            System.out.println("Looking for ID " + code);
            while(rs.next())
            {
                count = count + 1;
                passwordInDB = rs.getString("PASSWORD");
                firstName = rs.getString("FIRST_NAME");
                middleName = rs.getString("MIDDLE_NAME");
                lastName = rs.getString("LAST_NAME");
                type = rs.getString("TYPE");
            }
            System.out.println("Password Sent is : " + password);
            System.out.println("Password in db is : " + passwordInDB);
            System.out.println("Count is : " + count);
            ps.close();
            rs.close();
            if(count == 0)
            {
                return "IU";
            }
            else if(passwordInDB.equalsIgnoreCase(password))
            {

                return "VP";
            }
            else
            {
                return "IP";
            }
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
    }

    public String checkValidUserNew() throws SQLException
    {
        System.out.println("In Check valid user new");
        Connection con = ConnectionAgent.getConnection();
        System.out.println("Connection String is " + con);
        try
        {
            String queryString = "select a.password,a.code,a.first_name,a.middle_name,a.last_name,a.type from employee_master a where a.code = ? and date_of_separation = 0";
            System.out.println("Query string to execute is " + queryString);
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setString(1,code);
            ResultSet rs = ps.executeQuery();
            String passwordInDB = new String();
            int count = 0;
            System.out.println("Looking for ID " + code);
            while(rs.next())
            {
                count = count + 1;
                passwordInDB = rs.getString("PASSWORD");
                firstName = rs.getString("FIRST_NAME");
                middleName = rs.getString("MIDDLE_NAME");
                lastName = rs.getString("LAST_NAME");
                type = rs.getString("TYPE");
            }
            System.out.println("Password Sent is : " + password);
            System.out.println("Password in db is : " + passwordInDB);
            System.out.println("Count is : " + count);
            ps.close();
            rs.close();
            if(count == 0)
            {
                return "IU";
            }
            else if(passwordInDB.equalsIgnoreCase(password))
            {

                return "VU";
            }
            else
            {
                return "IP";
            }
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
    }
    public void deleteDateOfSeparation() throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        try
        {
            String updateString = "update employee_master set date_of_separation = 0000-00-00 where code = ?";
            PreparedStatement ps = con.prepareStatement(updateString);
            ps.setString(1,code);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public void updateDateOfSeparation() throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        try
        {
            String updateString = "update employee_master set date_of_separation = ? where code = ?";
            PreparedStatement ps = con.prepareStatement(updateString);
            ps.setDate(1,new java.sql.Date(dateOfSeparation.getTime()));
            ps.setString(2,code);
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
            String deleteString = "delete from employee_master where code = ?";
            PreparedStatement ps = con.prepareStatement(deleteString);
            ps.setString(1,code);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public static List<Employee> readAllActiveEmployeesWhereEmployeeCodeIsNot(String employeeCode) throws SQLException
    {
        List employeesList = new ArrayList<Employee>();
        Connection con = ConnectionAgent.getConnection();
        try
        {
            String queryString = "select a.*,b.name as department_name,c.name as designation_name,d.name as branch_name,a.account_code,a.bank_code from employee_master a,department b,designation c,branch d where year(a.date_of_separation) = 0 and a.department_code = b.code and a.designation_code = c.code and a.branch_code = d.code order by a.code";
            PreparedStatement ps = con.prepareStatement(queryString);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Employee employeeMaster = new Employee();
                String firstName = rs.getString("FIRST_NAME");
                String middleName = rs.getString("MIDDLE_NAME");
                String lastName = rs.getString("LAST_NAME");
                if(firstName !=null)
                {
                    employeeMaster.setName(firstName);
                }
                if(middleName != null)
                {
                    employeeMaster.setName(employeeMaster.getName() + " " + middleName);
                }
                if(lastName != null)
                {
                    employeeMaster.setName(employeeMaster.getName() + " " + lastName);
                }
                employeeMaster.setCode(rs.getString("CODE"));
                employeeMaster.setFirstName(rs.getString("FIRST_NAME"));
                employeeMaster.setMiddleName(rs.getString("MIDDLE_NAME"));
                employeeMaster.setLastName((rs.getString("LAST_NAME")));
                employeeMaster.setDesignationCode(rs.getString("DESIGNATION_CODE"));
                employeeMaster.setDepartmentCode(rs.getString("DEPARTMENT_CODE"));
                employeeMaster.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
                employeeMaster.setDesignationName(rs.getString("DESIGNATION_NAME"));
                employeeMaster.setEmail(rs.getString("email"));
                employeeMaster.setReportingManagerCode(rs.getString("reporting_manager_code"));
                employeeMaster.setBranchCode(rs.getString("BRANCH_CODE"));
                employeeMaster.setBranchName(rs.getString("BRANCH_NAME"));
                employeeMaster.setDateOfBirth(new java.util.Date(rs.getDate("DATE_OF_BIRTH").getTime()));
                employeeMaster.setDateOfJoining(new java.util.Date(rs.getDate("DATE_OF_JOINING").getTime()));
                employeeMaster.setProbationaryPeriod(rs.getInt("probationary_period"));
                if(rs.getDate("date_of_confirmation") != null)
                {
                    employeeMaster.setDateOfConfirmation(new java.util.Date(rs.getDate("date_of_confirmation").getTime()));
                }
                employeeMaster.setMetro(rs.getString("METRO"));
                employeeMaster.setType(rs.getString("TYPE"));
                employeeMaster.setDeductIt(rs.getString("DEDUCT_IT"));
                employeeMaster.setPan(rs.getString("PAN"));
                employeeMaster.setDeductProfessionalTax(rs.getString("DEDUCT_PROFESSIONAL_TAX"));
                employeeMaster.setState(rs.getString("STATE"));
                employeeMaster.setProvidentFundNumber(rs.getString("PROVIDENT_FUND_NUMBER"));
                employeeMaster.setUan(rs.getLong("uan"));
                employeeMaster.setDeductProvidentFund(rs.getString("DEDUCT_PROVIDENT_FUND"));
                employeeMaster.setProvidentFundFatherOrHusbandName(rs.getString("provident_fund_father_or_husband_name"));
                employeeMaster.setProvidentFundRelationshipWithMember(rs.getString("provident_fund_relationship_with_member"));
                employeeMaster.setDeductESI(rs.getString("DEDUCT_ESI"));
                employeeMaster.setEsiNumber(rs.getString("ESI_NUMBER"));
                if(rs.getString("can_raise_recruitment_requirement_request") == null)
                {
                    employeeMaster.setCanRaiseRecruitmentRequirementRequest("N");
                }
                else
                {
                    employeeMaster.setCanRaiseRecruitmentRequirementRequest(rs.getString("can_raise_recruitment_requirement_request"));
                }
                if(rs.getString("can_raise_training_request") == null)
                {
                    employeeMaster.setCanRaiseTrainingRequest("N");
                }
                else
                {
                    employeeMaster.setCanRaiseTrainingRequest(rs.getString("can_raise_training_request"));
                }
                if(rs.getString("allow_declarations_to_edit") == null)
                {
                    employeeMaster.setAllowDeclarationsToEdit("N");
                }
                else
                {
                    employeeMaster.setAllowDeclarationsToEdit(rs.getString("allow_declarations_to_edit"));
                }
                employeesList.add(employeeMaster);
            }
            ps.close();
            rs.close();
            ps = null;
            rs = null;
            return employeesList;
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public static List<Employee>readAllActiveAndSeparatedEmployeesForSeparationDate(Date separationDate) throws SQLException
    {
        List employeesList = new ArrayList<Employee>();

        Connection con = ConnectionAgent.getConnection();
        try
        {
            String queryString = "select a.*,b.name as department_name,c.name as designation_name,d.name as branch_name,a.account_code,a.bank_code from employee_master a,department b,designation c,branch d where year(a.date_of_separation) = 0 and a.department_code = b.code and a.designation_code = c.code and a.branch_code = d.code and (a.date_of_separation = 0 or a.date_of_separation <= ?)order by a.code";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setDate(1,new java.sql.Date(separationDate.getTime()));
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Employee employeeMaster = new Employee();
                String firstName = rs.getString("FIRST_NAME");
                String middleName = rs.getString("MIDDLE_NAME");
                String lastName = rs.getString("LAST_NAME");
                if(firstName !=null)
                {
                    employeeMaster.setName(firstName);
                }
                if(middleName != null)
                {
                    employeeMaster.setName(employeeMaster.getName() + " " + middleName);
                }
                if(lastName != null)
                {
                    employeeMaster.setName(employeeMaster.getName() + " " + lastName);
                }
                employeeMaster.setCode(rs.getString("CODE"));
                employeeMaster.setFirstName(rs.getString("FIRST_NAME"));
                employeeMaster.setMiddleName(rs.getString("MIDDLE_NAME"));
                employeeMaster.setLastName((rs.getString("LAST_NAME")));
                employeeMaster.setDesignationCode(rs.getString("DESIGNATION_CODE"));
                employeeMaster.setDepartmentCode(rs.getString("DEPARTMENT_CODE"));
                employeeMaster.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
                employeeMaster.setDesignationName(rs.getString("DESIGNATION_NAME"));
                employeeMaster.setEmail(rs.getString("email"));
                employeeMaster.setReportingManagerCode(rs.getString("reporting_manager_code"));
                employeeMaster.setBranchCode(rs.getString("BRANCH_CODE"));
                employeeMaster.setBranchName(rs.getString("BRANCH_NAME"));
                employeeMaster.setDateOfBirth(new java.util.Date(rs.getDate("DATE_OF_BIRTH").getTime()));
                employeeMaster.setDateOfJoining(new java.util.Date(rs.getDate("DATE_OF_JOINING").getTime()));
                employeeMaster.setProbationaryPeriod(rs.getInt("probationary_period"));
                if(rs.getDate("date_of_confirmation") != null)
                {
                    employeeMaster.setDateOfConfirmation(new java.util.Date(rs.getDate("date_of_confirmation").getTime()));
                }
                employeeMaster.setMetro(rs.getString("METRO"));
                employeeMaster.setType(rs.getString("TYPE"));
                employeeMaster.setDeductIt(rs.getString("DEDUCT_IT"));
                employeeMaster.setPan(rs.getString("PAN"));
                employeeMaster.setDeductProfessionalTax(rs.getString("DEDUCT_PROFESSIONAL_TAX"));
                employeeMaster.setState(rs.getString("STATE"));
                employeeMaster.setProvidentFundNumber(rs.getString("PROVIDENT_FUND_NUMBER"));
                employeeMaster.setUan(rs.getLong("uan"));
                employeeMaster.setDeductProvidentFund(rs.getString("DEDUCT_PROVIDENT_FUND"));
                employeeMaster.setProvidentFundFatherOrHusbandName(rs.getString("provident_fund_father_or_husband_name"));
                employeeMaster.setProvidentFundRelationshipWithMember(rs.getString("provident_fund_relationship_with_member"));
                employeeMaster.setDeductESI(rs.getString("DEDUCT_ESI"));
                employeeMaster.setEsiNumber(rs.getString("ESI_NUMBER"));
                if(rs.getString("can_raise_recruitment_requirement_request") == null)
                {
                    employeeMaster.setCanRaiseRecruitmentRequirementRequest("N");
                }
                else
                {
                    employeeMaster.setCanRaiseRecruitmentRequirementRequest(rs.getString("can_raise_recruitment_requirement_request"));
                }
                if(rs.getString("can_raise_training_request") == null)
                {
                    employeeMaster.setCanRaiseTrainingRequest("N");
                }
                else
                {
                    employeeMaster.setCanRaiseTrainingRequest(rs.getString("can_raise_training_request"));
                }
                if(rs.getString("allow_declarations_to_edit") == null)
                {
                    employeeMaster.setAllowDeclarationsToEdit("N");
                }
                else
                {
                    employeeMaster.setAllowDeclarationsToEdit(rs.getString("allow_declarations_to_edit"));
                }
                employeesList.add(employeeMaster);
            }
            ps.close();
            rs.close();
            ps = null;
            rs = null;
            return employeesList;
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public static List<Employee>readAllActiveAndSeparatedEmployeesForSeparationYear(int year) throws SQLException
    {
        List employeesList = new ArrayList<Employee>();

        Connection con = ConnectionAgent.getConnection();
        try
        {
            String queryString = "select a.*,b.name as department_name,c.name as designation_name,d.name as branch_name,a.account_code,a.bank_code from employee_master a,department b,designation c,branch d where a.department_code = b.code and a.designation_code = c.code and a.branch_code = d.code and (date_of_separation = 0 or year(a.date_of_separation) = ?) order by a.code";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setInt(1,year);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Employee employeeMaster = new Employee();
                String firstName = rs.getString("FIRST_NAME");
                String middleName = rs.getString("MIDDLE_NAME");
                String lastName = rs.getString("LAST_NAME");
                if(firstName !=null)
                {
                    employeeMaster.setName(firstName);
                }
                if(middleName != null)
                {
                    employeeMaster.setName(employeeMaster.getName() + " " + middleName);
                }
                if(lastName != null)
                {
                    employeeMaster.setName(employeeMaster.getName() + " " + lastName);
                }
                employeeMaster.setCode(rs.getString("CODE"));
                employeeMaster.setFirstName(rs.getString("FIRST_NAME"));
                employeeMaster.setMiddleName(rs.getString("MIDDLE_NAME"));
                employeeMaster.setLastName((rs.getString("LAST_NAME")));
                employeeMaster.setDesignationCode(rs.getString("DESIGNATION_CODE"));
                employeeMaster.setDepartmentCode(rs.getString("DEPARTMENT_CODE"));
                employeeMaster.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
                employeeMaster.setDesignationName(rs.getString("DESIGNATION_NAME"));
                employeeMaster.setEmail(rs.getString("email"));
                employeeMaster.setReportingManagerCode(rs.getString("reporting_manager_code"));
                employeeMaster.setBranchCode(rs.getString("BRANCH_CODE"));
                employeeMaster.setBranchName(rs.getString("BRANCH_NAME"));
                employeeMaster.setDateOfBirth(new java.util.Date(rs.getDate("DATE_OF_BIRTH").getTime()));
                employeeMaster.setDateOfJoining(new java.util.Date(rs.getDate("DATE_OF_JOINING").getTime()));
                employeeMaster.setProbationaryPeriod(rs.getInt("probationary_period"));
                if(rs.getDate("date_of_confirmation") != null)
                {
                    employeeMaster.setDateOfConfirmation(new java.util.Date(rs.getDate("date_of_confirmation").getTime()));
                }
                employeeMaster.setMetro(rs.getString("METRO"));
                employeeMaster.setType(rs.getString("TYPE"));
                employeeMaster.setDeductIt(rs.getString("DEDUCT_IT"));
                employeeMaster.setPan(rs.getString("PAN"));
                employeeMaster.setDeductProfessionalTax(rs.getString("DEDUCT_PROFESSIONAL_TAX"));
                employeeMaster.setState(rs.getString("STATE"));
                employeeMaster.setProvidentFundNumber(rs.getString("PROVIDENT_FUND_NUMBER"));
                employeeMaster.setUan(rs.getLong("uan"));
                employeeMaster.setDeductProvidentFund(rs.getString("DEDUCT_PROVIDENT_FUND"));
                employeeMaster.setProvidentFundFatherOrHusbandName(rs.getString("provident_fund_father_or_husband_name"));
                employeeMaster.setProvidentFundRelationshipWithMember(rs.getString("provident_fund_relationship_with_member"));
                employeeMaster.setDeductESI(rs.getString("DEDUCT_ESI"));
                employeeMaster.setEsiNumber(rs.getString("ESI_NUMBER"));
                if(rs.getString("can_raise_recruitment_requirement_request") == null)
                {
                    employeeMaster.setCanRaiseRecruitmentRequirementRequest("N");
                }
                else
                {
                    employeeMaster.setCanRaiseRecruitmentRequirementRequest(rs.getString("can_raise_recruitment_requirement_request"));
                }
                if(rs.getString("can_raise_training_request") == null)
                {
                    employeeMaster.setCanRaiseTrainingRequest("N");
                }
                else
                {
                    employeeMaster.setCanRaiseTrainingRequest(rs.getString("can_raise_training_request"));
                }
                if(rs.getString("allow_declarations_to_edit") == null)
                {
                    employeeMaster.setAllowDeclarationsToEdit("N");
                }
                else
                {
                    employeeMaster.setAllowDeclarationsToEdit(rs.getString("allow_declarations_to_edit"));
                }
                employeesList.add(employeeMaster);
            }
            ps.close();
            rs.close();
            ps = null;
            rs = null;
            return employeesList;
        }
        catch(SQLException e)
        {
            System.out.println("Error is " + e.getMessage());
            throw new SQLException(e.getMessage());
        }
    }
    public static List<Employee> readAllActiveEmployees() throws SQLException
    {
        List employeesList = new ArrayList<Employee>();

        Connection con = ConnectionAgent.getConnection();
        try
        {
            String queryString = "select a.*,b.name as department_name,c.name as designation_name,d.name as branch_name,a.account_code,a.bank_code,e.name as bank_name from employee_master a,department b,designation c,branch d,bank e where year(a.date_of_separation) = 0 and a.department_code = b.code and a.designation_code = c.code and a.branch_code = d.code and a.bank_code = e.code order by a.code";
            PreparedStatement ps = con.prepareStatement(queryString);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Employee employeeMaster = new Employee();
                String firstName = rs.getString("FIRST_NAME");
                String middleName = rs.getString("MIDDLE_NAME");
                String lastName = rs.getString("LAST_NAME");
                if(firstName !=null)
                {
                    employeeMaster.setName(firstName);
                }
                if(middleName != null)
                {
                    if(middleName.equals("") || middleName.equals(" "))
                    {

                    }
                    else
                    {
                        employeeMaster.setName(employeeMaster.getName() + " " + middleName);
                    }
                }
                if(lastName != null)
                {
                    if(lastName.equals("") || lastName.equals(" "))
                    {

                    }
                    else
                    {
                        employeeMaster.setName(employeeMaster.getName() + " " + lastName);
                    }

                }
                employeeMaster.setCode(rs.getString("CODE"));
                employeeMaster.setFirstName(rs.getString("FIRST_NAME"));
                employeeMaster.setMiddleName(rs.getString("MIDDLE_NAME"));
                employeeMaster.setLastName((rs.getString("LAST_NAME")));
                employeeMaster.setDesignationCode(rs.getString("DESIGNATION_CODE"));
                employeeMaster.setDepartmentCode(rs.getString("DEPARTMENT_CODE"));
                employeeMaster.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
                employeeMaster.setDesignationName(rs.getString("DESIGNATION_NAME"));
                employeeMaster.setEmail(rs.getString("email"));
                employeeMaster.setReportingManagerCode(rs.getString("reporting_manager_code"));
                employeeMaster.setBranchCode(rs.getString("BRANCH_CODE"));
                employeeMaster.setBranchName(rs.getString("BRANCH_NAME"));
                employeeMaster.setDateOfBirth(new java.util.Date(rs.getDate("DATE_OF_BIRTH").getTime()));
                employeeMaster.setDateOfJoining(new java.util.Date(rs.getDate("DATE_OF_JOINING").getTime()));
                employeeMaster.setProbationaryPeriod(rs.getInt("probationary_period"));
                if(rs.getDate("date_of_confirmation") != null)
                {
                    employeeMaster.setDateOfConfirmation(new java.util.Date(rs.getDate("date_of_confirmation").getTime()));
                }
                employeeMaster.setMetro(rs.getString("METRO"));
                employeeMaster.setType(rs.getString("TYPE"));
                employeeMaster.setDeductIt(rs.getString("DEDUCT_IT"));
                employeeMaster.setPan(rs.getString("PAN"));
                employeeMaster.setDeductProfessionalTax(rs.getString("DEDUCT_PROFESSIONAL_TAX"));
                employeeMaster.setState(rs.getString("STATE"));
                employeeMaster.setProvidentFundNumber(rs.getString("PROVIDENT_FUND_NUMBER"));
                employeeMaster.setUan(rs.getLong("uan"));
                employeeMaster.setDeductProvidentFund(rs.getString("DEDUCT_PROVIDENT_FUND"));
                employeeMaster.setProvidentFundFatherOrHusbandName(rs.getString("provident_fund_father_or_husband_name"));
                employeeMaster.setProvidentFundRelationshipWithMember(rs.getString("provident_fund_relationship_with_member"));
                employeeMaster.setDeductESI(rs.getString("DEDUCT_ESI"));
                employeeMaster.setEsiNumber(rs.getString("ESI_NUMBER"));
                employeeMaster.setBankName(rs.getString("bank_name"));
                employeeMaster.setAccountCode(rs.getString("account_code"));
                employeeMaster.setIfsc(rs.getString("ifsc"));
                if(rs.getString("can_raise_recruitment_requirement_request") == null)
                {
                    employeeMaster.setCanRaiseRecruitmentRequirementRequest("N");
                }
                else
                {
                    employeeMaster.setCanRaiseRecruitmentRequirementRequest(rs.getString("can_raise_recruitment_requirement_request"));
                }
                if(rs.getString("can_raise_training_request") == null)
                {
                    employeeMaster.setCanRaiseTrainingRequest("N");
                }
                else
                {
                    employeeMaster.setCanRaiseTrainingRequest(rs.getString("can_raise_training_request"));
                }
                employeeMaster.setSex(rs.getString("sex"));

                if(rs.getString("allow_declarations_to_edit") == null)
                {
                    employeeMaster.setAllowDeclarationsToEdit("N");
                }
                else
                {
                    employeeMaster.setAllowDeclarationsToEdit(rs.getString("allow_declarations_to_edit"));
                }
                employeesList.add(employeeMaster);
            }
            ps.close();
            rs.close();
            ps = null;
            rs = null;
            return employeesList;
        }
        catch(SQLException e)
        {
            System.out.println("Error reading active employees " + e.getMessage());
            throw new SQLException(e.getMessage());
        }

    }
    public static List<Employee>readEmployeesAssignedForReports(String assignedToEmployee) throws SQLException
    {
        List employeesList = new ArrayList<Employee>();

        Connection con = ConnectionAgent.getConnection();
        System.out.println("Reading employes for manager " + assignedToEmployee);
        PreparedStatement ps = null;
        try
        {
            String queryString = "select e.* from assign_employees_for_leave_reports a,employee_master e where assigned_to_employee_code = ? and a.employee_code = e.code order by a.employee_code";
            ps = con.prepareStatement(queryString);
            ps.setString(1,assignedToEmployee);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Employee employee = new Employee();
                employee.setCode(rs.getString("code"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setMiddleName(rs.getString("middle_name"));
                employee.setLastName(rs.getString("last_name"));
                employeesList.add(employee);
                List reportingEmployeesList = Employee.readReportingEmployees(rs.getString("code"));
                for(int i=0; i < reportingEmployeesList.size();i++)
                {
                    Employee reportingEmployee = (Employee)reportingEmployeesList.get(i);
                    employeesList.add(reportingEmployee);
                }
            }
            return employeesList;
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
        finally
        {
            ps.close();
            ps = null;
        }

    }
    public static List<Employee>readReportingEmployees(String employeeCode) throws SQLException
    {
        List employeesList = new ArrayList<Employee>();

        Connection con = ConnectionAgent.getConnection();
        System.out.println("Reading employes for manager " + employeeCode);
        try
        {
            String queryString = "select * from employee_master where reporting_manager_code = ? and date_of_settlement = 0";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setString(1,employeeCode);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Employee employee = new Employee();
                employee.setCode(rs.getString("code"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setMiddleName(rs.getString("middle_name"));
                employee.setLastName(rs.getString("last_name"));
                employeesList.add(employee);
                List reportingEmployeesList = Employee.readReportingEmployees(rs.getString("code"));
                for(int i=0; i < reportingEmployeesList.size();i++)
                {
                    Employee reportingEmployee = (Employee)reportingEmployeesList.get(i);
                    employeesList.add(reportingEmployee);
                }
            }
            ps.close();
            rs.close();
            ps = null;
            rs = null;
            return employeesList;

        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public static List<Employee> readAll() throws SQLException
    {
        List employeesList = new ArrayList<Employee>();

        Connection con = ConnectionAgent.getConnection();
        try
        {
            String queryString = "select a.*,b.name as department_name,c.name as designation_name,d.name as branch_name,a.account_code,a.bank_code from employee_master a,department b,designation c,branch d where a.department_code = b.code and a.designation_code = c.code and a.branch_code = d.code order by a.code";
            PreparedStatement ps = con.prepareStatement(queryString);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Employee employeeMaster = new Employee();
                String firstName = rs.getString("FIRST_NAME");
                String middleName = rs.getString("MIDDLE_NAME");
                String lastName = rs.getString("LAST_NAME");
                if(firstName !=null)
                {
                    employeeMaster.setName(firstName);
                }
                if(middleName != null)
                {
                    employeeMaster.setName(employeeMaster.getName() + " " + middleName);
                }
                if(lastName != null)
                {
                    employeeMaster.setName(employeeMaster.getName() + " " + lastName);
                }
                employeeMaster.setCode(rs.getString("CODE"));
                employeeMaster.setFirstName(rs.getString("FIRST_NAME"));
                employeeMaster.setMiddleName(rs.getString("MIDDLE_NAME"));
                employeeMaster.setLastName((rs.getString("LAST_NAME")));
                employeeMaster.setDesignationCode(rs.getString("DESIGNATION_CODE"));
                employeeMaster.setDepartmentCode(rs.getString("DEPARTMENT_CODE"));
                employeeMaster.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
                employeeMaster.setDesignationName(rs.getString("DESIGNATION_NAME"));
                employeeMaster.setBranchCode(rs.getString("BRANCH_CODE"));
                employeeMaster.setBranchName(rs.getString("BRANCH_NAME"));
                employeeMaster.setDateOfBirth(new java.util.Date(rs.getDate("DATE_OF_BIRTH").getTime()));
                employeeMaster.setDateOfJoining(new java.util.Date(rs.getDate("DATE_OF_JOINING").getTime()));
                employeeMaster.setProbationaryPeriod(rs.getInt("probationary_period"));
                if(rs.getDate("date_of_confirmation") != null)
                {
                    employeeMaster.setDateOfConfirmation(new java.util.Date(rs.getDate("date_of_confirmation").getTime()));
                }
                employeeMaster.setMetro(rs.getString("METRO"));
                employeeMaster.setType(rs.getString("TYPE"));
                employeeMaster.setDeductIt(rs.getString("DEDUCT_IT"));
                employeeMaster.setPan(rs.getString("PAN"));
                employeeMaster.setDeductProfessionalTax(rs.getString("DEDUCT_PROFESSIONAL_TAX"));
                employeeMaster.setState(rs.getString("STATE"));
                employeeMaster.setProvidentFundNumber(rs.getString("PROVIDENT_FUND_NUMBER"));
                employeeMaster.setUan(rs.getLong("uan"));
                employeeMaster.setDeductProvidentFund(rs.getString("DEDUCT_PROVIDENT_FUND"));
                employeeMaster.setProvidentFundFatherOrHusbandName(rs.getString("provident_fund_father_or_husband_name"));
                employeeMaster.setProvidentFundRelationshipWithMember(rs.getString("provident_fund_relationship_with_member"));
                employeeMaster.setDeductESI(rs.getString("DEDUCT_ESI"));
                employeeMaster.setEsiNumber(rs.getString("ESI_NUMBER"));
                employeeMaster.setSex(rs.getString("sex"));
                if(rs.getString("can_raise_recruitment_requirement_request") == null)
                {
                    employeeMaster.setCanRaiseRecruitmentRequirementRequest("N");
                }
                else
                {
                    employeeMaster.setCanRaiseRecruitmentRequirementRequest(rs.getString("can_raise_recruitment_requirement_request"));
                }
                if(rs.getString("can_raise_training_request") == null)
                {
                    employeeMaster.setCanRaiseTrainingRequest("N");
                }
                else
                {
                    employeeMaster.setCanRaiseTrainingRequest(rs.getString("can_raise_training_request"));
                }
                if(rs.getString("allow_declarations_to_edit") == null)
                {
                    employeeMaster.setAllowDeclarationsToEdit("N");
                }
                else
                {
                    employeeMaster.setAllowDeclarationsToEdit(rs.getString("allow_declarations_to_edit"));
                }
                employeesList.add(employeeMaster);
            }
            ps.close();
            rs.close();
            return employeesList;
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public static List<Employee> readAllRegularEmplyeesNotSeparatedInMonth(int month,int year) throws SQLException
    {
        List employeesList = new ArrayList<Employee>();

        Connection con = ConnectionAgent.getConnection();
        GregorianCalendar separationDateGc = new GregorianCalendar();
        separationDateGc.set(year, month-1,1);
        GregorianCalendar dateOfJoiningGc = new GregorianCalendar();
        System.out.println("In reading all regular employees month is " + month);
        System.out.println("In reading all regular employees year is " + year);
        dateOfJoiningGc.set(year, month-1, DateUtilities.getLastDayOfTheMonth(month, year));
        try
        {
            String queryString = "select a.*,b.name as department_name,c.name as designation_name,d.name as branch_name,a.account_code,a.bank_code from employee_master a,department b,designation c,branch d where a.department_code = b.code and a.designation_code = c.code and a.branch_code = d.code and (a.date_of_separation = 0 or a.date_of_separation >= ? or a.date_of_separation is NULL) and a.date_of_joining <= ? and a.type = 'R' order by a.code";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setDate(1,new java.sql.Date(separationDateGc.getTime().getTime()));
            ps.setDate(2,new java.sql.Date(dateOfJoiningGc.getTime().getTime()));
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Employee employeeMaster = new Employee();
                String firstName = rs.getString("FIRST_NAME");
                String middleName = rs.getString("MIDDLE_NAME");
                String lastName = rs.getString("LAST_NAME");
                if(firstName !=null)
                {
                    employeeMaster.setName(firstName);
                }
                if(middleName != null)
                {
                    employeeMaster.setName(employeeMaster.getName() + " " + middleName);
                }
                if(lastName != null)
                {
                    employeeMaster.setName(employeeMaster.getName() + " " + lastName);
                }
                employeeMaster.setCode(rs.getString("CODE"));
                employeeMaster.setFirstName(rs.getString("FIRST_NAME"));
                employeeMaster.setMiddleName(rs.getString("MIDDLE_NAME"));
                employeeMaster.setLastName((rs.getString("LAST_NAME")));
                employeeMaster.setDesignationCode(rs.getString("DESIGNATION_CODE"));
                employeeMaster.setDepartmentCode(rs.getString("DEPARTMENT_CODE"));
                employeeMaster.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
                employeeMaster.setDesignationName(rs.getString("DESIGNATION_NAME"));
                employeeMaster.setBranchCode(rs.getString("BRANCH_CODE"));
                employeeMaster.setBranchName(rs.getString("BRANCH_NAME"));
                employeeMaster.setDateOfBirth(new java.util.Date(rs.getDate("DATE_OF_BIRTH").getTime()));
                employeeMaster.setDateOfJoining(new java.util.Date(rs.getDate("DATE_OF_JOINING").getTime()));
                if(rs.getDate("DATE_OF_SEPARATION") != null)
                {
                    employeeMaster.setDateOfSeparation(new java.util.Date(rs.getDate("DATE_OF_SEPARATION").getTime()));
                }
                employeeMaster.setProbationaryPeriod(rs.getInt("probationary_period"));
                if(rs.getDate("date_of_confirmation") != null)
                {
                    employeeMaster.setDateOfConfirmation(new java.util.Date(rs.getDate("date_of_confirmation").getTime()));
                }
                employeeMaster.setMetro(rs.getString("METRO"));
                employeeMaster.setType(rs.getString("TYPE"));
                employeeMaster.setDeductIt(rs.getString("DEDUCT_IT"));
                employeeMaster.setPan(rs.getString("PAN"));
                employeeMaster.setDeductProfessionalTax(rs.getString("DEDUCT_PROFESSIONAL_TAX"));
                employeeMaster.setState(rs.getString("STATE"));
                employeeMaster.setProvidentFundNumber(rs.getString("PROVIDENT_FUND_NUMBER"));
                employeeMaster.setUan(rs.getLong("uan"));
                employeeMaster.setDeductProvidentFund(rs.getString("DEDUCT_PROVIDENT_FUND"));
                employeeMaster.setProvidentFundFatherOrHusbandName(rs.getString("provident_fund_father_or_husband_name"));
                employeeMaster.setProvidentFundRelationshipWithMember(rs.getString("provident_fund_relationship_with_member"));
                employeeMaster.setDeductESI(rs.getString("DEDUCT_ESI"));
                employeeMaster.setEsiNumber(rs.getString("ESI_NUMBER"));
                employeeMaster.setSex(rs.getString("SEX"));
                if(rs.getString("can_raise_recruitment_requirement_request") == null)
                {
                    employeeMaster.setCanRaiseRecruitmentRequirementRequest("N");
                }
                else
                {
                    employeeMaster.setCanRaiseRecruitmentRequirementRequest(rs.getString("can_raise_recruitment_requirement_request"));
                }
                if(rs.getString("can_raise_training_request") == null)
                {
                    employeeMaster.setCanRaiseTrainingRequest("N");
                }
                else
                {
                    employeeMaster.setCanRaiseTrainingRequest(rs.getString("can_raise_training_request"));
                }
                if(rs.getString("allow_declarations_to_edit") == null)
                {
                    employeeMaster.setAllowDeclarationsToEdit("N");
                }
                else
                {
                    employeeMaster.setAllowDeclarationsToEdit(rs.getString("allow_declarations_to_edit"));
                }
                employeesList.add(employeeMaster);
            }
            ps.close();
            rs.close();
            return employeesList;
        }
        catch(SQLException e)
        {
            System.out.println("Error in reading employees "+e.getMessage());
            throw new SQLException(e.getMessage());
        }
    }
    public static List<Employee> readAllActiveEmployeesForAnalysisCode(String analysisType,String analysisCode) throws SQLException
    {
        List employeesList = new ArrayList<Employee>();

        Connection con = ConnectionAgent.getConnection();
        try
        {
            String queryString = "select a.* from employee_master a, employee_analysis_code b where a.date_of_separation =0 and b.analysis_type_code = ? and b.analysis_code = ? and a.code = b.employee_code";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setString(1,analysisType);
            ps.setString(2,analysisCode);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Employee employeeMaster = new Employee();
                String firstName = rs.getString("FIRST_NAME");
                String middleName = rs.getString("MIDDLE_NAME");
                String lastName = rs.getString("LAST_NAME");
                if(firstName !=null)
                {
                    employeeMaster.setName(firstName);
                }
                if(middleName != null)
                {
                    employeeMaster.setName(employeeMaster.getName() + " " + middleName);
                }
                if(lastName != null)
                {
                    employeeMaster.setName(employeeMaster.getName() + " " + lastName);
                }
                employeeMaster.setCode(rs.getString("CODE"));
                employeeMaster.setFirstName(rs.getString("FIRST_NAME"));
                employeeMaster.setMiddleName(rs.getString("MIDDLE_NAME"));
                employeeMaster.setLastName((rs.getString("LAST_NAME")));
                employeeMaster.setDateOfBirth(new java.util.Date(rs.getDate("DATE_OF_BIRTH").getTime()));
                employeeMaster.setDateOfJoining(new java.util.Date(rs.getDate("DATE_OF_JOINING").getTime()));
                employeeMaster.setProbationaryPeriod(rs.getInt("probationary_period"));
                if(rs.getDate("date_of_confirmation") != null)
                {
                    employeeMaster.setDateOfConfirmation(new java.util.Date(rs.getDate("date_of_confirmation").getTime()));
                }
                employeeMaster.setMetro(rs.getString("METRO"));
                employeeMaster.setType(rs.getString("TYPE"));
                employeeMaster.setDeductIt(rs.getString("DEDUCT_IT"));
                employeeMaster.setPan(rs.getString("PAN"));
                employeeMaster.setDeductProfessionalTax(rs.getString("DEDUCT_PROFESSIONAL_TAX"));
                employeeMaster.setState(rs.getString("STATE"));
                employeeMaster.setProvidentFundNumber(rs.getString("PROVIDENT_FUND_NUMBER"));
                employeeMaster.setUan(rs.getLong("uan"));
                employeeMaster.setDeductProvidentFund(rs.getString("DEDUCT_PROVIDENT_FUND"));
                employeeMaster.setProvidentFundFatherOrHusbandName(rs.getString("provident_fund_father_or_husband_name"));
                employeeMaster.setProvidentFundRelationshipWithMember(rs.getString("provident_fund_relationship_with_member"));
                employeeMaster.setDeductESI(rs.getString("DEDUCT_ESI"));
                employeeMaster.setEsiNumber(rs.getString("ESI_NUMBER"));
                employeeMaster.setSex(rs.getString("SEX"));
                if(rs.getString("can_raise_recruitment_requirement_request") == null)
                {
                    employeeMaster.setCanRaiseRecruitmentRequirementRequest("N");
                }
                else
                {
                    employeeMaster.setCanRaiseRecruitmentRequirementRequest(rs.getString("can_raise_recruitment_requirement_request"));
                }
                if(rs.getString("can_raise_training_request") == null)
                {
                    employeeMaster.setCanRaiseTrainingRequest("N");
                }
                else
                {
                    employeeMaster.setCanRaiseTrainingRequest(rs.getString("can_raise_training_request"));
                }
                if(rs.getString("allow_declarations_to_edit") == null)
                {
                    employeeMaster.setAllowDeclarationsToEdit("N");
                }
                else
                {
                    employeeMaster.setAllowDeclarationsToEdit(rs.getString("allow_declarations_to_edit"));
                }
                employeesList.add(employeeMaster);
            }
            ps.close();
            rs.close();
            ps = null;
            rs = null;
            return employeesList;

        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }

    }
    public static List<Employee> readAllEmplyeesNotSeparatedInMonth(int month,int year) throws SQLException
    {
        List employeesList = new ArrayList<Employee>();

        Connection con = ConnectionAgent.getConnection();
        GregorianCalendar separationDateGc = new GregorianCalendar();
        separationDateGc.set(year, month-1,1);
        try
        {
            String queryString = "select a.*,b.name as department_name,c.name as designation_name,d.name as branch_name,a.account_code,a.bank_code,e.name as bank_name from employee_master a,department b,designation c,branch d,bank e where a.department_code = b.code and a.designation_code = c.code and a.branch_code = d.code and e.code = a.bank_code and (a.date_of_separation = 0 or a.date_of_separation >= ?) order by a.code";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setDate(1,new java.sql.Date(separationDateGc.getTime().getTime()));
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Employee employeeMaster = new Employee();
                String firstName = rs.getString("FIRST_NAME");
                String middleName = rs.getString("MIDDLE_NAME");
                String lastName = rs.getString("LAST_NAME");
                if(firstName !=null)
                {
                    employeeMaster.setName(firstName);
                }
                if(middleName != null)
                {
                    employeeMaster.setName(employeeMaster.getName() + " " + middleName);
                }
                if(lastName != null)
                {
                    employeeMaster.setName(employeeMaster.getName() + " " + lastName);
                }
                employeeMaster.setCode(rs.getString("CODE"));
                employeeMaster.setFirstName(rs.getString("FIRST_NAME"));
                employeeMaster.setMiddleName(rs.getString("MIDDLE_NAME"));
                employeeMaster.setLastName((rs.getString("LAST_NAME")));
                employeeMaster.setDesignationCode(rs.getString("DESIGNATION_CODE"));
                employeeMaster.setDepartmentCode(rs.getString("DEPARTMENT_CODE"));
                employeeMaster.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
                employeeMaster.setDesignationName(rs.getString("DESIGNATION_NAME"));
                employeeMaster.setBranchCode(rs.getString("BRANCH_CODE"));
                employeeMaster.setBranchName(rs.getString("BRANCH_NAME"));
                employeeMaster.setDateOfBirth(new java.util.Date(rs.getDate("DATE_OF_BIRTH").getTime()));
                employeeMaster.setDateOfJoining(new java.util.Date(rs.getDate("DATE_OF_JOINING").getTime()));
                employeeMaster.setProbationaryPeriod(rs.getInt("probationary_period"));
                if(rs.getDate("date_of_confirmation") != null)
                {
                    employeeMaster.setDateOfConfirmation(new java.util.Date(rs.getDate("date_of_confirmation").getTime()));
                }
                employeeMaster.setMetro(rs.getString("METRO"));
                employeeMaster.setType(rs.getString("TYPE"));
                employeeMaster.setDeductIt(rs.getString("DEDUCT_IT"));
                employeeMaster.setPan(rs.getString("PAN"));
                employeeMaster.setDeductProfessionalTax(rs.getString("DEDUCT_PROFESSIONAL_TAX"));
                employeeMaster.setState(rs.getString("STATE"));
                employeeMaster.setProvidentFundNumber(rs.getString("PROVIDENT_FUND_NUMBER"));
                employeeMaster.setUan(rs.getLong("uan"));
                employeeMaster.setDeductProvidentFund(rs.getString("DEDUCT_PROVIDENT_FUND"));
                employeeMaster.setProvidentFundFatherOrHusbandName(rs.getString("provident_fund_father_or_husband_name"));
                employeeMaster.setProvidentFundRelationshipWithMember(rs.getString("provident_fund_relationship_with_member"));
                employeeMaster.setDeductESI(rs.getString("DEDUCT_ESI"));
                employeeMaster.setEsiNumber(rs.getString("ESI_NUMBER"));
                employeeMaster.setSex(rs.getString("SEX"));
                employeeMaster.setBankCode(rs.getString("bank_code"));
                employeeMaster.setAccountCode(rs.getString("account_code"));
                employeeMaster.setBankName(rs.getString("bank_name"));
                employeeMaster.setDateOfSeparation(rs.getDate("date_of_separation"));
                if(rs.getString("can_raise_recruitment_requirement_request") == null)
                {
                    employeeMaster.setCanRaiseRecruitmentRequirementRequest("N");
                }
                else
                {
                    employeeMaster.setCanRaiseRecruitmentRequirementRequest(rs.getString("can_raise_recruitment_requirement_request"));
                }
                if(rs.getString("can_raise_training_request") == null)
                {
                    employeeMaster.setCanRaiseTrainingRequest("N");
                }
                else
                {
                    employeeMaster.setCanRaiseTrainingRequest(rs.getString("can_raise_training_request"));
                }
                if(rs.getString("allow_declarations_to_edit") == null)
                {
                    employeeMaster.setAllowDeclarationsToEdit("N");
                }
                else
                {
                    employeeMaster.setAllowDeclarationsToEdit(rs.getString("allow_declarations_to_edit"));
                }
                employeesList.add(employeeMaster);
            }
            ps.close();
            rs.close();
            return employeesList;
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
    }
    public static List readAllSeparatedEmployees(Date fromDate,Date toDate) throws SQLException
    {
        List employeesList = new ArrayList<Employee>();

        Connection con = ConnectionAgent.getConnection();
        try
        {
            String queryString = "select * from employee_master";
            if(fromDate != null && toDate !=null)
            {
                queryString = queryString + " where date_of_separation between ? and ?";
            }
            else if(fromDate == null && toDate != null)
            {
                queryString = queryString + " where date_of_separation <= ?";
            }
            else if(fromDate != null && toDate == null)
            {
                queryString = queryString + " where date_of_separation >= ?";
            }
            queryString = queryString + " order by date_of_separation desc";
            PreparedStatement ps = con.prepareStatement(queryString);
            if(fromDate != null && toDate !=null)
            {
                ps.setDate(1,new java.sql.Date(fromDate.getTime()));
                ps.setDate(2,new java.sql.Date(toDate.getTime()));
            }
            else if(fromDate == null && toDate != null)
            {
                ps.setDate(1, new java.sql.Date(toDate.getTime()));
            }
            else if(fromDate != null & toDate == null)
            {
                ps.setDate(1, new java.sql.Date(fromDate.getTime()));
            }
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Employee employee = new Employee();
                employee.setCode(rs.getString("CODE"));
                employee.setFirstName(rs.getString("FIRST_NAME"));
                employee.setMiddleName(rs.getString("MIDDLE_NAME"));
                employee.setLastName((rs.getString("LAST_NAME")));
                String name = new String();
                if(rs.getString("FIRST_NAME") != null)
                {
                    name = name + rs.getString("FIRST_NAME");
                }
                if(rs.getString("MIDDLE_NAME") != null)
                {
                    name = name + " " + rs.getString("MIDDLE_NAME");
                }
                if(rs.getString("LAST_NAME") != null)
                {
                    name = name + " " + rs.getString("LAST_NAME");
                }
                employee.setName(name);
                employee.setDateOfSeparation(new java.util.Date(rs.getDate("DATE_OF_SEPARATION").getTime()));
                employeesList.add(employee);
            }
            ps.close();
            rs.close();
            return employeesList;
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
    }

    public String checkValidUser() throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();

        System.out.println("Connection is " + con);
        String queryString = "select * from employee_master where code = ? and date_of_separation = 0";
        PreparedStatement ps = con.prepareStatement(queryString);
        ps.setString(1,code);
        String passwordInDB = new String();
        String panInDb=new String();
        Date dobInDb = new Date();
        int count = 0;
        ResultSet rs = ps.executeQuery();
        System.out.println("Password sent is " + password);
        while(rs.next())
        {
            count = count + 1;
            name = rs.getString("FIRST_NAME");
            if(rs.getString("MIDDLE_NAME") != null)
            {
                name = name + " " + rs.getString("MIDDLE_NAME");
            }
            if(rs.getString("LAST_NAME") != null)
            {
                name = name + " " + rs.getString("LAST_NAME");
            }
            email = rs.getString("EMAIL");
            passwordInDB = rs.getString("PASSWORD");
            panInDb=rs.getString("PAN");
            dobInDb = new java.util.Date(rs.getDate("date_of_birth").getTime());
            if(rs.getString("can_raise_recruitment_requirement_request") == null)
            {
                canRaiseRecruitmentRequirementRequest ="N";
            }
            else
            {
                canRaiseRecruitmentRequirementRequest =rs.getString("can_raise_recruitment_requirement_request");
            }
            if(rs.getString("can_raise_training_request") == null)
            {
                canRaiseTrainingRequest = "N";
            }
            else
            {
                canRaiseTrainingRequest = rs.getString("can_raise_training_request");
            }

        }
        System.out.println("Password in db is " + passwordInDB);
        ps.close();
        rs.close();
        if(count == 0)
        {
            return "IU";
        }
        else if(passwordInDB.equals(password))
        {
            if(dateOfBirth != null)
            {
                if(dateOfBirth.equals(dobInDb))
                {
                    return "VU";

                }
                else
                {
                    return "IU";
                }
            }
            else
            {
                if(pan.equalsIgnoreCase(panInDb))
                {
                    return "VU";
                }
                else
                {
                    return "IU";
                }
            }
        }
        else
        {
            return "IP";
        }
    }
    public String checkValidUserToGeneratePassword() throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        System.out.println("Connection is " + con);
        String queryString = "select * from employee_master where code = ? and date_of_separation = 0";
        PreparedStatement ps = con.prepareStatement(queryString);
        ps.setString(1,code);
        String panInDb=new String();
        Date dobInDb = new Date();
        int count = 0;
        ResultSet rs = ps.executeQuery();
        System.out.println("Password sent is " + password);
        while(rs.next())
        {
            count = count + 1;
            name = rs.getString("FIRST_NAME");
            if(rs.getString("MIDDLE_NAME") != null)
            {
                name = name + " " + rs.getString("MIDDLE_NAME");
            }
            if(rs.getString("LAST_NAME") != null)
            {
                name = name + " " + rs.getString("LAST_NAME");
            }
            email = rs.getString("EMAIL");
            panInDb=rs.getString("PAN");
            dobInDb = new java.util.Date(rs.getDate("date_of_birth").getTime());

        }
        ps.close();
        rs.close();
        if(count == 0)
        {
            return "IU";
        }
        else
        {
            if(dateOfBirth != null)
            {
                if(dateOfBirth.equals(dobInDb))
                {

                    return "VU";

                }
                else
                {
                    return "IU";
                }
            }
            else
            {
                if(pan.equalsIgnoreCase(panInDb))
                {

                    return "VU";
                }
                else
                {
                    return "IU";
                }
            }
        }
    }
    public String checkValidPassword() throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        System.out.println("Connection is " + con);
        String queryString = "select * from employee_master where code = ? and date_of_separation = 0";
        PreparedStatement ps = con.prepareStatement(queryString);
        ps.setString(1,code);
        String passwordInDB = new String();
        String panInDb=new String();
        Date dobInDb = new Date();
        int count = 0;
        ResultSet rs = ps.executeQuery();
        System.out.println("Password sent is " + password);
        while(rs.next())
        {
            count = count + 1;

            passwordInDB = rs.getString("PASSWORD");
        }
        System.out.println("Password in db is " + passwordInDB);
        ps.close();
        rs.close();
        if(count == 0)
        {
            return "IU";
        }
        else if(passwordInDB.equals(password))
        {
            return "VU";
        }
        else
        {
            return "IP";
        }
    }
    public String checkValidPayrollPassword() throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        System.out.println("Connection is " + con);
        String queryString = "select * from employee_master where code = ? and date_of_separation = 0";
        PreparedStatement ps = con.prepareStatement(queryString);
        ps.setString(1,code);
        String payrollPasswordInDB = new String();
        String panInDb=new String();
        Date dobInDb = new Date();
        int count = 0;
        ResultSet rs = ps.executeQuery();
        System.out.println("Password sent is " + payrollPassword);
        while(rs.next())
        {
            count = count + 1;
            payrollPasswordInDB = rs.getString("payroll_password");
        }
        System.out.println("Payroll Password in db is " + payrollPasswordInDB);
        ps.close();
        rs.close();
        if(count == 0)
        {
            return "IU";
        }
        else if(payrollPasswordInDB.equals(payrollPassword))
        {
            return "VU";
        }
        else
        {
            return "IP";
        }
    }

    public static boolean isServiceDepartmentEmployee(String employeeCode) throws SQLException
    {
        Connection con = ConnectionAgent.getConnection();
        String queryString = "select * from employee_master where code = ? and (department_code = ? or department_code = ?)";
        PreparedStatement ps = con.prepareStatement(queryString);
        ps.setString(1,employeeCode);
        ps.setString(2,"SER");
        ps.setString(3,"IOS");
        ResultSet rs = ps.executeQuery();
        boolean found = false;
        while(rs.next())
        {
            found = true;
        }
        ps.close();
        rs.close();
        return found;
    }
    /**
     * @return the branchName
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     * @param branchName the branchName to set
     */
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
/*    public String toString()
    {
        return code;
    } */

    /**
     * @return the reportingManagerCode
     */
    public String getReportingManagerCode() {
        return reportingManagerCode;
    }

    /**
     * @param reportingManagerCode the reportingManagerCode to set
     */
    public void setReportingManagerCode(String reportingManagerCode) {
        this.reportingManagerCode = reportingManagerCode;
    }

    /**
     * @return the probationaryPeriod
     */
    public int getProbationaryPeriod() {
        return probationaryPeriod;
    }

    /**
     * @param probationaryPeriod the probationaryPeriod to set
     */
    public void setProbationaryPeriod(int probationaryPeriod) {
        this.probationaryPeriod = probationaryPeriod;
    }

    /**
     * @return the dateOfConfirmation
     */
    public Date getDateOfConfirmation() {
        return dateOfConfirmation;
    }

    /**
     * @param dateOfConfirmation the dateOfConfirmation to set
     */
    public void setDateOfConfirmation(Date dateOfConfirmation) {
        this.dateOfConfirmation = dateOfConfirmation;
    }

    /**
     * @return the payrollPassword
     */
    public String getPayrollPassword() {
        return payrollPassword;
    }

    /**
     * @param payrollPassword the payrollPassword to set
     */
    public void setPayrollPassword(String payrollPassword) {
        this.payrollPassword = payrollPassword;
    }

    /**
     * @return the providentFundFatherOrHusbandName
     */
    public String getProvidentFundFatherOrHusbandName() {
        return providentFundFatherOrHusbandName;
    }

    /**
     * @param providentFundFatherOrHusbandName the providentFundFatherOrHusbandName to set
     */
    public void setProvidentFundFatherOrHusbandName(String providentFundFatherOrHusbandName) {
        this.providentFundFatherOrHusbandName = providentFundFatherOrHusbandName;
    }

    /**
     * @return the providentFundRelationshipWithMember
     */
    public String getProvidentFundRelationshipWithMember() {
        return providentFundRelationshipWithMember;
    }

    /**
     * @param providentFundRelationshipWithMember the providentFundRelationshipWithMember to set
     */
    public void setProvidentFundRelationshipWithMember(String providentFundRelationshipWithMember) {
        this.providentFundRelationshipWithMember = providentFundRelationshipWithMember;
    }

    /**
     *
     * @return the canRaiseRecruitmentRequirementRequest
     */
    public String getCanRaiseRecruitmentRequirementRequest() {
        return canRaiseRecruitmentRequirementRequest;
    }

    /**
     * @param canRaiseRecruitmentRequirementRequest the canRaiseRecruitmentRequirementRequest to set
     */
    public void setCanRaiseRecruitmentRequirementRequest(String canRaiseRecruitmentRequirementRequest) {
        this.canRaiseRecruitmentRequirementRequest = canRaiseRecruitmentRequirementRequest;
    }

    /**
     * @return the canRaiseTrainingRequest
     */
    public String getCanRaiseTrainingRequest() {
        return canRaiseTrainingRequest;
    }

    /**
     * @param canRaiseTrainingRequest the canRaiseTrainingRequest to set
     */
    public void setCanRaiseTrainingRequest(String canRaiseTrainingRequest) {
        this.canRaiseTrainingRequest = canRaiseTrainingRequest;
    }

    /**
     * @return the uan
     */
    public long getUan() {
        return uan;
    }

    /**
     * @param uan the uan to set
     */
    public void setUan(long uan) {
        this.uan = uan;
    }

    /**
     * @return the allowDeclarationsToEdit
     */
    public String getAllowDeclarationsToEdit() {
        return allowDeclarationsToEdit;
    }

    /**
     * @param allowDeclarationsToEdit the allowDeclarationsToEdit to set
     */
    public void setAllowDeclarationsToEdit(String allowDeclarationsToEdit) {
        this.allowDeclarationsToEdit = allowDeclarationsToEdit;
    }

    /**
     * @return the generalTabVisible
     */

}

