package term

import org.scalatest._

class TermSpec extends FlatSpec with Matchers {

  "The conplex term" should "be evaluate(1)" in {
    val term = If(IsZero(Pred(Succ(Zero))), True, False)
    term.eval shouldEqual True
  }

  "The conplex term" should "be evaluate(2)" in {
    val term = Pred(Pred(Pred(Succ(Succ(Succ(Succ(Zero)))))))
    term.eval shouldEqual Succ(Zero)
  }

  "The evaluation static trace" should "be correct(1)" in {
    val term = If(IsZero(Pred(Succ(Zero))), True, False)
    val stackTrace: List[Term] =
      If(IsZero(Pred(Succ(Zero))), True, False) ::
      If(IsZero(Zero), True, False) ::
      If(True, True, False) ::
      True ::
      Nil

    term.evalStackTrace shouldEqual stackTrace
  }

  "The evaluation static trace" should "be correct(2)" in {
    val term = Pred(Pred(Pred(Succ(Succ(Succ(Succ(Zero)))))))
    val stackTrace: List[Term] =
      Pred(Pred(Pred(Succ(Succ(Succ(Succ(Zero))))))) ::
      Pred(Pred(Succ(Succ(Succ(Zero))))) ::
      Pred(Succ(Succ(Zero))) ::
      Succ(Zero) ::
      Nil

    term.evalStackTrace shouldEqual stackTrace
  }

}
