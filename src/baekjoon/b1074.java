package baekjoon;
import java.io.*;
import java.util.*;

public class b1074 {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, N);
        recursive(r, c, size);
        System.out.println(count);
    }

    public static void recursive(int r, int c, int size) {
        if (size == 1) {
            return;
        } else if (r < size / 2 && c < size / 2) {
            recursive(r, c, size / 2);
        } else if (r < size / 2 && c >= size / 2) {
            count += size * size / 4;
            recursive(r, c - size / 2, size / 2);
        } else if (r >= size / 2 && c < size / 2) {
            count += size * size / 2;
            recursive(r - size / 2, c, size / 2);
        } else {
            count += size * size / 4 * 3;
            recursive(r - size / 2, c - size / 2, size / 2);
        }
    }
}
