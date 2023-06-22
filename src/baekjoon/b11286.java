package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class b11286 {

    static class MyComparable implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            if(Math.abs(o1) == Math.abs(o2)) return o1 - o2;
            return Math.abs(o1) - Math.abs(o2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new PriorityQueue<>(new MyComparable());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x == 0) {
                if(queue.isEmpty()) sb.append(0).append("\n");
                else sb.append(queue.poll()).append("\n");
            } else {
                queue.add(x);
            }
        }

        System.out.println(sb);
    }

}
