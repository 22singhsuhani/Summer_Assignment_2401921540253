class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq=new ArrayDeque<>();
        int n=nums.length;

        int[] ans=new int[n-k+1];

        for(int i=0;i<n;i++){

            //out of window ele
            if(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }

            //smaller ele of back remove
            while(!dq.isEmpty()&& 
                    nums[dq.peekLast()]<nums[i]){
                        dq.pollLast();
                    }

                    //add current idx
                    dq.offerLast(i);

                    //store max
                    if(i>=k-1){
                        ans[i-k+1]=nums[dq.peekFirst()];
                    }
        }
        return ans;
        
    }
}