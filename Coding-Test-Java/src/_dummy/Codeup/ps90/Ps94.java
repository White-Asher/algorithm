package _dummy.Codeup.ps90;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ps94 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        List<Integer> student = new ArrayList<>();

        for (int i = 0; i<num; i++){
            int tempStu = sc.nextInt();
            student.add(tempStu);
        }

        Collections.reverse(student);
        for (Integer students : student) {
            System.out.printf("%d ",students);
        }
    }
}
