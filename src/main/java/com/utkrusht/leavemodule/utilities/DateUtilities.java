package com.utkrusht.leavemodule.utilities;

/*
 * DateUtilities.java
 *
 * Created on November 23, 2007, 12:16 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



/**
 *
 * @author Manjunath
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtilities {

    Calendar cal;
    /** Creates a new instance of DateUtilities */
    public DateUtilities() {
        cal = GregorianCalendar.getInstance();
        cal.setLenient(false);
        System.out.println("Today ==== " + cal.get(Calendar.DAY_OF_MONTH) + "-" + cal.get(Calendar.MONTH)+ 1 + "-" + cal.get(Calendar.YEAR));
    }

    /** Remove '/' from the Date. And return the date in "yyyymmdd" format
     * (mySql format)
     */
    public static String removeSlashes(String date)
    {
        String dd = date.substring(0,2);
        String mm = date.substring(3,5);
        String yyyy = date.substring(6,10);
        return yyyy+mm+dd;
    }

    /**Return the date as "dd/mm/yyyy"
     public static String insertSlashes(String date)
     {
     String yyyy = date.substring(0,5);
     String mm = date.substring(5,7);
     String dd = date.substring(7,9);
     return dd + "/" + mm + "/" + yyyy;
     }

     /** Replace '-' with '/' in the date.
     * Return the date with '/' instead of '-'
     */
    public static String replaceHyphensWithSlashes(String date)
    {
        String yyyy = date.substring(0,4);
        String mm = date.substring(5,7);
        String dd = date.substring(8,10);
        return dd + "/" + mm + "/" + yyyy;
    }

    /** Replace '-' with '/' in the date.
     * Return the date with '/' instead of '-'
     * Date in Any format
     */
    public static String putSlashes(String date)
    {
        date = date.replace('-', '/');
        date = date.replace("\\", "/");
        System.out.println("After Putting Slashes" + date);
        return date;
    }

    /** Replace '/' with '-' in the date.
     * Return the date with '-' instead of '/'
     * Date in Any format
     */
    private static String putHyphens(String date)
    {
        date = date.replace('/', '-');
        date = date.replace("\\", "-");
        return date;
    }

    /** Check whether the "date" is a valid (existing/ existed) date.
     * "date" matches the "format". Ex:"22/02/2000" "d-M-y"
     * Returns TRUE if date is valid, else FALSE.
     */
    public static boolean validatedate(String date,String format) {
        try {
            System.out.println("Date Entered = " + date);
            if(format.contains("/"))
                date = DateUtilities.putSlashes(date);
            if(format.contains("-"))
                date = DateUtilities.putHyphens(date);
            if(format.contains("\\")){
                format = DateUtilities.putSlashes(format);
                date = DateUtilities.putSlashes(date);
            }
            System.out.println("Date Converted (" + format + ")" + date);
            SimpleDateFormat df = new SimpleDateFormat(format);
            df.setLenient(false);
            Date dt = df.parse(date);
            return true;
        }
        catch (ParseException e) {
            System.out.println("HI-------->+" + e.getMessage());
            return false;
        }
    }

    /**Returns no of days in a specified month of a specified year.
     *
     */
    public int getDays(int year, int month) {
        try {

          /*  String date = "1" + "-" + month + "-" + year;
            SimpleDateFormat df = new SimpleDateFormat("d-M-y");
            df.setLenient(false);
            Date dt = df.parse(date);*/
            Calendar cal1 = new GregorianCalendar(year, month - 1, 1);
            //cal1.set(year, month, 1);
            int days = cal1.getActualMaximum(Calendar.DAY_OF_MONTH);
            System.out.println("No Of Days =====" + days);
            return days;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    /** Returns date in "yyyy-mm-dd" format.
     * Input string is "dd-mm-yyyy" format. c = '-'.
     */
    public static String ddmmyyToyymmdd(String date, String c){
        String temp[] = date.split(c, 3);
        date = temp[2] + c + temp[1] + c + temp[0];
        return date;
    }

    /** Returns date in "dd-mm-yyyy" format.
     * Input string is "yyyy-mm-dd" format. c = '-'.
     */
    public static String yymmddToddmmyy(String date, String c){
        String temp[] = date.split(c, 3);
        c = "/";
        date = temp[2] + c + temp[1] + c + temp[0];
        return date;
    }

    /**Returns the curent year
     *
     */
    public int getYear(){

        return cal.YEAR;
    }

    /** Returns the current Month
     *
     */
    public int getMonth(){

        return (cal.MONTH - 1);
    }

    /** Returns the no of daysin the current month of the current year.
     *
     */
    public int getMonthDays(){

        return getDays(cal.YEAR, cal.MONTH);
    }

    /** Returns today's date
     *
     */
    public int currentDate(){
        return cal.get(cal.DAY_OF_MONTH);
    }
    /** Returns curent today's month
     *
     */
    public int currentMonth(){
        return (cal.get(cal.MONTH) + 1);
    }

    /** Returns today's year
     *
     */
    public int currentYear(){
        return cal.get(cal.YEAR);
    }
    public static int getMonthAsInt(String month)
    {
        if(month.substring(0,3).toUpperCase().equals("JAN"))
        {
            return 1;
        }
        else if(month.substring(0,3).toUpperCase().equals("FEB"))
        {
            return 2;
        }
        else if(month.substring(0,3).toUpperCase().equals("MAR"))
        {
            return 3;
        }
        else if(month.substring(0,3).toUpperCase().equals("APR"))
        {
            return 4;
        }
        else if(month.substring(0,3).toUpperCase().equals("MAY"))
        {
            return 5;
        }
        else if(month.substring(0,3).toUpperCase().equals("JUN"))
        {
            return 6;
        }
        else if(month.substring(0,3).toUpperCase().equals("JUL"))
        {
            return 7;
        }
        else if(month.substring(0,3).toUpperCase().equals("AUG"))
        {
            return 8;
        }
        else if(month.substring(0,3).toUpperCase().equals("SEP"))
        {
            return 9;
        }
        else if(month.substring(0,3).toUpperCase().equals("OCT"))
        {
            return 10;
        }
        else if(month.substring(0,3).toUpperCase().equals("NOV"))
        {
            return 11;
        }
        else if(month.substring(0,3).toUpperCase().equals("DEC"))
        {
            return 12;
        }
        else
        {
            return 0;
        }

    }
    public static String getMonthAsString(int month)
    {
        if(month == 01)
        {
            return "January";
        }
        else if(month==02)
        {
            return "February";
        }
        else if(month==3)
        {
            return "March";
        }
        else if(month==4)
        {
            return "April";
        }
        else if(month==5)
        {
            return "May";
        }
        else if(month==6)
        {
            return "June";
        }
        else if(month==7)
        {
            return "July";
        }
        else if(month==8)
        {
            return "August";
        }
        else if(month==9)
        {
            return  "September";
        }
        else if(month==10)
        {
            return "October";
        }
        else if(month==11)
        {
            return "November";
        }
        else
        {
            return "December";
        }
    }
    public static int getNumberOfDaysInMonth(int month,int year)
    {
        if(month==1 || month == 3 || month==5 || month==7 || month == 8 || month == 10 || month == 12)
        {
            return 31;
        }
        else if(month==4 || month == 6 || month == 9 || month == 11)
        {
            return 30;
        }
        else
        {
            System.out.println("Leap year search " + ((year * 100.0)% 4.0));
            System.out.println("Year is " + year);
            if((year % 4) == 0)
            {
                return 29;
            }
            else
            {
                return 28;
            }
        }
    }
    public static int getYearAndMonth(Date date)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = dateFormat.format(date);
        String yyyy = dateString.substring(0,4);
        String mm = dateString.substring(5,7);
        if(mm.substring(0,1).equalsIgnoreCase("0"))
        {
            mm = mm.substring(1,2);
        }
        return Integer.parseInt(yyyy+mm);
    }
    public static int getYear(Date date)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = dateFormat.format(date);
        String yyyy = dateString.substring(0,4);
        String mm = dateString.substring(5,7);
        if(mm.substring(0,1).equalsIgnoreCase("0"))
        {
            mm = mm.substring(1,2);
        }
        return Integer.parseInt(yyyy);
    }
    public static int getMonth(Date date)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = dateFormat.format(date);
        String yyyy = dateString.substring(0,4);
        String mm = dateString.substring(5,7);
        if(mm.substring(0,1).equalsIgnoreCase("0"))
        {
            mm = mm.substring(1,2);
        }
        return Integer.parseInt(mm);
    }
    public static int getDate(Date date)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = dateFormat.format(date);
        String yyyy = dateString.substring(0,4);
        String mm = dateString.substring(5,7);
        String dd = dateString.substring(8,10);
        if(mm.substring(0,1).equalsIgnoreCase("0"))
        {
            mm = mm.substring(1,2);
        }
        return Integer.parseInt(dd);
    }
    public static int getLastDayOfTheMonth(int mth,int yr)
    {
        System.out.println("Month is " + mth);
        System.out.println("Year is " + yr);
        if(mth == 1 || mth == 3 || mth ==5 || mth == 7 || mth == 8 || mth ==10 || mth == 12)
        {
            return 31;
        }
        else if(mth==2)
        {
            System.out.println("yr % 4 is " + (yr % 4));
            if(yr % 4 == 0)
            {
                return 29;
            }
            else
            {
                return 28;
            }
        }
        else
        {
            return 30;
        }
    }
    public static int convertTimeToMinutes(double hrs)
    {
        System.out.println("Hours sent " + hrs);
        int indexOfDot = -1;
        String hrsAsString = Double.toString(hrs);
        indexOfDot = hrsAsString.indexOf(".");
        int hours = Integer.parseInt(hrsAsString.substring(0,indexOfDot));
        int minutes = 0;
        String minutesAsString = hrsAsString.substring(indexOfDot+1,hrsAsString.length());
        if(minutesAsString.length()==1)
        {
            minutes = Integer.parseInt(minutesAsString + "0");
        }
        else
        {
            minutes = Integer.parseInt(minutesAsString);
        }
        int hoursAsMinutes = hours * 60;
        System.out.println("Minutes returned " + hoursAsMinutes);
        return (hoursAsMinutes + minutes);
    }
    public static double convertMinutestoHours(int minutes)
    {
        int hrs = minutes / 60;
        System.out.println("Hours Calculated is " + hrs);
        int mins = minutes % 60;
        System.out.println("Remaining Minutes is " + mins);
        double hrsMins = Double.parseDouble(hrs + "." + mins);
        System.out.println("Value being returned is " + hrsMins);
        return hrsMins;
    }
    public static int getDifferenceBetweenDatesInMinutes(GregorianCalendar fromDate,GregorianCalendar toDate)
    {
        int minutes = 0;
        while(true)
        {
            if(fromDate.get(GregorianCalendar.YEAR) == toDate.get(GregorianCalendar.YEAR) && fromDate.get(GregorianCalendar.MONTH) == toDate.get(GregorianCalendar.MONTH) && fromDate.get(GregorianCalendar.DATE) == toDate.get(GregorianCalendar.DATE) && fromDate.get(GregorianCalendar.HOUR_OF_DAY) == toDate.get(GregorianCalendar.HOUR_OF_DAY) && fromDate.get(GregorianCalendar.MINUTE) == toDate.get(GregorianCalendar.MINUTE))
            {
                break;
            }
            minutes = minutes + 1;
            fromDate.add(GregorianCalendar.MINUTE,1);
        }
        return minutes;
    }
    public static int getDifferenceBetweenDatesInDays(GregorianCalendar fromDate,GregorianCalendar toDate)
    {
        int days = 0;
        while(true)
        {
            if(fromDate.get(GregorianCalendar.YEAR) == toDate.get(GregorianCalendar.YEAR) && fromDate.get(GregorianCalendar.MONTH) == toDate.get(GregorianCalendar.MONTH) && fromDate.get(GregorianCalendar.DATE) == toDate.get(GregorianCalendar.DATE))
            {
                break;
            }
            days = days + 1;
            fromDate.add(GregorianCalendar.DATE,1);
        }
        return days;
    }
}

