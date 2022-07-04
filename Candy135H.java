class Solution {
    public int candy(int[] ratings) {
       
        //observations
        //chidren with lower or equal rating doesnt satisfy below conditions
        //Children with a higher rating get more candies than their neighbors.[1,0,2,3,4,5,4,4,1]
        //1 2 1 2
       
        int n = ratings.length;
        int ans = 0;
        for(int i = 0; i<n; i++)
        {
            //i to 0 && i to n-1;
            //check for len of decreasing sequence and choose max of it and add to the answer
            int ans1 = 1;
            int j = i;
            while(j>0 && ratings[j-1]<ratings[j] )
            {
                ans1++;
                j--;
            }
           
            int ans2 = 1;
            j = i;
            while(j<n-1 && ratings[j+1]<ratings[j])
            {
                ans2++;
                j++;
            }
            ans += Math.max(ans1, ans2);
        }
        return ans;
    }
}
