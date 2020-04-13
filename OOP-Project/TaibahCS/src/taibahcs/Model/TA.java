/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taibahcs.Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elkat
 */
public class TA extends FacultyMember{
    private int maxNumOfCourses;
    private int quotaOfCreditHours;
    private List<Course> assignedCourses;

    
    
    public TA() {
        super.setAcademicRank("TA");
        assignedCourses=new ArrayList<>();         //to avoid nullPointerException
    }

    public TA(String facultyID, String firstName, String lastName, String academicSpecialization, int maxNumOfCourses, int quotaOfCreditHours, List<Course> assignedCourses) {
        super(facultyID, firstName, lastName, "TA", academicSpecialization);
        this.maxNumOfCourses = maxNumOfCourses;
        this.quotaOfCreditHours = quotaOfCreditHours;
        this.assignedCourses = assignedCourses;
    }

    
    public TA(int maxNumOfCourses, int quotaOfCreditHours, List<Course> assignedCourses) {
        super.setAcademicRank("TA");
        this.maxNumOfCourses = maxNumOfCourses;
        this.quotaOfCreditHours = quotaOfCreditHours;
        this.assignedCourses = assignedCourses;
    }
    
    
    @Override
    public void setFacultyID(String facultyID) {
        super.setFacultyID(facultyID);  
    }

    @Override
    public String getFacultyID() {
        return super.getFacultyID();  
    }


    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);  
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();  
    }


    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);  
    }

    @Override
    public String getLastName() {
        return super.getLastName();  
    }

    @Override
    public void setAcademicRank(String academicRank) {
        super.setAcademicRank(academicRank);  
    }

    @Override
    public String getAcademicRank() {
        return super.getAcademicRank();  
    }
    
    @Override
    public void setAcademicSpecialization(String academicSpecialization) {
        super.setAcademicSpecialization(academicSpecialization);  
    }

    @Override
    public String getAcademicSpecialization() {
        return super.getAcademicSpecialization();  
    }
    
    public int getMaxNumOfCourses() {
        return maxNumOfCourses;
    }

    public void setMaxNumOfCourses(int maxNumOfCourses) {
        this.maxNumOfCourses = maxNumOfCourses;
    }

    public int getQuotaOfCreditHours() {
        return quotaOfCreditHours;
    }

    public void setQuotaOfCreditHours(int quotaOfCreditHours) {
        this.quotaOfCreditHours = quotaOfCreditHours;
    }

    public List<Course> getAssignedCourses() {
        return assignedCourses;
    }

    public void setAssignedCourses(List<Course> assignedCourses) {
        this.assignedCourses = assignedCourses;
    }

    public boolean addCourse(Course e) {
        return assignedCourses.add(e);
    }

    public Course getCourse(int index) {//what????
        return assignedCourses.get(index);
    }

    public boolean removeCourse(Object o) {
        return assignedCourses.remove(o);
    }

    public Course removeCourse(int index) {
        return assignedCourses.remove(index);
    }

    
    @Override
    public String toString() {
        return "TA{" + "FacultyID=" + getFacultyID()+", FirstName=" + getFirstName() 
                + ", LastName=" + getLastName()+ ", AcademicRank=" + getAcademicRank() 
                + ", AcademicSpecialization=" + getAcademicSpecialization()
                + ", maxNumOfCourses=" + maxNumOfCourses+ ", quotaOfCreditHours=" 
                + quotaOfCreditHours + ", assignedCourses=" + assignedCourses + '}';
    }

}
