package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class b11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken(" "));
        int K = Integer.parseInt(st.nextToken(" "));

        int[] coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            while (true) {
                if(K - coins[i] >= 0) {
                    K -= coins[i];
                    cnt++;
                } else {
                    break;
                }
            }

            if(K == 0) break;
        }

        System.out.println(cnt);
    }

}
