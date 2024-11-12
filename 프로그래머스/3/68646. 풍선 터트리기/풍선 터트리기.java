class Solution {
    public static int solution(int[] a) {
        int answer = 1;

        if(a.length <= 2)
            return a.length;

        int left = 0, right = a.length - 1;
        int leftMin = a[left], rightMin = a[right];

        while(left<right){
            if(leftMin > rightMin){
                left++;

                if(a[left] < leftMin)
                    answer++;

                leftMin = Math.min(leftMin, a[left]);
            }
            else {
                right--;
                
                if(a[right] < rightMin)
                    answer++;
                
                rightMin = Math.min(rightMin, a[right]);
            }
        }

        return answer;
    }
}