package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class b18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> score = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            score.add(Integer.valueOf(br.readLine()));
        }

        int trim = (int) Math.round(n * 0.15);

        Collections.sort(score);

        double sum = 0;

        for (int i = trim; i < score.size() - trim; i++) {
            sum += score.get(i);
        }

        System.out.println((int)Math.round(sum / (n - trim * 2)));
    }
}
