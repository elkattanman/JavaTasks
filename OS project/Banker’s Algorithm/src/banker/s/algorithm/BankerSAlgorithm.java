package banker.s.algorithm;

import java.util.Scanner;
import java.util.Vector;

public class BankerSAlgorithm {

    // total number of process 
    static int MAX_P = 20, P;
    // total number of resources 
    static int MAX_R = 10, R;

    // function to check if process 
    // can be allocated or not 
    static boolean is_available(int need[], int available[]) {
        boolean flag = true;
        // check if all the available resources 
        // are less greater than need of process 
        for (int i = 0; i < R; i++) {
            if (need[i] > available[i]) {
                flag = false;
            }
        }
        return flag;
    }

    // Print all the safe-sequences 
    static boolean safe_sequence(boolean marked[], int allocated[][], int max[][],
            int need[][], int available[], Vector<Integer> safe) {
        for (int i = 0; i < P; i++) {
            // check if it is not marked 
            // already and can be allocated 
            if (!marked[i] && is_available(need[i], available)) {
                // mark the process 
                marked[i] = true;
                // increase the available 
                // by deallocating from process i 
                for (int j = 0; j < R; j++) {
                    available[j] += allocated[i][j];
                }
                safe.add(i);
                // find safe sequence by taking process i 
                if(safe_sequence(marked, allocated, max, need, available, safe)) return true;
                safe.removeElementAt(safe.size() - 1);
                // unmark the process 
                marked[i] = false;
                // decrease the available 
                for (int j = 0; j < R; j++) {
                    available[j] -= allocated[i][j];
                }
            }
        }

        // if a safe-sequence is found, display it 
        if (safe.size() == P) {
            return true;
        }
        return false;
    }

    public static Scanner cin = new Scanner(System.in);
    public static int allocated[][] = new int[MAX_P][MAX_R];
    public static int max[][] = new int[MAX_P][MAX_R];
    public static int resources[] = new int[MAX_R];
    public static int[] available = new int[MAX_R];
    public static int[][] need = new int[MAX_P][MAX_R];


    public static void input() {
        System.out.print("Enter Number of Resources :: ");
        R = cin.nextInt();
        String regx = "";
        for (int i = 0; i < R; ++i) {
            regx = regx + "\\d ";
        }
        regx = "\\d - " + regx.trim() + " - " + regx.trim();
        System.out.println("Enter Process information, line by line, in the format shown below,when finish type \"end\" in new line.");
        System.out.println("Pid - allocated - maximum");
        //System.out.println(regx);
        while (true) {
            String s = cin.nextLine();
            if (s.equals("end")) {
                break;
            }
            if (!s.trim().matches(regx)) {
                System.err.println("you must Enter in this Format\n" + regx);
                continue;
            }
            String[] sp = s.split("-");
            Integer.parseInt(sp[0].trim());
            String[] all = sp[1].trim().split("\\s");
            String[] mx = sp[2].trim().split("\\s");
            for (int i = 0; i < all.length; ++i) {
                //System.out.print(all[i]+" ");
                allocated[P][i] = Integer.parseInt(all[i]);
            }

            for (int i = 0; i < all.length; ++i) {
                //System.out.print(mx[i]+" ");
                max[P][i] = Integer.parseInt(mx[i].trim());
            }
            P++;
        }
        System.out.println("Enter Available Resources : ");
        for (int i = 0; i < R; i++) {
            resources[i] = cin.nextInt();
        }
    }

    public static void print() {
        System.out.println("=====================================================================================");
        String Res = "";
        for (int i = 0; i < R; ++i) {
            Res += ("R" + (i + 1) + " ");
        }
        String line4="";
        for (int i = 0; i < R; i++) {
            line4 += String.format("%-2d ", available[i]);
        }
        Res = Res.trim();
        System.out.println("Total number of processes is " + P);
        System.out.println("Total number of resources is " + R);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("      %-20s %-20S %-20S %-20S%n", "Allocated", "Maximum", "Needs", "Available");
        System.out.printf("PID   %-20s %-20S %-20S %-20S%n", Res, Res, Res, Res);
        for (int i = 0; i < P; i++) {
            String line1, line2, line3;
            line1 = line2 = line3 = "";
            for (int j = 0; j < R; j++) {
                line1 += String.format("%-2d ", allocated[i][j]);
            }
            for (int j = 0; j < R; j++) {
                line2 += String.format("%-2d ", max[i][j]);
            }
            for (int j = 0; j < R; j++) {
                line3 += String.format("%-2d ", need[i][j]);
            }
            System.out.printf("%-5d %-20s %-20S %-20S %-20S%n", i + 1, line1, line2, line3, line4);
            line4="";
        }
        System.out.println("=====================================================================================");
    }

    public static void init() {
        for (int i = 0; i < R; i++) {
            int sum = 0;
            for (int j = 0; j < P; j++) {
                sum += allocated[j][i];
            }
            available[i] = resources[i] - sum;
        }

        for (int i = 0; i < P; i++) {
            for (int j = 0; j < R; j++) {
                need[i][j] = max[i][j] - allocated[i][j];
            }
        }
    }

    public static void Solve() {
        System.out.println("=====================================================================================");
        System.out.println("Total number of processes is " + P);
        System.out.println("Total number of resources is " + R);
        System.out.println("--------------------------------------------------------------------------------");
        // safe vector for displaying a safe-sequence 
        Vector<Integer> safe = new Vector<Integer>();

        // marked of size P for marking allocated process 
        boolean[] marked = new boolean[P];
        if(safe_sequence(marked, allocated, max, need, available, safe)){
            System.out.print("The System is in Safe State. Order of execution is ");
            for (int i = 0; i < P; i++){
                System.out.print("P" + (safe.get(i) + 1)); 
                if (i != (P - 1)){ 
                    System.out.print("--> "); 
                }
            }
        }else{
            System.out.println("The System is Not in Safe State.");
        }
        System.out.println("\n=====================================================================================");
    }
    
    public static void Request(){
        System.out.println("=====================================================================================");
        System.out.print("Enter Process ID: ");
        int id=cin.nextInt();
        System.out.print("Enter the request amount of Resources : ");
        int temp[]=new int[R];
        for(int i=0 ; i < R ; ++i){
            temp[i]=cin.nextInt();
            allocated[id-1][i]+=temp[i];
        }
        init();
        for(int i=0 ; i < R ; ++i){
            System.out.println("- R"+(i+1)+" - Available: "+ available[i] + " Need : "+need[id-1][i]);
        }
        System.out.println("=====================================================================================");
        System.out.println("Total number of processes is " + P);
        System.out.println("Total number of resources is " + R);
        System.out.println("--------------------------------------------------------------------------------");
        Vector<Integer> safe = new Vector<Integer>();
        boolean[] marked = new boolean[P];
        if(safe_sequence(marked, allocated, max, need, available, safe)){
            System.out.print("The System is in Safe State. Order of execution is ");
            for (int i = 0; i < P; i++){
                System.out.print("P" + (safe.get(i) + 1)); 
                if (i != (P - 1)){ 
                    System.out.print("--> "); 
                }
            }
        }else{
            System.out.println("The System is Not in Safe State.");
        }
        for(int i=0 ; i < R ; ++i){
            allocated[id-1][i]-=temp[i];
        }
        init();
        System.out.println("\n=====================================================================================");
    }

    public static boolean play(){
        System.out.println("Banker’s ALGORITHM");
        System.out.println("-------------------------");
        System.out.println("1. Display Process Information");
        System.out.println("2. Check System State");
        System.out.println("3. Request Resources and Check System States");
        System.out.println("4. Exit");
        System.out.print("Enter Your Choice : ");
        int ch=cin.nextInt();
        switch(ch){
            case 1:
                print();
                return true;
            case 2:
                Solve();
                return true;
            case 3:
                Request();
                return true;
            default:
                return false;
        }
    }
    public static void main(String[] args) {
        System.out.println("Banker’s ALGORITHM");
        System.out.println("-------------------------");
        input();
        init();
        while(play()){}
        System.out.println("Banker's Algorthim Program is terminating ..........");
    }

}
///input to program
/*
3
1 - 0 1 0 - 7 5 3
2 - 2 0 0 - 3 2 2
3 - 3 0 2 - 9 0 2
4 - 2 1 1 - 2 2 2
5 - 0 0 2 - 4 3 3
end
10 5 7
*/
