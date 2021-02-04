package Game;

import java.util.ArrayList;
import java.util.List;
// aaaaa
public class d1 {

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if (candies == null || candies.length == 0)
            return null;

        List<Boolean> res = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] >= max)
                max = candies[i];
        }

        for (int j = 0; j < candies.length; j++) {
            if (candies[j] + extraCandies >= max)
                res.add(true);
            else
                res.add(false);
        }

        return res;
    }

}
