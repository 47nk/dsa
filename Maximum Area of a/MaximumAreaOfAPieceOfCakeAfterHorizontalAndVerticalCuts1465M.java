public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        
        //Initail APPROACH (TLE)
        List<Integer> v = new ArrayList<>(); //List 1;
        v.add(0);
        for(int el : verticalCuts) v.add(el);
        v.add(w);
        
        List<Integer> hr = new ArrayList<>(); //List 2
        hr.add(0);
        for(int el : horizontalCuts) hr.add(el);
        hr.add(h);
        
        Collections.sort(v);
        Collections.sort(hr);
        long ans = 0;
//         for(int i = 1; i<v.size(); i++)
//         {
//             long height = v.get(i)-v.get(i-1); //height of rectangle formed
            
//             for(int j = 1; j<hr.size(); j++)
//             {
//                 long width = hr.get(j)-hr.get(j-1); //width of rectangle formed
//                 long area = width*height;
                
//                 ans = Math.max (area, ans);
//             }
//         }
        
//         return (int)(ans%(1000000007));
  
  //FINAL APPROACH
   
        long height = 0;
        for(int i = 1; i<v.size(); i++)
        {
            height = Math.max(height, v.get(i)-v.get(i-1)); //height of rectangle formed
            
            
        }
        
        long width = 0;
        for(int j = 1; j<hr.size(); j++)
        {
                width = Math.max(width, hr.get(j)-hr.get(j-1)); //width of rectangle formed
                
        }
        
        return (int)((width*height)%(1000000007));
            
    }
