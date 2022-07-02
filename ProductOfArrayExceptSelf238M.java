public int[] productExceptSelf(int[] nums) {
        //APPROACH 1 (time : O(n^2)TLE, space : O(n))
        int n = nums.length;
//         int[] ans = new int[n];
//         for(int i = 0; i<n; i++)
//         {
//             int product = 1;
//             for(int j = 0; j<n ; j++)
//             {
//                 if(i == j) continue;
//                 product *= nums[j];
//             }
            
//             ans[i] = product;
//         }
//         return ans;
        
        
        //FINAL APPROACH O(n) : time
        //cases to separatly handle
        //if zeroCount == 0;//simply use default code
        // if zeroCount == 1;//find position of zero and product with out 0;
        //else >1 return all nums zero
       //OR WE CAN USE prefix array and that array is the output array;
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 1; i<n; i++)
        {
            res[i] = res[i-1]*nums[i-1];
        }
       
        int product = 1;
        for(int i = n-2; i>=0; i--)
        {
            product = product*nums[i+1];
            res[i] = res[i]*product;
        }
        return res;
    }
