import java.util.ArrayList;
import java.util.Scanner;

public class Task_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] students = sc.nextLine().trim().split("\\s+");

        ArrayList<Integer> badOdd = new ArrayList<>(1);
        ArrayList<Integer> badEven = new ArrayList<>(1);
        for (int i = 0; i < n; i++) {
            int position = i + 1;
            int height = Integer.parseInt(students[i]);

            if (position % 2 == 0 && height % 2 == 1) badEven.add(position);
            if (position % 2 == 1 && height % 2 == 0) badOdd.add(position);
        }

        if (badOdd.size() == 1 && badEven.size() == 1) {
            int i1 = badOdd.getFirst();
            int i2 = badEven.getFirst();
            if (i1 < i2) {
                System.out.println(i1 + " " + i2);
            } else {
                System.out.println(i2 + " " + i1);
            }
        } else {
            System.out.println("-1 -1");
        }
        sc.close();
    }
}
