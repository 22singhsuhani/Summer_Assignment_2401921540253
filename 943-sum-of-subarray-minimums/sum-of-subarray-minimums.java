class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int mod=1000000007;

        int[] left=new int[n];
        int[] right=new int[n];

        Stack<Integer> st=new Stack<>();

        //PSE
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            left[i]=st.isEmpty()? i+1 : i-st.peek();
            st.push(i);
        }
        st.clear();

        //NSE
        for(int i=n-1;i>=0;i--){  // traverse form right
        while(!st.isEmpty() && arr[st.peek()]> arr[i]){
            st.pop();
        }
        right[i] = st.isEmpty() ? n-i : st.peek()-i;
        st.push(i);

        }

        //SUM
        long sum=0;

        for(int i=0;i<n;i++){
            long contribution= (long) arr[i]*left[i]*right[i];
            sum=(sum+contribution)%mod;
        }
        return(int )sum;
    }
}