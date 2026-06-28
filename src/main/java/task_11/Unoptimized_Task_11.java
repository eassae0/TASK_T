package task_11;

import java.util.Scanner;

public class Unoptimized_Task_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        int p = sc.nextInt();

        long summa = 0;
        for (int i = l; i <= r; i++) {
            summa = (summa + Task_11.power(i, p - 2, p)) % p;
        }

        System.out.println(summa);
        sc.close();
    }

}
