package baekjoon;

import java.io.*;
import java.util.*;

class b2667 {

    static int[][] apart;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] visited;

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
        int N = Integer.parseInt(st.nextToken());

        apart = new int[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            String nums = br.readLine();
            for (int j = 0; j < N; j++) {
                apart[i][j] = Character.getNumericValue(nums.charAt(j));
            }
        }

        List<Integer> bfs = BFS(N);

        for (Integer bf : bfs) {
            System.out.println(bf);
        }
    }


    public static List<Integer> BFS(int N) {
        int allCnt = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(apart[i][j] == 1 && visited[i][j] == 0) {
                    int cnt = 1;
                    allCnt++;
                    Queue<Location> queue = new LinkedList<>();
                    queue.add(new Location(i, j));
                    visited[i][j] = 1;
                    while (!queue.isEmpty()) {
                        Location poll = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = poll.x + dx[k];
                            int y = poll.y + dy[k];

                            if(x >= 0 && y >= 0 && x < N && y < N && apart[x][y] == 1 && visited[x][y] == 0) {
                                cnt++;
                                visited[x][y] = 1;
                                queue.add(new Location(x, y));
                            }
                        }
                    }

                    list.add(cnt);
                }
            }
        }

        List<Integer> answer = new ArrayList<>();
        answer.add(allCnt);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            answer.add(list.get(i));
        }

        return answer;
    }
}
