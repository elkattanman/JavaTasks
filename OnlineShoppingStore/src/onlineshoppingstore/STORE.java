/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineshoppingstore;

import java.util.ArrayList;

public class STORE {

    private String name;
    private ArrayList<ACCOUNT> account_list;
    private static ArrayList<MenuItem> menu;

    public STORE() {
        account_list = new ArrayList<>();
        menu=new ArrayList<>();
    }
    
    public STORE(String name, ArrayList<ACCOUNT> account_list , ArrayList<MenuItem> menu) {
        this.name = name;
        this.account_list = account_list;
        this.menu=menu;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ACCOUNT> getAccount_list() {
        return account_list;
    }

    public void setAccount_list(ArrayList<ACCOUNT> account_list) {
        this.account_list = account_list;
    }

    public static ArrayList<MenuItem> getMenu() {
        return menu;
    }

    public static void setMenu(ArrayList<MenuItem> menu) {
        STORE.menu = menu;
    }
    
    

    @Override
    public String toString() {
        return "STORE{" + "name=" + name + ", account_list=" + account_list + '}';
    }

    /**
     * ***********************************************
     */
    public void addItem(MenuItem p) {

        menu.add(p);

    }

    public void deleteProduct(int index) {

        menu.remove(index);

    }

    public void addAccount(ACCOUNT account) {
        account_list.add(account);
    }

}
