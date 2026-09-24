class Solution {
    public String sortString(String s) {

        int[] count = new int[26];

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        StringBuilder ans = new StringBuilder();

        while (ans.length() < s.length()) {

            // Increasing: a -> z
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    ans.append((char)(i + 'a'));
                    count[i]--;
                }
            }

            // Decreasing: z -> a
            for (int i = 25; i >= 0; i--) {
                if (count[i] > 0) {
                    ans.append((char)(i + 'a'));
                    count[i]--;
                }
            }
        }

        return ans.toString();
    }
}