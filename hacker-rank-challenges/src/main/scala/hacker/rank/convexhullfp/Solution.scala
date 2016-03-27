package hacker.rank.convexhullfp

import java.text.DecimalFormat

import scala.collection.mutable
import scala.io.StdIn.readLine

case class Point(x: Int, y: Int) {

  def distTo(other: Point): Double = {
    Math.sqrt(
      Math.pow(x - other.x, 2) +
      Math.pow(y - other.y, 2)
    )
  }

  def polarAngle(other: Point): Double = Math.atan2( other.y - y, other.x - x )

}

object ByYCoordinate extends Ordering[Point] {
  override def compare(p1: Point, p2: Point): Int = {
    if(p1.y == p2.y) {
      (p1.x - p2.x).toInt
    } else {
      (p1.y - p2.y).toInt
    }
  }
}

object Solution {

  def counterClockwise(p1: Point, p2: Point, p3: Point): Boolean  = {
    (p2.x - p1.x)*(p3.y - p1.y) - (p2.y - p1.y)*(p3.x - p1.x) <= 0
  }

  def withRespectToPolarAngle(p: Point): Ordering[Point] = new Ordering[Point] {
    override def compare(x: Point, y: Point): Int = p.polarAngle(x) compareTo p.polarAngle(y)
  }

  def grahamScan(points: Vector[Point]): Vector[Point] = {
    val p0 = points.min(ByYCoordinate)
    val otherPoints = points.filter( _ != p0 )
    val sortedPoints = otherPoints.sorted(withRespectToPolarAngle(p0))
    val S = new mutable.Stack[Point]()
    S.push(p0, sortedPoints(0), sortedPoints(1))
    for( i <- (2 to sortedPoints.length - 1)) {
      val pi = sortedPoints(i)
      while( S.size >= 2 && counterClockwise( S(1) , S(0) , pi ) ) {
        S.pop()
      }
      S.push(pi)
    }
    S.toVector
  }

  def perimeter(points: Vector[Point]): Double = {
    val cycle = (points.last +: points).view
    (for {
      (p1,p2) <- (cycle zip cycle.tail)
    } yield p1 distTo p2).sum
   }

  def main(args: Array[String]) = {
    val n = readLine().trim.toInt
    val points = Vector.fill(n) {
      val spl = readLine().trim.split("\\s+")
      Point(spl(0).toInt, spl(1).toInt)
    }
    val ch = grahamScan(points)
    val df = new DecimalFormat(".#")
    println(df.format(perimeter(ch)))
  }

}
