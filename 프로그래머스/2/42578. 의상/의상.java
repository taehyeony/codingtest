import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> map = new HashMap<>();

        for(String[] cloth : clothes){
            map.put(cloth[1],map.getOrDefault(cloth[1],0)+1);
        }

        for(int i: map.values()){
            answer*=(i+1);
        }

        return answer-1;
    }
}