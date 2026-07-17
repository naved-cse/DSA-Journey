class Solution {
    public boolean isIsomorphic(String s, String t) {
        // If lengths are different, they cannot be isomorphic
        if (s.length() != t.length()) {
            return false;
        }
        
        // Arrays to store the mappings
        int[] map_s_to_t = new int[256];
        int[] map_t_to_s = new int[256];
        
        for (int i = 0; i < s.length(); i++) {
            char char_s = s.charAt(i);
            char char_t = t.charAt(i);
            
            // Check if there is a conflict in the s -> t mapping
            if (map_s_to_t[char_s] != 0 && map_s_to_t[char_s] != char_t) {
                return false;
            }
            // Check if there is a conflict in the t -> s mapping
            if (map_t_to_s[char_t] != 0 && map_t_to_s[char_t] != char_s) {
                return false;
            }
            
            // Create the mappings for both directions
            map_s_to_t[char_s] = char_t;
            map_t_to_s[char_t] = char_s;
        }
        
        return true;
    }
}