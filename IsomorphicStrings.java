import java.util.HashMap;
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

/*
We take 2 hashmaps to track frequencies , one for s to t and another for t to s
we start iterating the string, take first character from first string and its corresponding character
from second string. If the character is present in first hashmap, then its value should be the character from second string
if it holds true we move ahead else we have a mismatch. If its not present then we add this mapping to hashmap.
 We repeat the above for second hashmap as well
*/

class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> sMap=new HashMap<Character,Character>();
        HashMap<Character,Character> tMap=new HashMap<Character,Character>();

        for(int i=0;i<s.length();i++)
        {
            if(sMap.containsKey(s.charAt(i)))
            {
                if(sMap.get(s.charAt(i))!=t.charAt(i))
                    return false;
            }
            else
            {
                sMap.put(s.charAt(i),t.charAt(i));
            }
            if(tMap.containsKey(t.charAt(i)))
            {
                if(tMap.get(t.charAt(i))!=s.charAt(i))
                    return false;
            }
            else
            {
                tMap.put(t.charAt(i),s.charAt(i));
            }
        }
        return true;
    }
}
