import scala.io.Source
import scala.math.max

package aoc2019 {

  object Day1 {

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

    def compute(data: List[String]): List[String] = {
      assert(calculate_fuel(12) == 2)
      assert(calculate_fuel(14) == 2)
      assert(calculate_fuel(1969) == 654)
      assert(calculate_fuel(100756) == 33583)

      val str2int = (s: String) => s.toInt
      // Part 1
      val masses = data.map(str2int)
      val total_fuel = masses.map(calculate_fuel).sum

      // Part 2
      assert(calc_fuel_recursive(14) == 2)
      assert(calc_fuel_recursive(1969) == 966)
      assert(calc_fuel_recursive(100756) == 50346)
      val total_fuel_recursive = masses.map(calc_fuel_recursive).sum

      List(
        "Solution to Day 1 Part 1: ",
        total_fuel.toString,
        "\n",
        "Solution to Day 1 Part 2: ",
        total_fuel_recursive.toString,
        "\n"
      )
    }
  }
}
