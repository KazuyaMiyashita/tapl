package term

import org.scalatest._

class SuccSpec extends FlatSpec with Matchers {

  "succ t1" should "be succ t1'a when t1 -> t1'" in {
    val term1 = IsZero(Zero)
    val term1a = True
    term1.eval shouldEqual term1a

    Succ(term1).eval shouldEqual Succ(term1a)
  }

  "succ zero" should "be normal form" in {
    Succ(Zero).isNormalForm shouldEqual true
  }

  "succ (iszero (zero))" should "be not normal form" in {
    Succ(IsZero(Zero)).isNormalForm shouldEqual false
  }

}
