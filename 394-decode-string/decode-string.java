class Solution {
    public String decodeString(String s) {
        return helper(s, 0)[0];
    }

    static String[] helper(String s, int i) {
        StringBuilder ans = new StringBuilder();
        int num = 0;

        while (i < s.length() && s.charAt(i) != ']') {

            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
                i++;
            }
            else if (s.charAt(i) == '[') {
                String[] res = helper(s, i + 1);
                String str = res[0];
                i = Integer.parseInt(res[1]);

                for (int j = 0; j < num; j++)
                    ans.append(str);

                num = 0;
            }
            else {
                ans.append(s.charAt(i));
                i++;
            }
        }

        return new String[]{ans.toString(), String.valueOf(i + 1)};
    }
}