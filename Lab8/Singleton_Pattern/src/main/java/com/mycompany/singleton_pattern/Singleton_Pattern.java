/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.singleton_pattern;

/**
 *
 * @author Phan Thao
 */
public class Singleton_Pattern {

    public static void main(String[] args) {
        CompanyInfo companyInfo = CompanyInfo.getInstance();
        companyInfo.displayInfo();
        
        companyInfo.setCompanyName("EIU-Đại học quốc tế Miền Đông");
        companyInfo.setAddress("3M38+6F3, Nam Kỳ Khởi Nghãi, Định Hòa, Thủ Dầu Một");
        companyInfo.setPhoneNumber("(+84) 0274 222 0372");
        companyInfo.displayInfo();
    }
}
