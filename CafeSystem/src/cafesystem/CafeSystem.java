/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafesystem;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elkat
 */
public class CafeSystem {

    static STORE store = new STORE();
    static SHOPPINGCART shoppingcart = new SHOPPINGCART();

    public static void checkout() {
        Scanner input = new Scanner(System.in);
        System.out.println("Total price = " + shoppingcart.getTotalPrice());
        System.out.println("Enter price");
        double price = input.nextDouble();
        if (price == shoppingcart.getTotalPrice()) {
            System.out.println("Done");
            shoppingcart = new SHOPPINGCART();
            shoppingcart.getOrdered_list().clear();
        } else {
            System.out.println("Review your price");
        }

    }

    public static void viewOrders() {

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

    public static Customer searchCustomer(String user, String pass) {

        for (Customer a : store.getCustomer_list()) {

            if (user.equals(a.getUserName()) && pass.equals(a.getPassword())) {
                return a;
            }
        }
        return null;
    }

    public static boolean searchAdmin(String user, String pass) {

        for (Admin a : store.getAdmin_list()) {

            if (user.equals(a.getUserName()) && pass.equals(a.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public static void displayCustomers() {

        System.out.println("The list of accounts: ");
        for (Customer a : store.getCustomer_list()) {

            System.out.println("Account Username : " + a.getUserName());
            System.out.println("Account Password : " + a.getPassword());
            System.out.println("The Customer Details for this account: ");

            System.out.println("-name: " + a.getName());
            System.out.println("-Address: " + a.getAddress());
            System.out.println("-Email: " + a.getEmail());
            System.out.println("-Phone: " + a.getPhone());
            System.out.println("******************");
        }

    }

    public static void displayAdmins() {

        System.out.println("The list of accounts: ");
        for (Admin a : store.getAdmin_list()) {

            System.out.println("Account Username : " + a.getUserName());
            System.out.println("Account Password : " + a.getPassword());
            System.out.println("The Customer Details for this account: ");

            System.out.println("-name: " + a.getName());
            System.out.println("-Address: " + a.getAddress());
            System.out.println("-Email: " + a.getEmail());
            System.out.println("-Phone: " + a.getPhone());
            System.out.println("******************");
        }
    }

    public static void displayMenu() {
        System.out.println("The List os available Items ");
        for (MenuItem p : store.getMenu()) {
            System.out.println("-ITEM ID : " + p.getProduct_id());
            System.out.println("-ITEM Name : " + p.getName());
            System.out.println("-ITEM Price : " + p.getPrice());
            System.out.println("********************************");

        }
    }

    public static void addItem() throws MyException {
        Scanner input = new Scanner(System.in);
        MenuItem obj = new MenuItem();
        System.out.println("Enter the Menu-item id ");
        obj.setProduct_id(input.next());
        System.out.println("Enter the Menu-item name ");
        obj.setName(input.next());
        System.out.println("Enter the Item price ");
        obj.setPrice(input.nextDouble());
        store.addItem(obj);
        new ItemFileOperation().addItem(store, obj);
        System.out.println("Great! The Menu has been added!");
    }

    public static void addCustomer() throws MyException {
        Scanner input = new Scanner(System.in);
        Customer c = new Customer();
        System.out.print("Enter Username :");
        c.setUserName(input.next());
        System.out.print("Enter Password :");
        c.setPassword(input.next());
        System.out.print("Enter Name :");
        c.setName(input.next());
        System.out.print("Enter Phone :");
        c.setPhone(input.next());
        System.out.print("Enter Email :");
        c.setEmail(input.next());
        System.out.print("Enter address :");
        c.setAddress(input.next());
        store.addCustomer(c);
        new CustomerFileOperation().addCustomer(store, c);
        System.out.println("Great! The Customer has been added!");
    }

    public static void addAdmin() throws MyException {
        Scanner input = new Scanner(System.in);
        Admin c = new Admin();
        System.out.print("Enter Username :");
        c.setUserName(input.next());
        System.out.print("Enter Password :");
        c.setPassword(input.next());
        System.out.print("Enter Name :");
        c.setName(input.next());
        System.out.print("Enter Phone :");
        c.setPhone(input.next());
        System.out.print("Enter Email :");
        c.setEmail(input.next());
        System.out.print("Enter address :");
        c.setAddress(input.next());
        store.addAdmin(c);
        new AdminFileOperation().addAdmin(store, c);
        System.out.println("Great! The Admin has been added!");
    }

    public static void deleteItem() throws MyException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the index of the item to be deleted:");
        int index = input.nextInt();
        new ItemFileOperation().RemoveItem(store, index);
    }

    public static void customer_login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your login information.");
        System.out.print("Username:");
        String username = sc.next();
        System.out.print("Password:");
        String password = sc.next();
        Customer c = searchCustomer(username, password);
        if (c == null) {
            System.out.println("Login Failed! Invalid Username and/or Password.\n");
        } else {
            shoppingcart.setCustomer(c);
            int x; // for repeat the method
            do {
                Scanner input = new Scanner(System.in);
                int cho = 0;
                System.out.println("********Welcome " + username + "**************\n"
                        + "choose the require operations from the list below ");
                System.out.println("(1) Display all Menu Items");
                System.out.println("(2) add a new Order to the shopping cart by id");
                System.out.println("(3) View Orders in your shopping cart");
                System.out.println("(4) Go to checkout");
                System.out.println("(5) Go back to the main menu");
                cho = input.nextInt();
                switch (cho) {
                    case 1:
                        displayMenu();
                        break;
                    case 2:
                        addOrder();
                        break;
                    case 3:
                        viewOrders();
                        break;
                    case 4:
                        checkout();
                        break;
                    default:
                        return;
                }

                System.out.println("Another user operations  ? (0) for yes  | (1) for no");
                x = input.nextInt();
            } while (x == 0);
        }
    }

    public static void admin_login() throws MyException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your login information.");
        System.out.print("Username:");
        String username = sc.next();
        System.out.print("Password:");
        String password = sc.next();
        if (!searchAdmin(username, password)) {
            System.out.println("Login Failed! Invalid Username and/or Password.\n");
        } else {
            int x; // for repeat the method
            do {
                Scanner input = new Scanner(System.in);
                int cho = 0;
                System.out.println("choose the require operations from the list below ");
                System.out.println("(1) Display Menu");
                System.out.println("(2) Display Customer");
                System.out.println("(3) Display Admins");
                System.out.println("(4) add Admin");
                System.out.println("(5) add a Item");
                System.out.println("(6) delete a Item");
                System.out.println("(7) Go back to the main menu");

                cho = input.nextInt();

                switch (cho) {
                    case 1:
                        displayMenu();
                        break;
                    case 2:
                        displayCustomers();
                        break;
                    case 3:
                        displayAdmins();
                        break;
                    case 4:
                        addAdmin();
                        break;
                    case 5:
                        addItem();
                        break;
                    case 6:
                        deleteItem();
                        break;
                    default:
                        return;
                }
                System.out.println("Another user operations  ? (0) for yes  | (1) for no");
                x = input.nextInt();
            } while (x == 0);
        }
    }

    public static void addOrder() {
        ORDEREDITEM ordereditem = new ORDEREDITEM();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter The iD of Item");
        String id = input.next();
        System.out.println("Enter the item quantity");
        int quantity = input.nextInt();
        boolean flag = false;
        for (MenuItem p : store.getMenu()) {
            if (p.getProduct_id().equals(id)) {
                flag = true;
                ordereditem.setMenuItem(p);
                ordereditem.setQuantity(quantity);
                System.out.println("Your cart now has the follwing items");
                System.out.println("-ITEM ID : " + p.getProduct_id());
                System.out.println("-ITEM Name : " + p.getName());
                System.out.println("-ITEM Price : " + p.getPrice());
                shoppingcart.add(ordereditem);
                System.out.println("********************************");
                System.out.println("quantity : " + quantity);

            }
        }
        if (!flag) {
            System.out.println("There is no item with this id");
        }
    }

    public static void login() throws MyException {
        Scanner input = new Scanner(System.in);
        int x; // for repeat the method
        do {
            int cho;
            System.out.println("Are you customer or Admin");
            System.out.println("(1) for Customer");
            System.out.println("(2) for Admin");
            System.out.println("(3) for Exit");
            cho = input.nextInt();
            input.nextLine();
            switch (cho) {
                case 1:
                    System.out.println("To Resgister press(1)\nto Login press(2)");
                    int t = input.nextInt();
                    if (t == 1) {
                        addCustomer();
                    } else {
                        customer_login();
                    }
                    break;
                case 2:
                    admin_login();
                    break;
                default:
                    System.out.println("Thanks for visiting our Cafe!");
                    return;
            }
        } while (true);
    }

    public static void main(String[] args) {
        try {
            new AdminFileOperation().ReadAdmins(store);
            new CustomerFileOperation().ReadCustomers(store);
            new ItemFileOperation().ReadItems(store);
            boolean flag = true;
            login();

        } catch (MyException ex) {
            System.err.println("Sorry There is an error in System\n Message: " + ex.getMessage());
        }
    }

}
