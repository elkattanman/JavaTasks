/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elkat
 */
public class CustomerDAO {

    private final String insertSQL = "INSERT INTO `store`.`customer` (`username`, `password`, `name`, `address`,`phone` ,`email`) VALUES(?,?,?,?,?,?);";
    private final String selectSQL = "SELECT * from `store`.`customer`";
    private final String loginSQL = "SELECT * from `store`.`customer` WHERE `username` = ? and `password` = ?";
    private final String updateSQL = "UPDATE `store`.`customer` SET `address` = ?, `phone` = ?, `email` = ? WHERE `name` = ?";
    private final String deleteSQL = "DELETE FROM `store`.`customer` WHERE `name` = ?;";

    public void insert(Customer c) throws Exception {
        Connection con = DBConnection.getCon();
        PreparedStatement ps = con.prepareStatement(insertSQL);
        ps.setString(1, c.getUserName());
        ps.setString(2, c.getPassword());
        ps.setString(3, c.getName());
        ps.setString(4, c.getAddress());
        ps.setString(5, c.getPhone());
        ps.setString(6, c.getEmail());
        ps.executeUpdate();
    }

    public List<Customer> getAll() throws Exception {
        List<Customer> ret = new ArrayList<>();
        Connection con = DBConnection.getCon();
        PreparedStatement ps = con.prepareStatement(selectSQL);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Customer c = new Customer();
            c.setUserName(rs.getString("username"));
            c.setPassword(rs.getString("password"));
            c.setName(rs.getString("name"));
            c.setAddress(rs.getString("address"));
            c.setEmail(rs.getString("email"));
            c.setPhone(rs.getString("phone"));
            ret.add(c);
        }
        return ret;
    }
    
    public Customer getOne(String username, String password) throws Exception {
        Customer c=null ;
        Connection con = DBConnection.getCon();
        PreparedStatement ps = con.prepareStatement(loginSQL);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            c = new Customer();
            c.setUserName(rs.getString("username"));
            c.setPassword(rs.getString("password"));
            c.setName(rs.getString("name"));
            c.setAddress(rs.getString("address"));
            c.setEmail(rs.getString("email"));
            c.setPhone(rs.getString("phone"));
            return c;
        }
        return c;
    }

    public void update(Customer c) throws Exception {
        Connection con = DBConnection.getCon();
        PreparedStatement ps = con.prepareStatement(updateSQL);
        ps.setString(1, c.getAddress());
        ps.setString(2, c.getPhone());
        ps.setString(3, c.getEmail());
        ps.setString(4, c.getName());
        ps.executeUpdate();
    }

    public void delete(Customer c) throws Exception {
        Connection con = DBConnection.getCon();
        PreparedStatement ps = con.prepareStatement(deleteSQL);
        ps.setString(1, c.getName());
        ps.executeUpdate();
    }
    
    public static void main(String[] args) {
        try {
            System.out.println(new CustomerDAO().getAll());
        } catch (Exception ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
