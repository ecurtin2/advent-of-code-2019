package aoc2019

import scala.io.Source
import scala.math.max

object Main {

  def readlines(filename: String): List[String] = {
    val source = Source.fromFile(filename)
    val lines = source.getLines.toList
    source.close
    lines
  }

  def parse(args: List[String]): Int = {
    if (args.length == 0) {
      1
    } else {
      args.head.toInt
    }
  }

  def main(args: Array[String]) {
    val day = parse(args.toList)

    val result: List[String] = day match {
      case 1 => aoc2019.Day1.compute(readlines("./data/day1_p1.txt"))
      case 2 => aoc2019.Day1.compute(readlines("./data/day1_p1.txt"))
    }
    println(result.mkString(""))
  }
}
