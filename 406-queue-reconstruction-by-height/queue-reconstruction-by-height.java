import java.util.*;

class Solution {
    public int[][] reconstructQueue(int[][] people) {

        // 1. Sort by height descending
        //    If same height, sort k ascending
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });

        // 2. Store the reconstructed queue
        List<int[]> list = new ArrayList<>();

        // 3. Insert person at index k
        for (int[] person : people) {
            list.add(person[1], person);
        }

        // 4. Convert List to 2D array
        return list.toArray(new int[people.length][]);
    }
}