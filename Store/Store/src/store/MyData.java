/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import Model.Admin;
import Model.Customer;
import Model.SHOPPINGCART;

/**
 *
 * @author elkat
 */
public class MyData {
    public static Admin admin=new Admin("admin", "admin", "Administrator", "address1", "7894561230", "email@test.com");
    public static SHOPPINGCART shoppingcart=new SHOPPINGCART();
    public static Customer customer=new Customer();
    
    
}
