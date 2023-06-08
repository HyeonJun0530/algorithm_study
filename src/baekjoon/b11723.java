package baekjoon;

import java.io.*;
import java.util.*;

class b11723 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken(" "));
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken(" ");
            int num = 0;
            if(st.hasMoreTokens()) num = Integer.parseInt(st.nextToken());

            if (str.contains("add")) {
                map.put(num, 1);
            } else if (str.contains("remove")) {
                if (map.getOrDefault(num, 0) == 1) {
                    map.remove(num);
                }
            } else if (str.contains("check")) {
                if(map.getOrDefault(num, 0) == 1) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (str.contains("toggle")) {
                if(map.getOrDefault(num, 0) == 1) {
                    map.remove(num);
                } else {
                    map.put(num, 1);
                }
            } else if (str.contains("all")) {
                for (int j = 1; j <= 20; j++) {
                    map.put(j, 1);
                }

            } else {
                map.clear();
            }
        }

        System.out.println(sb);
    }
}
