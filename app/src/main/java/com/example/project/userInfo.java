package com.example.project_layanalharbi;

public class userInfo {
    private String Firstname;
    private String Lastname;
    private String userEmail;
    private String Password;
    private String ConfPassword;
    private String Username;

    public userInfo() {

    }

    public String getUserName() {

        return Username;

    }
    public void setUserName(String userName) {
        this.Username = userName;
    }

    public String getUserFName() {

        return Firstname;

    }
    public void setUserFName(String userFirstName) {
        this.Firstname = userFirstName;
    }

    public String getUserLName() {

        return Lastname;
    }
    public void setUserLName(String userLastName) {
        this.Firstname = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return Password;
    }
    public void setUserPassword(String userPassword) {
        this.Password = userPassword;
    }

    public String getUserConfPassword() {
        return ConfPassword;
    }
    public void setUserConfPassword(String userConfPassword) {
        this.Password = userConfPassword;
    }
}
