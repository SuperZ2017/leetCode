import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        if (n <=0 || n >= 1000)
//            return;
//        double prob = n / 100.0;
//        if (n >= 100)
//            System.out.println("1.000000");
//        else {
//            String s = String.valueOf(prob);
//            if (s.length() == 3)
//                System.out.println(s+"00000");
//            else if (s.length() == 4)
//                System.out.println(s+"0000");
//        }
//
//    }

//    public static void main(String[] args) {
//        final Object lock = new Object();
//        String[] num = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
//        char[] alpha = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
//
//
//        new Thread(() -> {
//            synchronized (lock) {
//                for (String n : num) {
//                    System.out.print(n);
//                    try {
//                        lock.notify();
//                        lock.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                lock.notify();
//            }
//        }, "t1").start();
//
//        new Thread(() -> {
//            synchronized (lock) {
//                for (char a : alpha) {
//                    System.out.print(a);
//                    try {
//                        lock.notify();
//                        lock.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                lock.notify();
//            }
//        }, "t2").start();
//    }

    public static void main(String[] args) {
        String oldPath = "/home/copydir";
        String newPath = "/usr";
        copyFolder(oldPath, newPath);
    }

    public static void copyFolder(String oldPath, String newPath) {

        try {
            (new File(newPath)).mkdirs();
            File a = new File(oldPath);
            String[] file = a.list();
            File temp = null;
            for (int i = 0; i < file.length; i++) {
                if (oldPath.endsWith(File.separator)) {
                    temp = new File(oldPath + file[i]);
                } else {
                    temp = new File(oldPath + File.separator + file[i]);
                }

                if (temp.isFile()) {
                    FileInputStream input = new FileInputStream(temp);
                    FileOutputStream output = new FileOutputStream(newPath + "/" +
                            (temp.getName()).toString());
                    byte[] b = new byte[1024 * 5];
                    int len;
                    while ((len = input.read(b)) != -1) {
                        output.write(b, 0, len);
                    }
                    output.flush();
                    output.close();
                    input.close();
                }
                if (temp.isDirectory()) {
                    copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
                }
            }
        } catch (Exception e) {
            System.out.println("操作出错");
            e.printStackTrace();

        }
    }
}

