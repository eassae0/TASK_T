import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Task_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        String[] numbersAsStr = br.readLine().split(" ");


        ArrayList<Long> benefits = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(numbersAsStr[i]);
            int currentMultiplier = 1;

            while (num > 0) {
                long digit = num % 10;
                if (digit != 9) {
                    benefits.add((9 - digit) * currentMultiplier);
                }
                num /= 10;
                currentMultiplier *= 10;
            }
        }

        benefits.sort(Comparator.reverseOrder());

        long benefit = benefits.stream()
                .mapToLong(Long::longValue)
                .limit(k)
                .sum();

        System.out.println(benefit);
    }
}
