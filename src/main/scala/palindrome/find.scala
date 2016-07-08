package palindrome

object find extends App {

  //Find the longest palindrome from string s centered on position (start,end) 
	def findPalin(s: String, start: Int, end:Int): (Int,Int) = {
		if (start <= 0 || end >= s.length()-1) (start,end)
		else {
			val sNext = s.substring(start-1, end+2)
			if (sNext == sNext.reverse) findPalin(s, start-1, end+1)
			else (start, end)
		}
	}        
  // Find the longest palindrome of string s given position start.  First check whether characters start and next are the same OR
  //     characters either side of start are the same
	def biggestPalindrome(s: String, start: Int): (Int,Int) = {
		if (s(start) == s(start+1)) {
			findPalin(s, start, start+1)
			}
		else if (s(start-1) == s(start+1)) {
			findPalin(s, start, start)
			}
		else (0,0)
	}              
	
	// Find all palindromes in string s returning a list of (palindrome string, position, length).
	// result list is order by length
	def findAllPalindromes (sInput: String): List[(String, Int, Int)] = {
	  
	  val lMax = sInput.length() - 2
    val all = (for ( i <- 2 to lMax)	
      yield biggestPalindrome(sInput,i)).toList             
    
	 val palins = all.filter (x => (x._2-x._1 > 2))      // Remove non-palindrome entries
     .map (x => (sInput.substring(x._1, x._2+1), x._1, x._2 - x._1 + 1))  // Create (palindrome, length) tuples
     .sortWith(_._3 > _._3)                        // Order by length
     .take(3)
     
   for ( p <- palins ) { println ("Text: " + p._1 + " , Index: " + p._2 + " , Length: " + p._3) }
	  
	 palins
	}
	
}
