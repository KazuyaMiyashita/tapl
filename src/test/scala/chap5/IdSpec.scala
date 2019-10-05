package chap5

import org.scalatest._
import chap5.shortcut._
import chap5.FullBetaReduction.evaluator

class IdSpec extends FlatSpec with Matchers {

  "id(id(lambda z. id z))" should "be lanbda z. id z" in {
    val id = x ->: x

    val target: Term = id * (id * (z ->: id * z))
    val result: Term = z ->: z

    target.eval shouldEqual result
  }

}
