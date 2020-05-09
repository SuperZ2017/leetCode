import data.TreeNode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {

    }

    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return myPow(x, -n);

        double t = myPow(x, n >> 1);
        t *= t;

        if (n % 2 == 1)
            t *= x;

        return t;
    }

}

