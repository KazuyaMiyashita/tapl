package chap5

class NormalOrderEvaluation extends EvalutionStrategy {

  override def evalOnce(term: Term): Option[Term] = ???
  override def evalStackTrace(term: Term): LazyList[Term] = ???
  override def eval(term: Term): Term = evalStackTrace(term).last

}

object NormalOrderEvaluation {

  implicit val evaluator = new NormalOrderEvaluation

}
