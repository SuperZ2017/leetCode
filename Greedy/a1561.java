package Greedy;

import java.util.Arrays;

/**
 * 你可以获得的最大硬币数目
 */
public class a1561 {

    public int maxCoins(int[] piles) {
        int res = 0;
        int len = piles.length;
        Arrays.sort(piles);
        int[] newPiles = Arrays.copyOfRange(piles, len / 3, len);
        for(int i = 0; i < newPiles.length - 1; i += 2){
            res += newPiles[i];
        }
        return res;
    }
}
