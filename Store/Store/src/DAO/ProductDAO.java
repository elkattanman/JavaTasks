/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Customer;
import Model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elkat
 */
public class ProductDAO{
    private final String insertSQL= "INSERT INTO `store`.`product` (`id`, `name`, `price`) VALUES(?,?,?);";
    private final String selectSQL= "SELECT * from `store`.`product`";
    private final String updateSQL= "UPDATE `store`.`product` SET `name` = ?, `price` = ? WHERE `id` = ?;";
    private final String deleteSQL= "DELETE FROM `store`.`product` WHERE `id` = ?;";
    
    
    public void insert(Product p) throws Exception {
        Connection con = DBConnection.getCon();
        PreparedStatement ps = con.prepareStatement(insertSQL);
        ps.setString(1, p.getId());
        ps.setString(2, p.getName());
        ps.setDouble(3, Double.parseDouble(p.getPrice()));
        ps.executeUpdate();
    }

    
    public List<Product> getAll() throws Exception {
        List<Product> ret = new ArrayList<>();
        Connection con = DBConnection.getCon();
        PreparedStatement ps = con.prepareStatement(selectSQL);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Product temp = new Product();
            temp.setId(rs.getString("id"));
            temp.setName(rs.getString("name"));
            temp.setPrice(rs.getString("price"));
            ret.add(temp);
        }
        return ret;
    }


    public void update(Product p) throws Exception {
        Connection con = DBConnection.getCon();
        PreparedStatement ps = con.prepareStatement(updateSQL);
        ps.setString(1, p.getName());
        ps.setDouble(2, Double.parseDouble(p.getPrice()));
        ps.setString(3, p.getId());
        ps.executeUpdate();
    }


    public void delete(Product o) throws Exception {
        Connection con = DBConnection.getCon();
        PreparedStatement ps = con.prepareStatement(deleteSQL);
        ps.setString(1, o.getId());
        ps.executeUpdate();
    }
    
    
    
}
