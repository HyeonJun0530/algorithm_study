package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2630 {
    static int[][] color;
    static int blue = 0;
    static int white = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        color = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        colorCheck(0, 0, N);

        StringBuilder sb = new StringBuilder();
        sb.append(white).append("\n").append(blue);

        System.out.println(sb);
    }

    public static void colorCheck(int startX, int startY, int size) {
        int init = color[startX][startY];
        boolean flag = false;

        for (int i = startX; i < startX + size; i++) {
            for (int j = startY; j < startY + size; j++) {
                if (init != color[i][j]) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        if (flag) {
            int newSize = size / 2;
            colorCheck(startX, startY, newSize);
            colorCheck(startX, startY + newSize, newSize);
            colorCheck(startX + newSize, startY, newSize);
            colorCheck(startX + newSize, startY + newSize, newSize);
        } else {
            if (init == 1) {
                blue++;
            } else {
                white++;
            }
        }
    }
}
