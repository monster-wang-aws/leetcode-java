public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {

        if (s.length() == 0 || s == null) {
            return true;
        }
        
        int n = s.length();
        boolean[] f = new boolean [n + 1];
        f[0] = true;
        
        for (int i = 1; i <= n; i++) {
            f[i] = false;
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                f[i] = f[i] || f[j] && dict.contains(word);     
            }
        }
        
        return f[n];
    }
}