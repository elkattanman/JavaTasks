/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafesystem;

public class MenuItem {

private String product_id;
private String name;
private double price;

    public MenuItem() {
    }


    public MenuItem(String product_id, String name, String supplier, double price) {
        this.product_id = product_id;
        this.name = name;
        this.price = price;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PRODUCT{" + "product_id=" + product_id + ", name=" + name + ", price=" + price + '}';
    }

    
}
