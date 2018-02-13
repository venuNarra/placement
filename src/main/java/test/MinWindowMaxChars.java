package test;

import java.util.HashMap;

import sun.misc.LRUCache;

public class MinWindowMaxChars {
     
	    // Function to find smallest window containing
	    // all distinct characters
	    static String findSubString(String str)
	    {
	        int n = str.length();
	        // Count all distinct characters.
	        int dist_count = 0;
	         
	        HashMap<Character, Integer> map=new HashMap<Character,Integer>();
	        for (int i=0; i<n; i++)
	        {
	        	if(map.get(str.charAt(i))==null){
	        		map.put(str.charAt(i), 1);
	        		dist_count++;
	        	}
	        }
	      map.clear();
	        // Now follow the algorithm discussed in below
	        // post. We basically maintain a window of characters
	        // that contains all characters of given string.
	        // https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/ 
	        int start = 0, start_index = -1;
	        int min_len = Integer.MAX_VALUE;
	      
	        int count = 0;
	        for (int j=0; j<n; j++)
	        {
	            // Count occurrence of characters of string
	            if(map.get(str.charAt(j))!=null) { 	
	            	map.put(str.charAt(j), map.get(str.charAt(j)).intValue()+1);
	            }else {
	            	map.put(str.charAt(j),1);
	            	count++;
	            }
	       
	            // if all the characters are matched
	            if (count == dist_count)
	            {
	                // Try to minimize the window i.e., check if
	                // any character is occurring more no. of times
	                // than its occurrence in pattern, if yes
	                // then remove it from starting and also remove
	                // the useless characters.
	                while (map.get(str.charAt(start)) > 1)
	                {
	                    if (map.get(str.charAt(start)) > 1)
	                        map.put(str.charAt(start),map.get(str.charAt(start)).intValue()-1);
	                    start++;
	                }
	                 
	                // Update window size
	                int len_window = j - start + 1;
	                if (min_len > len_window)
	                {
	                    min_len = len_window;
	                    start_index = start;
	                }
	            }
	        }
	        // Return substring starting from start_index
	        // and length min_len
	        return str.substring(start_index, start_index+min_len);
	    }
	      
	    // Driver code
	    public static void main(String args[])
	    {
	        String str = "aabcbcdbca";
	        System.out.println("Smallest window containing all distinct"
	               + " characters is " + findSubString(str));
	        
	    }
	}