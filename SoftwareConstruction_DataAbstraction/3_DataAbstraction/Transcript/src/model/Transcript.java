package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * INVARIANT: course list and grade list are the same size
 * each course has a grade associated, and vice versa, at matching indices
 */
public class Transcript {

    private String studentName;
    private int studentID;
    private List<String> courseName = new ArrayList<>();
    private List<Double> courseGrade = new ArrayList<>();

    public Transcript(String studentName, int studentID) {
        this.studentName = studentName;
        this.studentID = studentID;
    }

    // REQUIRES: the grade should be between 0.0 and 4.0, and/or the course should not be null
    // MODIFIES: this
    public void addGrade(String course, double grade) {
        this.courseName.add(course);
        this.courseGrade.add(grade);
    }

    // This method should return course name and grade in some consistent String format
    // EFFECTS: returns course name and grade in format CourseName: Grade
    public String getCourseAndGrade(String course) {
        for (String c: courseName) {
            if (c.equals(course)) {
                return String.valueOf(c + ": " + courseGrade.get(courseName.indexOf(c)));
            }
        }
        return null;
    }

    // EFFECTS: prints course names with grades earned
    public void printTranscript() {
        for (String course: courseName) {
            System.out.println(course + ": " + courseGrade.get(courseName.indexOf(course)));
        }
    }

    /** Getters **/
    public double getGPA() {
        return calculateAverage(courseGrade);
    }

    public String getStudentName() {
        return this.studentName;
    }

    // REQUIRE: List Of double Item
    // EFFECTS: returns the average of the courses
    public double calculateAverage(List<Double> selectedGrades){
        double totalCoursesGrade = 0;
        int materialCount = 0;
        DecimalFormat d = new DecimalFormat("#.###");
        for (double grade: selectedGrades) {
            totalCoursesGrade += grade;
            materialCount += 1;
        }
        return Double.parseDouble(d.format(totalCoursesGrade / materialCount));
    }


    // EFFECTS: returns the grade for a given course
    public double getGradeByCourse(String course){
        for (String c: courseName) {
            if (c.equals(course)) {
                return courseGrade.get(courseName.indexOf(c));
            }
        }
        return Double.parseDouble(null);
    }

    //TODO: specification
    //
    public double getAverageOverSelectedCourses(List<String> selectedCourses){
        return 0.0;
        //think about which method you can call as a helper!
    }

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
