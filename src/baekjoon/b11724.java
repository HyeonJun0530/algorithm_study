package baekjoon;

import java.io.*;
import java.util.*;

class b11724 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken(" "));
        int M = Integer.parseInt(st.nextToken());

        int[][] vertex = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken(" "));
            int v = Integer.parseInt(st.nextToken());

            vertex[u][v] = 1;
            vertex[v][u] = 1;
        }

        System.out.println(BFS(vertex, N));
    }

    private static int BFS(int[][] vertex, int N) {

        Queue<Integer> queue = new LinkedList<>();

        int cnt = 0;
        int[] visited = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if(visited[i] == 0) {
                queue.add(i);
                visited[i] = 1;
                cnt++;
            }
            while (!queue.isEmpty()) {
                int n = queue.poll();

                for (int j = 1; j <= N; j++) {
                    if (vertex[n][j] == 1 && visited[j] == 0) {
                        queue.add(j);
                        visited[j] = 1;
                    }
                }
            }
        }

        return cnt;
    }
}

