package `5_graph`

fun main(){
    val n =readln().toInt()
    val people = mutableSetOf<Int>()
    val matrix=mutableListOf<List<Int>>()
    repeat(n) {
        val s = readln().split(" ").map { it.toInt() }
        for (i in 1..s.size-1) people.add(s[i])
        matrix.add(s)
    }
    val peopleList = people.sorted()
    val k =peopleList.size
    val indexMap =peopleList.withIndex().associate{ it.value  to  it.index }
    val answer = Array(k){IntArray(k)}
    for(i in 0 until n){
        for (j in 1 until matrix[i][0]+1){
            for(k in j+1 until matrix[i][0]+1){
                val p1= indexMap[matrix[i][j]]!!
                val p2 = indexMap[matrix[i][k]]!!
                answer[p1][p2]=1
                answer[p2][p1]=1
            }

        }

    }
    println(k)
    for (i in answer) println(i.joinToString(" "))
}