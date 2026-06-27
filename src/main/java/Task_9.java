import java.util.Scanner;

import static java.lang.Math.min;

public class Task_9 {
    public static void main(String[] args) {
        final int INF = 1_000_000_000;
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] dp = new int[n + 1][n + 2];

        for (int i = 0; i < dp.length; i++) {
            for (int k = 0; k < dp[0].length; k++) {
                dp[i][k] = INF;
            }
        }

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            int price = sc.nextInt();
            for (int k = 0; k <= n; k++) {
                //// Pay with cash
                if (price > 100) {
                    if (k > 0 && dp[i - 1][k - 1] != INF) {
                        dp[i][k] = min(dp[i][k], dp[i - 1][k - 1] + price);
                    }
                } else {
                    if (dp[i - 1][k] != INF) {
                        dp[i][k] = min(dp[i][k], dp[i - 1][k] + price);
                    }
                }

                //// Use a coupon
                if (dp[i - 1][k + 1] != INF){
                    dp[i][k] = min(dp[i][k], dp[i - 1][k + 1] + 0);
                }
            }
        }

        int minCost = INF;
        for (int k = 0; k <= n; k++) {
            minCost = min(minCost, dp[n][k]);
        }
        System.out.println(minCost);
    }
}
