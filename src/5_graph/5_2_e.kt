package `5_graph`

fun main() {
    val n = readln().toInt()
    val matrix = Array(n) { readln().split(" ").map { it.toInt() } as MutableList<Int> }
    val neighbours_sets = mutableListOf<MutableSet<Int>>()
    var countOfSets = 0
    for (i in 0..n - 1) {
        var found = false

        if (neighbours_sets.isNotEmpty()) {
            for (set in neighbours_sets) {
                if (i in set) {
                    found = true
                    for (j in i + 1..n - 1) {
                        if (matrix[i][j] == 1) set.add(j)
                    }
                }
            }
        }
        if (!found or neighbours_sets.isEmpty()) {
            var set = mutableSetOf<Int>(i)
            for (j in i + 1..n - 1) {
                if (matrix[i][j] == 1) set.add(j)
            }
            neighbours_sets.add(set)
        }


    }
    for (set in neighbours_sets) {
        val arr = set.toIntArray()
        for (i in 0 until arr.size) {
            for (j in i  until    arr.size) {
                matrix[i][j]=1
                matrix[j][i]=1

            }
        }
    }
    for (s in matrix) {
        println(s.joinToString(" "))
    }

}
/*
6
0 1 1 0 0 0
1 0 0 0 0 0
1 0 0 1 0 0
0 0 1 0 0 0
0 0 0 0 0 1
0 0 0 0 1 0
 */
