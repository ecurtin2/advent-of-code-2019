package aoc2019 {

  object Day2 extends aoc2019.Day {

    def execute_opcode(code: List[Int], pointer: Int = 0): List[Int] = {
      val result = code.drop(pointer) match {
        case List(1, x, y, loc, _*) =>
          (false, code.updated(loc, code(x) + code(y)), 4)
        case List(2, x, y, loc, _*) =>
          (false, code.updated(loc, code(x) * code(y)), 4)
        case List(99, _*) => (true, code, 1)
      }

      if (result._1) {
        result._2
      } else {
        execute_opcode(result._2, pointer + result._3)
      }
    }

    def executeNounVerb(code: List[Int], noun: Int, verb: Int): List[Int] = {
      execute_opcode(code.updated(1, noun).updated(2, verb))
    }

    override def compute_part1(data: List[String]): Int = {
      val input = data.map(_.toInt)
      executeNounVerb(input, 12, 2)(0)
    }

    override def compute_part2(data: List[String]): Int = {
      val input = data.map(_.toInt)
      val range = 0 to 99
      val nums = range.flatMap(x => range.map(y => (x, y)))
      val results = nums.map(
        nounVerb => executeNounVerb(input, nounVerb._1, nounVerb._2)(0)
      )
      val found = (nums zip results).find(r => r._2 == 19690720)
      found match {
        case Some(((noun, verb), result)) => 100 * noun + verb
        case None                         => -1
      }
    }
  }
}
