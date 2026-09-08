class Solution {
    public int splitArray(int[] nums, int k) {
        int left=0;
        int right=0;
        
        for(int x:nums){
            left=Math.max(x,left);
            right +=x;
        }
        while(left<=right){
            int mid=left+(right-left)/2;

            int count=1;
            int sum=0;

            for(int x:nums){
                if(sum+x >mid){
                    count++;
                    sum=x;
                }
                else{
                    sum+=x;
                }

            }
            if(count >k){   // mid chota rhgya tbhi to  jada bngyi
                left=mid+1;

            }
            else{
                right=mid-1;
            }
        }
            return left;
            
        
    }
}