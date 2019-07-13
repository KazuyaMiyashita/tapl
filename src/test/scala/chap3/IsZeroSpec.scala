package chap3

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
  

}
