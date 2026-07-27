package `5_graph`
//Depth-First Search


fun main(){
    val n = 5
    val graph = Array(n+1) { IntArray(n+1) }
    graph[1][2]=1
    graph[2][1]=1
    graph[1][5]=1
    graph[5][1]=1
    graph[5][4]=1
    graph[4][5]=1
    graph[3][5]=1
    graph[5][3]=1
    graph[4][3]=1
    graph[3][4]=1
    val visited =  IntArray(n + 1) { 0 }
    var hasCycle= false
    fun dfs(node: Int)  {
        visited[node]=1
        for (j in graph[node]) {
            if (j==1){
                if (visited[j]==0){
                    dfs(j)
                }
                else if (visited[j]==1){
                    hasCycle = true
                }
            }
        }
        visited[node]=2
    }
    for (i in 1..n){
        if (visited[i]==0){
            dfs(i)
        }
    }
    println(hasCycle)

}