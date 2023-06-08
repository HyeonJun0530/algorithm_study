package baekjoon;

import java.io.*;
import java.util.*;

class b14940 {

    static int[][] map;
    static int[][] answer;
    static int[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n;
    static int m;

    static class Location {
        int x;
        int y;

        public Location(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        answer = new int[n + 1][m + 1];
        visited = new int[n + 1][m + 1];

        Location target = null;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                int input = Integer.parseInt(st.nextToken(" "));
                map[i][j] = input;

                if (input == 2) {
                    target = new Location(i, j);
                }
            }
        }

        BFS(target);
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void BFS(Location target) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(target);
        answer[target.y][target.x] = 0;
        int cnt = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int j = 0; j < size; j++) {
                Location l = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int y = l.y + dy[i];
                    int x = l.x + dx[i];
                    if(y >= 0 && x >= 0 && y <= n && x <= m) {
                        if (visited[y][x] == 0 && map[y][x] == 1) {
                            visited[y][x] = 1;
                            answer[y][x] = cnt;
                            queue.add(new Location(y, x));
                        } else if(map[y][x] == 0) {
                            answer[y][x] = 0;
                            visited[y][x] = 1;
                        }
                    }
                }
            }

            cnt++;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if(visited[i][j] == 0 && map[i][j] == 1) {
                    answer[i][j] = -1;
                }
            }
        }

    }
}

