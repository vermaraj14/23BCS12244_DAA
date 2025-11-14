import java.util.HashMap;
public class Daa1 {
    public static String minWindow(String s, String t){
        if (s.length() < t.length()) return "";
         HashMap<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray())
            need.put(c, need.getOrDefault(c, 0) + 1);
            int r=t.length();
            int left = 0, minlen = Integer.MAX_VALUE, start = 0;
            for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (need.containsKey(ch)) {
                if (need.get(ch) > 0) r--;
                need.put(ch, need.get(ch)-1);
            }
            while(r==0){
                if(right-left+1<minlen){
                    minlen=right-left+1;
                    start=left;
                }
            }
            char lc = s.charAt(left);
            if(need.containsKey(lc)){
                need.put(lc, need.get(lc)+1);
            }
            if(need.get(lc)>0) 
                r++;
        
    }
    return minlen == Integer.MAX_VALUE ? "-1" : s.substring(start, start + minlen);
}

    public static void main(String args[]){
        String s="ADOBECODEBANC";
        String t="BANC";
        System.out.println(minWindow(s, t));
    }
}

