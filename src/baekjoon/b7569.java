package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class b7569 {

    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[][][] tomato;
    static int M;
    static int N;
    static int H;

    static class Location {
        int x;
        int y;
        int z;

        public Location(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken(" "));
        N = Integer.parseInt(st.nextToken(" "));
        H = Integer.parseInt(st.nextToken());

        tomato = new int[H][N][M];


        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken(" "));
                }
            }
        }

        System.out.println(BFS(tomato));

    }

    private static int BFS(int[][][] tomato) {
        Queue<Location> queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (tomato[i][j][k] == 1) queue.add(new Location(k, j, i));
                }
            }
        }

        int L = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false;

            for (int i = 0; i < size; i++) {
                Location poll = queue.poll();
                for (int j = 0; j < dx.length; j++) {
                    int x = poll.x + dx[j];
                    int y = poll.y + dy[j];
                    int z = poll.z + dz[j];
                    if (x >= 0 && y >= 0 && z >= 0
                            && x < M && y < N && z < H
                            && tomato[z][y][x] == 0) {
                        flag = true;
                        tomato[z][y][x] = 1;
                        queue.add(new Location(x, y, z));
                    }
                }
            }
            if (flag) L++;
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (tomato[i][j][k] == 0) L = -1;
                }
            }
        }

        return L;
    }

}

