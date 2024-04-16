package c.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class GradingStudents {

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<>();

        for(int grade : grades) {
            if(grade < 38) {
                result.add(grade);
            } else {
                if(5 - grade % 5 < 3) {
                    result.add(grade + 5 - (grade %5));
                } else {
                    result.add(grade);
                }
            }
        }
        return result ;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(73);
        arr.add(67);
        arr.add(38);
        arr.add(33);

        gradingStudents(arr).forEach(System.out::println);

    }
}
