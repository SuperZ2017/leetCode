package Company;

import java.util.Arrays;
import java.util.Scanner;

// https://www.nowcoder.com/question/next?pid=16516564&qid=362293&tid=32280013

public class b1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] coins = {1, 4, 16, 64};
        while (sc.hasNext()) {
            int N = 1024 - sc.nextInt();
            int[] dp = new int[N + 1];
            //PS：为啥 dp 数组初始化为 N + 1 呢，
            // 因为凑成 N 金额的硬币数最多只可能等于 N（全用 1 元面值的硬币），
            // 所以初始化为 N + 1 就相当于初始化为正无穷，便于后续取最小值。
            Arrays.fill(dp, N + 1);
            dp[0] = 0;
            for (int i = 1; i <= N; i++) {
                for (int coin : coins)
                    if (i - coin < 0)
                        continue;
                    else
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }

            System.out.println(dp[N]);
        }
    }
}
