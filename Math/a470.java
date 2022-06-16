package Math;


/**
 * 用 rand7() 实现 rand10()
 */
public class a470 {

    // TODO review
//    public int rand10() {
//        return (rand7() + rand7() + rand7() + rand7() + rand7() + rand7() + rand7() + rand7() + rand7() + rand7()) % 10 ;
//    }

/*

    // 首先 rand7() - 1 得到的数的集合为 {0, 1, 2, 3, 4, 5, 6}

    // 再乘 7 后得到的集合 A 为 {0，7，14，21，28，35，42}

    // 后面 rand7() 得到的集合 B 为 {1, 2, 3, 4, 5, 6, 7 }

    public int rand10() {
        // 首先得到一个数
        int num = (rand7() - 1) * 7 + rand7();
        // 只要它还大于 10，那就给我不断生成，因为我只要范围在 1-10 的，最后直接返回就可以了
        while (num > 10){
            num = (rand7() - 1) * 7 + rand7();
        }
        return num;
    }
    */


}
