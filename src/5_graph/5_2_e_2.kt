package `5_graph`

fun main() {
    val n = readln().toInt()
    val adjacencyMatrix = Array(n) { readln().split(" ").map { it.toInt() } as MutableList<Int> }
    val reachabilityMatrix = adjacencyMatrix.copyOf()

    //Мы перебираем все пары вершин и проверяем, существует ли путь через промежуточную вершину k.
    // Если существует путь от i до k и от k до j,
    // то мы устанавливаем reachabilityMatrix[i][j] в 1.
    for (k in 0 until n ) {
        for(i in 0 until n) {
            for (j in 0 until n) {
                if(reachabilityMatrix[i][k]==1 && reachabilityMatrix[k][j]==1) {
                    reachabilityMatrix[i][j] = 1
                }

            }
        }
    }
    for (s in reachabilityMatrix) {
        println(s.joinToString(" "))
    }




}
