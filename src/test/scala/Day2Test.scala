package aoc2019 {
  class Day2Test extends org.scalatest.FunSuite {
    test("day2.part1") {
      val cases = List(
        (List(1, 0, 0, 0, 99), List(2, 0, 0, 0, 99)),
        (List(2, 3, 0, 3, 99), List(2, 3, 0, 6, 99)),
        (List(2, 4, 4, 5, 99, 0), List(2, 4, 4, 5, 99, 9801)),
        (List(1, 1, 1, 4, 99, 5, 6, 0, 99), List(30, 1, 1, 4, 2, 5, 6, 0, 99))
      )

      for (each_case <- cases) {
        assert(Day2.execute_opcode(each_case._1) == each_case._2)
      }
    }
  }
}
