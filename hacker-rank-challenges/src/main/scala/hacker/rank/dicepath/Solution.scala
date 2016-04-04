package hacker.rank.dicepath

import scala.io.StdIn.{readInt, readLine}

case class DiceConfig(
  top: Short,
  back: Short,
  left: Short) {

  def opposing(x: Short): Short = (7-x).toShort

  def bottom = opposing(top)
  def front = opposing(back)
  def right = opposing(left)

  def rotateRight: DiceConfig = DiceConfig(top = left, back = back  , left = bottom)
  def rotateDown : DiceConfig = DiceConfig(top = back, back = bottom, left = left  )

}

case class Best(configs: Set[DiceConfig], bestSum: Long) {

  def bestIfMovement(movement: DiceConfig => DiceConfig): Best = {
    val (sum,dicesAndSums) = configs.map { config =>
      val newConfig = movement(config)
      val newSum = bestSum + newConfig.top
      (newConfig, newSum)
    }.groupBy { case (_,sum) => sum }
      .maxBy{ case (sum,_) => sum }
    val newDices = dicesAndSums.map { case (dice,_) => dice }
    Best(newDices, sum)
  }

  def ifRotatedRight: Best = bestIfMovement(_.rotateRight)

  def ifRotatedDown: Best = bestIfMovement(_.rotateDown)

}

object Best {

  def max(best1: Best, best2: Best): Best = {
    if(best1.bestSum > best2.bestSum) {
      best1
    } else if(best1.bestSum == best2.bestSum) {
      Best( best1.configs union best2.configs, best1.bestSum )
    } else {
      best2
    }
  }

}

object DicePath {
  def solve(m: Short, n: Short): Long = {
    val initialDice = DiceConfig(top = 1, back = 5, left = 3)
    val bestSolutionAt11 = Best(configs = Set(initialDice), bestSum = initialDice.top)

    val solution =  if(m == 1) {
      (1 to n-1).toVector.foldLeft(bestSolutionAt11) {
        case (best,_) => best.ifRotatedRight
      }
    } else if(n == 1) {
      (1 to m-1).toVector.foldLeft(bestSolutionAt11) {
        case (best,_) => best.ifRotatedDown
      }
    } else {
      val firstRow = (1 to n-1).toVector.scanLeft(bestSolutionAt11) {
        case (best,_) => best.ifRotatedRight
      }.tail

      //println(s"firstRow = $firstRow")

      val firstColumn = (1 to m-1).toVector.scanLeft(bestSolutionAt11) {
        case (best,_) => best.ifRotatedDown
      }.tail

      //println(s"firstColumn = $firstColumn")

      firstColumn.foldLeft(firstRow) { (upperRow, leftmostSolution) =>
        //println(s"upperRow = $upperRow")
        upperRow.scanLeft(leftmostSolution) { (leftSolution, upperSolution) =>
          Best.max( upperSolution.ifRotatedDown, leftSolution.ifRotatedRight )
        }.tail
      }.last
    }

    solution.bestSum
  }
}


object Solution {

  def main(args: Array[String]) ={
    val testCases = readInt()
    for ( _ <- (1 to testCases)) {
      val spl = readLine().split("\\s+")
      val m = spl(0).toShort
      val n = spl(1).toShort
      println(DicePath.solve(m,n))
    }
  }

}
