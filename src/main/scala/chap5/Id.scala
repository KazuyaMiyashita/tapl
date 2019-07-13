package chap5

case class Id(variable: Variable, term: Term)
  extends Lambda(variable, variable)
