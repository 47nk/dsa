class Solution {
    
    //length of longest wiggle subsequence;
    //may start from +ve or -ve difference
   
    public int wiggleMaxLength(int[] nums) {
        
        int n = nums.length;
        
        //base conditions
        if(n == 1) return 1;
        if(n == 2)
        {
            if(nums[0] == nums[1]) return 1;
            return 2;
        }
        
        //for n>2;
        int ans1 = solve(nums, false); // previous was -ve, curr must be >0;
        int ans2 = solve(nums, true);  // previous was +ve, curr must be <0;
        
        return Math.max(ans1, ans2);
       
    }
    
    public int solve(int[] nums,  boolean isPrevPositive)
    {
        int ans = 1;
        for(int i = 1; i<nums.length; i++)
        {
            if(nums[i-1] == nums[i]) continue;
            if((isPrevPositive && nums[i]<nums[i-1]) || (!isPrevPositive && nums[i]>nums[i-1]))
            {
                isPrevPositive = !isPrevPositive;
                ans++;
              
            }
            
        }
        return ans;
    }
}
