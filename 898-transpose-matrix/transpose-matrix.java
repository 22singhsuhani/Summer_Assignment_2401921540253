class Solution {
    public int[][] transpose(int[][] a) {
        int row=a.length;
        int col=a[0].length;

        int[][] b = new int[col][row];//new ki row=old ke col length ke equal

        for(int i=0;i<b.length;i++){
            for(int j=0;j<b[0].length;j++){
                b[i][j]=a[j][i];
            }
        }

        return b;


        
    }
}