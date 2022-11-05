package model;

import java.util.Scanner;

public class Person {
    private int cCCD;
    private String fullName;
    private int numberPhone;
    private String address;
    private Account account;

    public Person() {
    }

    public Person(int cCCD, String fullName, int numberPhone, String address){
        this.cCCD = cCCD;
        this.fullName = fullName;
        this.numberPhone = numberPhone;
        this.address = address;
    }

    public Person(int cCCD, String fullName, int numberPhone, String address, Account account) {
        this.cCCD = cCCD;
        this.fullName = fullName;
        this.numberPhone = numberPhone;
        this.address = address;
        this.account = account;
    }

    public int getcCCD() {
        return cCCD;
    }

    public void setcCCD(int cCCD) {
        this.cCCD = cCCD;
    }

    public String getFullName(){
        return fullName;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public int getNumberPhone(){
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone){
        this.numberPhone = numberPhone;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "\n-Username: "+getAccount().getUserName()+"\t fullName : "+getFullName()+"\t-CCCD : "+getcCCD()+"\twith Role: "+getAccount().getRole();
    }
}
