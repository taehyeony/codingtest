class Solution {
    public int[] solution(int brown, int yellow) {
        int xy = brown + yellow;
        int xPlusY = (brown / 2) + 2;
        int x = (int) (xPlusY + Math.sqrt(-xPlusY*-xPlusY-4*xy))/2;
        int y = xy/x;

        return new int[]{x,y};
    }
}