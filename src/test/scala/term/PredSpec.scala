package term

import org.scalatest._

class PredSpec extends FlatSpec with Matchers {

  "pred 0" should "be 0" in {
    Pred(Zero).eval shouldEqual Zero
  }

  "pred t1" should "be pred t1' when t1 -> t1'" in {
    val term1 = IsZero(Zero)
    val term1a = True
    term1.eval shouldEqual term1a

    Pred(term1).eval shouldEqual Pred(term1a)
  }

  "pred true" should "be normal form" in {
    Pred(True).isNormalForm shouldEqual true
    Pred(True).eval shouldEqual Pred(True)
  }

}
