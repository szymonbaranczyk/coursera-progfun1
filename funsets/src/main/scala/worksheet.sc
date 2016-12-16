def product(f: Int => Int)(a: Int, b: Int): Int ={
  if(a >= b) 1 else f(a) * product(f)(a+1,b)
}

import funsets.FunSets._

val a = union(union(union(singletonSet(1),
  singletonSet(2)),singletonSet(3)),singletonSet(5))
val b= map(a,x => x*2)
contains(b,3)
