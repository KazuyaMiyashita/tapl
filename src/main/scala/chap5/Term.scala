package chap5

sealed trait Term {
  final def ->:(v: Variable) = Lambda(v, this)
  final def *(t: Term) = Applicate(this, t)
  final def eval(implicit evaluator: EvalutionStrategy): Term = evaluator.eval(this)
}

trait Variable extends Term
case class Lambda(variable: Variable, term: Term) extends Term
case class Applicate(term1: Term, term2: Term) extends Term
