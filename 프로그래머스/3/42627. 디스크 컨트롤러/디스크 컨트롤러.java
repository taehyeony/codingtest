import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a,b)-> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int totalTime = 0;
        int currentTime = 0;
        int jobsIndex = 0;
        int count = 0;

        while(count < jobs.length){
            while(jobsIndex < jobs.length && jobs[jobsIndex][0] <= currentTime){
                pq.offer(jobs[jobsIndex++]);
            }
            if(pq.isEmpty()){
                currentTime = jobs[jobsIndex][0];
            } else {
                int[] job = pq.poll();
                totalTime += (currentTime + job[1]) - job[0];
                currentTime += job[1];
                count++;
            }
        }
        return totalTime/ jobs.length;
    }
}