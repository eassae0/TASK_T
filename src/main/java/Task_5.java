import java.util.Scanner;

public class Task_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long left = sc.nextLong();
        long right = sc.nextLong();

        long length = 0;
        int count = 0;
        long num;


        for (int digitCount = 1; digitCount <= 18; digitCount++) {
            length = length * 10 + 1;
            for (int i = 1; i < 10; i++) {
                num = length * i;
                if (left <= num && right >= num) count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
