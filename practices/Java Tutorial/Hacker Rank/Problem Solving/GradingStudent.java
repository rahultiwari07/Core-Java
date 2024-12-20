import java.util.ArrayList;
import java.util.List;

class StudentGrade{
    public static List<Integer> gradingStudents(int[] grades) {
        List<Integer> roundedGrades = new ArrayList<>();
        for (int grade : grades) {
            if (grade < 38) {
                roundedGrades.add(grade); // No rounding for failing grades
            } else {
                int mathValue = (int) Math.ceil(grade/5);
                int nextMultiple = (int) Math.ceil(grade / 5.0) * 5; // Calculate next multiple of 5
                int difference = nextMultiple - grade; // Distance to the next multiple
                if (difference <= 2) {
                    roundedGrades.add(nextMultiple); // Round up if difference is less than or equal to 2
                } else {
                    roundedGrades.add(grade); // No rounding needed
                }
            }
        }
        return roundedGrades;
    }
}

public class GradingStudent {
    public static void main(String args[]){

        int[] grade = {4,73,67,38,33};
        System.out.println("My Grade => " + StudentGrade.gradingStudents(grade));
    }
}
