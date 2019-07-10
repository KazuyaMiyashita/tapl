package term

import org.scalatest._

class IsZeroSpec extends FlatSpec with Matchers {

  "The IsZero class" should "not be normal form" in {
    IsZero(Zero).isNormalForm shouldEqual false
    IsZero(Succ(Zero)).isNormalForm shouldEqual false
    IsZero(Pred(Zero)).isNormalForm shouldEqual false
  }

  "iszero 0" should "be true" in {
    IsZero(Zero).eval shouldEqual True
  }

  "iszero (succ nv)" should "be false" in {
    IsZero(Succ(Zero)).eval shouldEqual False
    IsZero(Succ(Succ(Zero))).eval shouldEqual False
  }

  "iszero true" should "be normal form" in {
    IsZero(True).isNormalForm shouldEqual true
    IsZero(True).eval shouldEqual IsZero(True)
  }
  
  "iszero true" should "be deadlock" in {
    IsZero(True).eval.fullyEvaluated shouldEqual false
  }

  "iszero (succ (succ true))" should "not be deadlock" in {
    IsZero(Succ(Succ(True))).eval.fullyEvaluated shouldEqual true
  }

}
