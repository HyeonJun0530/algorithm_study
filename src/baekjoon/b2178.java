package baekjoon;

import java.io.*;
import java.util.*;

class b2178 {

    static int[][] miro;
    static int N;
    static int M;
    static int[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

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
        N = Integer.parseInt(st.nextToken(" "));
        M = Integer.parseInt(st.nextToken());

        miro = new int[N + 1][M + 1];
        visited = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String nums = br.readLine();
            for (int j = 1; j <= M; j++) {
                miro[i][j] = Character.getNumericValue(nums.charAt(j - 1));
            }
        }

        visited[1][1] = 1;

        System.out.println(BFS());
    }


    public static int BFS() {
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(1, 1));
        int answer = 1;
        boolean flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Location l = queue.poll();
                if(l.x == M && l.y == N) {
                    flag = true;
                    break;
                }

                for (int j = 0; j < dx.length; j++) {
                    int x = l.x + dx[j];
                    int y = l.y + dy[j];
                    if (x >= 1 && y >= 1
                            && x <= M && y <= N
                            && visited[y][x] == 0
                            && miro[y][x] == 1) {
                        visited[y][x] = 1;
                        queue.add(new Location(x, y));
                    }
                }
            }

            if(flag == true) break;

            answer++;
        }


        return answer;
    }
}
