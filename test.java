import data.TreeNode;

import java.util.*;

public class test {
    public static void main(String[] args) {
        char a = 'a';
        int c = a;
        System.out.println(c);
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


//    public int movingCount(int m, int n, int k) {
//        boolean[][] visited = new boolean[m][n];
//        return dfs(0, 0, k, m, n, visited);
//    }
//
//    private int dfs(int i, int j, int k, int m, int n, boolean[][] visited) {
//        int count = 0;
//        if (i < m && j < n && visited[i][j] && valid(i, j, k))
//            count += 1 + dfs(i + 1, j, k, m, n, visited) + dfs(i - 1, j, k, m, n, visited)
//                    + dfs(i, j + 1, k, m, n, visited) + dfs(i , j -1 , k, m, n, visited);
//
//        return count;
//
//    }
//
//
//    public int movingCount1(int m, int n, int k) {
//        boolean[][] visited = new boolean[m][n];
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[]{0, 0});
//        int res = 0;
//        while (!queue.isEmpty()) {
//            int[] x = queue.poll();
//            int i = x[0];
//            int j = x[1];
//            if (i > m || i < 0 || j > n || j < 0 || visited || !valid(i, j, k))
//                continue;
//            visited[i][j] = true;
//            queue.add(i + 1, j);
//        }


    }