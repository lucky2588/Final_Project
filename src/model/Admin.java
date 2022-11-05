package model;

import java.util.ArrayList;

public class Admin extends Person {
    private ArrayList<ManagerHomeModel> listManager;
    private ArrayList<Person> listUser;

    public Admin(int cCCD, String fullName, int numberPhone, String address, Account account) {
        super(cCCD, fullName, numberPhone, address, account);
    }

    public ArrayList<Person> getListUser() {
        return listUser;
    }

    public void setListUser(ArrayList<Person> listUser) {
        this.listUser = listUser;
    }

    public Admin(ArrayList<ManagerHomeModel> listManager) {
        this.listManager = listManager;
    }

    public ArrayList<ManagerHomeModel> getListManager() {
        return listManager;
    }

    public void setListManager(ArrayList<ManagerHomeModel> listManager) {
        this.listManager = listManager;
    }

}
