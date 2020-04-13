/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineshoppingstore;

public class ACCOUNT extends CUSTOMER{

    private int account_id;
    private String username;
    private String password;
//    private CUSTOMER customer;
    
    public ACCOUNT(){
        
        
    }
    public ACCOUNT(int account_id, String username, String password) {
        this.account_id = account_id;
        this.username = username;
        this.password = password;
//        this.customer = customer;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public CUSTOMER getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(CUSTOMER customer) {
//        this.customer = customer;
//    }

    @Override
    public String toString() {
        return "ACCOUNT{" + "account_id=" + account_id + ", username=" + username + ", password=" + password +'}';
    }
    
    
    
}
