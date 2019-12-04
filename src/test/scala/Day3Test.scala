package aoc2019 {
  class Day3Test extends org.scalatest.FunSuite {
    test("day3.part1") {
      val cases = List(
        (List("R8,U5,L5,D3", "U7,R6,D4,L4"), 6),
        (List("R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83"), 159),
        (List("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51","U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"), 135)
      )

      for (each_case <- cases) {
        assert(Day3.compute_part1(each_case._1) == each_case._2)
      }
    }

    test("day3.part2") {
      val cases = List(
        (List("R8,U5,L5,D3", "U7,R6,D4,L4"), 30),
        (List("R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83"), 610),
        (List("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51","U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"), 410)
      )

      for (each_case <- cases) {
        assert(Day3.compute_part2(each_case._1) == each_case._2)
      }
    }
  }
}
