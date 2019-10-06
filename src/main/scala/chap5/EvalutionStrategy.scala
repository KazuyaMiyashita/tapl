package chap5

trait EvalutionStrategy {
  def evalOnce(term: Term): Option[Term] = ???
  def evalStackTrace(term: Term): LazyList[Term] = ???
  def eval(term: Term): Term = ???
}
