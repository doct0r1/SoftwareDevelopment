package model;

public class Transcript {

    private String studentName;
    private int studentID;

    public Transcript(String studentName, int studentID) {
        this.studentName = studentName;
        this.studentID = studentID;
    }

    // REQUIRES: the grade should be between 0.0 and 4.0, and/or the course should not be null
    // MODIFIES: this
    public void addGrade(String course, double grade) { }

    // This method should return course name and grade in some consistent String format
    // EFFECTS: returns course name and grade in format CourseName: Grade
    public String getCourseAndGrade(String course) { return null; }

    // EFFECTS: prints course names with grades earned
    public void printTranscript() { }

    /** Getters **/
    public double getGPA() { return 0.0; }

    public String getStudentName() { return "Student Name"; }

    /** Setters **/
    // MODIFIES: this
    // EFFECTS: change the existing student name with the new name
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    // MODIFIES: this
    // EFFECTS: change the existing student ID with the new ID
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
}
