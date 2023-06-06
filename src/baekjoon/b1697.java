package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1697 {

    static int M;
    static int[] visited = new int[200001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken(" "));
        M = Integer.parseInt(st.nextToken());

        System.out.println(BFS(N));

    }

    public static int BFS(int N) {
        Queue<Integer> queue = new LinkedList<>();
        int L = 0;
        queue.add(N);
        boolean stop = false;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int location = queue.poll();
                if(location - 1 == M || location + 1 == M || location * 2 == M) {
                    stop = true;
                    break;
                } else {
                    if((location + 1) < 200000 &&visited[location + 1] == 0) {
                        queue.add(location + 1);
                        visited[location + 1] = 1;
                    }

                    if(location - 1 > 0 && visited[location - 1] == 0) {
                        queue.add(location - 1);
                        visited[location - 1] = 1;
                    }

                    if((location * 2) < 200000 && visited[location * 2] == 0)  {
                        queue.add(location * 2);
                        visited[location * 2] = 1;
                    }
                }
            }
            L++;
            if (stop != false) {
                break;
            }
        }
        if(N == M) {
            return 0;
        }

        return L;
    }
}
