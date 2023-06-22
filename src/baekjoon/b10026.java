package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());

        char[][] painting = new char[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            painting[i] = br.readLine().toCharArray();
        }

        sb.append(dfs(painting)).append(" ");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(painting[i][j] == 'G') painting[i][j] = 'R';
            }
        }

        visited = new int[n][n];

        sb.append(dfs(painting));

        System.out.println(sb);


    }

    public static int dfs(char[][] painting) {
        Queue<Location> queue = new LinkedList<>();
        int cnt = 0;

        int length = painting.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if(visited[i][j] == 0) {
                    queue.add(new Location(j,i));
                    visited[i][j] = 1;
                    cnt++;
                }

                while (!queue.isEmpty()) {
                    Location poll = queue.poll();
                    for (int k = 0; k < dx.length; k++) {
                        int x = poll.x + dx[k];
                        int y = poll.y + dy[k];
                        if(x >= 0 && y >= 0 && x < length && y < length
                                && painting[poll.y][poll.x] == painting[y][x] && visited[y][x] == 0) {
                            queue.add(new Location(x, y));
                            visited[y][x] = 1;
                        }
                    }
                }
            }
        }

        return cnt;
    }

}

