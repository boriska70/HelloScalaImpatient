package util

import scala.util.Random

/**
  * Created by boris on 1/3/17.
  */
class Utils {
  def createIntArray(len: Int, limit: Int) = {
    var r = new Random()
    var arr = new Array[Int](len)
    for (i <- 0 to len - 1) if (limit == -1) arr(i) = r.nextInt() else arr(i) = r.nextInt(limit)
    arr
  }
}
