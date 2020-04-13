package Kids.ClothingStore;

import java.util.Scanner;

public class Main {

    static STORE store = new STORE();

    public static Admin searchAdmin(String user, String pass) {

        for (Admin a : store.getAdmin_list()) {

            if (user.equals(a.getUserName()) && pass.equals(a.getPassword())) {
                return a;
            }
        }
        return null;
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

    public static void displayProduct() {
        System.out.println("The List os available Items ");
        for (Product p : store.getProducts()) {
            System.out.println("-Product ID : " + p.getId());
            System.out.println("-Product Name : " + p.getName());
            System.out.println("-Product Name : " + p.getSize());
            System.out.println("-Product Name : " + p.getType());
            System.out.println("-Product Price : " + p.getPrice());
            System.out.println("********************************");
        }
    }

    public static void addProduct() throws MyException {
        Scanner input = new Scanner(System.in);
        Product obj = new Product();
        System.out.println("Enter the Product id ");
        obj.setId(input.next());
        System.out.println("Enter the Product name ");
        obj.setName(input.next());
        System.out.println("Enter the Product Type ");
        obj.setType(input.next());
        System.out.println("Enter the Product Size ");
        obj.setSize(input.next());
        System.out.println("Enter Product price ");
        obj.setPrice(input.nextDouble());
        store.addProduct(obj);
        new ProductFileOperation().addItem(store, obj);
        System.out.println("Great! The Menu has been added!");
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
    
    public static void deleteProduct() throws MyException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the index of the item to be deleted:");
        int index = input.nextInt();
        new ProductFileOperation().RemoveItem(store, index);
    }
    
    public static void admin_login() throws MyException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your login information.");
        System.out.print("Username:");
        String username = sc.next();
        System.out.print("Password:");
        String password = sc.next();
        Admin a=searchAdmin(username, password);
        if (a==null) {
            System.out.println("Login Failed! Invalid Username and/or Password.\n");
        } else {
            int x; // for repeat the method
            do {
                Scanner input = new Scanner(System.in);
                int cho = 0;
                System.out.println("===================Welcome "+ a.getName() + " =================");
                System.out.println("choose the require operations from the list below ");
                System.out.println("(1) Show Products");
                System.out.println("(2) add a Product");
                System.out.println("(3) Display Admins");
                System.out.println("(4) add Admin");
                System.out.println("(5) delete a product");
                System.out.println("(7) Go back to the main menu");

                cho = input.nextInt();

                switch (cho) {
                    case 1:
                        displayProduct();
                        break;
                    case 2:
                        addProduct();
                        break;
                    case 3:
                        displayAdmins();
                        break;
                    case 4:
                        addAdmin();
                        break;
                    case 5:
                        deleteProduct();
                        break;
                    default:
                        return;
                }
                System.out.println("Another user operations  ? (0) for yes  | (1) for no");
                x = input.nextInt();
            } while (x == 0);
        }
    }
    public static void login() throws MyException {
        Scanner input = new Scanner(System.in);
        int x; // for repeat the method
        do {
            int cho;
            System.out.println("Welcome To Kids Clothing Store System");
            System.out.println("(1) Login");
            System.out.println("(2) for Exit");
            cho = input.nextInt();
            input.nextLine();
            switch (cho) {
                case 1:
                    admin_login();
                    break;
                default:
                    System.out.println("Thanks You :)!");
                    return;
            }
        } while (true);
    }
    
        public static void main(String[] args) {
        try {
            new AdminFileOperation().ReadAdmins(store);
            new ProductFileOperation().ReadItems(store);
            boolean flag = true;
            login();

        } catch (MyException ex) {
            System.err.println("Sorry There is an error in System\n Message: " + ex.getMessage());
        }
    }

}
