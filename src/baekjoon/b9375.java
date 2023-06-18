package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class b9375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            int t1 = Integer.parseInt(br.readLine());
            Map<String, Integer> clothing = new HashMap<>();

            for (int j = 0; j < t1; j++) {
                st = new StringTokenizer(br.readLine());
                String value = st.nextToken(" ");
                String key = st.nextToken();
                clothing.put(key, clothing.getOrDefault(key, 0) + 1);
            }

            for (String s : clothing.keySet()) {
                clothing.put(s, clothing.get(s) + 1);
            }

            int cnt = 0;

            for (Integer value : clothing.values()) {
                if(cnt == 0) cnt += value;
                else cnt *= value;
            }
            if(cnt != 0) cnt--;
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

}

