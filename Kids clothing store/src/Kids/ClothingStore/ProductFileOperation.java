package Kids.ClothingStore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ProductFileOperation {
    private final File file = new File("Products.txt");
    
    public void WriteMenu(STORE store) throws MyException{
        FileWriter out = null;
        try {
            out = new FileWriter(file);
            for (Product a : store.getProducts()) {
                out.append(a.getId()+",");
                out.append(a.getName()+",");
                out.append(a.getSize()+",");
                out.append(a.getType()+",");
                out.append(a.getPrice()+",");
            }
        } catch (IOException ex) {
            throw new MyException(ex);
        }finally{
            try {
                out.close();
            } catch (IOException ex) {
                throw new MyException(ex);
            }
        }
    }

    public void addItem(STORE store, Product c) throws MyException{
        FileWriter out = null;
        try {
            out = new FileWriter(file, true);
            store.addProduct(c);
            out.append(c.getId()+ ",");
            out.append(c.getName()+ ",");
            out.append(c.getSize()+ ",");
            out.append(c.getType()+ ",");
            out.append(c.getPrice()+ ",");
        } catch (IOException ex) {
            throw new MyException(ex);
        }finally{
            try {
                out.close();
            } catch (IOException ex) {
                throw new MyException(ex);
            }
        }
    }
    public void RemoveItem(STORE store, int id)throws MyException{
        store.removeProduct(id);
        WriteMenu(store);
    }
    public void ReadItems(STORE store) throws MyException{
        try {
            Scanner sc=new Scanner(file);
            sc.useDelimiter(",");
            while(sc.hasNext()){
                Product c=new Product();
                c.setId(sc.next());
                c.setName(sc.next());
                c.setSize(sc.next());
                c.setType(sc.next());
                c.setPrice(sc.nextDouble());
                store.addProduct(c);
            }
        } catch (FileNotFoundException ex) {
            throw new MyException(ex);
        }
    }
    
    
    
}
