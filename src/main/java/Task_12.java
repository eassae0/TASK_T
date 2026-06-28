import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Task_12 {

    record Node(int remainder, long sum) {
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long maxSum = sc.nextLong();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int m = Math.min(A, Math.min(B, C));

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingLong(Node::sum));
        queue.add(new Node(1 % m, 1));

        long[] dist = new long[m];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1 % m] = 1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.sum > dist[node.remainder]) continue;

            long sum = (node.sum + A);
            int rem = (int) (sum % m);
            if (sum < dist[rem] && sum <= maxSum) {
                dist[rem] = sum;
                queue.add(new Node(rem, sum));
            }

            sum = (node.sum + B);
            rem = (int) (sum % m);
            if (sum < dist[rem] && sum <= maxSum) {
                dist[rem] = sum;
                queue.add(new Node(rem, sum));
            }

            sum = (node.sum + C);
            rem = (int) (sum % m);
            if (sum < dist[rem] && sum <= maxSum) {
                dist[rem] = sum;
                queue.add(new Node(rem, sum));
            }
        }

        long result = 0;
        for (Long d : dist) {
            if (d <= maxSum) {
                result += ((maxSum - d) / m) + 1;
            }
        }
        System.out.println(result);
    }
}
