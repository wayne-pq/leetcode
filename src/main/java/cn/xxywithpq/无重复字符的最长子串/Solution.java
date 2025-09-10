import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet();
        int maxSize = 0;
        int left = 0;
        int right = 0;
        char[] ss = s.toCharArray();

        while(right < ss.length){
            if(!set.contains(ss[right])){
                set.add(ss[right]);
                maxSize = Math.max(maxSize,right - left +1);
                right++;
            }else{
                while(set.contains(ss[right])){
                    set.remove(ss[left]);
                    left++;
                }
            }
        }
        return maxSize;

    }
}