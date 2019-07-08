package term

import org.scalatest._

class TermSpec extends FlatSpec with Matchers {

  "The evaluation static trace" should "be correct" in {
    val term = If(IsZero(Pred(Succ(Zero))), True, False)
    val stackTrace: List[Term] =
      If(IsZero(Pred(Succ(Zero))), True, False) ::
      If(IsZero(Zero), True, False) ::
      If(True, True, False) ::
      True ::
      Nil

    term.evalStackTrace shouldEqual stackTrace
  }

}
