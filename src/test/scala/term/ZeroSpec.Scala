package term

import org.scalatest._

class ZeroSpec extends FlatSpec with Matchers {

  "The Zero object" should "be normal form" in {
    Zero.isNormalForm shouldEqual true
  }

  "The Zero object" should "not be evaluated" in {
    Zero.evalOnce shouldEqual Zero
    Zero.eval shouldEqual Zero
  }

}
