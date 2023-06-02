package baekjoon;

import java.io.*;
import java.util.*;


class b1463 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken(" "));
        dp = new int[N + 1];

        if(N > 3) {
            dp[1] = 0;
            dp[2] = 1;
            dp[3] = 1;
            for (int i = 4; i <= N; i++) {
                dp[i] = dp[i - 1] + 1;
                if (i % 3 == 0) {
                    dp[i] = Math.min(dp[i], dp[i / 3] + 1);
                }
                if (i % 2 == 0) {
                    dp[i] = Math.min(dp[i], dp[i / 2] + 1);
                }
            }
            System.out.println(dp[N]);
        } else {
            if(N == 1) System.out.println(0);
            else System.out.println(1);
        }
    }

}

