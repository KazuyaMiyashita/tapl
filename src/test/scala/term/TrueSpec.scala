package term

import org.scalatest._

class TrueSpec extends FlatSpec with Matchers {

  "The True object" should "be normal form" in {
    True.isNormalForm shouldEqual true
  }

  "The True object" should "not be evaluated" in {
    True.evalOnce shouldEqual True
    True.eval shouldEqual True
  }

}
