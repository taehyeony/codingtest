import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;

        recursive("", numbers);

        for(int num: set){
            if(isPrime(num)){
                System.out.println(num);
                answer++;
            }
        }

        return answer;
    }

    private void recursive(String str, String others){
        if(!str.isBlank()){
            set.add(Integer.parseInt(str));
        }
        for(int i=0;i<others.length();i++){
            recursive(str + others.charAt(i),others.substring(0,i)+others.substring(i+1));
        }
    }

    private boolean isPrime(Integer num){
        if(num<2){
            return false;
        }
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num % i ==0) return false;
        }
        return true;
    }
}