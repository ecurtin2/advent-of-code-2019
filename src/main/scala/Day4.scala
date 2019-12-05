package aoc2019 {
import scala.language.implicitConversions

  object Day4 extends aoc2019.Day {

    def containsDouble(x: List[Any]): Boolean = (x zip x.drop(1)).exists(x => x._1 == x._2)
    def increases(x: List[Int]): Boolean = (x zip x.drop(1)).forall(x => x._1 <= x._2)
    def digits(x: Int): List[Int] = x.toString.map(_.asDigit).toList
    implicit def toInt(v: Boolean): Int = if (v) 1 else 0
    def containsExactlyDouble(x: List[Any]): Boolean = {
        x.groupBy(identity).mapValues(_.size).values.toList.contains(2)
    }

    override def compute_part1(data: List[String]): Int = {
      (137683 to 596253).map(digits).filter(d => containsDouble(d) & increases(d)).length
    }

    override def compute_part2(data: List[String]): Int = {
      (137683 to 596253).map(digits).filter(d => containsExactlyDouble(d) & increases(d)).length
    }
  }
}
