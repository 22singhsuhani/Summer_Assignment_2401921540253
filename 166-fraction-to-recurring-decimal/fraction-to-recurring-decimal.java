class Solution {
    HashMap<Long, Integer> map = new HashMap<>();
    StringBuilder ans = new StringBuilder();

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        if ((numerator < 0) ^ (denominator < 0))
            ans.append("-");

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        ans.append(num / den);

        long rem = num % den;

        if (rem == 0)
            return ans.toString();

        ans.append(".");

        solve(rem, den);

        return ans.toString();
    }

    void solve(long rem, long den) {
        if (rem == 0)
            return;

        if (map.containsKey(rem)) {
            ans.insert(map.get(rem), "(");
            ans.append(")");
            return;
        }

        map.put(rem, ans.length());

        rem *= 10;
        ans.append(rem / den);

        solve(rem % den, den);
    }
}