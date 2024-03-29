package aoc2019 {
  import scala.math.abs

  object Day3 extends aoc2019.Day {

    object Direction extends Enumeration {
      val Up = Value("U")
      val Down = Value("D")
      val Left = Value("L")
      val Right = Value("R")
    }

    type Grid = Map[Tuple2[Int, Int], Set[Int]]
    type Point = Tuple2[Int, Int]
    type Move = Tuple2[Direction.Value, Int]

    def pointsFromMove(x: Int, y: Int, move: Move): List[Point] = {
      val points = move match {
        case (Direction.Up, d) =>
          for (yi <- (y + 1 to y + d)) yield (x, yi)
        case (Direction.Down, d) =>
          for (yi <- y - 1 to y - d by -1) yield (x, yi)
        case (Direction.Left, d) =>
          for (xi <- x - 1 to x - d by -1) yield (xi, y)
        case (Direction.Right, d) =>
          for (xi <- x + 1 to x + d) yield (xi, y)
      }
      points.toList
    }

    def movesFromString(s: String): List[Move] = {
      s.split(",")
        .map(s => (Direction.withName(s(0).toString), s.drop(1).toInt))
        .toList
    }

    def updatedGrid(g: Grid, points: List[Point], value: Int): Grid = {
      val updates = for (p <- points) yield (p, g.getOrElse(p, Set()) + value)
      g ++ updates
    }

    def pointsFromMoves(moves: List[Move]): List[Point] = {
      moves
        .foldLeft(List((0, 0)))(
          (points, move) =>
            points ++ pointsFromMove(points.last._1, points.last._2, move)
        )
        .drop(1) // Remove origin
    }

    def manhattan_distance(p: Point): Int = abs(p._1) + abs(p._2)

    def nsteps(points: List[Point], end: Point): Int = {
      points.indexOf(end) + 1 // Add one for zero-based index
    }

    override def compute_part1(data: List[String]): Int = {
      val grid: Map[Tuple2[Int, Int], Set[Int]] = Map()

      val steps = pointsFromMoves(movesFromString(data(0)))
      val g = updatedGrid(grid, steps, 1)

      val steps2 = pointsFromMoves(movesFromString(data(1)))
      val g2 = updatedGrid(g, steps2, 2)

      println(steps)
      println(steps2)

      g2.filter(x => x._2 == Set(1, 2)).keys.map(manhattan_distance).min
    }

    override def compute_part2(data: List[String]): Int = {
      val grid: Map[Tuple2[Int, Int], Set[Int]] = Map()

      val steps = pointsFromMoves(movesFromString(data(0)))
      val g = updatedGrid(grid, steps, 1)

      val steps2 = pointsFromMoves(movesFromString(data(1)))
      val g2 = updatedGrid(g, steps2, 2)

      val overlaps = g2.filter(x => x._2 == Set(1, 2)).keys
      overlaps.map(p => nsteps(steps, p) + nsteps(steps2, p)).min
    }
  }
}
