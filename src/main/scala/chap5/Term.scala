package chap5

sealed trait Term {
  final def ->:(v: Variable) = Lambda(v, this)
  final def *(t: Term) = Applicate(this, t)

  final def evalOnce(implicit evaluator: EvalutionStrategy): Option[Term] = evaluator.evalOnce(this)
  final def evalStackTrace(implicit evaluator: EvalutionStrategy): LazyList[Term] = evaluator.evalStackTrace(this)
  final def eval(implicit evaluator: EvalutionStrategy): Term = evaluator.eval(this)
}

trait Variable extends Term
case class Lambda(variable: Variable, term: Term) extends Term {
  override def toString = s"λ${variable}.${term}"
}
case class Applicate(term1: Term, term2: Term) extends Term {
  override def toString = s"${term1} (${term2})"
}
