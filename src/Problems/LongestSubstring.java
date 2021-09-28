package Problems;

import java.util.HashMap;

public class LongestSubstring 
{
	public int longestSubString(String s) {
		HashMap<Character,Integer> longestsub= new HashMap<Character,Integer>();
		int len=0,j=0,l=0;
			while(j<s.length())
			{
				
				if(longestsub.containsKey(s.charAt(j)))
				{
					if(l>len)
					{
						len =l;
					}
					j=longestsub.get(s.charAt(j))+1;
					l=0;
					longestsub.clear();
					
				}
				else
				{
					l++;
					longestsub.put(s.charAt(j),j);
					j++;
				}
			}
			if(l>len)
			{
				len =l;
			}
		
		return len;
	}
}
