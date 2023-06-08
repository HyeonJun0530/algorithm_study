package baekjoon;

import java.io.*;
import java.util.*;

class b11659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken(" "));
        int M = Integer.parseInt(st.nextToken());
        int[] nums = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            nums[i] += nums[i - 1] + Integer.parseInt(st.nextToken(" "));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken(" "));
            int end = Integer.parseInt(st.nextToken());

            int sum = nums[end] - nums[start - 1];

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
