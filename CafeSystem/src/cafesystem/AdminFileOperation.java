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
public class AdminFileOperation {
    private File file = new File("admins.txt");
    
    public void WriteAdmins(STORE store) throws MyException{
        FileWriter out = null;
        try {
            out = new FileWriter(file);
            for (Admin a : store.getAdmin_list()) {
                out.append(a.getUserName() + ",");
                out.append(a.getPassword() + ",");
                out.append(a.getName() + ",");
                out.append(a.getPhone() + ",");
                out.append(a.getEmail() + ",");
                out.append(a.getAddress() + ",");
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

    public void addAdmin(STORE store, Admin c) throws MyException{
        FileWriter out = null;
        try {
            out = new FileWriter(file, true);
            store.addAdmin(c);
            out.append(c.getUserName() + ",");
            out.append(c.getPassword() + ",");
            out.append(c.getName() + ",");
            out.append(c.getPhone() + ",");
            out.append(c.getEmail() + ",");
            out.append(c.getAddress() + ",");
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
    public void RemoveAdmin(STORE store, int id)throws MyException{
        store.removeAdmin(id);
        WriteAdmins(store);
    }
    public void ReadAdmins(STORE store) throws MyException{
        try {
            Scanner sc=new Scanner(file);
            sc.useDelimiter(",");
            while(sc.hasNext()){
                Admin c=new Admin();
                c.setUserName(sc.next());
                c.setPassword(sc.next());
                c.setName(sc.next());
                c.setPhone(sc.next());
                c.setEmail(sc.next());
                c.setAddress(sc.next());
                store.addAdmin(c);
            }
        } catch (FileNotFoundException ex) {
            throw new MyException(ex);
        }
    }
    
    
    
}
