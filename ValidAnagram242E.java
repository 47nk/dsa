  public boolean isAnagram(String s, String t) {
        
        //first SOLUTION
        //check for frequencies of letters if they are equal for every letter than return true else false;
        //and on first step itself check for length of the strings;
        if(s.length() != t.length()) return false;
//         for(int i = 0; i<26; i++)
//         {
//             int f1 = 0;
//             int f2 = 0;
//             for(int j = 0; j<s.length(); j++)
//             {
//                 if(i == (int)(s.charAt(j)-'a'))
//                 {
                    
//                     f1++;
//                 }
//             }
            
//             for(int j = 0; j<s.length(); j++)
//             {
//                 if(i == t.charAt(j)-'a')
//                 {
//                     f2++;
//                 }
//             }
            
            
//             if(f1 != f2) return false;
//         }
        
//         return true;
        
        //Approach II (use arr to store frequencies of letters);
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
