import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
// Time Complexity : O(n*k)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
We calculate hash of each string and check if it already exists in the hashmap. if it does we append the string
to the value of that key. if not then we create a new entry and add this string as value to the hash calculated
since anagrams have same characters, hash of strings with same characters present will be same if we use
prime product or form factor method.
* */

class GroupAnagramsTogether {
    int[] arrayOfPrimes;
    public List<List<String>> groupAnagrams(String[] strs) {

         arrayOfPrimes=generateArrayOfPrimeNumbers();
        HashMap<Double,List<String>> ans=new HashMap<>();

        for(String s:strs)
        {
            double hash=getHash(s);
            if(!ans.containsKey(hash))
            {
                ans.put(hash,new ArrayList<>());
            }
            ans.get(hash).add(s);
        }


        return new ArrayList<>(ans.values());

    }


    private int[] generateArrayOfPrimeNumbers()
    {
        int i=2;
        int[] ans=new int[26];
        for(int j=0;j<ans.length;)
        {
            if(isPrime(i))
                ans[j++]=i;
            i++;
        }
        return ans;
    }

    private boolean isPrime(int x){
        for(int i=2;i<x;i++)
        {
            if(x%i==0)
                return false;
        }
        return true;
    }

    private double getHash(String str){



        double hash=1;
        for(char c:str.toCharArray())
        {
            hash=hash*arrayOfPrimes[c - 'a'];
        }

        return hash;
    }
}