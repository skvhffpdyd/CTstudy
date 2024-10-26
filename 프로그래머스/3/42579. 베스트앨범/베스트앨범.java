import java.util.*;
class Solution {
    public static int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        Map<String, Integer> playsMap = new HashMap<>();
        Map<Integer, String> reverseMap = new HashMap<>();
        Map<String, ArrayList<Integer>> genreMap = new HashMap<>();

        for(int i = 0; i < genres.length; i++){
            if(!genreMap.containsKey(genres[i])){
                ArrayList<Integer> value = new ArrayList<>();
                value.add(i);
                genreMap.put(genres[i], value);
                playsMap.put(genres[i], plays[i]);
            }
            else{
                ArrayList<Integer> value = genreMap.get(genres[i]);
                value.add(i);
                genreMap.put(genres[i], value);
                playsMap.put(genres[i], playsMap.get(genres[i])+plays[i]);
            }
        }

        for (String key : playsMap.keySet())
            reverseMap.put(playsMap.get(key), key);

        Integer[] playValues = playsMap.values().toArray(new Integer[0]);
        Arrays.sort(playValues);

        for(int i = playValues.length - 1; i >= 0 ; i--){
            String genre = reverseMap.get(playValues[i]);
            int first = 0;
            int firstIndex = -1;
            int second = 0;
            int secondIndex = -1;
            ArrayList<Integer> musicList = genreMap.get(genre);
            for(int j = 0; j < musicList.size(); j++){
                int m = musicList.get(j);
                if(plays[m] > first){
                    if(first != 0){
                        second = first;
                        secondIndex = firstIndex;
                    }
                    first = plays[m];
                    firstIndex = m;
                }
                else if(plays[m] > second || plays[m] == first){
                    second = plays[m];
                    secondIndex = m;
                }
            }
            if(secondIndex == -1)
                answer.add(firstIndex);
            else {
                answer.add(firstIndex);
                answer.add(secondIndex);
            }
        }

        int[] ans = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++){
            ans[i] = answer.get(i);
        }

        return ans;
    }
}