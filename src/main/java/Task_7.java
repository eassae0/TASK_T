import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] studAsStr = br.readLine().trim().split("\\s+");
        int[] stud = new int[n];
        for (int i = 0; i < n; i++) stud[i] = Integer.parseInt(studAsStr[i]) - 1;

        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) inDegree[stud[i]]++;

        int lonely = -1;
        int over = -1;

        int errorZero = 0;
        int errorMoreThanTwo = 0;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] > 2) {
                System.out.println("-1 -1");
                return;
            }

            if (inDegree[i] == 0) {
                errorZero++;
                lonely = i;
            }
            if (inDegree[i] == 2) {
                errorMoreThanTwo++;
                over = i;
            }
        }

        if (errorZero != 1 || errorMoreThanTwo != 1) {
            System.out.println("-1 -1");
            return;
        }

        int firstGiver = -1;
        int secondGiver = -1;

        for (int i = 0; i < n; i++) {
            int currentTarget = stud[i];

            if (currentTarget == over) {
                if (firstGiver == -1) {
                    firstGiver = i;
                } else {
                    secondGiver = i;
                    break;
                }
            }
        }

        if (inspector(n, stud, firstGiver, lonely)) {
            System.out.println((firstGiver + 1) + " " + (lonely + 1));
        } else if (inspector(n, stud, secondGiver, lonely)) {
            System.out.println((secondGiver + 1) + " " + (lonely + 1));
        } else System.out.println("-1 -1");
    }

    private static boolean inspector(int n, int[] students, int fakeGiver, int fakeTarget) {
        int current = 0;
        int visitedCount = 0;
        boolean[] visited = new boolean[n];
        int originalTarget = students[fakeGiver];
        students[fakeGiver] = fakeTarget; // experimental mutation

        while (!visited[current]) {
            visited[current] = true;
            visitedCount++;

            current = students[current];
        }

        students[fakeGiver] = originalTarget;
        return current == 0 && visitedCount == n;
    }
}

