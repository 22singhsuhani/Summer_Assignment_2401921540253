class Solution {
    public int trap(int[] h) {
        Stack<Integer> st= new Stack<>();
        int water=0;

        for(int i=0;i<h.length;i++){
            while(!st.isEmpty() && h[i]>h[st.peek()]){
                int bottom=st.pop();

                if(st.isEmpty())
                break;

                int left=st.peek();
                int width=i-left-1;
                int height= Math.min(h[i],h[left])-h[bottom];

                water+=width*height;
            }
            st.push(i);


        }
        return water;
        
    }
}