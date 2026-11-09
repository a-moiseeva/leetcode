package livecoding2

import kotlin.collections.ArrayDeque
import java.util.Queue

class Solution31 {
    fun numIslands(grid: Array<CharArray>): Int {
        val n = grid.size
        val m = grid[0].size
        var islands = 0
        val directions = listOf(Pair(1, 0), Pair(0, 1), Pair(-1, 0), Pair(0, -1))

        for (i in 0..n - 1) {
            for (j in 0..m - 1) {
                if (grid[i][j] == '0') continue
                islands++
                val queue = ArrayDeque<Pair<Int, Int>>()
                queue.add(Pair(i, j))
                while (queue.isNotEmpty()) {
                    val current = queue.first()
                    queue.removeFirst()
                    for (d in directions) {
                        if (current.first + d.first < n &&
                            current.first + d.first >= 0 &&
                            current.second + d.second < m &&
                            current.second + d.second >= 0 &&
                            grid[current.first + d.first][current.second + d.second] == '1'
                        ) {
                            queue.add(Pair(current.first + d.first, current.second + d.second))
                            grid[current.first + d.first][current.second + d.second] = '0'
                        }
                    }
                }
            }
        }
        return islands

    }
}

class Solution34342 {
    fun numIslands(grid: Array<CharArray>): Int {
        var numberIslands = 0

        var newGrid=grid

        for (i in 0..grid.size-1){
            for(j in 0..grid[0].size-1){
                if(newGrid[i][j]== '1'){
                    numberIslands++
                    val m = ArrayDeque<Pair<Int,Int>>()
                    m.add(Pair(i,j))
                    while(!m.isEmpty()){
                        val p=m.removeFirst()
                        val x = p.first
                        val y = p.second
                        if(x>-1&&y>-1&&x<grid.size&&y<grid[0].size&&newGrid[x][y]=='1'){
                            newGrid[x][y]='0'
                            m.add(Pair(x+1,y+1))
                            m.add(Pair(x-1,y+1))
                            m.add(Pair(x+1,y-1))
                            m.add(Pair(x-1,y-1))
                        }

                    }
                }
            }
        }

        return numberIslands

    }
}