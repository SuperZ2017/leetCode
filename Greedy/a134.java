package Greedy;

/**
 * 加油站
 */
public class a134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int j = i;
            int remain = gas[i];
            while (remain - cost[j] >= 0) {
                remain = remain - cost[j] + gas[(j + 1) % n];
                j = (j + 1) % n;
                if (j == i) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int n = gas.length;

        int total_tank = 0;
        int curr_tank = 0;
        int starting_station = 0;
        for (int i = 0; i < n; i++) {
            total_tank += gas[i] - cost[i];
            curr_tank += gas[i] - cost[i];

            if (curr_tank < 0) {
                starting_station = i + 1;
                curr_tank = 0;
            }
         }

        return total_tank >= 0 ? starting_station : -1;
    }
}
