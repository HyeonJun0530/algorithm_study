package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class b16953 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Long A = Long.parseLong(st.nextToken(" "));
        Long B = Long.parseLong(st.nextToken());



        Queue<Long> queue = new LinkedList<>();
        queue.add(A);
        int L = 1;
        boolean flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Long num = queue.poll();

                if(num * 2 <= B && !queue.contains(num * 2)) {
                    queue.add(num * 2);
                }

                String numStr = num + "1";
                Long num2 = Long.parseLong(numStr);

                if(num2 <= B && !queue.contains(num2)) {
                    queue.add(num2);
                }

                if(num * 2 == B || num2.equals(B)) {
                    flag = true;
                    break;
                }
            }
            L++;

            if(flag) {
                break;
            }
        }

        if(!flag) System.out.println(-1);
        else {
            System.out.println(L);
        }
    }


}
