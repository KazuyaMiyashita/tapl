package term

import org.scalatest._

class FalseSpec extends FlatSpec with Matchers {

  "The False object" should "be normal form" in {
    False.isNormalForm shouldEqual true
  }

  "The False object" should "not be evaluated" in {
    False.evalOnce shouldEqual None
    False.eval shouldEqual False
  }

  "The False object" should "not be deadlock" in {
    False.eval.fullyEvaluated shouldEqual true
  }

}
