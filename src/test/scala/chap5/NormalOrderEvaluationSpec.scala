package chap5

import org.scalatest._
import chap5.shortcut._
import chap5.NormalOrderEvaluation.evaluator

class NormalOrderEvaluationSpec extends FlatSpec with Matchers {

  "id(id(λz. id z))" should "be λ z. z" in {
    val id = x ->: x

    val term: Term = id * (id * (z ->: id * z))
    val stackTrace: LazyList[Term] =
      (id * (id * (z ->: id * z))) #::
      (id * (z ->: id * z)) #::
      (z ->: id * z) #::
      (z ->: z) #::
      LazyList.empty

      term.evalStackTrace shouldEqual stackTrace
  }

}
