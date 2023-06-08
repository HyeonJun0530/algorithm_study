package baekjoon;
import java.io.*;
import java.util.*;

class b2579 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<Integer> scoreList = new ArrayList<>();
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            scoreList.add(Integer.parseInt(br.readLine()));
        }

        dp[0] = scoreList.get(0);

        if (N > 1) dp[1] = scoreList.get(1) + dp[0];
        if (N > 2) dp[2] = Math.max(scoreList.get(0) + scoreList.get(2), scoreList.get(1) + scoreList.get(2));

        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i - 2] + scoreList.get(i), dp[i - 3] + scoreList.get(i - 1) + scoreList.get(i));
        }

        System.out.println(dp[N - 1]);
    }


}

