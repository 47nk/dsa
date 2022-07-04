class Solution {
    public int longestConsecutive(int[] nums) {
        
        //observations
        //duplicates exist
        //length of nums can be 0;
        //nums[i] can be negative also;
        
        //SOLUTION 1 (n^2);
           int n = nums.length;
           if(n == 0) return 0;
//         HashSet<Integer> set = new HashSet<>();
//         for(int el : nums) set.add(el);
        
//         int ans = 1;
//         for(int el : nums)
//         {
//             int currAns = 1;
//             while(set.contains(el+1))
//             {
//                 currAns++;
//                 el++;
//             }
//             ans = Math.max(ans, currAns);
//         }
//         return ans;
      
        HashSet<Integer> set = new HashSet<>();
        for(int el : nums) set.add(el);
        int ans = 0;
        for(int i = 0; i<n; i++)
        {
            if(!set.contains(nums[i]-1)) //we are not checking prev streak
                // means we are starting from first el in increaing sequence;
            {
                int currAns = 1;
                int m = nums[i]+1;
                while(set.contains(m))
                {
                    m++;
                    currAns++;
                }
                ans = Math.max(currAns, ans);
            }
        }
        return ans;
    }
    
}
