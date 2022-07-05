class Solution {
    public boolean isPalindrome(String s) {
        
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n; i++)
        {
            char c = s.charAt(i);
            
            //only capital and lowercase aplhabets are allowed and numerics
            //else skip;
            if( (c>='A' && c<='Z') || (c>='a' && c<='z') || (c>='0' && c<='9'))
            {
                
                if((c>='a' && c<='z') || (c>='0' && c<='9'))
                {
                    sb.append(""+c);
                }else{
                    int val = c-'A';
                    sb.append(""+(char)(val+'a'));
                }
            }
        }
      
        
        return isPalindrome(sb, 0, sb.length()-1);
    }
    
    public boolean isPalindrome(StringBuilder sb, int i, int j)
    {
        while(i<j)
        {
            if(sb.charAt(i) != sb.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
