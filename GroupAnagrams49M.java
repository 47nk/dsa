//First solution(O(n^2));
    public List<List<String>> groupAnagrams(String[] strs) {
        
        int n = strs.length;
        
        List<List<String>> ans = new ArrayList<>();
        boolean[] visited = new boolean[n]; //makes sure multiple catagorization doesnt occur
      
      for(int i = 0; i<n && !visited[i]; i++)
        {
            visited[i] = true;
        
            List<String> temp = new ArrayList<>();
            temp.add(strs[i]);
        
            for(int j = i+1; j<n; j++)
            {
                if(!visited[j] && areAnagrams(strs[i], strs[j]))
                {
                    temp.add(strs[j]);
                    visited[j] = true;
                }
                
            }
            ans.add(temp);
        }
      
        return ans;
    }
    
    
    
    
    //function to check anagrams
    public boolean areAnagrams(String s, String t)
    {
        if(s.length() != t.length()) return false;
        
        int[] arr = new int[26];
        for(int i = 0; i<s.length(); i++)
        {
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }
        for(int el : arr)
        {
            if(el != 0) return false;
        }
        return true;
    }








//O(n) time complexity

 public List<List<String>> groupAnagrams(String[] strs) {
        
        int n = strs.length;
        
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i<n; i++)
        {
            
            //storing frequency
            int[] arr = new int[26];
            for(int j = 0; j<strs[i].length(); j++)
            {
                arr[strs[i].charAt(j)-'a']++;
            }
            String s = Arrays.toString(arr);
            
            
            //checking and putting into map
            if(map.containsKey(s))
            {
                List<String> list = map.get(s);
                list.add(strs[i]);
                map.put(s, list);
            }else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(s, list);
            }
            
           
        }
        
         List<List<String>> list = new ArrayList<>();
        
         for(Map.Entry<String, List<String>> en : map.entrySet())
         {
                list.add(en.getValue());
         }
            
        return list;
    }
