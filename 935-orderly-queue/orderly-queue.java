class Solution {
    public String orderlyQueue(String s, int k) {

        // If k > 1, any permutation is possible
        if (k > 1) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }

        // k == 1
        String ans = s;

        for (int i = 1; i < s.length(); i++) {
            String rotation = s.substring(i) + s.substring(0, i);

            if (rotation.compareTo(ans) < 0) {
                ans = rotation;
            }
        }

        return ans;
    }
}