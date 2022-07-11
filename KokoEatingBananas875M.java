class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int n = piles.length;
        int s = 1;
        int e = Integer.MIN_VALUE;
        
        for(int el : piles) e = Math.max(el, e);
        
        int ans = 0;
        while(s<=e)
        {
            int m = s+(e-s)/2; //m here stands number of banana eaten in one hour;
            long k = func(piles, m); //k is corresponding hours to eat all bananas of we can eat m banana;
            System.out.println(k+"->"+m);
            if( k <= (long)h)
            {
                 ans =  m;
                 e = m-1;
               
            }else{
                
              s = m+1;
            }
        }
        return ans;
    }
    public long func(int[] piles, int m)
    {
        long hours = 0;
        for(int el : piles)
        {
            hours += el/m;
            if(el%m != 0)
            {
                hours++;
            }
            
        }
        return hours;
    }
}
