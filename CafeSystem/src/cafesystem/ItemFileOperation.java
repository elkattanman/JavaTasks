/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author elkat
 */
public class ItemFileOperation {
    private final File file = new File("menu.txt");
    
    public void WriteMenu(STORE store) throws MyException{
        FileWriter out = null;
        try {
            out = new FileWriter(file);
            for (MenuItem a : store.getMenu()) {
                out.append(a.getProduct_id()+",");
                out.append(a.getName()+",");
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

    public void addItem(STORE store, MenuItem c) throws MyException{
        FileWriter out = null;
        try {
            out = new FileWriter(file, true);
            store.addItem(c);
            out.append(c.getProduct_id()+ ",");
            out.append(c.getName()+ ",");
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
        store.removeItem(id);
        WriteMenu(store);
    }
    public void ReadItems(STORE store) throws MyException{
        try {
            Scanner sc=new Scanner(file);
            sc.useDelimiter(",");
            while(sc.hasNext()){
                MenuItem c=new MenuItem();
                c.setProduct_id(sc.next());
                c.setName(sc.next());
                c.setPrice(sc.nextDouble());
                store.addItem(c);
            }
        } catch (FileNotFoundException ex) {
            throw new MyException(ex);
        }
    }
    
    
    
}
