package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class b21736 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] campus;
    static int[][] visited;
    static int N;
    static int M;

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
        N = Integer.parseInt(st.nextToken(" "));
        M = Integer.parseInt(st.nextToken());

        campus = new char[N][M];
        visited = new int[N][M];

        int iy = 0;
        int ix = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = input.charAt(j);
                if (input.charAt(j) == 'I') {
                    ix = j;
                    iy = i;
                }
            }
        }


        int cnt = dfs(ix, iy);

        if (cnt == 0) System.out.println("TT");
        else System.out.println(cnt);

    }

    private static int dfs(int ix, int iy) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(ix, iy));
        visited[iy][ix] = 1;
        int cnt = 0;

        while (!queue.isEmpty()) {
            Location location = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int x = location.x + dx[i];
                int y = location.y + dy[i];

                if(x >= 0 && y >= 0 && x < M && y < N && campus[y][x] != 'X' && visited[y][x] != 1) {
                    if(campus[y][x] == 'P') cnt++;
                    queue.add(new Location(x, y));
                    visited[y][x] = 1;
                }
            }
        }

        return cnt;
    }
}

