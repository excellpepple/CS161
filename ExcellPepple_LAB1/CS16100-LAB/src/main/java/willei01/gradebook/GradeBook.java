package willei01.gradebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class GradeBook {
    public static void main(String[] args) throws FileNotFoundException {
        File gradebookFile = new File("grade_data.txt");
        Scanner scanner = new Scanner(gradebookFile);
        PrintWriter writer = new PrintWriter("gradebook.txt");
        String header = "Student\t\tTest1\tTest2\tTest3\tTest4\tTest5\tAverage\tGrade\n";
        ArrayList<Double> studentAverages = new ArrayList<Double>();
        double classAverage = 0;
        writer.print(header);
        while (scanner.hasNextLine()) {
            int numberOfStudents = scanner.nextInt();
            for (int i = 0; i < numberOfStudents; i++) {
                String studentName = scanner.next();
                int[] studentScores = new int[5];
                for (int j = 0; j < studentScores.length; j++) {
                    studentScores[j] = scanner.nextInt();
                }
                Student student = new Student(studentName, studentScores);
                writer.print(student.getName() + "\t\t");
                for (int score = 0; score < student.getScores().length; score++) {
                    writer.print(student.getScores()[score]+ "\t\t");
                }
                writer.print(student.getAverage() + "\t");
                studentAverages.add(student.getAverage());
                writer.print(student.getGrade() + "\t");
                writer.println();


            }
        }
        for (int average = 0; average < studentAverages.size(); average++) {
            classAverage += studentAverages.get(average);
        }
        classAverage /= studentAverages.size();
        writer.println("Class Average = " + classAverage);
        scanner.close();
        writer.close();
    }

}
