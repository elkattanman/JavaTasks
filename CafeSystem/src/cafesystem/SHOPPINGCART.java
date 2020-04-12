/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafesystem;

import java.util.ArrayList;


public class SHOPPINGCART {
    private Customer customer;
    private ArrayList<ORDEREDITEM> ordered_list;
    private double totalPrice = 0.0;

    public SHOPPINGCART() {
        ordered_list=new ArrayList<>();
        customer=new Customer();
    }

    public SHOPPINGCART(Customer customer, ArrayList<ORDEREDITEM> ordered_list) {
        this.customer = customer;
        this.ordered_list = ordered_list;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<ORDEREDITEM> getOrdered_list() {
        return ordered_list;
    }

    public void setOrdered_list(ArrayList<ORDEREDITEM> ordered_list) {
        this.ordered_list = ordered_list;
    }

    public boolean add(ORDEREDITEM e) {
        addPrice(e.getQuantity()*e.getMenuItem().getPrice());
        return ordered_list.add(e);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public void addPrice(double Price) {
        this.totalPrice += Price;
    }
    
    
    
}
