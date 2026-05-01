package com.impJavaPractice.app;
//Write in excel file and read from excel file , upload file 

//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class connectionToDatabase {
//    public static void main(String[] args) {
//        String url = "jdbc:mysql://127.0.0.1:3306/hr_mysql?useSSL=false&serverTimezone=UTC";
//        String user = "root";
//        String password = "";
//        
//        
//
//        try {
//            Connection con = DriverManager.getConnection(url, user, password);
//            System.out.println("Connected to database successfully");
//            con.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    
//}
//}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConnectionToDatabase {

    public static void main(String[] args) {

        String url = "jdbc:mysql://127.0.0.1:3306/hr_mysql?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "";
        
        List<Country> countryList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load driver

            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to MySQL database successfully");
            
            String query = "SELECT * FROM hs_hr_country";

            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                countryList.add(
                    new Country(
                        rs.getString("cou_code"),
                        rs.getString("name"),
                        rs.getString("cou_name"),
                        rs.getString("iso3"),
                        rs.getInt("numcode")
                    )
                );
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        

for (Country country : countryList) {
            System.out.println(
                country.getCouCode() + " | " +
                country.getName() + " | " +
                country.getCouName() + " | " +
                country.getIso3() + " | " +
                country.getNumCode()
            );
        }

    }
    }
   class Country {

    private String couCode;
    private String name;
    private String couName;
    private String iso3;
    private int numCode;

    public Country(String couCode, String name, String couName, String iso3, int numCode) {
        this.couCode = couCode;
        this.name = name;
        this.couName = couName;
        this.iso3 = iso3;
        this.numCode = numCode;
    }

    public String getCouCode() { return couCode; }
    public String getName() { return name; }
    public String getCouName() { return couName; }
    public String getIso3() { return iso3; }
    public int getNumCode() { return numCode; }
}

