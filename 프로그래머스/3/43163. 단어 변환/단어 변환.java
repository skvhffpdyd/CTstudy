import java.util.*;
class Solution {
    static int min;
    static boolean non = true;
    public static int solution(String begin, String target, String[] words) {
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        if(!wordList.contains(target)){
            return 0;
        }
        min = words.length;
        for(int i = 0; i < words.length; i++){
            Set<String> wordCount = new HashSet<>();
            if(compare(begin, words[i]) == 1){
                wordCount.add(words[i]);
                dfs(words[i], target, words, 1, wordCount);
            }
        }

        if(!non){
            return 0;
        }

        return min;
    }

    public static void dfs(String begin, String target, String[] words, int count, Set<String> wordCount){
        boolean check = false;
        if(target.equals(begin)) {
            if (min > count)
                min = count;
            non = true;
            return;
        }

        for(int i = 0; i < words.length; i++){
            if(wordCount.contains(words[i])){
                continue;
            }
            if(compare(begin, words[i]) == 1){
                check = true;
                wordCount.add(words[i]);
                dfs(words[i], target, words, count+1, wordCount);
            }
        }

        if(!check){
            non = false;
        }
    }

    public static int compare(String word, String check){
        char[] wordChar = word.toCharArray();
        char[] checkChar = check.toCharArray();
        int answer = 0;

        for(int i = 0; i < wordChar.length; i++){
            if(wordChar[i] != checkChar[i])
                answer++;
        }

        return answer;
    }
}