import java.util.*;
class Solution {
    static ArrayList<String> path = new ArrayList<>();
    public static String[] solution(String[][] tickets) {
        String[] answer = {};
        int len = tickets.length;
        Map<String, ArrayList<String>> airMap = new HashMap<>();
        Set<String> airSet = new HashSet<>();

        for(String[] t : tickets){
            ArrayList<String> next = new ArrayList<>();

            if(airMap.containsKey(t[0]))
                next = airMap.get(t[0]);

            next.add(t[1]);
            airMap.put(t[0], next);
            airSet.add(t[0]);
            airSet.add(t[1]);
        }

        ArrayList<String> icn = airMap.get("ICN");
        ArrayList<String> icnc = (ArrayList<String>) icn.clone();
        String ans = "ICN";
        for(String i : icn){
            icnc.remove(i);
            airMap.put("ICN", icnc);
            travel(airMap,len,1,i,ans+","+i);
            icnc = (ArrayList<String>) icn.clone();
            airMap.put("ICN", icnc);
        }

        Collections.sort(path);
        answer = path.get(0).split(",");

        return answer;
    }

    public static void travel(Map<String, ArrayList<String>> airMap, int len, int count, String cur, String answer){
        if(answer.length() > (len+1) * 3 + len)
            return;

        if(len == count && answer.length() == (len+1)*3 + len) {
            path.add(answer);
            return;
        }
        if(!airMap.containsKey(cur))
            return;

        String copy = answer;
        ArrayList<String> next = airMap.get(cur);
        ArrayList<String> nt = (ArrayList<String>) next.clone();

        if(next.size() == 0)
            return;

        for(String n : next){
            answer += (","+n);
            nt.remove(n);
            airMap.put(cur, nt);
            travel(airMap, len, count+1, n, answer);
            answer = copy;
            nt = (ArrayList<String>) next.clone();
            airMap.put(cur, nt);
        }

    }
}