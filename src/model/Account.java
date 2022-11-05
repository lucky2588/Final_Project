package model;

public class Account {
    private String userName;
    private String passWord;
    private String role;

    public Account(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public Account(String userName, String passWord, String role) {
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
    }

    public Account() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setRole(String role){
        this.role = role;
    }
    public String getRole(){
        return role;
    }

    @Override
    public String toString(){
        return "\t-Username: "+getUserName();
    }

}
