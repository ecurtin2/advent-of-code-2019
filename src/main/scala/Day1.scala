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
      assert(calculate_fuel(12) == 2)
      assert(calculate_fuel(14) == 2)
      assert(calculate_fuel(1969) == 654)
      assert(calculate_fuel(100756) == 33583)

      // Part 1
      val masses = data.map(_.toInt)
      val total_fuel = masses.map(calculate_fuel).sum

      // Part 2
      assert(calc_fuel_recursive(14) == 2)
      assert(calc_fuel_recursive(1969) == 966)
      assert(calc_fuel_recursive(100756) == 50346)
      val total_fuel_recursive = masses.map(calc_fuel_recursive).sum

      (total_fuel, total_fuel_recursive)
    }
  }
}
