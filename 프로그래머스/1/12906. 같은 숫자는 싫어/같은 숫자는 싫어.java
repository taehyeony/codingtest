import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        int temp = -1;

        for(int i: arr){
            if(i!=temp){
                temp = i;
                answer.add(i);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}