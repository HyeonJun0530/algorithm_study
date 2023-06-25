package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class b16928 {

    static int[] dice = {1, 2, 3, 4, 5, 6};
    static int[] visited = new int[101];
    static int[] snake;
    static int[] ladder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken(" "));
        int M = Integer.parseInt(st.nextToken());
        ladder = new int[101];
        snake = new int[101];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ladder[Integer.parseInt(st.nextToken(" "))] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            snake[Integer.parseInt(st.nextToken(" "))] = Integer.parseInt(st.nextToken());
        }


        System.out.println(dfs());


    }

    private static int dfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int L = 0;
        int cnt = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int location = queue.poll();
                if (location == 100) cnt = Math.min(cnt, L);
                else {
                    for (int j = 0; j < dice.length; j++) {
                        int moving = location + dice[j];
                        if (moving <= 100 && visited[moving] != 1) {
                            if (ladder[moving] != 0) {
                                queue.add(ladder[moving]);
                                visited[ladder[moving]] = 1;
                                visited[moving] = 1;
                            } else if (snake[moving] != 0) {
                                queue.add(snake[moving]);
                                visited[snake[moving]] = 1;
                                visited[moving] = 1;
                            } else {
                                queue.add(moving);
                                visited[moving] = 1;
                            }
                        }
                    }
                }
            }
            L++;
        }


        return cnt;
    }
}

