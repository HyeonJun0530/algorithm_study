package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b1260 {
    static int[] chk;
    static int N;
    static int M;
    static List<Integer> dfsList = new ArrayList<>();
    static List<Integer> bfsList = new ArrayList<>();
    static Queue<Integer> bfsQ = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken(" "));
        M = Integer.parseInt(st.nextToken(" "));
        int V = Integer.parseInt(st.nextToken(" "));
        chk = new int[N + 1];
        boolean[][] arr = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken(" "));
            int n2 = Integer.parseInt(st.nextToken(" "));
            arr[n1][n2] = true;
            arr[n2][n1] = true;
        }
        dfsList.add(V);
        chk[V] = 1;
        DFS(arr, V);
        chk = new int[N + 1];
        chk[V] = 1;
        BFS(arr, V);
        StringBuilder sb = new StringBuilder();
        for (Integer df : dfsList) {
            sb.append(df).append(" ");
        }
        sb.append("\n");
        for (Integer bf : bfsList) {
            sb.append(bf).append(" ");
        }

        System.out.println(sb);
    }

    private static void BFS(boolean[][] arr, int v) {
        bfsQ.add(v);
        while (!bfsQ.isEmpty()) {
            int start = bfsQ.poll();
            bfsList.add(start);
            for (int i = 1; i <= arr.length - 1; i++) {
                if (arr[start][i] == true && chk[i] == 0) {
                    bfsQ.add(i);
                    chk[i] = 1;
                }
            }
        }

    }

    private static void DFS(boolean[][] arr, int v) {
        for (int i = 1; i <= arr.length - 1; i++) {
            if (arr[v][i] == true && chk[i] == 0 ){
                chk[i] = 1;
                dfsList.add(i);
                DFS(arr, i);
            }
        }
    }
}
