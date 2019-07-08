# tapl
TaPLのお勉強

## 第三章

```
$ sbt

sbt:tapl-test> console
scala> import term._
scala> val term: Term = If(IsZero(Pred(Succ(Zero))), True, False)
term: term.Term = If(IsZero(Pred(Succ(Zero))),True,False)
scala> term.evalStackTrace.foreach(println)
If(IsZero(Pred(Succ(Zero))),True,False)
If(IsZero(Zero),True,False)
If(True,True,False)
True
```

🤗
