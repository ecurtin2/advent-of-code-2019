package aoc2019

import scala.io.Source
import scala.math.max

object Main {

  val DEFAULT_DAY: Int = 1

  def readlines(filename: String): List[String] = {
    val source = Source.fromFile(filename)
    val lines = source.getLines.toList
    source.close
    lines
  }

  def parse(args: List[String]): Int = {
    if (args.length == 0) {
      DEFAULT_DAY
    } else {
      args.head.toInt
    }
  }

  def main(args: Array[String]) {
    val day = parse(args.toList)

    val result: Tuple2[Any, Any] = day match {
      case 1 => aoc2019.Day1.compute(readlines("./data/day1_p1.txt"))
      case 2 => aoc2019.Day1.compute(readlines("./data/day1_p1.txt"))
    }
    println("Solutions for Advent of Code Day " + day + ":")
    println("Part 1: " + result._1)
    println("Part 2: " + result._2)
  }
}
