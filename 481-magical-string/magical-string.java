class Solution {
    public int magicalString(int n) {
        if (n <= 3) return 1;
        
        int[] s = new int[n + 1];
        s[0] = 1; s[1] = 2; s[2] = 2;
        
        int head = 2, tail = 3, num = 1, ones = 1;
        
        while (tail < n) {
            for (int i = 0; i < s[head]; i++) {
                s[tail] = num;
                if (num == 1 && tail < n) ones++;
                tail++;
            }
            head++;
            num = 3 - num; // Flip 1 <-> 2
        }
        
        return ones;
    }
}
