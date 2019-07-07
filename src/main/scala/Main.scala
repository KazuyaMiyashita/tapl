
import term._

object Main extends App {
  println("hello")

  val hoge: Term = Pred(Succ(Zero))

  println(hoge.evalOnce)

}
