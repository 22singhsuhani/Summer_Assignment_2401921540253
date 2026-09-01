class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int max=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;

            }

            else{
                count=0;
            }

            max=Math.max(max,count); //sath sath maintain h , counts max consecutive 1 jbtk 0 ho 
        }

        return max;
    }
}