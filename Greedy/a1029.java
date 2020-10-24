package Greedy;

import java.util.Arrays;

/**
 * 两地调度
 */
public class a1029 {

    public int twoCitySchedCost(int[][] costs) {
        // 去 A 城市的费用 - 去 B 城市的费用
        Arrays.sort(costs, (o1, o2) -> o1[0] - o1[1] - (o2[0] - o2[1]));

        int total = 0;
        int n = costs.length / 2;
        for (int i = 0; i < n; i++)
            // 选出 price_A - price_B 最小的 N 个人，让他们飞往 A 市，其余人飞往 B 市
            total += costs[i][0] + costs[i + n][1];

        return total;
    }
}
