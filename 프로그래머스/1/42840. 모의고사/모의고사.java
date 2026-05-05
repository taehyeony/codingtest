import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] mathPhobia = new int[3];
        for(int i=0;i<answers.length;i++){
            if(i%5+1==answers[i]){
                mathPhobia[0]++;
            }
            int[] b_answer = {2,1,2,3,2,4,2,5};
            if(b_answer[i%8]==answers[i]){
                mathPhobia[1]++;
            }
            int[] c_answer = {3,3,1,1,2,2,4,4,5,5};
            if(c_answer[i%10]==answers[i]){
                mathPhobia[2]++;
            }
        }
        int max = Math.max(Math.max(mathPhobia[0],mathPhobia[1]),mathPhobia[2]);
        for(int i=0;i<3;i++){
            if(mathPhobia[i]==max){
                answer.add(i+1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}