package baekjoon;

import java.io.*;
import java.util.*;

class b5525 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(br.readLine());

        String pattern = "I";

        for (int i = 1; i <= N; i++) {
            pattern += "OI";
        }

        String arr = br.readLine();
        int cnt = 0;

        for (int i = 0; i <= arr.length() - pattern.length(); i++) {
            String check = arr.substring(i, i + pattern.length());
            if (pattern.equals(check)) cnt++;
        }

        System.out.println(cnt);

    }

}
