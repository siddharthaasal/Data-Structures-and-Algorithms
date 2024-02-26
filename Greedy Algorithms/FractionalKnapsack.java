import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int val[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int W = 50;

        double[][] ratio = new double[val.length][2];
        // idx ratio

        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = (double) val[i] / (double) weight[i];
        }

        // sort by val/weight asc order here
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacityLeft = W;
        int profitCollected = 0;
        // loop traverse in descending
        for (int i = val.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacityLeft >= weight[idx]) {
                capacityLeft -= weight[idx];
                profitCollected += val[idx];
            } else {
                profitCollected += (ratio[i][1] * capacityLeft);
                capacityLeft = 0;
                break;
            }
        }
        System.out.println("Maximum profit: " + profitCollected);
    }
}
