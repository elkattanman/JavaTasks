/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafesystem;

public class ORDEREDITEM {

    private MenuItem menuItem;
    private int quantity;

    public ORDEREDITEM() {
    }

    public ORDEREDITEM(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ORDEREDITEM{" + "menuItem=" + menuItem + ", quantity=" + quantity + '}';
    }
    
    

}
