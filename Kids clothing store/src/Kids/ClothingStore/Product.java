package Kids.ClothingStore;

public class Product {
    private String id;
    private String name;
    private String Type;
    private String size;
    private double price;

    public Product() {
    }

    public Product(String id, String name, String Type, String size, double price) {
        this.id = id;
        this.name = name;
        this.Type = Type;
        this.size = size;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", Type=" + Type + ", size=" + size + ", price=" + price + '}';
    }
    
}
