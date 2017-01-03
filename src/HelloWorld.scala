/**
  * Created by boris on 1/3/17.
  */
object HelloWorld {

  def main(args: Array[String]): Unit = {

    val arrSize: Int = 5;
    val arr = new Array[Int](arrSize)
    for(i <- 0 to arrSize-1) arr(i)=i

    for(i <- (0 until (arr.length,2)).reverse) println("Hello, world " + arr(i))
    println("==============")
    for(elem <- arr) println("Hello, world " + elem)
    println("==============")
    val newArr = productEvenArrayRevert(arr,5)
    for(elem <- newArr) println("Hello, world " + elem)
  }

  def productEvenArrayRevert(arr: Array[Int], coef: Int) = {
    //(for(i <- 0 until(arr.length) if arr(i) % 2 ==0) yield coef*arr(i)).sorted(Ordering.Int.reverse)
    //OR:
    arr.filter(_ % 2 == 0).map(coef * _).sorted(Ordering.Int.reverse)
  }

}