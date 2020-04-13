package taibahcs.Model;

public class FacultyMember {
    private String facultyID;
    private String firstName; 
    private String lastName; 
    private String academicRank; 
    private String academicSpecialization;

    public FacultyMember() {} //Constructor no-args

    public FacultyMember(String facultyID, String firstName, String lastName, String academicRank, String academicSpecialization) {
        this.facultyID = facultyID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.academicRank = academicRank;
        this.academicSpecialization = academicSpecialization;
    }

    public String getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(String facultyID) {
        this.facultyID = facultyID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAcademicRank() {
        return academicRank;
    }

    public void setAcademicRank(String academicRank) {
        this.academicRank = academicRank;
    }

    public String getAcademicSpecialization() {
        return academicSpecialization;
    }

    public void setAcademicSpecialization(String academicSpecialization) {
        this.academicSpecialization = academicSpecialization;
    }

    @Override//why?????
    public String toString() {
        return "FacultyMember{" + "facultyID=" + facultyID + ", firstName=" + firstName + ", lastName=" + lastName + ", academicRank=" + academicRank + ", academicSpecialization=" + academicSpecialization + '}';
    }
    
    
    
    
}
