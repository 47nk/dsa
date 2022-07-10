class TimeMap {

  //INITIAL SOLUTION
    HashMap<Integer, String[]> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        //same key at different time stamps
        //increasing order of timestamp
        //else return null
        String[] temp = new String[2];
        temp[0] = key;
        temp[1] = value;
        map.put(timestamp, temp);
      
    }
    
    public String get(String key, int timestamp) {
      
       while(timestamp>0)
       {
           if(map.containsKey(timestamp))
           {
               if(map.get(timestamp)[0].equals(key))
               {
                   return map.get(timestamp)[1];
               }
           }
           timestamp--;
       }
       return "";
    }
}


//FINAL SOLUTION
class TimeMap {

    HashMap<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        
        TreeMap<Integer, String> currentTreeMap;
        if(map.containsKey(key))
        {
            currentTreeMap = map.get(key);
            currentTreeMap.put(timestamp, value);
          
        }else{
            
            currentTreeMap = new TreeMap<>();
            currentTreeMap.put(timestamp, value);
        
        }
        map.put(key, currentTreeMap);
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key))
        {
            TreeMap<Integer, String> currTreeMap = map.get(key);
            Integer floorKey = currTreeMap.floorKey(timestamp);
            if(floorKey != null)
            {
                return currTreeMap.get(floorKey);
            }
        }
        
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
