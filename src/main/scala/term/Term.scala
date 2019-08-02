package term

sealed trait Term {
  def evalOnce: Option[Term]
  def isValue: Boolean

  final def evalStackTrace: LazyList[Term] = this #:: (evalOnce match {
    case Some(next) => next.evalStackTrace
    case None => LazyList.empty
  })
  final def eval: Term = evalStackTrace.last
  final def isNormalForm: Boolean = evalOnce.isEmpty
  final def fullyEvaluated: Boolean = isNormalForm && isValue
}

trait Value extends Term {
  override def evalOnce: Option[Term] = None
  override def isValue: Boolean = true
}

case object True extends Term with Value
case object False extends Term with Value
case object Zero extends Term with Value

case class If(cond: Term, onTrue: Term, onFalse: Term) extends Term {
  override def evalOnce: Option[Term] = cond match {
    case True => Some(onTrue)
    case False => Some(onFalse)
    case cond => cond.evalOnce.map(If(_, onTrue, onFalse))
  }
  override def isValue: Boolean = false
}

case class IsZero(term: Term) extends Term {
  override def evalOnce: Option[Term] = term match {
    case Zero => Some(True)
    case Succ(_: Term) => Some(False)
    case term => term.evalOnce.map(IsZero(_))
  }
  override def isValue: Boolean = false
}

case class Succ(term: Term) extends Term {
  override def evalOnce: Option[Term] = term.evalOnce.map(Succ(_))
  override def isValue: Boolean = term match {
    case Zero => true
    case Succ(t) => t.isValue
    case _ => false
  }
}

case class Pred(term: Term) extends Term {
  override def evalOnce: Option[Term] = term match {
    case Zero => Some(Zero)
    case Succ(t: Term) => Some(t)
    case term => term.evalOnce.map(Pred(_))
  }
  override def isValue: Boolean = false
}



