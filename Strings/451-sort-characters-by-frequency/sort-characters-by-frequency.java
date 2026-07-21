import java.util.*;

class Solution {
    public String frequencySort(String s) {

        Map<Character, Integer> counts = new HashMap<>();
        for (char c: s.toCharArray()){
            counts.put(c, counts.getOrDefault(c,0) + 1);
        }

        List<Character>[] buckets = new List[s.length() + 1];

        for(char key: counts.keySet()){
            int freq = counts.get(key);

            if (buckets[freq] == null){
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = buckets.length - 1; i > 0; i--){
            if (buckets[i] != null){
                for (char c : buckets[i]){
                    for (int j = 0; j < i; j++){
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}