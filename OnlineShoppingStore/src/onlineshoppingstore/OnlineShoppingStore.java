/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineshoppingstore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OnlineShoppingStore {

    static double totalPrice = 0.0;
    static ArrayList<ORDEREDITEM> list;
    static STORE store;
    static SHOPPINGCART shoppingcart;
    static Scanner account_scan;
    static Scanner product_scan;

    public static void checkout() {
        Scanner input = new Scanner(System.in);

        System.out.println("Total price = "+totalPrice);
        System.out.println("Enter price");
        double price = input.nextDouble();
        
        if(price==totalPrice){
            System.out.println("Done");
            shoppingcart = new SHOPPINGCART();
            list= new ArrayList<>();
        }else{
            System.out.println("Review your price");
        }

    }

    public static void view_shopping_cart() {

        if (shoppingcart.getOrdered_list().isEmpty()) {
            System.out.println("shopping cart is empty");
        } else {

            ArrayList<ORDEREDITEM> list = shoppingcart.getOrdered_list();

            for (ORDEREDITEM item : list) {
                System.out.println("-ITEM ID : " + item.getMenuItem().getProduct_id());
                System.out.println("-ITEM Name : " + item.getMenuItem().getName());
                System.out.println("-ITEM Price : " + item.getMenuItem().getPrice());
                System.out.println("- Quantity : " + item.getQuantity());
                System.out.println("********************************");

            }
        }
    }

    public static boolean search_account(String user, String pass) {

        for (ACCOUNT a : store.getAccount_list()) {

            if (user.equals(a.getUsername()) && pass.equals(a.getPassword())) {
                return true;
            }

        }

        return false;

    }

    public static void display_all_account() {

        System.out.println("The list of accounts: ");
        for (ACCOUNT a : store.getAccount_list()) {

            System.out.println("Account Id : " + a.getAccount_id());
            System.out.println("Account Username : " + a.getUsername());
            System.out.println("Account Password : " + a.getPassword());

            System.out.println("The Customer Details for this account: ");

            System.out.println("-name: " + a.getName());
            System.out.println("-Address: " + a.getAddress());
            System.out.println("-Email: " + a.getEmail());
            System.out.println("-Phone: " + a.getPhone());

            System.out.println("******************");

        }

    }

    public static void add_product() {
        File product_file = new File("products.txt");
        FileWriter out = null;
        try {
            out = new FileWriter(product_file, true);
            Scanner input = new Scanner(System.in);
            MenuItem obj = new MenuItem();
            System.out.println("Enter the Menu-item id ");
            obj.setProduct_id(input.next());
            out.append(obj.getProduct_id()+",");
            System.out.println("Enter the Menu-item name ");
            obj.setName(input.next());
            out.append(obj.getName()+",");
            System.out.println("Enter the Item price ");
            obj.setPrice(input.nextDouble());
            out.append(obj.getPrice()+",");
            store.addItem(obj);
            System.out.println("Great! The Menu has been added!");
        } catch (IOException ex) {
            Logger.getLogger(OnlineShoppingStore.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(OnlineShoppingStore.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void delete_product() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the index of the item to be deleted:");
        int index = input.nextInt();

        store.deleteProduct(index);

    }

    public static void display_all_product() {
        System.out.println("The List os available Items ");
        for (MenuItem p : STORE.getMenu()) {
            System.out.println("-ITEM ID : " + p.getProduct_id());
            System.out.println("-ITEM Name : " + p.getName());
            System.out.println("-ITEM Price : " + p.getPrice());

            System.out.println("********************************");

        }

    }

    public static void add_product_by_id() {
//        shoppingcart = new SHOPPINGCART();
        ORDEREDITEM oreOrdereditem = new ORDEREDITEM();
//        ArrayList<ORDEREDITEM> list = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter The iD of product");
        String id = input.next();
        System.out.println("Enter the item quantity");
        int quantity = input.nextInt();

        for (MenuItem p : STORE.getMenu()) {
            if (p.getProduct_id().equals(id)) {
                oreOrdereditem.setMenuItem(p);
                oreOrdereditem.setQuantity(quantity);

                System.out.println("Your cart now has the follwing items");
                System.out.println("-ITEM ID : " + p.getProduct_id());
                System.out.println("-ITEM Name : " + p.getName());
                System.out.println("-ITEM Price : " + p.getPrice());
                totalPrice += (p.getPrice()*quantity);
                System.out.println("********************************");
                System.out.println("quantity : " + quantity);

            }

        }

        list.add(oreOrdereditem);
        shoppingcart.setOrdered_list(list);

    }

    public static void Customer_login() {
        try {

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter your login information.");

            System.out.print("Username:");

            String username = sc.next();
            System.out.print("Password:");
            String password = sc.next();

            if (!search_account(username, password)) {
                System.out.println("Login Failed! Invalid Username and/or Password.\n");
            } else {

                int x; // for repeat the method
                do {

                    Scanner input = new Scanner(System.in);
                    int cho = 0;
                    System.out.println("choose the require operations from the list below ");
                    System.out.println("(1) Display all Menu Items");
                    System.out.println("(2) add a new Order to the shopping cart by id");
                    System.out.println("(3) Go back to the main menu");
                    System.out.println("(4) View Orders in your shopping cart");
                    System.out.println("(5) Go to checkout");

                    cho = input.nextInt();

                    if (cho == 1) {
                        display_all_product();
                    } else if (cho == 2) {
                        add_product_by_id();
                    } else if (cho == 3) {
                        login();
                    } else if (cho == 4) {
                        view_shopping_cart();
                    } else {
                        checkout();
                    }

                    System.out.println("Another user operations  ? (0) for yes  | (1) for no");
                    x = input.nextInt();
                } while (x == 0);
            }
            login();
        } catch (Exception ex) {
            Logger.getLogger(OnlineShoppingStore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void admin_login() {
        int x; // for repeat the method
        do {

            Scanner input = new Scanner(System.in);
            int cho = 0;

            System.out.println("choose the require operations from the list below ");
            System.out.println("(1) Display all Menu");
            System.out.println("(2) Display all account");
            System.out.println("(3) add a Item");
            System.out.println("(4) delete a Item");
            System.out.println("(5) Go back to the main menu");

            cho = input.nextInt();

            if (cho == 1) {
                display_all_product();
            } else if (cho == 2) {
                display_all_account();
            } else if (cho == 3) {
                add_product();
            } else if (cho == 4) {
                delete_product();
            } else {
                login();
            }

            System.out.println("Another user operations  ? (0) for yes  | (1) for no");
            x = input.nextInt();
        } while (x == 0);

        login();

    }

    public static void login() {
        Scanner input = new Scanner(System.in);

        int cho;
        System.out.println("Are you customer or Admin");
        System.out.println("(1) for Customer");
        System.out.println("(2) for Admin");
        System.out.println("(3) for Exit");
        cho = input.nextInt();
        input.nextLine();
        switch (cho) {
            case 1:
                Customer_login();
                break;
            case 2:
                admin_login();
                break;
            default:
                System.out.println("Thanks for visiting our Cafe!");
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        try {
            File account_file = new File("accounts.txt");
            account_scan = new Scanner(account_file);
            File product_file = new File("products.txt");
            product_scan = new Scanner(product_file);

            account_scan.useDelimiter(",|\n");
            product_scan.useDelimiter(",|\n");

            store = new STORE();

            while (product_scan.hasNext()) {
                MenuItem objProduct = new MenuItem();
                objProduct.setProduct_id(product_scan.next());
                objProduct.setName(product_scan.next());
                objProduct.setPrice(product_scan.nextDouble());
                //System.err.println(objProduct);
                store.addItem(objProduct);
            }

            while (account_scan.hasNext()) {
                ACCOUNT obj = new ACCOUNT();

                obj.setAccount_id(account_scan.nextInt());
                obj.setUsername(account_scan.next());
                obj.setPassword(account_scan.next());
                obj.setName(account_scan.next());
                obj.setAddress(account_scan.next());
                obj.setPhone(account_scan.next());
                obj.setEmail(account_scan.next());

                store.addAccount(obj);

            }

        } catch (FileNotFoundException ex) {
            System.out.println("******  error while reading files (accounts and products)");
            ex.printStackTrace();

        } finally {

            product_scan.close();
            account_scan.close();
        }

        System.out.println("^^^^^^ Welcome to our Online Cafe' ^^^^^");
        System.out.println("************************************************");

        shoppingcart = new SHOPPINGCART();
        list = new ArrayList<>();

        login();

    }

}
