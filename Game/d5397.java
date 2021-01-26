package Game;

import java.util.LinkedList;
import java.util.List;

//public class d5397 {
//
//    public static List<String> simplifiedFractions(int n) {
//        List<String> res = new LinkedList<>();
//        int fenMu = 0, fenZi = 0;
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                fenMu = i;
//                fenZi = j;
//                if (fenZi >= fenMu)
//                    continue;
//
//                if (fenZi == 1) {
//                    res.add(fenZi + "/" + fenMu);
//                    continue;
//                }
//
//                if (fenMu % fenZi != 0)
//                    res.add(fenZi + "/" + fenMu);
//            }
//        }
//        return res;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(4%2);
//        System.out.println(7%2);
//        List<String> re = simplifiedFractions(5);
//        System.out.println(1);
//    }
//}