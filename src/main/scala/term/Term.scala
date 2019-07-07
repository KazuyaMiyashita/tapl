package term

sealed trait Term {
  def evalOnce: Term
  def isNormalForm: Boolean
  def eval: Term = if (isNormalForm) this else evalOnce.eval
}

trait Value extends Term {
  override def evalOnce: Term = this
  override def isNormalForm: Boolean = true
}

case object True extends Term with Value
case object False extends Term with Value
case object Zero extends Term with Value

case class If(cond: Term, onTrue: Term, onFalse: Term) extends Term {
  override def evalOnce: Term = cond match {
    case True => onTrue
    case False => onFalse
    case cond => If(cond.eval, onTrue, onFalse)
  }
  override def isNormalForm = false
}

case class IsZero(term: Term) extends Term {
  override def evalOnce: Term = term match {
    case Zero => True
    case Succ(t: Term) => False
    case term => IsZero(term.eval)
  }
  override def isNormalForm = false
}

case class Succ(term: Term) extends Term {
  override def evalOnce: Term = Succ(term.eval)
  override def isNormalForm: Boolean = term.isNormalForm
}

case class Pred(term: Term) extends Term {
  override def evalOnce: Term = term match {
    case Zero => Zero
    case Succ(t: Term) => t
    case term => Pred(term.eval)
  }
  override def isNormalForm: Boolean = term match {
    case Zero => true
    // case Succ(t: Term) => t.isNormalForm
    case _ => false
  }
}


