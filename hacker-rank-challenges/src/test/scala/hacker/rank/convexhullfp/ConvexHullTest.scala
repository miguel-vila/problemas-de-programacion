package hacker.rank.convexhullfp

import org.scalatest.{WordSpecLike, Matchers}

class ConvexHullTest extends Matchers with WordSpecLike {

  "ConvexHull" should {

    "test 1" in {
      val points = Vector(
        Point(1,1),
        Point(2,5),
        Point(3,3),
        Point(5,3),
        Point(3,2),
        Point(2,2)
      )
      Solution.grahamScan(points) should equal (Vector(Point(2,5), Point(5,3), Point(1,1)))
    }

    "test 2" in {
      val points = Vector(
        Point(1,1),
        Point(2,5),
        Point(3,3),
        Point(5,3),
        Point(3,2),
        Point(4,1),
        Point(2,2)
      )
      Solution.grahamScan(points) should equal (Vector(Point(2,5), Point(5,3), Point(4,1), Point(1,1)))
    }

    "test 3" in {
      val points = Vector(
        Point(1,1),
        Point(2,5),
        Point(3,3),
        Point(5,3),
        Point(3,2),
        Point(3,5),
        Point(4,4),
        Point(2,2)
      )
      Solution.grahamScan(points) should equal (Vector(Point(2,5), Point(3,5), Point(5,3), Point(1,1)))
    }

    "test 4" in {
      val points = Vector(
        Point(1,1),
        Point(1,2),
        Point(2,5),
        Point(3,3),
        Point(5,3),
        Point(3,2),
        Point(2,2)
      )
      Solution.grahamScan(points) should equal (Vector(Point(1,2), Point(2,5), Point(5,3), Point(1,1)))
    }

    "test 5" in {
      val points = Vector(
        Point(1,1),
        Point(2,5),
        Point(0,3),
        Point(3,3),
        Point(5,3),
        Point(3,2),
        Point(2,2)
      )
      Solution.grahamScan(points) should equal (Vector(Point(0,3), Point(2,5), Point(5,3), Point(1,1)))
    }

  }

}
