/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author LuisM45
 */
public class Date {
    private byte day;
    private byte month;
    private int year ;

    public Date() {
        this.day = 0;
        this.month = 0;
        this.year = 0;
    }
    public Date(String date) {
        setDate(date, "/");
    }
    public Date(String date,String separator) {
        setDate(date, separator);
    }
    public Date(int day, int month, int year) {
        setDate(day, month, year);
    }
    
    public void setDate(String date) {
        setDate(date,"/");
    }
    public void setDate(String date,String separator) {
        StringTokenizer stt = new StringTokenizer(date.trim(), separator);
        int day = Integer.parseInt(stt.nextToken());
        int month = Integer.parseInt(stt.nextToken());
        int year = Integer.parseInt(stt.nextToken());
        setDate(day, month, year);
    }
    
    public void setDate(int day, int month, int year) {
            this.day = (byte) day;
            this.month = (byte) month;
            this.year = year;
    }
    
    public boolean isValid(){
        return isValidDate((byte)day, (byte)month, (byte)year);
    }
    
    public static boolean isValidDate(String date) {
        return isValidDate(date, "/");
    }
    
    public static boolean isValidDate(String date,String separator) {
        StringTokenizer stt = new StringTokenizer(date.trim(), separator);
        byte day = Byte.parseByte(stt.nextToken());
        byte month = Byte.parseByte(stt.nextToken());
        int year = Integer.parseInt(stt.nextToken());
        return isValidDate(day, month, year);
    }
    
    public static boolean isValidDate(byte day, byte month, int year){
        if(month>12||day<1||month<1) return false;
            
        byte d31[] = {1,3,5,7,8,10,12};
        byte d30[] = {4,6,9,11};
        byte d2X ;
        if(Arrays.binarySearch(d31, month)>-1) return day<=31;
        if(Arrays.binarySearch(d30,month)>  -1) return day<=30;
        
        
        if(((year%4==0)&&!(year%100!=0))||(year%400==0)) d2X=29;
        else d2X=28;
        return day<=d2X;
    }
    public boolean isGreaterThan(Date date){
        if(this.year>date.year)return true;
        if(this.month>date.month)return true;
        if(this.day>date.day)return true;
        return true;
    }
    public boolean isLesserThan(Date date){
        if(this.year<date.year)return true;
        if(this.month<date.month)return true;
        if(this.day<date.day)return true;
        return true;
    }

    public String toString(String sepparator) {
        return (day+"/"+month+"/"+year);
    }

    public byte getDay() {
        return day;
    }

    public void setDay(byte day) {
        this.day = day;
    }

    public byte getMonth() {
        return month;
    }

    public void setMonth(byte month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    
    
    @Override
    public String toString() {
        return (day+"/"+month+"/"+year);
    }
    

}
