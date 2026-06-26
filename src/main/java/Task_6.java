import java.util.ArrayList;
import java.util.Scanner;

public class Task_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] students = sc.nextLine().trim().split("\\s+");

        ArrayList<Integer> badOdd = new ArrayList<>();
        ArrayList<Integer> badEven = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int position = i + 1;
            int height = Integer.parseInt(students[i]);

            if (position % 2 == 0 && height % 2 == 1) badEven.add(position);
            if (position % 2 == 1 && height % 2 == 0) badOdd.add(position);
        }


        if (badOdd.isEmpty() && badEven.isEmpty()) {
            if (n >= 3) {
                System.out.println("1 3");
            } else System.out.println("-1 -1");

        } else if (badOdd.size() == 1 && badEven.size() == 1) {
            int i1 = badOdd.get(0);
            int i2 = badEven.get(0);
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
