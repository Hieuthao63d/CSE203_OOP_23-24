/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.singleton_pattern;

/**
 *
 * @author Phan Thao
 */
public class CompanyInfo {
    private static CompanyInfo instance;
    
    private String companyName;
    private String address;
    private String phoneNumber;
    private String email;
    private String owner;
    
    private CompanyInfo(){
        this.companyName = "MyCompany";
        this.address = "123 Main Street, City, Country";
        this.phoneNumber = "123-456-7890";
        this.email = "info@eiu.edu.com";
        this.owner = "";
        
    }

    public static synchronized CompanyInfo getInstance() {
        if ( instance ==null){
            instance = new CompanyInfo();
        }
        return instance;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getOwner() {
        return owner;
    }

    public static void setInstance(CompanyInfo instance) {
        CompanyInfo.instance = instance;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    public void displayInfo(){
        System.out.println("Company Name: "+ companyName);
        System.out.println("Address: "+ address);
        System.out.println("Phone Number: "+ phoneNumber);
        System.out.println("Email: "+ email);
        System.out.println("Owner: "+ owner);
    }
}
