package `5_graph`

import java.util.LinkedList
import java.util.Queue


fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val maze = Array(n) { readln() }
    var start = Pair(0, 0)
    var finish = Pair(0, 0)
    var key = Pair(0,0)
    var door = Pair(0,0)
    for (i in 0..n - 1) {
        for (j in 0..m - 1) {
            if (maze[i][j] == 'S') {
                start = Pair(i, j)
            }
            if (maze[i][j] == 'F') {
                finish = Pair(i, j)
            }
            if(maze[i][j] == 'K') {
                key = Pair(i, j)
            }
            if(maze[i][j] == 'D') {
                door = Pair(i, j)
            }
        }
    }
    val visited = mutableSetOf<Pair<Pair<Int, Int>,Boolean>>()
    //храним пара(пара(координаты), наличие ключа) -> пара(длина пути, направление откуда шли)
    var queue: Queue<Pair<Pair<Int, Int>, Pair<Boolean, String>>> = LinkedList()
    //храним пара (пара(координаты)), пара(наличие ключа ,длина пути )
    var hasAKey= false
    queue.add(Pair(start, Pair(hasAKey,"" )))
    visited.add(Pair(start,hasAKey))
    val directions_map =
        mapOf<Char, Pair<Int, Int>>( 'D' to Pair(1, 0),'L' to Pair(0, -1),'U' to Pair(-1, 0), 'R' to Pair(0, 1) )
    while (queue.isNotEmpty()) {

        val (curXY, cur) = queue.poll()
        val(curKey,curStep)=cur
        val (curX, curY) = curXY
        for (d in directions_map) {
            val (dirX, dirY) = d.value
            val x = curX + dirX
            val y = curY + dirY
            var newS = ""+curStep+d.key

            if (maze[x][y] == '.' && !visited.contains(Pair(Pair(x, y),curKey))) {
                visited.add(Pair(Pair(x, y),curKey) )
                queue.add(Pair(Pair(x,y),Pair(curKey, newS)))
            } else if(maze[x][y] == 'K' && curKey==false){
                visited.add(Pair(Pair(x, y),true) )
                newS=newS+'P'
                queue.add(Pair(Pair(x, y), Pair(true,newS )))
            }
            else if(maze[x][y] == 'D' && curKey==true){
                visited.add(Pair(Pair(x, y),true) )
                queue.add(Pair(Pair(x, y), Pair(true,newS )))
            }else if(maze[x][y] == 'S' && curKey==true){
                visited.add(Pair(Pair(x, y),true) )
                queue.add(Pair(Pair(x, y), Pair(true,newS )))
            }
            else if (maze[x][y] == 'F') {
                visited.add(Pair(Pair(x, y),curKey) )
                queue.add(Pair(Pair(x, y), Pair(curKey,newS )))
                /*      println("FOUND THE END UIIII")*/
                println(newS.length)
                println(newS)

                return

            }
        }

    }
    println(-1)

}
