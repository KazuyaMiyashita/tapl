package chap5

sealed trait Term

trait Variable extends Term
abstract class Lambda(variable: Variable, term: Term)
case class Applicate(term1: Term, term2: Term)
