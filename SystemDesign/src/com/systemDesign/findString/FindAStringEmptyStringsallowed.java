package com.systemDesign.findString;

public class FindAStringEmptyStringsallowed {

	public static int searchI(String[] strings, String str, int first, int last) {
		while (first <= last) {
			/* Move mid to the middle */
			int mid = (last + first) / 2;
			
			/* If mid is empty, find closest non-empty string */
			if (strings[mid].isEmpty()) { 
				int left = mid - 1;
				int right = mid + 1;
				while (true) {
					if (left < first && right > last) {
						return -1;
					} else if (left >= first && !strings[left].isEmpty()) {
						mid = left;
						break;
					}else if (right <= last && !strings[right].isEmpty()) {
						mid = right;
						break;
					} 
					right++;
					left--;
				}
			}
			
			int res = strings[mid].compareTo(str);
			if (res == 0) { // Found it!
				return mid;
			} else if (res < 0) { // Search right
				first = mid + 1;
			} else { // Search left
				last = mid - 1;
			}
		}
		return -1;
	}	
	
	public static int searchR(String[] strings, String str, int first, int last) {
		if (first > last) {
			return -1;
		}
		
		/* Move mid to the middle */
		int mid = (last + first) / 2;
		
		/* If mid is empty, find closest non-empty string. */
		if (strings[mid].isEmpty()) { 
			int left = mid - 1;
			int right = mid + 1;
			while (true) {
				if (left < first && right > last) {
					return -1;
				} else if (right <= last && !strings[right].isEmpty()) {
					mid = right;
					break;
				} else if (left >= first && !strings[left].isEmpty()) {
					mid = left;
					break;
				}
				right++;
				left--;
			}
		}
			
		/* Check for string, and recurse if necessary */
		if (str.equals(strings[mid])) { // Found it!
			return mid;
		} else if (strings[mid].compareTo(str) < 0) { // Search right
			return searchR(strings, str, mid + 1, last);
		} else { // Search left
			return searchR(strings, str, first, mid - 1);
		}
	}	
		
	public static int search(String[] strings, String str) {
		if (strings == null || str == null || str.isEmpty()) {
			return -1;
		}
		return searchI(strings, str, 0, strings.length - 1);
	}
	 
	// Driver Code
	public static void main(String[] args)
	{
	    // Input arr of Strings.
	    String[] arr= {"for", "", "", "", "geeks", "ide", "",
	                     "practice", "" , "", "quiz", "", ""};
	 
	    // input Search String
	    String str = "quiz";
	  System.out.println(search(arr, str));
	  
	}
}
