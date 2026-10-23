class Solution { //sum of subarray max=sum of subarray min
    public long subArrayRanges(int[] nums) {
        return solve(nums,true)-solve(nums,false);  //MAX-MIN
    }
    public long solve(int[]a,boolean max){ // max h kini
    int n=a.length;
    long sum=0;
    Stack<Integer> st=new Stack<>();

    for(int i=0;i<=n;i++){
        while(!st.isEmpty() && (i==n ||
        (max? a[st.peek()] < a[i]: a[st.peek()] > a[i]))){  //curr ele max h ki min ?

            int idx=st.pop();                            
            int left=st.isEmpty()? idx+1:idx-st.peek();   //how many left choices for curr ele
            int right=i-idx;    //count how many right choices for curr ele

            sum+= (long) a[idx]* left*right;
        }
        st.push(i);
    }
    return sum;

    }
        
}