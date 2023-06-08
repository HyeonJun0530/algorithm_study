package baekjoon;

import java.io.*;
import java.util.*;

class b11339 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            list.add(Integer.valueOf(st.nextToken(" ")));
        }

        Collections.sort(list);

        int sum = 0;
        int ch = 0;
        for (int i = 0; i < list.size(); i++) {
            ch += list.get(i);
            sum += ch;
        }

        System.out.println(sum);
    }
}

