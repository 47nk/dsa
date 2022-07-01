 public boolean containsDuplicate(int[] nums) {
        
        //initial approach(SOLUTION 1)
        //O(n^2) -- TLE
        int n = nums.length;
        // for(int i = 0; i<n-1; i++)
        // {
        //     for(int j = i+1; j<n; j++)
        //     {
        //         if(nums[i] == nums[j]) return true;
        //     }
        // }
        // return false;
        
        //use sorting (SOLUTION 2)
        //o(nlogn + n) time
        // Arrays.sort(nums);
        // for(int i = 1; i<n; i++)
        // {
        //     if(nums[i-1] == nums[i]) return true;
        // }
        // return false;
        
        
        
        
        
        //use hashset(FINAL SOLUTION)
        //O(n) time && O(n) space
        Set<Integer> set = new HashSet<>();
        for(int el : nums)
        {
            if(set.contains(el)) return true;
            set.add(el);
        }
        return false;
    }
