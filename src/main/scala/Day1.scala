import scala.io.Source
import scala.math.max

package aoc2019 {

  object Day1 extends aoc2019.Day {

    def calculate_fuel(mass: Int): Int = {
      max(mass / 3 - 2, 0)
    }

    def calc_fuel_recursive(mass: Int): Int = {
      if (mass <= 0) {
        0
      } else {
        val fuel = calculate_fuel(mass)
        fuel + calc_fuel_recursive(fuel)
      }
    }

    override def compute(data: List[String]): Tuple2[Int, Int] = {
      val masses = data.map(_.toInt)
      (masses.map(calculate_fuel).sum, masses.map(calc_fuel_recursive).sum)
    }
  }
}
