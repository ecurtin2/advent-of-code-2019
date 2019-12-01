package aoc2019 {
  class Day1Test extends org.scalatest.FunSuite {
    test("day1.part1") {
      assert(Day1.calculate_fuel(12) == 2)
      assert(Day1.calculate_fuel(14) == 2)
      assert(Day1.calculate_fuel(1969) == 654)
      assert(Day1.calculate_fuel(100756) == 33583)
    }

    test("day1.part2") {
      assert(Day1.calc_fuel_recursive(14) == 2)
      assert(Day1.calc_fuel_recursive(1969) == 966)
      assert(Day1.calc_fuel_recursive(100756) == 50346)
    }
  }
}
