package livecoding1

fun isVertSym(points: Array<IntArray>): Boolean{
    if (points.isEmpty()) return true
    val m = HashMap<Pair<Int,Int>, Int>()

    var xMin= Int.MAX_VALUE
    var xMax= Int.MIN_VALUE
    for(i in points){
        val x = i[0]
        val y = i[1]
        if(x<xMin) xMin=x
        if(x>xMax) xMax=x
        m[Pair(x,y)] = m.getOrDefault(Pair(x,y),0) +1
    }
    val line = (xMax+xMin)
    for(i in m){
        val x = i.key.first
        val y = i.key.second
        val freq= i.value
        val xx = (line-x)
        if(!m.containsKey(Pair(xx,y))) return false
        if(m[Pair(xx,y)] != freq)   return false
    }

    return true
}


fun main() {
    val a =0
    val points = mutableListOf<Pair<Int, Int>>(Pair(1, 1),Pair(1, 1), Pair(-1,1), Pair(-1,1), Pair(0,0))
    val points_map = mutableMapOf<Pair<Int, Int>, Int>()
    var max = points[0].first
    var min = max
    for (point in points) {
        if (point.first > max) max = point.first
        if (point.first < min) min = point.first
        points_map[point] = (points_map[point] ?: 0) + 1
    }
    val the_line = (max + min) / 2
    println(the_line)
    for (point in points_map) {
        var need_to_find = the_line
        if (point.key.first < the_line) need_to_find = the_line + the_line - point.key.first
        if (point.key.first > the_line) need_to_find = the_line + the_line - point.key.first
        if (!points_map.contains(Pair(need_to_find, point.key.second))) println("false").also{ return}
        if (points_map[point.key] != points_map[Pair(need_to_find, point.key.second)]) println("false").also{ return}
    }
    println("true")

}


fun main2(): Boolean {
    val points = mutableListOf<Pair<Int, Int>>(Pair(1, 1),Pair(1, 1), Pair(-1,1), Pair(-1,1), Pair(0,0))
    var min = points[0].first
    var max = min
    val m = HashMap<Pair<Int,Int>,Int>()
    for (point in points) {
        if (point.first<min) min = point.first
        if(point.first>max) max=  point.first
        m[point] = m.getOrDefault(point,0)+1
    }
    val line = (min+max)/2
    for (point in m.keys) {
        if(!m.contains(Pair(2*line-1,point.second))) return false
        if(    m[Pair(2*line-1,point.second)] != m[point]   ) return false
    }
    return true
}