class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder s = new StringBuilder();

        while (a > 0 || b > 0 || c > 0) {
            if (a >= b && a >= c) {
                if (s.length() >= 2 && s.charAt(s.length()-1) == 'a'
                    && s.charAt(s.length()-2) == 'a') {
                    if (b >= c && b > 0) {
                        s.append('b');
                        b--;
                    } else if (c > 0) {
                        s.append('c');
                        c--;
                    } else break;
                } else {
                    s.append('a');
                    a--;
                }
            } else if (b >= a && b >= c) {
                if (s.length() >= 2 && s.charAt(s.length()-1) == 'b'
                    && s.charAt(s.length()-2) == 'b') {
                    if (a >= c && a > 0) {
                        s.append('a');
                        a--;
                    } else if (c > 0) {
                        s.append('c');
                        c--;
                    } else break;
                } else {
                    s.append('b');
                    b--;
                }
            } else {
                if (s.length() >= 2 && s.charAt(s.length()-1) == 'c'
                    && s.charAt(s.length()-2) == 'c') {
                    if (a >= b && a > 0) {
                        s.append('a');
                        a--;
                    } else if (b > 0) {
                        s.append('b');
                        b--;
                    } else break;
                } else {
                    s.append('c');
                    c--;
                }
            }
        }

        return s.toString();
    }
}