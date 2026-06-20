import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.min;

public class Task_3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("\\s+");
        int countOfWorkers = Integer.parseInt(str[0]);
        int timeLeftingWorkers = Integer.parseInt(str[1]);
        int[] workers = new int[countOfWorkers];
        String[] workerAsStr = br.readLine().split("\\s+");
        for (int i = 0; i < countOfWorkers; i++) {
            workers[i] = Integer.parseInt(workerAsStr[i]);
        }
        int idxLeftingWorkers = Integer.parseInt(br.readLine()) - 1;

        if (workers[idxLeftingWorkers] - workers[0] <= timeLeftingWorkers ||
                workers[workers.length - 1] - workers[idxLeftingWorkers] <= timeLeftingWorkers){
            System.out.println(workers[workers.length - 1] - workers[0]);
        } else {
            int var1 = workers[idxLeftingWorkers] - workers[0];
            int var2 = workers[workers.length - 1] - workers[idxLeftingWorkers];
            System.out.println(workers[workers.length - 1] - workers[0] + min(var1, var2));
        }

    }
}
