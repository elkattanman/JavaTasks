/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taibahcs;

import java.util.ArrayList;
import java.util.List;
import taibahcs.Model.Course;
import taibahcs.Model.TA;

/**
 *
 * @author elkat
 */
public class TaibahCS {

    /**
     * @param args the command line arguments
     */
    List <Course> c = new ArrayList<>();
    public static void main(String[] args) {
        
        List <Course> al = new ArrayList<>();
        al.add(new Course("bhb", "bkbk", 155));  
        al.add(new Course("bhb", "bkbk", 155));  
        al.add(new Course("bhb", "bkbk", 155));  
        al.add(new Course("bhb", "bkbk", 155));  
        Course t = new Course();
        System.out.println(t);
    }
    
    public void insertCourse()
    {
        c.add(new Course("CS111","Programming1",4));
        c.add(new Course("CS112","Programming2",4));
        c.add(new Course("CS103","Discrete Structures",3));
        c.add(new Course("CS211","Algorithms and Data Structures",4));
        c.add(new Course("CE211","Digital Logic Design",4));
        c.add(new Course("CS281","Introduction to Software Engineering",3));
        c.add(new Course("CE224","Computer Organization and Architecture1",4));
        c.add(new Course("CE332","Computer Networks",4));
        c.add(new Course("CS284","Software Modelling and Analysis",4));
        c.add(new Course("CS301","Theory of Computation",3));
        c.add(new Course("CS323","Operating Systems",4));
        c.add(new Course("CS362","Intelligent Systems",3));
        c.add(new Course("CS372","Database Systems",4));
        c.add(new Course("CS451","Computer Graphics",4));
        c.add(new Course("CS433","Computer Security",4));
        c.add(new Course("CS424","Introduction to Parallel Computing",4));
    }
    
    
}
