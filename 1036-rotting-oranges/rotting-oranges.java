class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        //INITIALIZE VARIABLES
        Queue<int[]> q= new LinkedList<>();
        int fresh=0;
        int time=0;

        //ADD ROTTEN ONES TO QUEUE
        //INC FRESH COUNT 
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

                int [][] dir={
                    {-1,0}, //down
                    {1,0}, //up
                    {0,-1},  //left
                    {0,1}, // right
                };
                //APPLY  BFS MULTISCORE
                while(!q.isEmpty() && fresh>0){
                    int size=q.size();

                    for(int k=0;k<size;k++){
                        int[] curr=q.poll();
                        int r=curr[0];
                        int c=curr[1];
                        for(int [] d:dir){
                            int nr=r+d[0];
                            int nc=c+d[1];

                            if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                                grid[nr][nc]=2;
                                fresh--;

                                q.add(new int[]{nr,nc});
                            }
                        }
                    }
                    time++;
                }
                    if(fresh==0)return time;
                    else{
                        return -1;

                    }

                }
            } 
        







        
    
