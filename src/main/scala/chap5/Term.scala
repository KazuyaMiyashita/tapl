package chap5

sealed trait Term {
  def ->:(v: Variable) = Lambda(v, this)
  def *(t: Term) = Applicate(this, t)
}

trait Variable extends Term
case class Lambda(variable: Variable, term: Term) extends Term
case class Applicate(term1: Term, term2: Term) extends Term
