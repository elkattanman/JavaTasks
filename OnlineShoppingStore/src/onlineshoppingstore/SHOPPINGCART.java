/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineshoppingstore;

import java.util.ArrayList;


public class SHOPPINGCART {
    
    private ArrayList<ORDEREDITEM> ordered_list;
//    private ACCOUNT account;

    public SHOPPINGCART() {
        ordered_list = new ArrayList<>();
    }

    public SHOPPINGCART(ArrayList<ORDEREDITEM> ordered_list) {
        this.ordered_list = ordered_list;
    }

    public ArrayList<ORDEREDITEM> getOrdered_list() {
        return ordered_list;
    }

    public void setOrdered_list(ArrayList<ORDEREDITEM> ordered_list) {
        this.ordered_list = ordered_list;
    }
    
    
}
