package chap5

trait EvalutionStrategy {
  def eval(term: Term): Term
}
