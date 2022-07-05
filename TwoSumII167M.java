class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        //INITIAL approach
        //O(n^2) TLE
        int n = numbers.length;
        // for(int i = 0; i<n-1; i++)
        // {
        //     for(int j = i+1; j<n; j++)
        //     {
        //         int sum = numbers[i]+numbers[j];
        //         if(sum == target)
        //         {
        //             return new int[]{i+1, j+1};
        //         }
        //     }
        // }
        
        
        //final solution
        //two pointers (O(n));
        int i = 0;
        int j = n-1;
        while(i<j)
        {
            int sum = numbers[i]+numbers[j];
            
            if(sum == target)
            {
                return new int[]{i+1, j+1};
                
            }else{
                
                if(sum>target)
                {
                    j--;
                }else{
                    i++;
                }
                
            }
        }
        return new int[]{-1, -1};
    }
}
