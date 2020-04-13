package Model;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Product extends RecursiveTreeObject<Product>{

public StringProperty id;
public StringProperty name;
public StringProperty price;

    public Product() {
        id=new SimpleStringProperty();
        name=new SimpleStringProperty();
        price=new SimpleStringProperty();
    }


    public Product(String id, String name, String supplier, String price) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleStringProperty(price);
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id = new SimpleStringProperty(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public String getPrice() {
        return price.get();
    }

    public void setPrice(String price) {
        this.price = new SimpleStringProperty(price);
    }

    @Override
    public String toString() {
        return "PRODUCT{" + "id=" + id.get() + ", name=" + name.get() + ", price=" + price.get() + '}';
    }

    
}
