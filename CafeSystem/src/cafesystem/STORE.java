/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafesystem;

import java.util.ArrayList;

public class STORE {

    private String name;
    private ArrayList<Customer> Customer_list;
    private ArrayList<Admin> Admin_list;
    private ArrayList<MenuItem> menu;

    public STORE() {
        Customer_list=new ArrayList<>();
        Admin_list=new ArrayList<>();
        menu=new ArrayList<>();
    }

    public STORE(String name, ArrayList<Customer> Customer_list, ArrayList<Admin> Admin_list, ArrayList<MenuItem> menu) {
        this.name = name;
        this.Customer_list = Customer_list;
        this.Admin_list = Admin_list;
        this.menu = menu;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Customer> getCustomer_list() {
        return Customer_list;
    }

    public void setCustomer_list(ArrayList<Customer> Customer_list) {
        this.Customer_list = Customer_list;
    }

    public ArrayList<Admin> getAdmin_list() {
        return Admin_list;
    }

    public void setAdmin_list(ArrayList<Admin> Admin_list) {
        this.Admin_list = Admin_list;
    }

    public ArrayList<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<MenuItem> menu) {
        this.menu = menu;
    }

    public boolean addAdmin(Admin e) {
        return Admin_list.add(e);
    }

    public Admin removeAdmin(int index) {
        return Admin_list.remove(index);
    }

    public boolean addCustomer(Customer e) {
        return Customer_list.add(e);
    }

    public Customer removeCustomer(int index) {
        return Customer_list.remove(index);
    }

    public boolean addItem(MenuItem e) {
        return menu.add(e);
    }

    public MenuItem removeItem(int index) {
        return menu.remove(index);
    }

    @Override
    public String toString() {
        return "STORE{" + "name=" + name + ", Customer_list=" + Customer_list + ", Admin_list=" + Admin_list + '}';
    }
    
    
}
