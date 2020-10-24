import data.ListNode;
import data.TreeNode;

import java.util.*;

public class test {

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> needs = new HashMap<>();
        for (Character c : s2.toCharArray())
            needs.merge(c, 1, (p, o) -> p + o);

        int L = 0, R = 0;
        int match = 0;

        while (R < s1.length()) {
            char c1 = s1.charAt(R);
            if (needs.containsKey(c1)) {
                window.merge(c1, 1, (p, o) -> p + o);
                if (window.get(c1) == needs.get(c1))
                    match++;
            }

            R++;

            while (R - L < s1.length()) {
                if (match == needs.size())
                    return true;

                char c2 = s1.charAt(L);
                if (needs.containsKey(c2)) {
                    window.put(c2, window.get(c2) - 1);
                    if (needs.get(c2) > window.get(c2))
                        match--;
                }

                L++;
            }
        }

        return false;
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];

        for (int i = 2*n-1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() < nums[i%n])
                stack.pop();

            res[i%n] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(nums[i%n]);

        }

        return res;
    }


    public String convert(String s, int numRows) {
        List<StringBuilder> list = new ArrayList<>();
        int i = 0, flag = -1;

        for (char c : s.toCharArray()) {
            list.get(i).append(c);
            if (i == 0 || i == numRows - 1)
                flag = -flag;
            i += flag;
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder s1 : list)
            sb.append(s1);

        return sb.toString();
    }



    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {

            int L = i + 1, R = nums.length - 1;
            sum = nums[i] + nums[L] + nums[R];
            if (Math.abs(target - sum) < Math.abs(target - ans))
                ans = sum;

            if (sum > target)
                R--;
            else if (sum < target)
                L++;
            else
                return ans;

        }

        return ans;
    }

    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new LinkedList<>();
        gen(n, n, "");
        return res;
    }

    void gen(int left, int right, String str) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }

        if (left > 0)
            gen(left-1, right, str + "(");

        if (right > 0)
            gen(left, right-1, str + ")");
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            if (idx == -1 || interval[0] > res[idx][1])
                res[++idx] = interval;
            else
                res[idx][1] = Math.max(res[idx][1], interval[1]);
        }

        return Arrays.copyOf(res, idx + 1);
    }


    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;

        while (p.next != null && p.next.next != null) {

            if (p.next.val == p.next.next.val) {
                ListNode tmp = p.next;
                while (tmp != null && tmp.next != null && tmp.val == tmp.next.val)
                    tmp = tmp.next;
                p.next = tmp.next;
            } else {
                p.next = p.next;
            }
        }

        return dummy.next;
    }

    public ListNode deleteDuplicates_1(ListNode head) {
        ListNode cur = head;

        while (cur != null && cur.next != null) {

            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else
                cur = cur.next;
        }

        return head;
    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.val == 0 && root.left == null && root.right == null)
            return null;
        return root;
    }

    String[] chars = {"","", "abc", "def", "ghi", "jkl", ",mno", "pqrs", "tuv", "wxyz"};
    List<String> res1;
    public List<String> letterCombinations(String digits) {
        res1 = new LinkedList<>();

        findCombination(digits, 0, "");
        return res;
    }

    private void findCombination(String digits, int idx, String s) {
        if (idx == digits.length()) {
            res1.add(s);
            return;
        }

        Character c = digits.charAt(idx);
        String letters = chars[c - '0'];
        for (int i = 0; i < letters.length(); i++)
            findCombination(digits, idx + 1, s + letters.charAt(i));
        return;
    }

    public static void main(String[] args) {
        char c = '2';

//        char d = String.valueOf(c).toLowerCase().charAt(0);
        System.out.println(Character.isLetter(c));
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start > end)
            return;
        int temp, t, l, r;
        l = start;
        r = end;
        temp = nums[start];

        while (l < r) {
            while (l < r && nums[r] < temp)
                r--;
            while (l < r && nums[l] > temp)
                l++;
            t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
        }

        nums[start] = nums[l];
        nums[l] = temp;
        quickSort(nums, start, l - 1);
        quickSort(nums, l + 1, end);
    }
}

