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
        if(sc.hasNext()) {
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
}
