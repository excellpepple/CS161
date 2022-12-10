package willei01.gradebook;

import java.util.Arrays;

public class Student {
    private String name;
    private int[] scores = new int[5];


    public Student(String name, int[] scores) {
        this.name = new String(name);
        for (int i = 0; i < scores.length; i++){
            this.scores[i] = scores[i];
        }
    }

    /**
     * This function returns a copy of the name field.
     *
     * @return A new String object is being returned.
     */
    public String getName() {
        return new String(this.name);
    }
    /**
     * This function takes a string and sets the name variable to a new string that is a copy of the input string.
     *
     * @param name The name of the variable.
     */
    public void setName(String name) {
        this.name = new String(name);
    }
    /**
     * Return a copy of the scores array.
     *
     * @return A copy of the array.
     */
    public int[] getScores() {
        return Arrays.copyOf(this.scores, scores.length);
    }
    /**
     * This function returns the average of the scores in the scores array.
     *
     * @return The average of the scores.
     */
    public double getAverage(){
        double sum = 0;
        for (int i = 0; i < this.scores.length; i++){
            sum += this.scores[i];
        }
        return sum / this.scores.length;
    }
    /**
     * If the average score is greater than or equal to 90, return "A", else if the average score is greater than or equal
     * to 80, return "B", else if the average score is greater than or equal to 70, return "C", else if the average score
     * is greater than or equal to 60, return "D", else return "F"
     *
     * @return The grade of the student.
     */
    public String getGrade(){
        double averageScore = this.getAverage();
        if (averageScore >= 90){
            return "A";
        } else if (averageScore >= 80){
            return "B";
        } else if (averageScore >= 70){
            return "C";
        } else if (averageScore >= 60){
            return "D";
        } else {
            return "F";
        }
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", scores=" + Arrays.toString(scores) +
                ", average=" + this.getAverage() +
                ", grade=" + this.getGrade() +
                '}';
    }
}
