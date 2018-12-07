package com.example.shahzad.project1;


public class modeldb {
public static int counterr=0;
private static String[] userEmail=new String[100];
private static String[] password=new String[100];
private static String[] name=new String[100];
private static String[] location=new String[100];
    public static String getUserEmail(int i) {
        return userEmail[i];
    }

    public void setUserEmail(String userEmail, int i) {
        this.userEmail[i] = userEmail;
    }

    public static String getPassword(int i) {
        return password[i];
    }

    public void setPassword(String password,int i) {
        this.password[i] = password;
    }

    public static String getName(int i) {
        return name[i];
    }

    public void setName(String name,int i) {
        this.name[i] = name;
    }

    public static String getLocation(int i) {
        return location[i];
    }

    public void setLocation(String location, int i) {
        this.location[i] = location;
    }


}
