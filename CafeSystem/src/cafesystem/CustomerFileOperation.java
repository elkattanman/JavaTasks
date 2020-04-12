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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elkat
 */
public class CustomerFileOperation {
    private File file = new File("customers.txt");
    
    public void WriteCustomers(STORE store) throws MyException{
        FileWriter out = null;
        try {
            out = new FileWriter(file);
            for (Customer a : store.getCustomer_list()) {
                out.append(a.getUserName() + ",");
                out.append(a.getPassword() + ",");
                out.append(a.getName() + ",");
                out.append(a.getPhone() + ",");
                out.append(a.getEmail() + ",");
                out.append(a.getAddress() + ",");
            }
        } catch (Exception ex) {
            throw new MyException(ex);
        }finally{
            try {
                out.close();
            } catch (IOException ex) {
                throw new MyException(ex);
            }
        }
    }

    public void addCustomer(STORE store, Customer c) throws MyException{
        FileWriter out = null;
        try {
            out = new FileWriter(file, true);
            store.addCustomer(c);
            out.append(c.getUserName() + ",");
            out.append(c.getPassword() + ",");
            out.append(c.getName() + ",");
            out.append(c.getPhone() + ",");
            out.append(c.getEmail() + ",");
            out.append(c.getAddress() + ",");
        } catch (Exception ex) {
            throw new MyException(ex);
        }finally{
            try {
                out.close();
            } catch (IOException ex) {
                throw new MyException(ex);
            }
        }
    }
    public void RemoveCustomer(STORE store, int id)throws MyException{
        store.removeCustomer(id);
        WriteCustomers(store);
    }
    public void ReadCustomers(STORE store) throws MyException{
        try {
            Scanner sc=new Scanner(file);
            sc.useDelimiter(",");
            while(sc.hasNext()){
                Customer c=new Customer();
                c.setUserName(sc.next());
                c.setPassword(sc.next());
                c.setName(sc.next());
                c.setPhone(sc.next());
                c.setEmail(sc.next());
                c.setAddress(sc.next());
                store.addCustomer(c);
            }
        } catch (FileNotFoundException ex) {
            throw new MyException(ex);
        }
    }
    
    
    
}
