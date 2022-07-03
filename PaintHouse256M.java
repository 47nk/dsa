class Solution {
    int[][] dp;
    public int minCost(int[][] costs) {
        
        //costs[i] = {r, b, g}
        //3 types of colors
        //no adjacent can have same color;
        
        //at curr point(3 KEY OBSERVATIONS)
        
        //which color we are using 
        //till which index we are reached
        //curr cost;
        //we cant go greedy
        //hence dp
       
        dp = new int[costs.length][4];
        return find(costs, 0, -1);
    }
    //color (0, 1, 2 : r, b, g)
    
    public int find(int[][] costs, int idx, int color)
    {
        if(idx == costs.length) return 0;
        
        if(dp[idx][color+1] != 0) return dp[idx][color+1];
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<3; i++)
        {
            if(i == color) continue;
            ans = Math.min(ans, costs[idx][i]+find(costs, idx+1, i));
        }
        
        return dp[idx][color+1] = ans;
    }
}
