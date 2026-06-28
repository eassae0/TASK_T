package task_11;

import java.util.Arrays;
import java.util.Scanner;

public class Task_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        int p = sc.nextInt();

        long[] P = new long[r - l + 1];
        Arrays.fill(P, 1);
        P[0] = l;

        for (int i = 1; i < P.length; i++) {
            P[i] = (P[i - 1] * (l + i)) % p;
        }

        long inv = power(P[P.length - 1], p - 2, p);
        long summa = 0;

        for (int i = P.length - 1; i > 0; i--) {
            long currentNumber = l + i;
            summa = (summa + (inv * P[i - 1]) % p) % p;
            inv = (inv * currentNumber) % p;
        }

        summa = (summa + inv) % p;
        System.out.println(summa);


    }

    static long power(long base, long exp, long mod) {
        long res = 1;
        base = base % mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}
