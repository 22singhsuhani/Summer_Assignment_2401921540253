class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        ArrayList<Integer> ans = new ArrayList<>();
        int m=mat.length;
        int n=mat[0].length;
        int fc=0, fr=0, lc=n-1 , lr=m-1;
        int tne=m*n;
        while(fc<=lc && fr<=lr){
            //top row
            for(int j=fc;j<=lc;j++)
                ans.add(mat[fr][j]);
            fr++;
            if(ans.size()==tne)break;

            //lc
            for(int i=fr;i<=lr;i++)
                ans.add(mat[i][lc]);
            lc--;
            if(ans.size()==tne)break;

            //lr
            for(int j=lc;j>=fc;j--)
                ans.add(mat[lr][j]);
            lr--;
            if(ans.size()==tne)break;

            //fc
            for(int i=lr;i>=fr;i--)
                ans.add(mat[i][fc]);
            fc++;
        } 
        return ans;


    }
}