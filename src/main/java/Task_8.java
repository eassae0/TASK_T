import java.util.Locale;
import java.util.Scanner;

public class Task_8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        if (!sc.hasNextDouble()) {
            return;
        }

        double X = sc.nextDouble();
        double Y = sc.nextDouble();

        double x1 = sc.nextDouble(); // (0, 0)
        double y1 = sc.nextDouble();

        double x2 = sc.nextDouble(); // (X, 0)
        double y2 = sc.nextDouble();

        double x3 = sc.nextDouble(); // (X, Y)
        double y3 = sc.nextDouble();

        double x4 = sc.nextDouble(); // (0, Y)
        double y4 = sc.nextDouble();

        double c = x1;
        double f = y1;

        double a = (x2 - x1)/X;
        double d = (y2 - y1)/X;

        double b = (x4 - x1)/Y;
        double e = (y4 - y1)/Y;

        double D = a * e - b * d;

        double Dx = (-c) * e - b * (-f);
        double Dy = a * (-f) - (-c) * d;

        double x = Dx / D;
        double y = Dy / D;

        System.out.printf(Locale.US, "%.5f %.5f\n", x, y);


        sc.close();

    }
}
