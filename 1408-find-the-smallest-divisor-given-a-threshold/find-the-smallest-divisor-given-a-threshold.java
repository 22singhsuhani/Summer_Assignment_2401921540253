class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left=1;
        int right=0;

        for(int x :nums){
            right=Math.max(right,x);
        }

        while(left<=right){
            int mid=left+(right-left)/2;
            int sum=0;

            for(int x:nums){
            sum += ( x + mid -1 ) / mid; 
            } //ceiling div that rounds up to integer
        
        if( sum <= threshold){
            right=mid-1;
        }
        else{
            left=mid+1;
        }
        }
        return left;
    }
}