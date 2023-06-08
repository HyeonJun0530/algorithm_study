package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new PriorityQueue<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (queue.isEmpty()) {
                    answer.add(0);
                } else {
                    answer.add(queue.poll());
                }
            } else {
                queue.add(input);
            }
        }

        for (Integer integer : answer) {
            System.out.println(integer);
        }
    }

}
