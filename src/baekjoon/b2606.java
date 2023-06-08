package baekjoon;

import java.io.*;
import java.util.*;

class b2606 {

    static int[][] vertex;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int computer = Integer.parseInt(br.readLine());
        int vertexNum = Integer.parseInt(br.readLine());

        vertex = new int[computer + 1][computer + 1];
        visited = new int[computer + 1];
        visited[1] = 1;


        for (int i = 0; i < vertexNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken(" "));
            int n2 = Integer.parseInt(st.nextToken());
            vertex[n1][n2] = 1;
            vertex[n2][n1] = 1;
        }

        System.out.println(BFS());

    }

    private static int BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {

            int n = queue.poll();

            for (int i = 1; i < visited.length; i++) {
                if(vertex[n][i] == 1 && visited[i] == 0) {
                    queue.add(i);
                    visited[i] = 1;
                }
            }
        }
        int answer = 0;

        for (int i = 2; i < visited.length; i++) {
            if(visited[i] != 0) answer++;
        }

        return answer;
    }


}
