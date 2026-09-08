class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int left=0;
        int right=0;

        for(int weight:weights){
            left=Math.max(left,weight);
            right +=weight;

        }
        while(left<=right){
            int mid=left+(right-left)/2;

            //CALCULATE DAYS
        int reqdays =1;
        int currweight=0;

        for(int weight:weights){   // summing up
            if(currweight+weight > mid){    
                reqdays++;  
                currweight=weight;
            }
            else{
                currweight+=weight;
            }
        }
        if(reqdays <=days){    //aur time h to reduce days
            right=mid-1;
        }
        else{
            left=mid+1;   //inc days (mid is insufficient)
        }

    }
    return left;

    }
}