package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class b1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken(" "));
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> people = new HashMap<>();

        for (int i = 0; i < N; i++) {
            people.put(br.readLine(), 1);
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            people.put(name, people.getOrDefault(name, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (String s : people.keySet().stream().sorted().collect(Collectors.toList())) {
            if(people.get(s) == 2) {
                cnt++;
                sb.append(s).append("\n");
            }
        }
        System.out.println(cnt);
        System.out.println(sb);
    }
}
