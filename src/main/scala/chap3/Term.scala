package chap3

sealed trait Term {
  def evalOnce: Option[Term]

  final def evalStackTrace: LazyList[Term] = this #:: (evalOnce match {
    case Some(next) => next.evalStackTrace
    case None => LazyList.empty
  })
  final def eval: Term = evalStackTrace.last
  final def isNormalForm: Boolean = evalOnce.isEmpty
}

trait Value extends Term {
  override def evalOnce: Option[Term] = None
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
}

case class IsZero(term: Term) extends Term {
  override def evalOnce: Option[Term] = term match {
    case Zero => Some(True)
    case Succ(_: Term) => Some(False)
    case term => term.evalOnce.map(IsZero(_))
  }
}

case class Succ(term: Term) extends Term {
  override def evalOnce: Option[Term] = term.evalOnce.map(Succ(_))

}

case class Pred(term: Term) extends Term {
  override def evalOnce: Option[Term] = term match {
    case Zero => Some(Zero)
    case Succ(t: Term) => Some(t)
    case term => term.evalOnce.map(Pred(_))
  }
}



