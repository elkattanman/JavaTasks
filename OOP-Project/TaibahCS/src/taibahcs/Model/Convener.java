package taibahcs.Model;

import java.util.ArrayList;
import java.util.List;

public class Convener extends FacultyMember {

    private List<Course> courses;

    private List<FacultyMember> members;//differnce

    public Convener() {
        super.setAcademicRank("Assistant Professor");
        courses = new ArrayList<>();  //to avoid nullPointerException
        members = new ArrayList<>(); //to avoid nullPointerException
    }

    public Convener(List<Course> courses, List<FacultyMember> members) {
        super.setAcademicRank("Assistant Professor");
        this.courses = courses;
        this.members = members;
    }

    public Convener(String facultyID, String firstName, String lastName, String academicRank, String academicSpecialization, List<Course> courses, List<FacultyMember> members) {
        super(facultyID, firstName, lastName, academicRank, academicSpecialization);
        this.courses = courses;
        this.members = members;
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

    public List<FacultyMember> getMembers() {
        return members;
    }

    public void setMembers(List<FacultyMember> members) {
        this.members = members;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public boolean addCourse(Course e) {
        return courses.add(e);
    }

    public Course getCourse(int index) {
        return courses.get(index);
    }

    public boolean addFacultyMember(FacultyMember e) {
        return members.add(e);
    }

    public FacultyMember getFacultyMember(int index) {
        return members.get(index);
    }

    @Override
    public String toString() {
        return "Convener{" +"FacultyID=" + getFacultyID()+", FirstName=" + getFirstName() 
                + ", LastName=" + getLastName()+ ", AcademicRank=" + getAcademicRank() 
                + ", AcademicSpecialization=" + getAcademicSpecialization()
                + "courses=" + courses + ", members=" + members + '}';
    }

}
