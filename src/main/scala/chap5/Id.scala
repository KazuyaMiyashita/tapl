package chap5

import chap3._

case class Id(variable: Variable, term: Term)
  extends Lambda(variable, variable)

case object Factorial extends Lambda(
  X,
  If(IsZero(X), Succ(Zero), Multiple(X, Factorial(Pred(X))))
)

case object Tru extends Lambda(
  X,
  Lambda(
    Y,
    X
  )
)

case object Fls extends Lambda(
  X,
  Lambda(
    Y,
    Y
  )
)
