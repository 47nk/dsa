public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs)
        {
            sb.append(s.length()+" "+s);
        }
        
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        
        List<String> ans = new ArrayList<>();
        int idx = 0;
        while(idx<s.length())
        {
            StringBuilder temp = new StringBuilder();
            while(s.charAt(idx) != ' ')
            {
                temp.append(""+s.charAt(idx));
                idx++;
            }
            idx++;
            int len = Integer.parseInt(temp.toString()); //this is length of our current string
            ans.add(s.substring(idx, idx+len));
            idx = idx+len;
        }
        
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
