package baekjoon;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class b18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken(" "));

        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken(" "));
            list.add(num);
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> sort = numMap.keySet().stream().collect(Collectors.toList());
        Collections.sort(sort);
        numMap.clear();

        for (int i = 0; i < sort.size(); i++) {
            numMap.put(sort.get(i), i);
        }

        StringBuilder sb = new StringBuilder();

        for (Integer integer : list) {
            sb.append(numMap.get(integer)).append(" ");
        }

        System.out.println(sb);
    }
}
