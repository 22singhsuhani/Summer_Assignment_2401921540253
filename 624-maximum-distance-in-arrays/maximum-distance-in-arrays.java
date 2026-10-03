class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int ans=0;
        int minval=arrays.get(0).get(0);  // first array ka smallest val
        int maxval = arrays.get(0).get(arrays.get(0).size() - 1);
        for(int i=1;i<arrays.size();i++){
            List<Integer> arr=arrays.get(i);

            int currentmin=arr.get(0);
            int currentmax=arr.get(arr.size()-1);

            ans=Math.max(ans,currentmax-minval);
            ans=Math.max(ans,maxval-currentmin);

            minval=Math.min(minval,currentmin);
            maxval=Math.max(maxval,currentmax);

        }
        return ans;


        
    }
}