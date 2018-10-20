package model;

import exceptions.CourseFullException;
import exceptions.GPATooLowException;
import exceptions.MissingPrereqException;
import exceptions.NoCoursesTakenException;

import java.util.LinkedList;
import java.util.List;

public class Transcript {

    private String name;
    private int year;
    private int id;
    private double gpa;
    private List<Course> currentCourses;
    private List<Course> pastCourses;

    public Transcript(String studentName, int academicYear, int studentID) {
        this.name = studentName;
        this.year = academicYear;
        this.id = studentID;
        currentCourses = new LinkedList<>();
        pastCourses = new LinkedList<>();
    }

    // getters
    public String getName() {
        return name;
    }

    public int getAcademicYear() {
        return year;
    }

    public int getId() {
        return id;
    }

    public List<Course> getCurrentCourses() {
        return currentCourses;
    }

    public List<Course> getPastCourses() {
        // HINT: you may need to consider what kind of information a completed
        // course on a transcript needs to have that the Course class
        // doesn't already contains
        return pastCourses;
    }

    // EFFECTS: computes cGPA
    //          if the list of past courses is empty, throws NoCoursesTakenException
    public double computeGPA() throws NoCoursesTakenException {
        //          HINTS:
        //          use the following formula to convert into a GPA
        //          GPA (4.0 scale) = (total percentage/20) - 1
        //          **Do you need a helper method?**
        if (this.pastCourses.isEmpty()) {
            throw new NoCoursesTakenException("No courses taken, cannot compute GPA");
        } else {
            double totalGradeSum = 0;

            for (Course c: pastCourses) {
                totalGradeSum += c.getGrade();
            }
            return percentToGPA(totalGradeSum / this.pastCourses.size());
        }
    }

    /**
     * helper for computeGPA()
     * @param pcnt GPA percent
     * @return GPA
     */
    private double percentToGPA(double pcnt) {
        return (pcnt / 20) -1;
    }

    // EFFECTS: promotes the student represented by the transcript
    //          to the next academic year if GPA is over 2.6 on a 4.0 scale, and return true
    //          else return false with no change to the year field
    //          if GPA is not over 2.6 on a 4.0 scale, throws GPATooLowException
    //          if no courses have been taken, throws NoCoursesTakenException
    public boolean promoteStudent() throws GPATooLowException, NoCoursesTakenException {
        try {
            double thisGPA = computeGPA();
            if (thisGPA <= 2.6) {
                throw new GPATooLowException("Too low GPA: " + this.getName());
            } else {
                this.year++;
                return true;
            }
        } catch (NoCoursesTakenException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }


    // MODIFIES: this
    // EFFECTS: adds the given course to the list of past courses and returns true,
    //          unless pastCourses contains given course, then does not add and returns false
    public boolean addToPastCourses(Course c) {
        if (!pastCourses.contains(c)) {
            pastCourses.add(c);
            return true;
        }
        return false;
    }

    // MODIFIES: this
    // EFFECTS: adds a course (c) into the record
    //          if the transcript is missing prerequisites, throws a MissingPrereqException
    //          if the course has no space for more students to register, throws a CourseFullException
    public boolean addCourse(Course course) throws MissingPrereqException, CourseFullException {
        // You have to realize that there are a number of cases that your code needs to consider. What if the course
        // you wish to add has no prerequisites? What if the course you want to add is already full?
        // Careful consideration of these cases will lead to code that is correct
        if (this.pastCourses.isEmpty() && !course.getPrereq().isEmpty()) {
            throw new MissingPrereqException("The student does not have the necessary prerequisites.");
        } else if (course.isCourseFull()) {
            throw new CourseFullException("his course is currently full.");
        } else if (course.getPrereq().isEmpty()) {
            currentCourses.add(course);
            course.addStudent();
            return true;
        } else {
            for (Course c: course.getPrereq()) {
                if (!pastCourses.contains(c)) {
                    throw new MissingPrereqException("The student does not have the necessary prerequisites for the " + c.getName() + " course.");
                }
            }
            currentCourses.add(course);
            course.addStudent();
            return true;
        }
    }
}
