class Solution {
    public String makeLargestSpecial(String s) {

        List<String> list = new ArrayList<>();

        int count = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '1')
                count++;
            else
                count--;

            // One complete special substring
            if (count == 0) {

                String inner = s.substring(start + 1, i);

                // Recursively make inner part largest
                inner = makeLargestSpecial(inner);

                list.add("1" + inner + "0");

                start = i + 1;
            }
        }

        // Sort in descending lexicographical order
        Collections.sort(list, Collections.reverseOrder());

        StringBuilder ans = new StringBuilder();

        for (String str : list) {
            ans.append(str);
        }

        return ans.toString();
    }
}