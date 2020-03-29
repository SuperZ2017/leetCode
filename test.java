import data.TreeNode;

import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String m1 = sc.nextLine();
//        int m  =Integer.parseInt(m1);
//        sc.nextLine();
//        String n1 = sc.nextLine();
//        int n = Integer.parseInt(n1);
        //      sc.nextLine();
        int m = sc.nextInt();
        int n = sc.nextInt();
        List<String> list = new ArrayList<>();
        if (sc.hasNext()) {
            list.add(sc.nextLine());
        }
        String a = list.toString();
/**        String a = b.toString();
 String[] mn1 = a.split(" ");
 int[] mn2 = new int[a.length()];
 for(int i = 0; i < a.length(); i++)
 mn2[i] = Integer.parseInt(mn1[i]);
 int[][] mn3 = new int[m][n];
 int k = 0;
 for(int i = 0; i < m; i++){
 for(int j = 0; j < n; j++){
 mn3[i][j] = mn2[k++];
 }
 }

 int dp[][] = new int[m][n];
 dp[0][0] = mn3[0][0];
 for(int i = 1; i < m; i++){
 dp[i][0] = dp[i-1][0]+mn3[i][0];
 }
 for(int j = 1; j < n; j++){
 dp[0][j] = dp[0][j-1]+mn3[0][j];
 }
 for(int i = 1; i < m; i++){
 for(int j = 1; j < n; j++){
 dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]+mn3[i][j]);
 }
 }
 System.out.println(dp[m-1][n-1]); */
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int len = nums.length;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0)
                return Collections.emptyList();

            int cur = nums[i];

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int L = i + 1, R = len - 1;
            while (L < R) {
                int temp = cur + nums[L] + nums[R];
                if (temp == 0) {
                    result.add(Arrays.asList(cur, nums[L], nums[R]));
                    while (L < R && nums[L + 1] == nums[L]) L++;
                    while (L < R && nums[R - 1] == nums[R]) R--;
                } else if (temp > 0) {
                    R--;
                } else {
                    L++;
                }
            }
        }
        return result;
    }

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>(3);
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c))
                stack.add(c);
            else if (!map.containsKey(c))
                stack.push(c);
        }

        if (!stack.isEmpty())
            return false;

        return true;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

}