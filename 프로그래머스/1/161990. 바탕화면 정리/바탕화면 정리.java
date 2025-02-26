class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        int lux = 0, luy = 0, rdx = 0, rdy = 0;
        int count = 0;
        boolean first = true;
        for(String wall : wallpaper){
            if(wall.contains("#")){
                if(first){
                    first = false;
                    lux = count;
                    luy = wall.indexOf("#");
                    rdy = wall.lastIndexOf("#") + 1;
                    rdx = count + 1;
                }
                else {
                    if (wall.indexOf("#") < luy) {
                        luy = wall.indexOf("#");
                    }
                    if (wall.lastIndexOf("#") + 1 > rdy) {
                        rdy = wall.lastIndexOf("#") + 1;
                    }
                    rdx = count+1;
                }
            }
            count++;
        }
        answer = new int[]{lux, luy, rdx, rdy};
        return answer;
    }
}
