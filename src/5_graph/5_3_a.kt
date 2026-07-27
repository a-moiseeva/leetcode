package `5_graph`
fun main() {


    val (n,m)= readln().split(" ").map{it.toInt()}
    val graph= Array(n+1){mutableListOf<Int>()}
    for (i in 0 until m) {
        val (u,v,t)=readln().split(" ").map{it.toInt()}
        when(t){
            1 -> graph[u].add(v)
            2 -> graph[v].add(u)
        }
    }
    val visited = IntArray(n+1){0}// 0 - не посещен, 1 - в процессе, 2 - посещен
    var hasCycle = false


    fun dfs(node: Int){
        if (hasCycle) return
        visited[node]=1
        for(neighbour in graph[node]){
            if (visited[neighbour] == 0){
                dfs(neighbour)
            }
            else if(visited[neighbour] == 1){
                hasCycle = true
            }
        }
        visited[node]=2
    }
    for (i in 1..n) {
        if (visited[i] == 0) {
            dfs(i)
        }
    }

    println(if ((hasCycle) or (m<=n-2)) "NO" else "YES")
}

