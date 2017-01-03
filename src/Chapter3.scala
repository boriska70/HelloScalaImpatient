import java.awt.datatransfer.{DataFlavor, SystemFlavorMap}

import scala.collection.{JavaConverters, mutable}
import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/**
  * Created by boris on 1/3/17.
  */
object Chapter3 {

  def main(args: Array[String]): Unit = {

    val a = chap3Ex1(12)
    chap3Ex2(a)
    chap3Ex3(a)
    chap3Ex4()
    chap3Ex5()
    chap3Ex6()
    chap3Ex7()
    chap3Ex9()
    chap3Ex10()
  }

  def printLine(chap: Int, ex: Int, start: Boolean): Unit = {
    if (start) printf("========= Chapter %d, Exersize %d ==========\n", chap, ex)
    else printf("========= END of Chapter %d, Exersize %d ==========\n\n", chap, ex)
  }

  def createIntArray(len: Int, limit: Int) = {
    var r = new Random()
    var arr = new Array[Int](len)
    for (i <- 0 to len - 1) if (limit == -1) arr(i) = r.nextInt() else arr(i) = r.nextInt(limit)
    arr
  }

  def chap3Ex1(n: Int) = {
    printLine(3, 1, true)
    val r = new Random()
    val a = new Array[Int](n)
    for (i <- 0 until (a.length)) a(i) = r.nextInt(n)
    printf("Random Array of %d: %s\n", n, a.mkString(", "))
    printLine(3, 1, false)
    a
  }

  def chap3Ex2(arr: Array[Int]): Unit = {
    printLine(3, 2, true)
    val start = System.currentTimeMillis()
    for (i <- 0 until(arr.length, 2)) {
      if (i < arr.length - 1) {
        var tmp = arr(i)
        arr(i) = arr(i + 1)
        arr(i + 1) = tmp
      }
    }
    println("Done in " + (System.currentTimeMillis() - start))
    printf("Swapped Array is:   %s\n", arr.mkString(", "))
    printLine(3, 2, false)
  }

  //works slower on big arrays - due to a new array creation (?)
  def chap3Ex3(arr: Array[Int]): Unit = {
    printLine(3, 3, true)
    val start = System.currentTimeMillis()
    val arr2 = for (i <- 0 until arr.length) yield {
      if (i % 2 == 1) arr(i - 1)
      else {
        if (i == arr.length - 1) arr(i) else arr(i + 1)
      }
    }
    println("Done in " + (System.currentTimeMillis() - start))
    printf("Swapped Array2 is:  %s\n", arr2.mkString(", "))
    printLine(3, 3, false)
  }

  def chap3Ex4(): Unit = {
    printLine(3, 4, true)
    val aLen = 50
    val r = new Random()
    val a = new Array[Int](aLen)
    for (i <- 0 until (a.length)) a(i) = r.nextInt()
    println(a.mkString(","))
    var pos, neg = new ArrayBuffer[Int]
    var zero: Int = 0
    for (elem <- a) if (elem < 0) neg += elem else if (elem > 0) pos += elem else zero += 1
    printf("Length of positive, negative and zero: %d,%d,%d\n", pos.length, neg.length, zero)
    var res = pos ++ neg
    for (i <- 0 until (zero)) res += 0
    printf("The new array is %s\n", res.mkString(", "))
    printLine(3, 4, false)
  }

  def chap3Ex5(): Unit = {
    printLine(3, 5, true)
    val aLen = 10
    var r = new Random
    var arr = new Array[Double](aLen)
    for (i <- 0 until (aLen)) arr(i) = r.nextDouble()
    printf("The array is %s\n", arr.mkString(", "))
    println("The array average is " + arr.sum / arr.length)
    printLine(3, 5, false)
  }

  def chap3Ex6() = {
    printLine(3, 6, true)
    val arr = createIntArray(10, 15)
    printf("The array is %s\n", arr.mkString(", "))
    printf("The reverted array is %s\n", arr.reverse.mkString(", "))

    var arbu = new ArrayBuffer[Int]() ++ arr
    printf("The ArrayBuffer is %s\n", arbu.mkString(", "))
    printf("The reverted ArrayBuffer is %s\n", arbu.reverse.mkString(", "))
    printLine(3, 6, false)
  }

  def chap3Ex7() = {
    printLine(3, 7, true)
    val arr = createIntArray(10, 15)
    println("Initial array: " + arr.mkString(", "))
    val arrDist = arr.distinct
    println("No duplicates array: " + arrDist.mkString(", "))
    println("Duplicates found: " + (arr.length-arrDist.length))
    printLine(3, 7, false)
  }

  def chap3Ex9()  = {
    printLine(3, 9, true)
    var amZones = java.util.TimeZone.getAvailableIDs().filter( _.startsWith("America")).map((str) => str.stripPrefix("America/"))
    println("American time zones: " + amZones.mkString(", "))
    printLine(3, 9, false)
  }

  def chap3Ex10(): Unit = {
    printLine(3, 10, true)
    val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
    val natives = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
    var buf: mutable.Buffer[String] = JavaConverters.asScalaBuffer(natives)
    println("Natives found: " + buf.mkString(", "))
    printLine(3, 10, false)
  }
}
