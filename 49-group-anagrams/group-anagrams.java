import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Edge case check
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        
        // Maps the sorted string to its corresponding anagram group
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            // Convert to char array and sort alphabetically
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            
            // Convert sorted char array back to a String key
            String key = String.valueOf(chars);
            
            // Initialize list if key is new, then append the original string
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        
        // Return all grouped values from the map
        return new ArrayList<>(map.values());
    }
}
