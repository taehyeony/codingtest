import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        
        int standardDay = (int) Math.ceil((100.0 - progresses[0]) / speeds[0]);
        int count = 1;

        for (int i = 1; i < progresses.length; i++) {
            int reqDay = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);

            if (standardDay >= reqDay) {
                count++;
            } else {
                list.add(count);
                count = 1;
                standardDay = reqDay;
            }
        }
        list.add(count);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}