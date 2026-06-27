import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Task_10 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        double[] x = new double[n];
        double[] y = new double[n];

        double xMin = Double.MAX_VALUE;
        double xMax = -Double.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextDouble();
            y[i] = sc.nextDouble();

            xMin = min(xMin, x[i]);
            xMax = max(xMax, x[i]);
        }

        double totalArea = 0;
        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n;
            totalArea += (x[next] - x[i]) * (y[next] + y[i]) / 2.0;
        }

        double halfArea = Math.abs(totalArea) / 2.0;

        double L = xMin;
        double R = xMax;

        for (int iteration = 0; iteration < 100; iteration++) {
            double x_mid = (L + R) / 2.0;
            double leftArea = 0;

            for (int i = 0; i < n; i++) {
                int next = (i + 1) % n;

                if (x[i] <= x_mid && x[next] <= x_mid) {
                    leftArea += (x[next] - x[i]) * (y[next] + y[i]) / 2.0;

                } else if (x[i] <= x_mid && x[next] > x_mid) {
                    double y_mid = y[i] + (y[next] - y[i]) * (x_mid - x[i]) / (x[next] - x[i]);
                    leftArea +=(x_mid - x[i]) * (y_mid + y[i]) / 2.0;

                } else if (x[i] > x_mid && x[next] <= x_mid) {
                    double y_mid = y[i] + (y[next] - y[i]) * (x_mid - x[i]) / (x[next] - x[i]);
                    leftArea +=(x[next] - x_mid) * (y_mid + y[next]) / 2.0;
                }
            }

            leftArea = Math.abs(leftArea);

            if (leftArea < halfArea) {
                L = x_mid;
            } else {
                R = x_mid;
            }
        }

        System.out.println(L);



    }
}
