// Program to identify all possible anagrams in a sentence

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

public class Anagram {
    public static void main(String a[])
    {
        String input = "cat is not a dog and sword has no words when government creates act so what is tac";
        String arr[] = input.split(" ");
        Map<Integer,ArrayList<String>> hm = new HashMap<Integer,ArrayList<String>>();
        
        // Creating Hashmap with length of the word as key 
        // and all words of same length as value of type ArrayList<String>

        for(String word : arr)
        {
          ArrayList<String> al;
          if(hm.get(word.length())!=null)
            hm.get(word.length()).add(word);
          else
          {
            al = new ArrayList<String>();
            al.add(word);
            hm.put(word.length(), al);
          }
        }

        //hm.forEach((key,value)->System.out.println("Key "+key+" Value "+value.toString())); // display HashMap

        // Looping through the hashmap to find anagrams
        Map<String,ArrayList<String>> anagrams = new HashMap<String,ArrayList<String>>();
        for (Map.Entry<Integer,ArrayList<String>> entry : hm.entrySet())
        {
          ArrayList<String> words = new ArrayList<String>(entry.getValue());
          if(words.size()>1) // Only interested in ArrayList with more than 1 word of same length
          {
              for(int i=0;i<words.size();i++)
              {
                for(int j=i+1;j<words.size();j++)
                {
                  if(isAnagram(words.get(i),words.get(j)))
                  {
                   System.out.println(words.get(i)+" and "+words.get(j)+" are anagrams");
                  }
                }
              }
          }
        }
    }

    private static boolean isAnagram(String a, String b)
    {
      List<Character> l1 = new ArrayList<Character>();
      List<Character> l2 = new ArrayList<Character>();
      boolean flag = false;
      for (char c : a.toCharArray()) {
        l1.add(c);
      }
      for (char c : b.toCharArray()) {
        l2.add(c);
      }
      for(int i=0;i<l1.size();i++)
      {
        for(int j=0;j<l2.size();j++)
        {
            if(l1.get(i)==l2.get(j))
            {
                flag = true;
            }
        }
        if(flag==false)
          return false;
        flag = false;
      }
        return true;    
    }
}
