package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken(" "));
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> poketmonMap = new HashMap<>();
        List<String> poketmonList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            String poket = br.readLine();
            poketmonMap.put(poket, i);
            poketmonList.add(poket);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String problem = br.readLine();

            if (isStringOrNum(problem)) {
                sb.append(poketmonList.get(Integer.parseInt(problem) - 1));
            } else {
                sb.append(poketmonMap.get(problem));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static boolean isStringOrNum(String problem) {
        try {
            Integer.parseInt(problem);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
