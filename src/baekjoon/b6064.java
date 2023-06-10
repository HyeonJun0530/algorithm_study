package baekjoon;

import java.io.*;
import java.util.*;

class b6064 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken(" "));
            int N = Integer.parseInt(st.nextToken(" "));
            int x = Integer.parseInt(st.nextToken(" "));
            int y = Integer.parseInt(st.nextToken());

            int maximum = LCM(N, M);

            while(true) {
                // 해가 최소공배수보다 크면 -1 출력
                if(x > maximum) {
                    System.out.println(-1);
                    break;
                }
                // year를 N으로 나머지 연산을 하면, y의 값을 알 수 있다.
                else if(((x % N) == 0 ? N : x % N) == y){
                    System.out.println(x);
                    break;
                }
                // year는 M만큼 증가하고,
                x += M;
            }
        }


    }

    private static int LCM(int n, int m) {
        return n * m / GCD(n,m);
    }

    public static int GCD(int A, int B) {
        int temp = 0;
        while(B > 0) {
            temp = A % B;
            A = B;
            B = temp;
        }
        return A;
    }

}
