import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(String operation: operations){
            String[] list = operation.split(" ");
            String command = list[0];
            int value = Integer.parseInt(list[1]);
            if(command.equals("I")){
                minHeap.offer(value);
                maxHeap.offer(value);
            } else {
                if(value == 1 && !maxHeap.isEmpty()){
                    int max = maxHeap.poll();
                    minHeap.remove(max);
                }else if(!minHeap.isEmpty()) {
                    int min = minHeap.poll();
                    maxHeap.remove(min);
                }
            }
        }

        int[] answer = {0, 0};
        if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
            answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }

        return answer;
    }
}