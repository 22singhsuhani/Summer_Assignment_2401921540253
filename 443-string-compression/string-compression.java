class Solution {
    public int compress(char[] chars) {
        int writeIndex = 0;
        int i = 0;
        
        while (i < chars.length) {
            int j = i;
            // Find the end of the current group of identical characters
            while (j < chars.length && chars[j] == chars[i]) {
                j++;
            }
            
            // 1. Write the character
            chars[writeIndex++] = chars[i];
            
            // 2. Write the count if it's greater than 1
            int count = j - i;
            if (count > 1) {
                String countStr = Integer.toString(count);
                for (char c : countStr.toCharArray()) {
                    chars[writeIndex++] = c;
                }
            }
            
            // Move to the next group
            i = j;
        }
        
        return writeIndex;
    }
}
