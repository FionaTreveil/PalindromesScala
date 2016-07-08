package palindrome

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class findSuite extends FunSuite {

  import find._

  trait TestSets {
    val s1 = "sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop"
    val s2 = ""
    val s3 = "jkllkjih"
  }


  test("union contains all elements of each set") {
    new TestSets {
      val p1 = findAllPalindromes(s1)
      val p2 = findAllPalindromes(s2)
      val p3 = findAllPalindromes(s3)
      assert(p1.length === 3)
      assert(p1.head === ("hijkllkjih", 23, 10))
      assert(p2.length === 0)
      assert(p3.length === 1)
      assert(p3.head === ("jkllkj", 0, 6))
    }
  }


}
