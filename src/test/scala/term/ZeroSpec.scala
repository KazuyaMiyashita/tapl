package term

import org.scalatest._

class ZeroSpec extends FlatSpec with Matchers {

  "The Zero object" should "be normal form" in {
    Zero.isNormalForm shouldEqual true
  }

  "The Zero object" should "not be evaluated" in {
    Zero.evalOnce shouldEqual None
    Zero.eval shouldEqual Zero
  }

  "The Zero object" should "not be deadlock" in {
    Zero.eval.fullyEvaluated shouldEqual true
  }

}
