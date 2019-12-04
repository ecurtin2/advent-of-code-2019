package aoc2019

import scala.io.Source
import scala.math.max
import scala.sys.env

object Main {

  val DEFAULT_DAY_ENVVAR = "AOC2019_DEFAULT_DAY"
  val DEFAULT_PART_ENVVAR = "AOC2019_DEFAULT_PART"
  val DEFAULT_DAY: Int = env.getOrElse(DEFAULT_DAY_ENVVAR, "1").toInt
  val DEFAULT_PART: Int = env.getOrElse(DEFAULT_PART_ENVVAR, "1").toInt

  def readlines(filename: String): List[String] = {
    val source = Source.fromFile(filename)
    val lines = source.getLines.toList
    source.close
    lines
  }

  def parse(args: List[String]): Tuple2[Int, Int] = {
    args match {
      case List() => (DEFAULT_DAY, DEFAULT_PART)
      case List(a) => (a.toInt, DEFAULT_PART)
      case List(a, b, _*) => (a.toInt, b.toInt)
  }
  }

  def main(args: Array[String]) {
    val dayPart = parse(args.toList)

    val result: Any = dayPart match {
      case (1, 1) => aoc2019.Day1.compute_part1(readlines("./data/day1_p1.txt"))
      case (1, 2) => aoc2019.Day1.compute_part2(readlines("./data/day1_p1.txt"))
      case (2, 1) => aoc2019.Day2.compute_part1(readlines("./data/day2_p1.txt"))
      case (2, 2) => aoc2019.Day2.compute_part2(readlines("./data/day2_p1.txt"))
      case (3, 1) => aoc2019.Day3.compute_part1(readlines("./data/day3_p1.txt"))
      case (3, 2) => aoc2019.Day3.compute_part2(readlines("./data/day3_p1.txt"))
    }

    val day = dayPart._1
    val part = dayPart._2

    println(s"Solutions for Advent of Code Day $day Part $part: $result")
  }
}
