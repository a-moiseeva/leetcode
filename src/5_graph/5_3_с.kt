package `5_graph`

import java.util.*

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val maze = Array(n) { readln() }
    var start = Pair(0, 0)
    var finish = Pair(0, 0)
    for (i in 0..n - 1) {
        for (j in 0..m - 1) {
            if (maze[i][j] == 'S') {
                start = Pair(i, j)
            }
            if (maze[i][j] == 'F') {
                finish = Pair(i, j)
            }
        }
    }
    val visited = mutableMapOf<Pair<Int, Int>, Pair<Int, Char>>()
    //храним пара(координаты) -> пара(длина пути, направление откуда шли)
    var queue: Queue<Pair<Pair<Int, Int>, Int>> = LinkedList()
    queue.add(Pair(start, 0))
    visited[start] = Pair(0, 'S')

    val directions_map =
        mapOf<Char, Pair<Int, Int>>('U' to Pair(-1, 0), 'D' to Pair(1, 0),'L' to Pair(0, -1), 'R' to Pair(0, 1) )
    val decode_directions_map = mapOf<Char, Char>('U' to 'D', 'R' to 'L', 'D' to 'U', 'L' to 'R')
    while (queue.isNotEmpty()) {
        val (curXY, curStep) = queue.poll()
        val (curX, curY) = curXY
        for (d in directions_map) {
            val (dirX, dirY) = d.value
            val x = curX + dirX
            val y = curY + dirY

            if (maze[x][y] == '.' && !visited.containsKey(Pair(x, y))) {
                visited[Pair(x, y)] = Pair(curStep + 1, d.key)
                queue.add(Pair(Pair(x, y), curStep + 1))
            } else if (maze[x][y] == 'F') {
                visited[Pair(x, y)] = Pair(curStep + 1, d.key)
                queue.add(Pair(Pair(x, y), curStep + 1))
          /*      println("FOUND THE END UIIII")*/
                println(curStep + 1)
                var s = ""
                var xx = finish.first
                var yy = finish.second
             /*   println(visited)*/
                repeat(curStep + 1) {
                   /* println("$xx,$yy")*/
                    var dir = visited[Pair(xx, yy)]!!.second
                  /*  println(    dir)*/
                    val reversed_dir = decode_directions_map[dir]
                    val (newX, newY) = directions_map[reversed_dir!!]!!
                    xx = xx + newX
                    yy = yy + newY
                    s = s + dir
                }
                println(s.reversed())

                return

            }
        }

    }
    println(-1)

}
