package ui;

import model.Transcript;

public class Main {

    public static void main(String[] args) {
        Transcript t1 = new Transcript("Jane Doe", 7830);
        Transcript t2 = new Transcript("Ada Lovelace", 8853);
        Transcript t3 = new Transcript("Mustafa Jamal", 999);

        t1.addGrade("CPSC-210", 3.5);
        t1.addGrade("ENGL-201", 4.0);
        t1.addGrade("CPSC-110", 3.1);

        t3.addGrade("CS", 3.9);

        System.out.print(t1.getStudentName() + ": ");
        t1.printTranscript();

        System.out.println(t1.getGPA());

        t3.setStudentID(101);
        System.out.print(t3.getStudentName() + ": ");
        System.out.println(t3.getGPA());
    }
}
