package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class b9461 {

    static long[] PN = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        PN[1] = 1L;
        PN[2] = 1L;
        PN[3] = 1L;
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            for (int j = 4; j <= N; j++) {
                PN[j] = PN[j - 2] + PN[j - 3];
            }
            sb.append(PN[N]).append("\n");
        }

        System.out.println(sb);
    }

}

