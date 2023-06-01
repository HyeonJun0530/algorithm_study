package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class b1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] button = new boolean[10];
        if(M != 0) {
            List<Integer> arr = new ArrayList<>();
            String[] readLine = br.readLine().split(" ");
            for (int i = 0; i < M; i++) {
                arr.add(Integer.parseInt(readLine[i]));
            }

            for (int i = 0; i < arr.size(); i++) {
                button[arr.get(i)] = true;
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= 999999; i++) {
            char[] ch = String.valueOf(i).toCharArray();
            int count = 0;
            boolean chk = true;
            for (int j = 0; j < ch.length; j++) {
                if(button[Character.getNumericValue(ch[j])]) {
                    chk = false;
                    break;
                }
            }

            if(i == 100) {
                chk = true;
            }

            if(chk == true) {
                if(i != 100) {
                    count = Math.abs(N - i) + ch.length;
                } else {
                    count = Math.abs(N - i);
                }
                min = Math.min(min, count);
            }

        }

        System.out.println(min);
    }
}
