package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class b20529 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());

        int[] distance = new int[T];
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            String[] mbti = new String[n];

            for (int j = 0; j < n; j++) {
                mbti[j] = st.nextToken(" ");
            }

            distance[i] = getMinDistance(mbti);
        }

        for (int i : distance) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }

    private static int getMinDistance(String[] mbti) {
        if (mbti.length > 32) return 0;
        else {
            for (int i = 0; i < mbti.length - 1; i++) {
                int cnt = 0;
                for (int j = i + 1; j < mbti.length; j++) {
                    if (mbti[i].equals(mbti[j])) cnt++;
                }

                if (cnt >= 3) {
                    return 0;
                }
            }

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < mbti.length - 2; i++) {
                int dis = Integer.MAX_VALUE;
                for (int j = i + 1; j < mbti.length - 1; j++) {
                    for (int k = j + 1; k < mbti.length; k++) {
                        dis = Math.min(dis, calculateDistance(mbti[i], mbti[j], mbti[k]));
                    }
                }

                min = Math.min(min, dis);
            }

            return min;
        }
    }

    private static int calculateDistance(String s, String s1, String s2) {
        int total = 0;
        for (int i = 0; i < 4; i++) {
            if(s.charAt(i) != s1.charAt(i)) total++;
            if(s1.charAt(i) != s2.charAt(i)) total++;
            if(s.charAt(i) != s2.charAt(i)) total++;
        }


        return total;
    }
}

