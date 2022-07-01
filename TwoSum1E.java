  public int[] twoSum(int[] nums, int target) {
        //initial solution
        //O(n^2)
        int  n = nums.length;
        // for(int i = 0; i<n-1; i++)
        // {
        //     for(int j = i+1; j<n; j++)
        //     {
        //         int sum = nums[i]+nums[j];
        //         if(sum == target) return new int[]{i, j};
        //     }
        // }
        // return new int[]{-1, -1};
        
        //O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++)
        {
            if(map.containsKey(target-nums[i]))
            {
                return new int[]{map.get(target-nums[i]), i};
            }else
            {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
