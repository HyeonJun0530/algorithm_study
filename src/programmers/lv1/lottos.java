package programmers.lv1;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int cnt = 0;
        int zeroCnt = 0;

        for(int i = 0; i < lottos.length; i++) {
            if(lottos[i] == 0) zeroCnt++;
            for(int j = 0; j < win_nums.length; j++) {
                if(lottos[i] == win_nums[j]) cnt++;
            }
        }

        int maxCnt = cnt + zeroCnt;

        if(7 - maxCnt >= 6) answer[0] = 6;
        else answer[0] = 7 - maxCnt;
        if(7 - cnt >= 6) answer[1] = 6;
        else answer[1] = 7 - cnt;

        return answer;
    }
}
