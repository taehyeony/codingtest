import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        for (String runner : participant) {
          map.put(runner, map.getOrDefault(runner,0) + 1);
        }

        for (String runner : completion) {
          map.put(runner, map.get(runner) - 1);
        }

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
          if (entry.getValue()!=0) {
            answer = entry.getKey();
            break;
          }
        }
        
        return answer;
    }
}