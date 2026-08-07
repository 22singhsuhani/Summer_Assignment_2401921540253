
class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];

        
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

      
        int max = 0, ch = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > max) {
                max = freq[i];
                ch = i;
            }
        }

     
        if (max > (s.length() + 1) / 2)
            return "";

        char[] ans = new char[s.length()];
        int index = 0;

        // Put most frequent character at even positions
        while (freq[ch] > 0) {
            ans[index] = (char) (ch + 'a');
            freq[ch]--;
            index += 2;
        }

  
        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                if (index >= s.length())
                    index = 1;

                ans[index] = (char) (i + 'a');
                freq[i]--;
                index += 2;
            }
        }

        return new String(ans);
    }
}

