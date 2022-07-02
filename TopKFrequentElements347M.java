 public int[] topKFrequent(int[] nums, int k) {
        //at every step store top k frequencies;
        
        //SOLUTION 1
        //sort -> nlogn
        //priority queue 
        //return ans;
//         int n = nums.length;
//         Arrays.sort(nums);
//         int[] ans = new int[k];
//         PriorityQueue<int[]> q = new PriorityQueue<>((a, b)-> a[1]-b[1]); //[1, 2], [2, 3];
//         int curr = 1;
//         for(int i = 1; i<=n; i++)
//         {
           
            
//             if(i != n && nums[i] == nums[i-1])
//             {
//                 curr++;
                
//             }else{
                
//                 int[] arr = new int[2];
//                 arr[0] = nums[i-1];
//                 arr[1] = curr;
                
                
//                 if(q.size()<k)
//                 {
//                     q.add(arr);
//                 }else{
//                     if(q.peek()[1]<curr)
//                     {
//                         q.poll();
//                         q.add(arr);
//                     }
//                 }
                
                
//                 curr = 1;
//             }
//         }
//         int index = 0;
//         while(!q.isEmpty())
//         {
//             int[] arr = q.poll();
//             ans[index++] = arr[0];
//         }
//         return ans;
        
        
        
        
        
        //SOLUTION 2
        //using hashMap and Bucket sort;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        
        List<Integer>[] bucket = new List[n+1]; //max frequency can be n, min 1; therefore n+1 elments 1 to n;
        for(Map.Entry<Integer, Integer> en : map.entrySet())
        {   
            int key = en.getKey();
            int freq = en.getValue();
            if(bucket[freq] == null)
            {
                List<Integer> list = new ArrayList<>();
                list.add(key);
                bucket[freq] = list;
                
            }else{
                List<Integer> list = bucket[freq];
                list.add(key);
                bucket[freq] = list;
            }
        }
        
        int count = 0;
        int[] ans = new int[k];
        int index = n;
        while(index>0)
        {
            if(bucket[index] == null)
            {
               index--;
               continue;
            }
            List<Integer> curr = bucket[index];
            for(int i = 0; i<curr.size() && count<k; i++)
            {
                ans[count++] = curr.get(i);
            }
            
          index--;
        }
        return ans;
    }
