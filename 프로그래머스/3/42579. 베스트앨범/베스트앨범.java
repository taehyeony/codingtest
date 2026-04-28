import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totalPlayMap = new HashMap<>();
        Map<String, List<int[]>> genresSongMap = new HashMap<>();

        for(int i=0;i< genres.length;i++){
            totalPlayMap.put(genres[i],totalPlayMap.getOrDefault(genres[i],0)+plays[i]);

            genresSongMap.putIfAbsent(genres[i],new ArrayList<>());
            genresSongMap.get(genres[i]).add(new int[]{plays[i],i});
        }

        List<String> sortedGenres = new ArrayList<>(totalPlayMap.keySet());
        sortedGenres.sort((g1,g2)-> totalPlayMap.get(g2) - totalPlayMap.get(g1));

        List<Integer> result = new ArrayList<>();

        for(String genre: sortedGenres){
            List<int[]> songs = genresSongMap.get(genre);

            songs.sort((a,b) -> b[0]-a[0]);

            for(int i=0; i<Math.min(songs.size(),2);i++){
                result.add(songs.get(i)[1]);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}