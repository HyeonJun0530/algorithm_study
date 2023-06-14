package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class b7662 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                String oper = st.nextToken(" ");
                int num = Integer.parseInt(st.nextToken());
                if(oper.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
                else if (oper.equals("D")) {
                    if(map.size() > 0) {
                        if (num == 1) {
                            Integer max = map.lastKey();
                            Integer cnt = map.get(max);
                            if(cnt == 1) map.remove(max);
                            else map.put(max, cnt - 1);
                        } else {
                            Integer min = map.firstKey();
                            Integer cnt = map.get(min);
                            if(cnt == 1) map.remove(min);
                            else map.put(min, cnt - 1);
                        }
                    }
                }
            }

            if(map.size() > 0) sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            else sb.append("EMPTY").append("\n");

        }

        System.out.println(sb);
    }

}

