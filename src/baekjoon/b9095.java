package baekjoon;

import java.io.*;
import java.util.*;

class b9095 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            sb.append(Dp(list.get(i))).append("\n");
        }


        System.out.println(sb);

    }

    public static int Dp(int num) {
        dp = new int[num + 1];

        dp[1] = 1;
        if(num > 1) dp[2] = 2;
        if(num > 2) dp[3] = 4;

        for (int i = 4; i <= num; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        return dp[num];
    }
}
