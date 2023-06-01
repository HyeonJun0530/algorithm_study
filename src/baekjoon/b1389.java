package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1389 {
    static int[] chk;
    static int[][] friends;
    static int N;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken(" "));
        int M = Integer.parseInt(st.nextToken(" "));

        chk = new int[N + 1];
        friends = new int[N + 1][N + 1];
        answer = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken(" "));
            int n2 = Integer.parseInt(st.nextToken(" "));
            friends[n1][n2] = 1;
            friends[n2][n1] = 1;
        }

        for (int i = 1; i <= N; i++) {
            answer[i] = BFS(i);
            chk = new int[N + 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            min = Math.min(answer[i], min);
        }
        for (int i = 1; i <= N ; i++) {
            if (answer[i] == min) {
                System.out.println(i);
                break;
            }
        }
    }


    public static int BFS(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        int bacon = 1;
        int ans = 0;
        int size = q.size();
        int cnt = 0;
        while (!q.isEmpty()) {
            cnt++;
            int n = q.poll();
            for (int j = 1; j <= N; j++) {
                if (friends[n][j] == 1 & chk[j] == 0 && i != j) {
                    ans += bacon;
                    chk[j] = 1;
                    q.add(j);
                }
            }
            if (size == cnt) {
                bacon++;
                cnt = 0;
                size = q.size();
            }
        }

        return ans;
    }
}
