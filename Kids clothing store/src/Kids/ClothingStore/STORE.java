package Kids.ClothingStore;

import java.util.ArrayList;

public class STORE {
    private String name;
    
    private ArrayList<Admin> Admin_list;
    private ArrayList<Product> products;

    public STORE() {
        Admin_list=new ArrayList<>();
        products=new ArrayList<>();
    }

    public STORE(String name, ArrayList<Admin> Admin_list, ArrayList<Product> products) {
        this.name = name;
        this.Admin_list = Admin_list;
        this.products = products;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Admin> getAdmin_list() {
        return Admin_list;
    }

    public void setAdmin_list(ArrayList<Admin> Admin_list) {
        this.Admin_list = Admin_list;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    
    public boolean addAdmin(Admin e) {
        return Admin_list.add(e);
    }

    public Admin removeAdmin(int index) {
        return Admin_list.remove(index);
    }

    public boolean addProduct(Product e) {
        return products.add(e);
    }

    public Product removeProduct(int index) {
        return products.remove(index);
    }
    
}
