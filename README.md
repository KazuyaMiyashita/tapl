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

```
sbt:tapl-test> test
[info] PredSpec:
[info] pred 0
[info] - should be 0
[info] pred t1
[info] - should be pred t1' when t1 -> t1'
[info] TermSpec:
[info] The evaluation static trace
[info] - should be correct(1)
[info] The evaluation static trace
[info] - should be correct(2)
[info] FalseSpec:
[info] The False object
[info] - should be normal form
[info] The False object
[info] - should not be evaluated
[info] IsZeroSpec:
[info] The IsZero class
[info] - should not be normal form
[info] iszero 0
[info] - should be true
[info] iszero (succ nv)
[info] - should be false
[info] TrueSpec:
[info] The True object
[info] - should be normal form
[info] The True object
[info] - should not be evaluated
[info] IfSpec:
[info] if true then t2 else t3
[info] - should be t2
[info] if t1 then t2 else t3
[info] - should be if t1' then t2 else t3 when t1 -> t1'
[info] SuccSpec:
[info] succ t1
[info] - should be succ t1'a when t1 -> t1'
[info] succ zero
[info] - should be normal form
[info] succ (iszero (zero))
[info] - should be not normal form
[info] Run completed in 435 milliseconds.
[info] Total number of tests run: 16
[info] Suites: completed 7, aborted 0
[info] Tests: succeeded 16, failed 0, canceled 0, ignored 0, pending 0
[info] All tests passed.
[success] Total time: 1 s, completed Jul 9, 2019 7:58:25 AM
```

🤗
