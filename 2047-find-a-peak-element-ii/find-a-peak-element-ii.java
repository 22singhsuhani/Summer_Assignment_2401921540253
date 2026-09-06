class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;

        int left=0;
        int right=n-1;

        while(left<=right){
            int mid= left+(right-left) /2 ;

            int row=0;
            for(int i=1;i<m;i++){
                if(mat[i][mid]> mat[row][mid]){
                    row=i;
                }
            }
            int current = mat[row][mid];

            int leftval = (mid>0)? mat[row][mid-1]: -1;  // move left
            int rightval = (mid<n-1)? mat[row][mid+1] : -1;//go right

            if(current>leftval && current >rightval){
                return new int[] {row,mid};
            }

            if(leftval>current){
                right=mid-1;
            }
            else{
                left=mid+1;
            }

        }
        return new int[]{-1,-1};




    }
}