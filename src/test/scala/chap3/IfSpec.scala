package chap3

import org.scalatest._

class IfSpec extends FlatSpec with Matchers {

  "if true then t2 else t3" should "be t2" in {
    If(True, True, False).eval shouldEqual True
    If(True, Zero, False).eval shouldEqual Zero
  }

  "if t1 then t2 else t3" should "be if t1' then t2 else t3 when t1 -> t1'" in {
    val term1 = IsZero(Zero)
    val term1a = True
    term1.eval shouldEqual term1a

    If(term1, False, True).evalOnce shouldEqual Some(If(term1a, False, True))
  }

  "if succ(succ(zero)) then t2 else t3" should "be normal form" in {
    If(Succ(Succ(Zero)), IsZero(Zero), False).isNormalForm shouldEqual true
    If(Succ(Succ(Zero)), IsZero(Zero), False).eval shouldEqual If(Succ(Succ(Zero)), IsZero(Zero), False)
  }

}
