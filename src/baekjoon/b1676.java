package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class b1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int answer = 0;
        int[] arr = new int[2];

        for (Integer integer : list) {
            while (integer % 2 == 0) {
                integer /= 2;
                arr[0]++;
            }
            while (integer % 5 == 0) {
                integer /= 5;
                arr[1]++;
            }

        }
        answer = Math.min(arr[0], arr[1]);

        if (n == 0) answer = 0;

        System.out.println(answer);
    }
}
