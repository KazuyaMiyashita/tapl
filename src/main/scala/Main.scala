
import chap3._

object Main extends App {

  If(IsZero(Pred(Succ(Zero))), True, False).evalStackTrace.foreach(println)

  println

  Pred(Pred(Pred(Succ(Succ(Succ(Succ(Zero))))))).evalStackTrace.foreach(println)

}
