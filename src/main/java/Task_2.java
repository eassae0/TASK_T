import java.util.Scanner;

import static java.lang.Math.pow;

public class Task_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        int cuts = 0;

        while (pow(2, cuts) < n) {
            cuts++;
        }

        System.out.println(cuts);


    }
}
