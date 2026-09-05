class Solution {
    public void rotate(int[][] m) {
        for(int i=0;i<m.length;i++){
            for(int j=0;j<i;j++){
                int temp=m[i][j];
                m[i][j]=m[j][i];
                m[j][i]=temp;
            }
        }

        //rev each row
        for(int i=0;i<m.length;i++){
            int left=0, right=m[0].length-1;
            while(left<right){
                int temp=m[i][left];
                m[i][left]=m[i][right];
                m[i][right]=temp;

                left++;
                right--;
            }


            }
        }
       

    
}