package chap5

class FullBetaReduction extends EvalutionStrategy {

  override def eval(term: Term) = ???

}

object FullBetaReduction {

  implicit val evaluator = new FullBetaReduction

}
