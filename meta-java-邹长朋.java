// 本试卷唯一 ID: A39BB3C2BE2686F484D1661619495155, 请勿修改本行内容
/* 注意, 这里不要写包名. 留空 */
/* 这里如果用到其他的类, 记得要引用, 否则编译不过 */
import java.io.IOException;
import java.util.*;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 回答方式: 直接保存或者复制本java文件, 然后在原处作答. 建议重命名成 meta-java-<姓名>.java
 * 选择题改变量赋值的字符串
 * 实现题在原本的函数体里返回正确答案, 注意不要改动函数结构. 用这一个Java文件完成
 * 本卷直接用代码判卷, 没有人工干预. 格式错误, 语法错误, 格式改动会导致试卷无效
 *
 * 注: 一个java文件可以有多个类, 但只能有一个public类. 所以你的实现中可以建内部类, 辅助类. 可以javac编译确认自己语法无误
 * 以下带public static修饰的实现题方法, 不要改变这个签名
 *
 *
 * 这里不要更改默认的类名, 也不要更改修饰符不要加public. 类名保持为 MetaJavaQuestionSheet
 * 可以改文件名, 建议改为 meta-java-<姓名>.java
 */
class MetaJavaQuestionSheet {

    /* qn0:
        只是样例! 不用改动

        A. 别选我

        B. 别选我

        C. 选我, 选我就得分

        D. 也选我, 选我就得分
    */
    public static String qn0 = "CD";
//    /* qn1:
//        下列代码的输出结果不可能是:
        private static volatile int s = 0;
        private static final ThreadPoolExecutor async = new ThreadPoolExecutor(
                0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS, new SynchronousQueue<>());
        public static void main(String[] args) throws InterruptedException {
            for (int i = 0; i < 10000; i++) {
                async.execute(()-> s++);
            }
            Thread.sleep(5000L);
            System.out.println(s);
        }

//        A. 10001
//
//        B. 9999
//
//        C. 10000
//
//        D. 9998
//    */
    public static String qn1 = "A";
    /* qn2:
        下面代码会输出怎样的结果:
        public class A {

            class Inner {
                public String  v1 = "Fake News";
                public String v2 = "Go ahead";
            }

            private static String GetVal() {
                try {
                    return Inner.class.newInstance().v1;
                } catch (Exception e) {
                    try {
                        return Inner.class.getDeclaredConstructor(A.class).newInstance((A)null).v2;
                    } catch (Exception ee) {
                        ee.printStackTrace();
                        return "Fake News, Go ahead";
                    }
                }
            }
            public static void main(String[] args) {

                System.out.println(GetVal());
            }
        }

        A. Fake News, Go ahead

        B. Go ahead

        C. Fake News

        D. 以上都不对
    */
    public static String qn2 = "A";
    /* qn3:
        下面的代码在java(jdk8)最终会产生几个String对象:
        String a = "没人";
        String b = "比我";
        String c = "更懂";
        String d = "java";
        String s = a + b + c + d;

        A. 5

        B. 6

        C. 7

        D. 8
    */
    public static String qn3 = "A";
    /* qn4:
        下面代码会分别输出怎样的结果:
        String s = new String(new char[] {'没','人','比','我','更','懂','j','a','v','a'});
        String si = "没人比我更懂java";
        System.out.println(s == si);
        System.out.println(s.intern() == "没人比我更懂java");
        System.out.println(s == si.intern());

        A. true true true

        B. false true true

        C. true false true

        D. false true false
    */
    public static String qn4 = "B";
    /* qn5:
        若进栈序列为a，b，c，d，e，f，进栈和出栈可以穿插进行，则不可能出现的出栈序列是()

        A. c，b，d，a，f，e

        B. b，d，c，a，e，f

        C. d，c，b，a，e，f

        D. b，c，e，a，f，d
    */
    public static String qn5 = "D";
    /* qn6:
        以下代码编译时哪一行会出错？

        1 package com.metaapp.solution;
        2 public class Solution {
        3     int p1 = 0;
        4     int p2 = 0;
        5     public Solution(int arg){
        6         p1 = arg;
        7     }
        8     public static void main(String args[]){
        9         Solution s1,s2;
       10         int m,n;
       11         m=1;n=2;
       12         s1 = new Solution();
       13         s2 = new Solution(n);
       14     }
       15 }

        A. Line 9

        B. Line 2

        C. Line 12

        D. Line 6
    */
    public static String qn6 = "C";
    /* qn7:
        public class Queue {
          private int size;
          private int[] data;
          private int front, rear;

          public Queue(int size) {
              this.size = size;
              data = new int[size];
              front = 0; rear = 0;
          }
      }
      int MaxSize=10;
      Quene q = new Queue(MaxSize);

      对于q来说，以下能判断队列满的条件是()

        A. q.front == q.rear;

        B. q.front - q.rear == MaxSize;

        C. q.front == (q.rear+1) % MaxSize;

        D. q.front + q.rear == MaxSize;
    */
    public static String qn7 = "C";
    /* qn8:
        method()方法如下，method()如果调用下面5个不同的update()方法，哪些SQL会被回滚 (多选):
        @Service
        public class TestService {
            @Resource
          TestService testService;

          public void method() {
            1. update1();
            ======================
            2. testService.update2();
            ======================
            3. testService.update3();
            ======================
            4. testService.update4();
            ======================
            5. testService.update5();
          }
          @Transactional
          public void update1() {
            //SQL_1
            throw new Exception();
          }
          @Transactional
          public void update2() {
            //SQL_2
            throw new Exception();
          }
          @Transactional
          private void update3() {
            //SQL_3
            throw new Exception();
          }
          @Transactional
          public void update4() {
            //SQL_4
            throw new Error();
          }
          @Transactional
          public void update5() {
            //SQL_5
            throw new IOException();
          }
        }

        A. SQL_2

        B. SQL_4

        C. SQL_5

        D. SQL_3

        E. SQL_1
    */
    public static String qn8 = "ABE";
    /* qn9:
        "没人比我更懂java".toCharArray(), 在java(jdk8)中关于这个字符数组char[], 以下说法正确的是:

        A. 以上说法都不对

        B. 这个字符串在内存中总共占用 10 byte

        C. 这个字符串在内存中总共占用 16 byte

        D. 这个字符串在内存中总共占用 20 byte
    */
    public static String qn9 = "D";
     /*qn10:
        下面代码会分别输出怎样的结果:
          public static void main(String[] args) {
              Thread t = new Thread() {
                  public void run() {
                      cnn();
                  }
              };
              t.run();
              System.out.print("FakeNews ");
          System.out.print("; ");
              t.start();
              System.out.print("FakeNews ");
          }
          static void cnn() {
              System.out.print("CNN ");
          }

        A. CNN FakeNews 和FakeNews CNN 都有可能 ; CNN FakeNews 和FakeNews CNN 都有可能

        B. CNN FakeNews ; CNN FakeNews 和FakeNews CNN 都有可能

        C. CNN FakeNews ; CNN FakeNews

        D. CNN FakeNews 和FakeNews CNN 都有可能 ; CNN FakeNews
    */
    public static String qn10 = "B";
    /* qn11:
        main()方法如下，try中可以捕获两种类型的异常，如果在该方法运行中产生了一个IOException，将会输出怎样的结果:
          public static void main(String[] args) {
              System.out.print(method(0));
          }
          private static Integer method(Integer i){
              try{
                  if(i++ > 0)
                      throw new IOException();
                  return i++;
              }catch (IOException e){
                  i++;
                  return i++;
              }catch (Exception e){
                  i++;
                  return i++;
              }finally {
                  return i++;
              }
          }

        A. 3

        B. 2

        C. 会抛错 没有输出

        D. 4
    */
    public static String qn11 = "B";
    /* qn12:
        已知一个完全二叉树的第6层有3个叶子结点，则整个二叉树的结点数最多有

        A. 122

        B. 121

        C. 34

        D. 45
    */
    public static String qn12 = "C";
    /* qn13:
        一棵二叉树后序遍历的节点顺序是: 6 4 5 2 7 3 1 ，中序遍历是: 6 4 2 5 1 3 7 ，则前序遍历结果为:

        A. 1 2 4 6 5 7 3

        B. 1 2 4 6 5 3 7

        C. 1 2 3 4 5 6 7

        D. 1 2 4 5 6 3 7
    */
    public static String qn13 = "B";
    /* qn14:
        下面代码会分别输出怎样的结果:
          public static void main(String[] args) {
              Map<String, Object> map = new HashMap<>();
              String str = "没人比我更懂java";
              StrObject obj = new StrObject("没人比我更懂java");
              map.put("str", str);
              map.put("obj", obj);

              str = "真的没人比我更懂java";
              System.out.printf(map.get("str").toString()+"; ");

              StrObject new_obj = (StrObject) map.get("obj");
              new_obj.setStr("真的没人比我更懂java");
              System.out.printf(map.get("obj").toString()+"; ");
          }
          static class StrObject{
              String str;
              public StrObject(String str){
                  this.str = str;
              }
              public void setStr(String str){
                  this.str = str;
              }
              @Override
              public String toString() {
                  return str;
              }
          }

        A. 没人比我更懂java; 没人比我更懂java;

        B. 没人比我更懂java; 真的没人比我更懂java;

        C. 真的没人比我更懂java; 没人比我更懂java;

        D. 真的没人比我更懂java; 真的没人比我更懂java;
    */
    public static String qn14 = "A"; // B
    /* qn15:
        下面这段程序当n=10的输出是()
      1 public int calc(int n) {
      2     try {
      3         n+=1;
      4         if(n/0 > 0) {
      5             n+=1;
      6         } else {
      7             n-=10;
      8         }
      9         return n;
      10     } catch(Exception e) {
      11         n++;
      12     }
      13     n++;
      14     return n++;

        A. 抛出异常

        B. 14

        C. 12

        D. 0

        E. 13
    */
    public static String qn15 = "E";

    /*
     * 以下是实现题
     */
    /**
     * <b>注意! 本题不要遍历二维数组. 要求时间复杂度严格低于n^2, 否则视为不得分 </b>
     *
     * 现有一个n*n的二维正整数数组nums，每行元素保证递增，每列元素保证递增，求某正整数x是否存在于该二维数组中，需要尽量优化时间和空间复杂度；
     * @param int[][] nums
     * @param int x 目标数
     * @return boolean
     */
    public static boolean searchMatrix(int[][] nums, int x) {
        // Todo your code goes here...
        if(nums == null || nums.length == 0 || nums[0].length == 0){
            return false;
        }
        int m = nums.length - 1;
        int n = nums[0].length - 1;
        int row = 0;
        int col = n;
        while (row <= m && col >= 0){
            if (nums[row][col] > x){
                col--;
            }
            else if (nums[row][col] < x){
                row++;
            }
            else {
                return true;
            }
        }
        return false;
    }
    /**
     * 对任意一个Map<String, Object>, 其 key 为 String,
     * 其 value 为 Map<String, Object> Object[] Number String 中的任意一种,
     * 显然叶子节点是 value 类型为 Number 或 String的节点,
     * 将 Map 转为多条字符串, 每条字符串表达其中一个叶子节点,
     * 比如:
     * {"a":{"b":["v",2,{"c":0}]},"d":[1,null,3]}
     * 将转化为以下这些字符串
     * a.b[0] = v
     * a.b[1] = 2
     * a.b[2].c = 0
     * d[0] = 1
     * d[1] = null
     * d[2] = 3
     *
     * @param map 上述的 map
     * @return 所有的字符串
     */
    public static Set<String> showMap(Map<String, Object> map) {
        //TODO your code goes here...
        Set<String> res = new HashSet<>();
        for (String str : map.keySet()){
            StringBuilder tmp = new StringBuilder();
            // 当 value 是 String
            if (map.get(str) instanceof String || map.get(str) == null){
                tmp.append(str + " = " + map.get(str));
                res.add(tmp.toString());
            }
            // 当 value 是 Number
            else if (map.get(str) instanceof Number){
                tmp.append(str + " = " + map.get(str));
                res.add(tmp.toString());
            }
            // 当 value 是 Object[]
            else if (map.get(str) instanceof Object[]){
                Object[] obj = (Object[]) map.get(str);
                for (int i = 0; i < obj.length; i++){
                    if (obj[i] instanceof String || obj[i] == null){
                        tmp.append(str + "[" + i + "] = " + (String)obj[i]);
                        res.add(tmp.toString());
                        tmp = new StringBuilder();
                    }
                    else if (obj[i] instanceof Number){
                        tmp.append(str + "[" + i + "] = " + (Number)obj[i]);
                        res.add(tmp.toString());
                        tmp = new StringBuilder();
                    }
                    else if (obj[i] instanceof Object[]){
                        Map<String, Object> map1 = new HashMap<>();
                        map1.put("", obj[i]);
                        Set<String> set1 = new TreeSet<>(showMap(map1));
                        for (String s1 : set1){
                            tmp.append(str + "[" + i + "]." + s1);
                            res.add(tmp.toString());
                            tmp = new StringBuilder();
                        }
                    }
                    else if (obj[i] instanceof Map){
                        Set<String> set3 = showMap((Map<String, Object>) obj[i]);
                        for (String s3 : set3){
                            tmp.append(str + "[" + i + "]." + s3);
                            res.add(tmp.toString());
                            tmp = new StringBuilder();
                        }
                    }
                }
            }
            else if (map.get(str) instanceof Map){
                Set<String> set2 = showMap((Map<String, Object>) map.get(str));
                for (String s1 : set2){
                    tmp.append(str + "." + s1);
                    res.add(tmp.toString());
                    tmp = new StringBuilder();
                }
            }
        }
        return res;
    }
    /**
     * 给定一个二叉树, 检查它是否是镜像对称的
     * 例如以下是镜像对称的
     *      1
     *     / \
     *    2   2
     *   / \ / \
     *  3  4 4  3
     *
     * 下面这个则不是镜像对称的
     *      1
     *     / \
     *    2   2
     *     \   \
     *      3   3
     *
     * TreeNode类的定义:
     *
     * @param TreeNode 一颗二叉树
     * @return boolean 是否是对称的
     */

    // 以下给出TreeNode类, 请勿修改
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static boolean isTreeSymmetric(TreeNode root) {
        //TODO your code goes here...
        if(root == null){
            return true;
        }

        return isSymmetric(root, root);
//        return false;
    }

    public static boolean isSymmetric(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null){
            return true;
        }
        if (root1 == null || root2 == null){
            return false;
        }
        return (root1.val == root2.val) && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }
}